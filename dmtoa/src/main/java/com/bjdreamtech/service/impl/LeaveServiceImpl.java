package com.bjdreamtech.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.bean.DMTSessionBean;
import com.bjdreamtech.dmt.format.DMTTimeFormatter;
import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.bjdreamtech.dmt.util.DMTDateUtil;
import com.bjdreamtech.dmt.util.DMTFileUtil;
import com.bjdreamtech.dmt.util.DMTPrimaryKeyUtil;
import com.bjdreamtech.entity.Holiday;
import com.bjdreamtech.entity.LeavePerson;
import com.bjdreamtech.entity.SysAdmin;
import com.bjdreamtech.entity.SysAdminExample;
import com.bjdreamtech.entity.SysFile;
import com.bjdreamtech.entity.SysParam;
import com.bjdreamtech.entity.SysParamExample;
import com.bjdreamtech.entity.bean.ApprovalerBean;
import com.bjdreamtech.format.DMTStatusFormatter;
import com.bjdreamtech.mapper.auto.HolidayMapper;
import com.bjdreamtech.mapper.auto.LeavePersonMapper;
import com.bjdreamtech.mapper.auto.SysAdminMapper;
import com.bjdreamtech.mapper.auto.SysFileMapper;
import com.bjdreamtech.mapper.auto.SysParamMapper;
import com.bjdreamtech.mapper.custom.LeaveManageMapper;
import com.bjdreamtech.mapper.custom.ParamManageMapper;
import com.bjdreamtech.service.ILeaveService;

@Service
public class LeaveServiceImpl extends BaseServiceImpl implements ILeaveService{
	@Autowired
	private LeaveManageMapper leaveManageMapper;
	@Autowired
	private ParamManageMapper paramManageMapper;
	@Autowired
	private LeavePersonMapper leavePersonMapper;
	@Autowired
	private HolidayMapper holidayMapper;
	@Autowired
	private SysAdminMapper adminMapper;
	@Autowired
	private SysFileMapper fileMapper;
	@Autowired
	private SysParamMapper paramMapper;
	
	/**
	 * 请假单列表查询
	 * @param request
	 * @return
	 */
	@Override
	public DMTDataTableBean queryLeaves(HttpServletRequest request) {
		initPageParameter(request);
		DMTSessionBean sessionBean = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String adminid = sessionBean.getAdminid();
		String roleid = sessionBean.getRoleid();
		String applyer = request.getParameter("applyer");
		String status = request.getParameter("status");
		String type = request.getParameter("type");
		String leavTtype = request.getParameter("leaveType");
		if(notNull(status)) {
			params.put("status", status);
		}
		if(notNull(leavTtype)) {
			params.put("leavTtype", leavTtype);
		}
		if("1".equals(type)) {
			//申请列表查询
			params.put("applyer", adminid);
		}else if("2".equals(type)) {
			//审阅列表查询
			if(!"88888888".equals(roleid)) {
				//非超级管理员，查询审阅人为当前管理员的
				params.put("approvaler", adminid);
			}else {
				//如果是超级管理员，查询所有人或指定用户提交的并过滤自身提交的
				if(notNull(applyer)) {
					params.put("applyer", applyer);
				}else {
					params.put("extension_applyer", adminid);
				}
			}
		}
		
		
		List<Map<String, Object>> leaves = leaveManageMapper.queryLeavesByPage(params);
		//最终审阅结果转换
		DMTStatusFormatter.formatStatusList(leaves, "leavePass", "leavePassCopy", "LEAVE_PASS_STATUS", paramManageMapper);
		//请假类型转换
		DMTStatusFormatter.formatStatusList(leaves, "leaveType", "leaveTypeCopy", "LEAVE_TYPE", paramManageMapper);
		//第一审阅结果转换
		DMTStatusFormatter.formatStatusList(leaves, "firstApprovalRes", "firstApprovalResCopy", "LEAVE_AUTH_STATUS", paramManageMapper);
		//第二审阅结果转换
		DMTStatusFormatter.formatStatusList(leaves, "secondApprovalRes", "secondApprovalResCopy", "LEAVE_AUTH_STATUS", paramManageMapper);
		//第三审阅结果转换
		DMTStatusFormatter.formatStatusList(leaves, "thirdApprovalRes", "thirdApprovalResCopy", "LEAVE_AUTH_STATUS", paramManageMapper);
		//开始时间转换
		DMTTimeFormatter.formatTimeList(leaves, "startTime", "startTimeCopy");
		//结束时间转换
		DMTTimeFormatter.formatTimeList(leaves, "endTime", "endTimeCopy");
		//创建时间转换
		DMTTimeFormatter.formatTimeList(leaves, "createtime", "createtimeCopy");
		//最终审阅时间转换
		DMTTimeFormatter.formatTimeList(leaves, "approvalTime", "approvalTimeCopy");
		return new DMTDataTableBean(pageUtil.getTotalCount(),leaves);
	}
	
