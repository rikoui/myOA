package com.bjdreamtech.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjdreamtech.entity.Holiday;
import com.bjdreamtech.entity.HolidayExample;
import com.bjdreamtech.entity.SysAdmin;
import com.bjdreamtech.entity.SysAdminExample;
import com.bjdreamtech.mapper.auto.HolidayMapper;
import com.bjdreamtech.mapper.auto.SysAdminMapper;
import com.bjdreamtech.mapper.custom.DailyCountScheludeMapper;
import com.bjdreamtech.service.IDailyCountScheludeService;

@Service
public class DailyCountScheludeServiceImpl extends BaseServiceImpl implements IDailyCountScheludeService {

	@Autowired
	private HolidayMapper holidayMapper;
	@Autowired
	private SysAdminMapper sysAdminMapper;
	@Autowired
	private DailyCountScheludeMapper countScheludeMapper;
	
	
	/**
	 * 每天凌晨1:00统计日报未提交情况
	 */
	@Override
	public void dailyCount() {
		//获取当前日期前一天
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -1);
		String preDay = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
		String dailyTime = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		//查询所有假期
		List<Holiday> holidays = holidayMapper.selectByExample(null);
		//判断当前日期前一天是否为假期
		boolean holidayFlage = holidays.stream().map(Holiday::getHolidayId).anyMatch(holiday -> preDay.equals(holiday));
		if(!holidayFlage) {
			//查询非管理员操作员
			SysAdminExample adminExample = new SysAdminExample();
			adminExample.createCriteria().andAdminStatusEqualTo("0").andAdminRoleIdNotEqualTo("88888888");
			List<SysAdmin> admins = sysAdminMapper.selectByExample(adminExample);
			if(admins!=null && admins.size()>0) {
				Map<String, Object> param = null;
				int count = 0;
				for(SysAdmin admin : admins) {
					//查询该操作员当天是否提交日报
					param = new HashMap<String, Object>();
					param.put("adminId", admin.getAdminId());
					param.put("dailyTime",dailyTime);
					count = countScheludeMapper.dailySubmitCount(param);
					if(count <= 0) {//日报未提交
						//判断当前操作员提交且审核通过，请假日期包含当前日期前一天的请假单是否存在
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("preDay", preDay);
						map.put("adminId", admin.getAdminId());
						int leaveCount = countScheludeMapper.leaveCountByCondition(map);
						if(leaveCount <= 0) {
							//当前操作员未提交日报天数加1
							int countday = Integer.parseInt(admin.getAdminCountday())+1;
							SysAdmin sysAdmin = new SysAdmin();
							sysAdmin.setAdminId(admin.getAdminId());
							sysAdmin.setAdminCountday(String.valueOf(countday));
							sysAdminMapper.updateByPrimaryKeySelective(sysAdmin);
						}
					}
				}
			}
		}
	}


	/**
	 * 每天凌晨2:00统计请假单补提和事后审核情况
	 * @throws ParseException 
	 */
	@Override
	public void leaveLayzeCount() throws ParseException {
		//获取当前日期前一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -1);
		String preDay = sdf.format(c.getTime());
		//查询所有假期
		List<Holiday> holidays = holidayMapper.selectByExample(null);
		//查询当前日期前提交的日报
		List<Map<String, Object>> dailys = countScheludeMapper.queryDailys(preDay);
		//提交的日报按操作员分组
		Map<String, List<Map<String, Object>>> collect = dailys.stream().collect(Collectors.groupingBy(daily -> (String)daily.get("adminId")));
		Map<String, Object> param = new HashMap<String, Object>();
		//查询当前日期前一天审核通过的请假申请
		param.put("approvalTime",preDay);
		List<Map<String, Object>> leaves = countScheludeMapper.selectLeaveByAdmin(param);
		if(leaves != null && leaves.size() > 0) {
			for(Map<String, Object> leave : leaves) {
				String adminId = (String) leave.get("adminId");
				String startTime = (String) leave.get("startTime");
				String startDate = startTime.substring(0,8);
				if(preDay.compareTo(startDate) == 1) { //当前日期前一天大于请假开始日期
					String endTime = (String) leave.get("endTime");
					String endDate = endTime.substring(0,8);
					String endDay = "";
					if(endDate.compareTo(preDay) >= 0) {
						c.add(Calendar.DATE, -1);
						endDay = sdf.format(c.getTime());
					}else{
						endDay = endTime;
					}
					List<String> days = startToEndDays(startTime,endDay);
					//去除请假日期中的假期
					List<String> list = new ArrayList<String>();
					for(int i=0;i<days.size();i++) {
						String day = days.get(i);
						if(holidays.stream().map(Holiday::getHolidayId).anyMatch(holiday -> holiday.equals(day)||(holiday+"#").equals(day))) {
							list.add(day);
						}
					}
					days.removeAll(list);
					if(!days.isEmpty()) {
						int countDay = 0; // 需减去未提交日报天数
						for(String leaveDay : days) {
							//当前操作员提交的日报
							List<Map<String, Object>> adminDailys = collect.get(adminId);
							//判断操作员在当前请假日期是否提交日报
							if(adminDailys.stream().map(adminDaily -> (String)adminDaily.get("dailyTime")).noneMatch(dailyTime -> dailyTime.equals(leaveDay)||(dailyTime+"#").equals(leaveDay))) {
								countDay++;
							}
						}
						if(countDay > 0) {
							//当前操作员未提交日报天数更新
							SysAdmin sysAdmin = sysAdminMapper.selectByPrimaryKey(adminId);
							int countday = Integer.parseInt(sysAdmin.getAdminCountday())-countDay;
							sysAdmin.setAdminCountday(String.valueOf(countday));
							sysAdminMapper.updateByPrimaryKeySelective(sysAdmin);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 根据请假开始日期和结束日期计算具体每个请假日期
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ParseException
	 */
	private List<String> startToEndDays(String startTime,String endTime) throws ParseException {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(startTime));
		String startDate = sdf1.format(c.getTime());
		Calendar c1 = Calendar.getInstance();
		c1.setTime(sdf.parse(endTime));
		String endDate = sdf1.format(c1.getTime());
		if(startDate.equals(endDate)) {
			//请假开始时间和请假结束时间在同一日期
			if(c.get(Calendar.HOUR_OF_DAY)>=14) {
				list.add(startDate+"#");
			}else {
				if(c1.get(Calendar.HOUR_OF_DAY)<14) {
					list.add(startDate+"#");
				}else {
					list.add(startDate);
				}
			}
		}else {
			while(c.compareTo(c1) <= 0) {
				if(sdf1.format(c.getTime()).equals(startDate)) {
					//开始日期，判断时间是否大于14点，大于14点(也就是下午2点之后)为半天
					if(c.get(Calendar.HOUR_OF_DAY)>=14) {
						list.add(startDate+"#");
					}else {
						list.add(startDate);
					}
					c.add(Calendar.DATE, 1);
					//时分秒清零
					c.set(Calendar.HOUR_OF_DAY, 0);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
					c.set(Calendar.MILLISECOND, 0);
					continue;
				}
				if(sdf1.format(c.getTime()).equals(endDate)) {
					//结束日期，判断时间是否小于14点，小于14点为半天
					if(c1.get(Calendar.HOUR_OF_DAY)<14) {
						list.add(endDate+"#");
					}else {
						list.add(endDate);
					}
					c.add(Calendar.DATE, 1);
					continue;
				}
				list.add(sdf1.format(c.getTime()));
				c.add(Calendar.DATE, 1);
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
			}
		}
		return list;
	}


	/**
	 * 全年周末假期录入
	 */
	@Override
	public void weekDayEnter() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		//当前年份
		int year = c.get(Calendar.YEAR);
		//将日期定位到当年第一天
		c.set(Calendar.DAY_OF_YEAR,1);
		//当年天数
		int yeardays = c.getActualMaximum(Calendar.DAY_OF_YEAR);
		List<String> weekdays = new ArrayList<String>();
		//判断是否是周末
		if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY||c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
			weekdays.add(sdf.format(c.getTime()));
		}
		for(int i=1;i<yeardays;i++) {
			c.add(Calendar.DATE, 1);
			if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY||c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
				weekdays.add(sdf.format(c.getTime()));
			}
		}
		//查询当年已录入假期
		HolidayExample example = new HolidayExample();
		example.createCriteria().andHolidayIdLike(year+"%");
		List<Holiday> holidays = holidayMapper.selectByExample(example);
		//假期入库
		if(weekdays.size() > 0) {
			Holiday holiday = null;
			for (String weekDay : weekdays) {
				//未录入才录入
				if(holidays.stream().noneMatch(day -> day.getHolidayId().equals(weekDay))) {
					holiday = new Holiday();
					holiday.setHolidayId(weekDay);
					holidayMapper.insertSelective(holiday);
				}
			}
		}
	}
}