	/**
	 * 请假申请
	 * @param request
	 * @return
	 */
	@Override
	public DMTResultBean leaveAdd(HttpServletRequest request) {
		try {
			DMTSessionBean sessionBean = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String reason = request.getParameter("reason");
			String approvaler = request.getParameter("approvaler");
			String leaveType = request.getParameter("leavetype");
			String fileId = request.getParameter("fileId");
			if(isNull(startTime)) {
				return new DMTResultBean("1","请选择请假开始时间","");
			}
			if(isNull(endTime)) {
				return new DMTResultBean("1","请选择请假结束时间","");
			}
			if(isNull(reason)) {
				return new DMTResultBean("1","请输入请假原因","");
			}
			if(isNull(approvaler)) {
				return new DMTResultBean("1","请选择审阅人","");
			}
			if(isNull(leaveType)) {
				return new DMTResultBean("1","请选择请假类型","");
			}
			// 病假和产假需要证明
			if ("01".equals(leaveType) || "06".equals(leaveType)) {
				if(isNull(fileId)) {
					return new DMTResultBean("1","请上传处方或医院证明","");
				}
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(startTime));
			Calendar c1 = Calendar.getInstance();
			c1.setTime(sdf.parse(endTime));
			if(c.after(c1)) {
				return new DMTResultBean("1","请假结束时间必须大于等于开始时间","");
			}
			List<String> days = startToEndDays(startTime,endTime);
			//查询所有假期
			List<Holiday> holidays = holidayMapper.selectByExample(null);
			//去除请假日期中的假期
			List<String> list = new ArrayList<String>();
			for(int i=0;i<days.size();i++) {
				String day = days.get(i);
				if(holidays.stream().map(Holiday::getHolidayId).anyMatch(holiday -> holiday.equals(day)||(holiday+"#").equals(day))) {
					list.add(day);
				}
			}
			days.removeAll(list);
			//计算请半天假的日期数
			long count = days.stream().filter(day -> day.contains("#")).count();
			//请假天数
			float leaveNum = days.size()-(int)count+(float)count/2;
			String leaveNumDesc = "";
			if("08".equals(leaveType)) {
				//如果是倒休假，判断倒休天数是否够抵扣请假天数
				//获取倒休天数
				float lieuDay = adminMapper.selectByPrimaryKey(sessionBean.getAdminid()).getAdminLieuDay();
				if(leaveNum > lieuDay) {
					leaveNumDesc = new StringBuffer().append("共请假").append(leaveNum).append("天，倒休")
							.append(lieuDay).append("天，事假").append(leaveNum-lieuDay).append("天").toString();
				}else {
					leaveNumDesc = "共倒休"+leaveNum+"天";
				}
			}else {
				leaveNumDesc = new StringBuffer().append("共").append(leaveNum).append("天").append(getParamValueByCodeAndKey("LEAVE_TYPE", leaveType)).toString();
			}
			//申请存库
			LeavePerson leavePerson = new LeavePerson();
			leavePerson.setLevaeId(DMTPrimaryKeyUtil.getPrimaryKey(""));
			leavePerson.setLeaveAdminId(sessionBean.getAdminid());
			leavePerson.setLeaveEndTime(new SimpleDateFormat("yyyyMMddHHmmss").format(c1.getTime()));
			leavePerson.setLeaveStartTime(new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime()));
			leavePerson.setLeaveReason(reason);
			leavePerson.setLeaveNum(leaveNum);
			leavePerson.setLeaveNumDesc(leaveNumDesc);
			leavePerson.setLeaveCreatime(DMTDateUtil.parseDate());
			leavePerson.setLeaveFirstApprovaler(approvaler);
			leavePerson.setLeaveFirstApprovelStatus("01");
			if(approvaler.equals(ApprovalerBean.SECONDAPPROVALER.getAdminId())) {
				//如果选择的第一审阅人为默认第二审阅人
				if(leaveNum > 3) {//请假天数大于3天，设置第二审阅人
					leavePerson.setLeaveSecondApprovaler(ApprovalerBean.THIRDAPPROVALER.getAdminId());
					leavePerson.setLeaveSecondApprovelStatus("01");
				}
			}else {
				leavePerson.setLeaveSecondApprovaler(ApprovalerBean.SECONDAPPROVALER.getAdminId());
				leavePerson.setLeaveSecondApprovelStatus("01");
				if(leaveNum > 3) {//请假天数大于3天，设置第三审阅人
					leavePerson.setLeaveThirdApprovaler(ApprovalerBean.THIRDAPPROVALER.getAdminId());
					leavePerson.setLeaveThirdApprovelStatus("01");
				}
			}
			leavePerson.setLeaveType(leaveType);
			leavePerson.setLeavePass("01");
			if(StringUtils.isNotBlank(fileId)) {
				leavePerson.setLeavePic(fileId);
			}
			leavePersonMapper.insertSelective(leavePerson);
		} catch (ParseException e) {
			e.printStackTrace();
			return new DMTResultBean("1","系统异常","");
		}
		return new DMTResultBean();
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
	 * 请假申请信息查询
	 * @param request
	 * @return
	 */
	@Override
	public DMTResultBean getLeaveInfo(HttpServletRequest request) {
		LeavePerson leavePerson = leavePersonMapper.selectByPrimaryKey(request.getParameter("id"));
		leavePerson.setLeaveStartTime(DMTDateUtil.packDate(leavePerson.getLeaveStartTime()));
		leavePerson.setLeaveEndTime(DMTDateUtil.packDate(leavePerson.getLeaveEndTime()));
		return new DMTResultBean("0","",leavePerson);
	}

	/**
	 * 请假申请修改
	 * @param request
	 * @return
	 */
	@Override
	public DMTResultBean leaveEdit(HttpServletRequest request) {
		try {
			DMTSessionBean sessionBean = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
			String id = request.getParameter("id");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String reason = request.getParameter("reason");
			String approvaler = request.getParameter("approvaler");
			String leaveType = request.getParameter("leavetype");
			String fileId = request.getParameter("fileId");
			if(isNull(startTime)) {
				return new DMTResultBean("1","请选择请假开始日期","");
			}
			if(isNull(endTime)) {
				return new DMTResultBean("1","请选择请假结束日期","");
			}
			if(isNull(reason)) {
				return new DMTResultBean("1","请输入请假原因","");
			}
			// 病假和产假需要证明
			if ("01".equals(leaveType) || "06".equals(leaveType)) {
				if(isNull(fileId)) {
					return new DMTResultBean("1","请上传处方或医院证明","");
				}
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(startTime));
			Calendar c1 = Calendar.getInstance();
			c1.setTime(sdf.parse(endTime));
			if(c.after(c1)) {
				return new DMTResultBean("1","请假结束日期必须大于等于开始日期","");
			}
			List<String> days = startToEndDays(startTime,endTime);
			//查询所有假期
			List<Holiday> holidays = holidayMapper.selectByExample(null);
			//去除请假日期中的假期
			List<String> list = new ArrayList<String>();
			for(int i=0;i<days.size();i++) {
				String day = days.get(i);
				if(holidays.stream().map(Holiday::getHolidayId).anyMatch(holiday -> holiday.equals(day)||(holiday+"#").equals(day))) {
					list.add(day);
				}
			}
			days.removeAll(list);
			//计算请半天假的日期数
			long count = days.stream().filter(day -> day.contains("#")).count();
			//请假天数
			float leaveNum = days.size()-(int)count+(float)count/2;
			String leaveNumDesc = "";
			if("08".equals(leaveType)) {
				//如果是倒休假，判断倒休天数是否够抵扣请假天数
				//获取倒休天数
				float lieuDay = adminMapper.selectByPrimaryKey(sessionBean.getAdminid()).getAdminLieuDay();
				if(leaveNum > lieuDay) {
					leaveNumDesc = new StringBuffer().append("共请假").append(leaveNum).append("天，倒休")
							.append(lieuDay).append("天，事假").append(leaveNum-lieuDay).append("天").toString();
				}else {
					leaveNumDesc = "共倒休"+leaveNum+"天";
				}
			}else {
				leaveNumDesc = new StringBuffer().append("共").append(leaveNum).append("天").append(getParamValueByCodeAndKey("LEAVE_TYPE", leaveType)).toString();
			}
			//申请存库
			LeavePerson leavePerson = new LeavePerson();
			leavePerson.setLevaeId(id);
			leavePerson.setLeaveEndTime(new SimpleDateFormat("yyyyMMddHHmmss").format(c1.getTime()));
			leavePerson.setLeaveStartTime(new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime()));
			leavePerson.setLeaveReason(reason);
			leavePerson.setLeaveNum(leaveNum);
			leavePerson.setLeaveNumDesc(leaveNumDesc);
			leavePerson.setLeaveFirstApprovaler(approvaler);
			leavePerson.setLeaveType(leaveType);
			if(leaveNum > 3) {//请假天数大于3天，设置第三审阅人
				leavePerson.setLeaveThirdApprovaler(ApprovalerBean.THIRDAPPROVALER.getAdminId());
			}else {
				leavePerson.setLeaveThirdApprovaler("");
			}
			if(StringUtils.isNotBlank(fileId)) {
				//删除原先上传文件
				String oldFileId = leavePersonMapper.selectByPrimaryKey(id).getLeavePic();
				SysFile oldfile = fileMapper.selectByPrimaryKey(oldFileId);
				File file = new File(oldfile.getFilePath());
				file.delete();
				fileMapper.deleteByPrimaryKey(oldFileId);
				leavePerson.setLeavePic(fileId);
			}
			leavePersonMapper.updateByPrimaryKeySelective(leavePerson);
		} catch (ParseException e) {
			e.printStackTrace();
			return new DMTResultBean("1","系统异常","");
		}
		return new DMTResultBean();
	}

	/**
	 * 获取所有操作员
	 * @param request
	 * @return
	 */
	@Override
	public DMTResultBean getAllAdmin(HttpServletRequest request) {
		DMTSessionBean sessionBean = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		List<String> list = new ArrayList<String>();
		list.add(sessionBean.getAdminid());
		list.add("88888888");
		list.add("PT20171206160840");
		SysAdminExample example = new SysAdminExample();
		example.createCriteria().andAdminStatusEqualTo("0").andAdminIdNotIn(list);
		List<SysAdmin> admins = adminMapper.selectByExample(example);
		return new DMTResultBean("0","",admins);
	}

	/**
	 * 获取请假申请详细信息
	 * @param request
	 * @return
	 */
	@Override
	public DMTResultBean getLeaveDetail(HttpServletRequest request) {
		String id = request.getParameter("id");
		List<Map<String,Object>> list = leaveManageMapper.getLeaveDetail(id);
		if(list != null && list.size() > 0) {
			Map<String,Object> res = list.get(0);
			
			//最终审阅结果转换
			DMTStatusFormatter.formatStatus(res, "leavePass", "leavePassCopy", "LEAVE_PASS_STATUS", paramManageMapper);
			//请假类型转换
			DMTStatusFormatter.formatStatus(res, "leaveType", "leaveTypeCopy", "LEAVE_TYPE", paramManageMapper);
			//第一审阅结果转换
			DMTStatusFormatter.formatStatus(res, "firstApprovalRes", "firstApprovalResCopy", "LEAVE_AUTH_STATUS", paramManageMapper);
			//第二审阅结果转换
			DMTStatusFormatter.formatStatus(res, "secondApprovalRes", "secondApprovalResCopy", "LEAVE_AUTH_STATUS", paramManageMapper);
			//第三审阅结果转换
			DMTStatusFormatter.formatStatus(res, "thirdApprovalRes", "thirdApprovalResCopy", "LEAVE_AUTH_STATUS", paramManageMapper);
			//开始时间转换
			DMTTimeFormatter.formatTime(res, "startTime", "startTimeCopy");
			//结束时间转换
			DMTTimeFormatter.formatTime(res, "endTime", "endTimeCopy");
			//创建时间转换
			DMTTimeFormatter.formatTime(res, "createtime", "createtimeCopy");
			//最终审阅时间转换
			DMTTimeFormatter.formatTime(res, "approvalTime", "approvalTimeCopy");
			return new DMTResultBean("0","",res);
		}
		return new DMTResultBean("1","未查询到相关请假申请","");
	}

	/**
	 * 请假申请审阅
	 * @param request
	 * @return
	 */
	@Override
	public DMTResultBean leaveAuth(HttpServletRequest request) {
		DMTSessionBean sessionBean = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String leaveId = request.getParameter("leaveId");
		String aprovalRes = request.getParameter("aprovalRes");
		String aprovalDesc = request.getParameter("aprovalDesc");
		
		LeavePerson person = leavePersonMapper.selectByPrimaryKey(leaveId);
		Float leaveNum = person.getLeaveNum();
		String firstApprovaler = person.getLeaveFirstApprovaler();
		
		//非管理员审阅，修改第一审阅人审阅信息
		if(!"88888888".equals(sessionBean.getRoleid())) {
			LeavePerson leavePerson = new LeavePerson();
			leavePerson.setLevaeId(leaveId);
			leavePerson.setLeaveFirstApprovalDesc(aprovalDesc);
			leavePerson.setLeaveFirstApprovalRes(aprovalRes);
			leavePerson.setLeaveFirstApprovaler(sessionBean.getAdminid());
			leavePerson.setLeaveFirstApprovelStatus("00");
			if("1".equals(aprovalRes)) {
				//审阅拒绝，设置最终审阅结果和审阅时间
				leavePerson.setLeavePass("01");
				leavePerson.setLeaveApprovalTime(DMTDateUtil.parseDate());
			}
			leavePersonMapper.updateByPrimaryKeySelective(leavePerson);
		}else {
			if(firstApprovaler.equals(ApprovalerBean.SECONDAPPROVALER.getAdminId())) {
				if(leaveNum > 3) {
					if(ApprovalerBean.SECONDAPPROVALER.getAdminId().equals(sessionBean.getAdminid())) {
						LeavePerson leavePerson = new LeavePerson();
						leavePerson.setLevaeId(leaveId);
						leavePerson.setLeaveFirstApprovalDesc(aprovalDesc);
						leavePerson.setLeaveFirstApprovalRes(aprovalRes);
						leavePerson.setLeaveFirstApprovaler(sessionBean.getAdminid());
						leavePerson.setLeaveFirstApprovelStatus("00");
						if("1".equals(aprovalRes)) {
							//审阅拒绝，设置最终审阅结果和审阅时间
							leavePerson.setLeavePass("01");
							leavePerson.setLeaveApprovalTime(DMTDateUtil.parseDate());
						}
						leavePersonMapper.updateByPrimaryKeySelective(leavePerson);
					}else if(ApprovalerBean.THIRDAPPROVALER.getAdminId().equals(sessionBean.getAdminid())) {
						LeavePerson leavePerson = new LeavePerson();
						leavePerson.setLevaeId(leaveId);
						leavePerson.setLeaveSecondApprovalDesc(aprovalDesc);
						leavePerson.setLeaveSecondApprovalRes(aprovalRes);
						leavePerson.setLeaveSecondApprovaler(sessionBean.getAdminid());
						if("1".equals(aprovalRes)) {
							//审阅拒绝
							leavePerson.setLeavePass("01");
						}else {
							leavePerson.setLeavePass("00");
						}
						leavePerson.setLeaveApprovalTime(DMTDateUtil.parseDate());
						leavePerson.setLeaveSecondApprovelStatus("00");
						leavePersonMapper.updateByPrimaryKeySelective(leavePerson);
					}
				}else {
					LeavePerson leavePerson = new LeavePerson();
					leavePerson.setLevaeId(leaveId);
					leavePerson.setLeaveFirstApprovalDesc(aprovalDesc);
					leavePerson.setLeaveFirstApprovalRes(aprovalRes);
					leavePerson.setLeaveFirstApprovaler(sessionBean.getAdminid());
					leavePerson.setLeaveFirstApprovelStatus("00");
					if("1".equals(aprovalRes)) {
						//审阅拒绝
						leavePerson.setLeavePass("01");
					}else {
						leavePerson.setLeavePass("00");
					}
					leavePerson.setLeaveApprovalTime(DMTDateUtil.parseDate());
					leavePersonMapper.updateByPrimaryKeySelective(leavePerson);
				}
			}else {
				if(leaveNum > 3) {
					if(ApprovalerBean.SECONDAPPROVALER.getAdminId().equals(sessionBean.getAdminid())) {
						LeavePerson leavePerson = new LeavePerson();
						leavePerson.setLevaeId(leaveId);
						leavePerson.setLeaveSecondApprovalDesc(aprovalDesc);
						leavePerson.setLeaveSecondApprovalRes(aprovalRes);
						leavePerson.setLeaveSecondApprovaler(sessionBean.getAdminid());
						leavePerson.setLeaveSecondApprovelStatus("00");
						if("1".equals(aprovalRes)) {
							//审阅拒绝，设置最终审阅结果和审阅时间
							leavePerson.setLeavePass("01");
							leavePerson.setLeaveApprovalTime(DMTDateUtil.parseDate());
						}
						leavePersonMapper.updateByPrimaryKeySelective(leavePerson);
					}else if(ApprovalerBean.THIRDAPPROVALER.getAdminId().equals(sessionBean.getAdminid())) {
						LeavePerson leavePerson = new LeavePerson();
						leavePerson.setLevaeId(leaveId);
						leavePerson.setLeaveThirdApprovalDesc(aprovalDesc);
						leavePerson.setLeaveThirdApprovalRes(aprovalRes);
						leavePerson.setLeaveThirdApprovaler(sessionBean.getAdminid());
						if("1".equals(aprovalRes)) {
							//审阅拒绝
							leavePerson.setLeavePass("01");
						}else {
							leavePerson.setLeavePass("00");
						}
						leavePerson.setLeaveApprovalTime(DMTDateUtil.parseDate());
						leavePerson.setLeaveThirdApprovelStatus("00");
						leavePersonMapper.updateByPrimaryKeySelective(leavePerson);
					}
				}else {
					LeavePerson leavePerson = new LeavePerson();
					leavePerson.setLevaeId(leaveId);
					leavePerson.setLeaveSecondApprovalDesc(aprovalDesc);
					leavePerson.setLeaveSecondApprovalRes(aprovalRes);
					leavePerson.setLeaveSecondApprovaler(sessionBean.getAdminid());
					if("1".equals(aprovalRes)) {
						//审阅拒绝
						leavePerson.setLeavePass("01");
					}else {
						leavePerson.setLeavePass("00");
					}
					leavePerson.setLeaveApprovalTime(DMTDateUtil.parseDate());
					leavePerson.setLeaveSecondApprovelStatus("00");
					leavePersonMapper.updateByPrimaryKeySelective(leavePerson);
				}
			}
		}
		
		return new DMTResultBean();
	}

	/**
	 * 附件大小检查&上传
	 * @throws Exception 
	 */
	@Override
	public DMTResultBean checkFileSize(MultipartFile merCertPic, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//校验文件大小
		if(StringUtils.isNotEmpty(merCertPic.getOriginalFilename())){
			// 判断是否是图片
			BufferedImage image = ImageIO.read(merCertPic.getInputStream());
			if(null==image||image.getWidth()<=0||image.getHeight()<=0){//如果iamge=null 表示上传的不是图片格式
				return new DMTResultBean("1","上传的文件不是图片格式，请重新上传","");
			} else if(merCertPic.getSize()>10485760){
				return new DMTResultBean("1","图片大小不能超过10M","");
			} else {
				DMTSessionBean sessionBean = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
				String oldName = merCertPic.getOriginalFilename();
				//后缀
				String houzui = oldName.substring(oldName.indexOf(".")+1).toUpperCase();
				//保存文件名使用UUID
				String fileName = UUID.randomUUID().toString().replaceAll("-", "");
	
				String filePath = DMTConfigUtil.CONFIG_FILEPATH + fileName;
				
				// 保存图片到服务器
				DMTFileUtil.saveFile(merCertPic.getInputStream(), DMTConfigUtil.CONFIG_FILEPATH, fileName);
				
				// 保存图片表
				SysFile file = new SysFile();
				String fileId = DMTPrimaryKeyUtil.getPrimaryKey("");
				file.setFileId(fileId);
				file.setFileName(fileName);
				file.setFileOriginalName(oldName);
				file.setFilePath(filePath);
				file.setFileType(houzui);
				file.setFileCreateAdmin(sessionBean.getAdminid());
				file.setFileCreatetime(DMTDateUtil.parseDate());
				fileMapper.insertSelective(file);
				
				Map<String,String> res = new HashMap<String,String>();
				res.put("fileName", oldName);
				res.put("fileId", fileId);
				return new DMTResultBean("0","",res);
			}
		}
		return null;
	}
	
	/**
	 * 根据参数代码和参数key获取参数值
	 * @param code 参数代码
	 * @param key 参数key
	 * @return
	 */
	private String getParamValueByCodeAndKey(String code,String key) {
		String value = "";
		SysParamExample example = new SysParamExample();
		example.createCriteria().andParamCodeEqualTo(code).andParamKeyEqualTo(key);
		List<SysParam> params = paramMapper.selectByExample(example);
		if(params!=null && params.size()>0) {
			value = params.get(0).getParamValue();
		}
		return value;
	}

	/**
	 * 附件下载
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@Override
	public ResponseEntity<byte[]> fileDownload(HttpServletRequest request) throws IOException {
		String fileId = request.getParameter("fileId");
		SysFile sysFile = fileMapper.selectByPrimaryKey(fileId);
		File file = new File(sysFile.getFilePath());
		HttpHeaders headers = new HttpHeaders();
		String fileName = new String(sysFile.getFileOriginalName().getBytes("UTF-8"),"ISO8859-1");
		headers.setContentDispositionFormData("attacment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	
}
