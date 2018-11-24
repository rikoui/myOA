package com.bjdreamtech.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTSessionBean;
import com.bjdreamtech.dmt.util.DMTDateUtil;
import com.bjdreamtech.dmt.util.DMTPrimaryKeyUtil;
import com.bjdreamtech.entity.SysAdmin;
import com.bjdreamtech.entity.SysAdminExample;
import com.bjdreamtech.entity.TableDaily;
import com.bjdreamtech.entity.TableDailyExample;
import com.bjdreamtech.entity.TableNextplan;
import com.bjdreamtech.entity.TableNextplanExample;
import com.bjdreamtech.entity.TableWeekly;
import com.bjdreamtech.entity.TableWeeklyExample;
import com.bjdreamtech.entity.bean.WeeklyDetailsBean;
import com.bjdreamtech.format.DMTStatusFormatter;
import com.bjdreamtech.mapper.auto.SysAdminMapper;
import com.bjdreamtech.mapper.auto.TableDailyMapper;
import com.bjdreamtech.mapper.auto.TableNextplanMapper;
import com.bjdreamtech.mapper.auto.TableWeeklyMapper;
import com.bjdreamtech.mapper.custom.DailyManageMapper;
import com.bjdreamtech.mapper.custom.NextPlanManageMapper;
import com.bjdreamtech.mapper.custom.WeeklyManageMapper;
import com.bjdreamtech.service.IWeeklyService;
import com.bjdreamtech.util.DMTResultBean;

@Service("weeklyService")
public class WeeklyServiceImpl extends BaseServiceImpl implements IWeeklyService {
	@Resource
	private WeeklyManageMapper weeklyMapper;
	@Resource
	private DailyManageMapper dailyMapper;
	@Resource
	private NextPlanManageMapper nextPlanMapper;
	@Resource
	private TableWeeklyMapper tableWeeklyMapper;
	@Resource
	private TableDailyMapper tableDailyMapper;
	@Resource
	private TableNextplanMapper tableNextplanMapper;
	@Resource
	private SysAdminMapper sysAdminMapper;
	
	@Override
	public DMTResultBean getWeekly(HttpServletRequest request) throws Exception {
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String rolename = admin.getRolename();
		String weeklyadmin = admin.getRealname();
		String weeklyadminid = admin.getAdminid();
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_MONTH, -1);  
		String time = DMTDateUtil.parseDate(cal.getTime()).substring(0, 8);
		// cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),
		// cal.get(Calendar.DAY_OF_MONTH));
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		String timeStart = "";
		String timeEnd = "";
		if (weeks[week_index] == "星期日") {
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			cal.add(Calendar.DAY_OF_WEEK, -7);
			Date timestr = cal.getTime();
			timeStart = DMTDateUtil.parseDate(timestr).substring(0, 8);
			timeEnd = time;
		} else {
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			Date timestr = cal.getTime();
			timeStart = DMTDateUtil.parseDate(timestr).substring(0, 8);
			cal.setTime(timestr);
			cal.add(Calendar.DAY_OF_WEEK, 6);
			Date timeE = cal.getTime();
			timeEnd = DMTDateUtil.parseDate(timeE).substring(0, 8);
		}
		WeeklyDetailsBean weeklyBean = new WeeklyDetailsBean();
		weeklyBean.setRolename(rolename);
		weeklyBean.setWeeklyadmin(weeklyadmin);
		weeklyBean.setTimeStart(DMTDateUtil.packDateShort(timeStart));
		weeklyBean.setTimeEnd(DMTDateUtil.packDateShort(timeEnd));
		Map<String, Object> params = new HashMap<String, Object>();
		if (notNull(time)) {
			params.put("weeklystart", time);
		}
		if (notNull(weeklyadminid)) {
			params.put("weeklyadminid", weeklyadminid);
		}

		List<Map<String, Object>> weekly = weeklyMapper.WeeklyQuery(params);
		if (weekly == null || weekly.size() == 0) {
			return new DMTResultBean("0", "", weeklyBean);
		} else {
			String authadmin = (String) weekly.get(0).get("weekly_auth_admin");
			String lastdesc = (String) weekly.get(0).get("weekly_lastdesc");
			weeklyBean.setAuthAdmin(authadmin);
			weeklyBean.setLastDesc(lastdesc);
			String weeklyId = (String) weekly.get(0).get("weekly_id");
			System.out.println("==="+weeklyId);
			List<Map<String, Object>> daily = dailyMapper.dailyQueryList(weeklyId);
			String[] dailyTime = new String[daily.size()];
			String[] dailyPart = new String[daily.size()];
			String[] dailyContent = new String[daily.size()];
			String[] dailyQuestion = new String[daily.size()];
			String[] dailyAnswer = new String[daily.size()];
			for (int i = 0; i < daily.size(); i++) {
				String dailytime = (String) daily.get(i).get("daily_time");
				if (dailytime != null || dailytime != "") {
					dailyTime[i] = dailytime + " " + (String) daily.get(i).get("daily_week");
				}
				dailyPart[i] = (String) daily.get(i).get("daily_part");
				dailyContent[i] = (String) daily.get(i).get("daily_content");
				dailyQuestion[i] = (String) daily.get(i).get("daily_question");
				dailyAnswer[i] = (String) daily.get(i).get("daily_answer");
			}
			weeklyBean.setDailyTime(dailyTime);
			weeklyBean.setDailyPart(dailyPart);
			weeklyBean.setDailyContent(dailyContent);
			weeklyBean.setDailyQuestion(dailyQuestion);
			weeklyBean.setDailyAnswer(dailyAnswer);

			List<Map<String, Object>> nextPlan = nextPlanMapper.nextPlanQueryList(weeklyId);
			int[] no = new int[nextPlan.size()];
			String[] nextplanThing = new String[nextPlan.size()];
			String[] nextplanStarttime = new String[nextPlan.size()];
			String[] nextplanOvertime = new String[nextPlan.size()];
			String[] nextplanLeading = new String[nextPlan.size()];
			String[] nextplanPart = new String[nextPlan.size()];
			for (int i = 0; i < nextPlan.size(); i++) {
				no[i] = i + 1;
				nextplanThing[i] = (String) nextPlan.get(i).get("nextplan_thing");
				nextplanStarttime[i] = (String) nextPlan.get(i).get("nextplan_starttime");
				nextplanOvertime[i] = (String) nextPlan.get(i).get("nextplan_overtime");
				nextplanLeading[i] = (String) nextPlan.get(i).get("nextplan_leading");
				nextplanPart[i] = (String) nextPlan.get(i).get("nextplan_parting");
			}
			weeklyBean.setNo(no);
			weeklyBean.setNextplanThing(nextplanThing);
			weeklyBean.setNextplanStarttime(nextplanStarttime);
			weeklyBean.setNextplanOvertime(nextplanOvertime);
			weeklyBean.setNextplanLeading(nextplanLeading);
			weeklyBean.setNextplanPart(nextplanPart);
			return new DMTResultBean("0", "", weeklyBean);
		}
	}

	@Override
	public DMTResultBean findWeeklyAdminSelect(HttpServletRequest request) {
		List<TableWeekly> weeklyAdminList = weeklyMapper.queryWeeklyAdminSelect();
		return new DMTResultBean("0", "", weeklyAdminList);
	}

	@Override
	public DMTDataTableBean<Map<String, Object>> queryWeeklyByPage(HttpServletRequest request) {
		// 初始化分页参数
		initPageParameter(request);
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String realname = admin.getRealname();
		String weeklytime = request.getParameter("weeklytime");
		String weeklystatus = request.getParameter("weeklystatus");
		if (notNull(realname)) {
			params.put("realname", realname);
		}
		params.put("weeklyadmin", admin.getAdminid());
		if (notNull(weeklytime)) {
			weeklytime = weeklytime.replace("-", "");
			params.put("weeklytime", weeklytime);
		}
		if (notNull(weeklystatus)) {
			params.put("weeklystatus", weeklystatus);
		}
		List<Map<String, Object>> weeklyList = weeklyMapper.queryWeeklyListByPage(params);
		DMTStatusFormatter.formatStatusList(weeklyList, "weeklystatus", "weeklystatuscopy", "WEEKLY_AUTH_STATUS",
				paramManageMapper);
		List<Map<String, Object>> weeklylist = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < weeklyList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("staffno", weeklyList.get(i).get("staffno"));
			map.put("weeklyadmin", weeklyList.get(i).get("weeklyadmin"));
			map.put("authadmin", weeklyList.get(i).get("authadmin"));
			map.put("weeklystart", DMTDateUtil.packDateShort((String) weeklyList.get(i).get("weeklystart")));
			map.put("weeklyend", DMTDateUtil.packDateShort((String) weeklyList.get(i).get("weeklyend")));
			map.put("weeklystatus", weeklyList.get(i).get("weeklystatuscopy"));
			map.put("weeklyadminid", weeklyList.get(i).get("weeklyadminid"));
			weeklylist.add(map);
		}
		return new DMTDataTableBean<Map<String, Object>>(pageUtil.getTotalCount(), weeklylist);
	}

	@Override
	public DMTResultBean queryWeeklyDetail(HttpServletRequest request) throws Exception {
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String rolename = admin.getRolename();
		String weeklystart = request.getParameter("weeklystart");
		String weeklyadmin = request.getParameter("weeklyadminid");
		String review = request.getParameter("review");
		String flag = request.getParameter("flag");
		Map<String, Object> params = new HashMap<String, Object>();
		if (notNull(weeklystart)) {
			weeklystart = weeklystart.replace("-", "");
			params.put("weeklystart", weeklystart);
		}
		if (notNull(weeklyadmin)) {
			params.put("weeklyadminid", weeklyadmin);
		}

		// 点击审阅，修改状态，添加审阅人
		if ("true".equals(flag)) {
			TableWeeklyExample tableWeeklyExample = new TableWeeklyExample();
			tableWeeklyExample.createCriteria().andWeeklyAdminIdEqualTo(weeklyadmin).andWeeklyStartEqualTo(weeklystart);
			List<TableWeekly> tableWeeklyList = tableWeeklyMapper.selectByExample(tableWeeklyExample);
			if (tableWeeklyList != null && tableWeeklyList.size() > 0) {
				TableWeekly tableWeekly = tableWeeklyList.get(0);
				if (notNull(tableWeekly.getWeeklyRealyauth())) {
					if (!tableWeekly.getWeeklyRealyauth().contains(admin.getRealname())) {
						tableWeekly.setWeeklyRealyauth(tableWeekly.getWeeklyRealyauth() + "," + admin.getRealname());
					}
				} else {
					tableWeekly.setWeeklyRealyauth(admin.getRealname());
				}
				tableWeekly.setWeeklyStatus("00");
				if (!notNull(tableWeekly.getWeeklyRemark())) {
					tableWeekly.setWeeklyRemark(admin.getRealname() + "已审阅");
				}
				tableWeeklyMapper.updateByPrimaryKey(tableWeekly);
			}
		}
		
		List<Map<String, Object>> weekly = weeklyMapper.QueryWeeklyDetail(params);
		WeeklyDetailsBean weeklyBean = new WeeklyDetailsBean();
		// 部门
		if ("review".equals(review)) {
			weeklyBean.setRolename((String) weekly.get(0).get("roleName"));
		} else {
			weeklyBean.setRolename(rolename);
		}
		if (weekly == null || weekly.size() == 0) {
			return new DMTResultBean("0", "", weeklyBean);
		} else {
			String timeStart = (String) weekly.get(0).get("weekly_start");
			String timeEnd = (String) weekly.get(0).get("weekly_end");
			String authadminName = (String) weekly.get(0).get("authadmin");
			String authadminId = (String) weekly.get(0).get("weekly_auth_admin");
			String authadmin = authadminName + "AND" + authadminId;
			String lastdesc = (String) weekly.get(0).get("weekly_lastdesc");
			String weeklyRemark = (String) weekly.get(0).get("weekly_remark");
			if (!notNull(weeklyRemark) && "true".equals(flag)) {
				weeklyRemark = admin.getRealname() + "已审阅";
			}
			// 填写人
			weeklyBean.setWeeklyadmin((String) weekly.get(0).get("realName"));
			// 开始时间
			weeklyBean.setTimeStart(DMTDateUtil.packDateShort(timeStart));
			// 结束时间
			weeklyBean.setTimeEnd(DMTDateUtil.packDateShort(timeEnd));
			// 审核
			weeklyBean.setAuthAdmin(authadmin);
			// 上周总结
			weeklyBean.setLastDesc(lastdesc);
			// 周报审核意见
			weeklyBean.setWeeklyRemark(weeklyRemark);
			
			String weeklyId = (String) weekly.get(0).get("weekly_id");
			List<Map<String, Object>> daily = dailyMapper.dailyQueryList(weeklyId);
			String[] dailyTime = new String[daily.size()];
			String[] dailyPart = new String[daily.size()];
			String[] dailyContent = new String[daily.size()];
			String[] dailyQuestion = new String[daily.size()];
			String[] dailyAnswer = new String[daily.size()];
			String[] dailyRemark = new String[daily.size()];
			for (int i = 0; i < daily.size(); i++) {
				String dailytime = (String) daily.get(i).get("daily_time");
				if (dailytime != null || dailytime != "") {
					dailyTime[i] = dailytime + " " + (String) daily.get(i).get("daily_week");
				}
				dailyPart[i] = (String) daily.get(i).get("daily_part");
				dailyContent[i] = (String) daily.get(i).get("daily_content");
				dailyQuestion[i] = (String) daily.get(i).get("daily_question");
				dailyAnswer[i] = (String) daily.get(i).get("daily_answer");
				dailyRemark[i] = (String) daily.get(i).get("daily_remark");
			}
			weeklyBean.setDailyTime(dailyTime);
			weeklyBean.setDailyPart(dailyPart);
			weeklyBean.setDailyContent(dailyContent);
			weeklyBean.setDailyQuestion(dailyQuestion);
			weeklyBean.setDailyAnswer(dailyAnswer);
			weeklyBean.setDailyRemark(dailyRemark);

			List<Map<String, Object>> nextPlan = nextPlanMapper.nextPlanQueryList(weeklyId);
			int[] no = new int[nextPlan.size()];
			String[] nextplanThing = new String[nextPlan.size()];
			String[] nextplanStarttime = new String[nextPlan.size()];
			String[] nextplanOvertime = new String[nextPlan.size()];
			String[] nextplanLeading = new String[nextPlan.size()];
			String[] nextplanPart = new String[nextPlan.size()];
			for (int i = 0; i < nextPlan.size(); i++) {
				no[i] = i + 1;
				nextplanThing[i] = (String) nextPlan.get(i).get("nextplan_thing");
				nextplanStarttime[i] = (String) nextPlan.get(i).get("nextplan_starttime");
				nextplanOvertime[i] = (String) nextPlan.get(i).get("nextplan_overtime");
				nextplanLeading[i] = (String) nextPlan.get(i).get("nextplan_leading");
				nextplanPart[i] = (String) nextPlan.get(i).get("nextplan_parting");
			}
			weeklyBean.setNo(no);
			weeklyBean.setNextplanThing(nextplanThing);
			weeklyBean.setNextplanStarttime(nextplanStarttime);
			weeklyBean.setNextplanOvertime(nextplanOvertime);
			weeklyBean.setNextplanLeading(nextplanLeading);
			weeklyBean.setNextplanPart(nextplanPart);
			return new DMTResultBean("0", "", weeklyBean);
		}
	}

	@Override
	public DMTResultBean weeklyReview(HttpServletRequest request) {
		DMTSessionBean userinfo = getSessionBean(request);
		String weeklyadmin = request.getParameter("weeklyadmin");
		String weeklystart = request.getParameter("weeklystart");
		String remark = request.getParameter("remark");
		Map<String, Object> params = new HashMap<String, Object>();
		if (notNull(weeklystart)) {
			weeklystart = weeklystart.replace("-", "");
			params.put("weeklystart", weeklystart);
		}
		if (notNull(weeklyadmin)) {
			params.put("weeklyadmin", weeklyadmin);
		}
		List<Map<String, Object>> weekly = weeklyMapper.QueryWeekly(params);
		TableWeekly tableWeekly = new TableWeekly();
		tableWeekly.setWeeklyId((String) weekly.get(0).get("weekly_id"));
		tableWeekly.setWeeklyAdminId((String) weekly.get(0).get("weekly_admin_id"));

		tableWeekly.setWeeklyAuthAdmin((String) weekly.get(0).get("weekly_auth_admin"));
		tableWeekly.setWeeklyStart(weeklystart);
		tableWeekly.setWeeklyEnd((String) weekly.get(0).get("weekly_end"));
		tableWeekly.setWeeklyStatus("00");
		tableWeekly.setWeeklyLastdesc((String) weekly.get(0).get("weekly_lastdesc"));
		tableWeekly.setWeeklyRemark(remark);
		tableWeekly.setWeeklyRealyauth((String) weekly.get(0).get("weekly_realyauth"));
		tableWeeklyMapper.updateByPrimaryKeySelective(tableWeekly);
		log.logging("修改周报状态", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return null;
	}

	@Override
	public DMTResultBean saveWeekly(HttpServletRequest request) {
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		// 当前登录操作员ID
		String weeklyadminid = admin.getAdminid();
		// 审阅人
		String weeklyauthadmin = request.getParameter("authadmin");
		// 开始时间
		String weeklyStart = request.getParameter("weeklystart");
		String weeklystart = weeklyStart.replace("-", "");
		// 结束时间
		String weeklyEnd = request.getParameter("weeklyend");
		String weeklyend = weeklyEnd.replace("-", "");
		//String weeklystatus = "01";
		String weeklylastdesc = request.getParameter("lastdesc");
		
		// 日报
		String dailytime = request.getParameter("dailytime");
		//String[] dailytimes =dailytime.split(",");
		String dailypart = request.getParameter("dailypart");
		//String[] dailyparts = dailypart.split("\\*");
		String dailycontent = request.getParameter("dailycontent");
		//String[] dailycontents = dailycontent.split("\\*");
		String dailyquestion = request.getParameter("dailyquestion");
		//String[] dailyquestions = dailyquestion.split("\\*");
		String dailyanswer = request.getParameter("dailyanswer");
		//String[] dailyanswers = dailyanswer.split("\\*");
		
		// 下周计划
		// 下周事情
		String nextplanthing = request.getParameter("nextplanthing");
		String[] nextplanthings = nextplanthing.split("SPLIT");
		// 计划开始时间
		String nextplanstarttime = request.getParameter("nextplanstarttime");
		String[] nextplanstarttimes = nextplanstarttime.split("SPLIT");
		// 计划完成时间
		String nextplanovertime = request.getParameter("nextplanovertime");
		String[] nextplanovertimes = nextplanovertime.split("SPLIT");
		// 负责任
		String nextplanleading = request.getParameter("nextplanleading");
		String[] nextplanleadings = nextplanleading.split("SPLIT");
		// 参与人
		String nextplanparting = request.getParameter("nextplanparting");
		String[] nextplanpartings = nextplanparting.split("SPLIT");
		// 下周计划条数
		String planCount = request.getParameter("planCount");
		
		if (!notNull(weeklyauthadmin)) {
			return new DMTResultBean("1", "审阅人不能为空", "审阅人不能为空");
		}
		
		// 周报ID
		String weeklyId = "";
		
		// 查询是否提交过周报
		TableWeeklyExample tableWeeklyExample = new TableWeeklyExample();
		tableWeeklyExample.createCriteria().andWeeklyAdminIdEqualTo(weeklyadminid).andWeeklyStartEqualTo(weeklystart);
		List<TableWeekly> tableWeeklyList = tableWeeklyMapper.selectByExample(tableWeeklyExample);
		
		// 星期一
		if (weeklyStart.equals(dailytime.split(" ")[0])) {
			// 已经提交过周报
			if (tableWeeklyList != null && tableWeeklyList.size() > 0) {
				TableWeekly tableWeekly = tableWeeklyList.get(0);
				weeklyId = tableWeekly.getWeeklyId();
				if ("00".equals(tableWeekly.getWeeklyStatus())) {
					return new DMTResultBean("1", "周报已审阅，不能修改！", "周报已审阅，不能修改！");
				}
				// 修改周报
				tableWeekly.setWeeklyAuthAdmin(weeklyauthadmin);
				tableWeekly.setWeeklyLastdesc(weeklylastdesc);
				tableWeeklyMapper.updateByPrimaryKey(tableWeekly);
				// 修改日报
				TableDailyExample tableDailyExample = new TableDailyExample();
				tableDailyExample.createCriteria().andDailyWeeklyIdEqualTo(weeklyId).andDailyTimeEqualTo(dailytime.split(" ")[0]);
				List<TableDaily> tableDailyList = tableDailyMapper.selectByExample(tableDailyExample);
				// 已提交日报
				if (tableDailyList != null && tableDailyList.size() > 0) {
					TableDaily tableDaily = tableDailyList.get(0);
					if ("00".equals(tableDaily.getDailyStatus())) {
						return new DMTResultBean("1", "当天日报已审阅，不能修改！", "当天日报已审阅，不能修改！");
					} else {
						tableDaily.setDailyPart(dailypart);
						tableDaily.setDailyContent(dailycontent);
						tableDaily.setDailyQuestion(dailyquestion);
						tableDaily.setDailyAnswer(dailyanswer);
						tableDaily.setDailyCommittime(DMTDateUtil.parseDate());
						tableDaily.setDailyStatus("01");
						tableDailyMapper.updateByPrimaryKey(tableDaily);
					}
				} else {
					// 新增日报
					TableDaily tableDaily = new TableDaily();
					tableDaily.setDailyId(DMTPrimaryKeyUtil.getPrimaryKey(""));
					tableDaily.setDailyWeeklyId(weeklyId);
					tableDaily.setDailyTime(dailytime.split(" ")[0]);
					tableDaily.setDailyWeek(dailytime.split(" ")[1]);
					tableDaily.setDailyPart(dailypart);
					tableDaily.setDailyContent(dailycontent);
					tableDaily.setDailyQuestion(dailyquestion);
					tableDaily.setDailyAnswer(dailyanswer);
					tableDaily.setDailyCommittime(DMTDateUtil.parseDate());
					tableDaily.setDailyStatus("01");
					tableDailyMapper.insertSelective(tableDaily);
				}
			} else {
				// 未提交周报
				// 新增周报
				weeklyId = DMTPrimaryKeyUtil.getPrimaryKey("");
				TableWeekly tableWeekly = new TableWeekly();
				tableWeekly.setWeeklyId(weeklyId);
				tableWeekly.setWeeklyAdminId(weeklyadminid);
				tableWeekly.setWeeklyAuthAdmin(weeklyauthadmin);
				tableWeekly.setWeeklyStart(weeklystart);
				tableWeekly.setWeeklyEnd(weeklyend);
				tableWeekly.setWeeklyStatus("01");
				tableWeekly.setWeeklyLastdesc(weeklylastdesc);
				int weeklyCount = tableWeeklyMapper.insertSelective(tableWeekly);
				if (weeklyCount > 0) {
					// 新增日报
					TableDaily tableDaily = new TableDaily();
					tableDaily.setDailyId(DMTPrimaryKeyUtil.getPrimaryKey(""));
					tableDaily.setDailyWeeklyId(weeklyId);
					tableDaily.setDailyTime(dailytime.split(" ")[0]);
					tableDaily.setDailyWeek(dailytime.split(" ")[1]);
					tableDaily.setDailyPart(dailypart);
					tableDaily.setDailyContent(dailycontent);
					tableDaily.setDailyQuestion(dailyquestion);
					tableDaily.setDailyAnswer(dailyanswer);
					tableDaily.setDailyCommittime(DMTDateUtil.parseDate());
					tableDaily.setDailyStatus("01");
					tableDailyMapper.insertSelective(tableDaily);
				}
			}
		} else {
			// 查询周报
			if (tableWeeklyList != null && tableWeeklyList.size() > 0) {
				TableWeekly tableWeekly = tableWeeklyList.get(0);
				weeklyId = tableWeekly.getWeeklyId();
				tableWeekly.setWeeklyAuthAdmin(weeklyauthadmin);
				tableWeeklyMapper.updateByPrimaryKey(tableWeekly);
			} else {
				TableWeekly tableWeekly = new TableWeekly();
				weeklyId = DMTPrimaryKeyUtil.getPrimaryKey("");
				tableWeekly.setWeeklyId(weeklyId);
				tableWeekly.setWeeklyAdminId(weeklyadminid);
				tableWeekly.setWeeklyAuthAdmin(weeklyauthadmin);
				tableWeekly.setWeeklyStart(weeklystart);
				tableWeekly.setWeeklyEnd(weeklyend);
				tableWeekly.setWeeklyStatus("01");
				tableWeekly.setWeeklyLastdesc(weeklylastdesc);
				tableWeeklyMapper.insertSelective(tableWeekly);
			}
			
			// 保存日报
			// 查询当天日报
			TableDailyExample tableDailyExample = new TableDailyExample();
			tableDailyExample.createCriteria().andDailyWeeklyIdEqualTo(weeklyId).andDailyTimeEqualTo(dailytime.split(" ")[0]);
			List<TableDaily> tableDailyList = tableDailyMapper.selectByExample(tableDailyExample);
			// 已提交日报
			if (tableDailyList != null && tableDailyList.size() > 0) {
				TableDaily tableDaily = tableDailyList.get(0);
				if ("00".equals(tableDaily.getDailyStatus())) {
					return new DMTResultBean("1", "当天日报已审阅，不能修改！", "当天日报已审阅，不能修改！");
				} else {
					tableDaily.setDailyPart(dailypart);
					tableDaily.setDailyContent(dailycontent);
					tableDaily.setDailyQuestion(dailyquestion);
					tableDaily.setDailyAnswer(dailyanswer);
					tableDaily.setDailyCommittime(DMTDateUtil.parseDate());
					tableDaily.setDailyStatus("01");
					tableDailyMapper.updateByPrimaryKey(tableDaily);
				}
			} else {
				// 新增日报
				TableDaily tableDaily = new TableDaily();
				tableDaily.setDailyId(DMTPrimaryKeyUtil.getPrimaryKey(""));
				tableDaily.setDailyWeeklyId(weeklyId);
				tableDaily.setDailyTime(dailytime.split(" ")[0]);
				tableDaily.setDailyWeek(dailytime.split(" ")[1]);
				tableDaily.setDailyPart(dailypart);
				tableDaily.setDailyContent(dailycontent);
				tableDaily.setDailyQuestion(dailyquestion);
				tableDaily.setDailyAnswer(dailyanswer);
				tableDaily.setDailyCommittime(DMTDateUtil.parseDate());
				tableDaily.setDailyStatus("01");
				tableDailyMapper.insertSelective(tableDaily);
			}
		}
		
		// 新增下周计划
		if (!"0".equals(planCount)) {
			// 查询下周计划
			TableNextplanExample tableNextplanExample = new TableNextplanExample();
			tableNextplanExample.createCriteria().andNextplanWeeklyIdEqualTo(weeklyId);
			// 删除下周计划
			tableNextplanMapper.deleteByExample(tableNextplanExample);
			// 新增下周计划
			TableNextplan tableNextplan = new TableNextplan();
			for (int i = 0; i < Integer.parseInt(planCount); i++) {
				tableNextplan.setNextplanId(DMTPrimaryKeyUtil.getPrimaryKey(""));
				tableNextplan.setNextplanThing(nextplanthings[i + 1].equals("@#@") ? "" : nextplanthings[i + 1]);
				tableNextplan.setNextplanStarttime(nextplanstarttimes[i + 1].equals("@#@") ? "" : nextplanstarttimes[i + 1]);
				tableNextplan.setNextplanOvertime(nextplanovertimes[i + 1].equals("@#@") ? "" : nextplanovertimes[i + 1]);
				tableNextplan.setNextplanLeading(nextplanleadings[i + 1].equals("@#@") ? "" : nextplanleadings[i + 1]);
				tableNextplan.setNextplanParting(nextplanpartings[i + 1].equals("@#@") ? "" : nextplanpartings[i + 1]);
				tableNextplan.setNextplanWeeklyId(weeklyId);
				int insertSelective = tableNextplanMapper.insertSelective(tableNextplan);
				if (insertSelective == 0) {
					return new DMTResultBean("1", "失败", "下周计划提交失败");
				}
			}
		}
		return new DMTResultBean("0", "成功", "周报提交成功");
	}

	@Override
	public DMTResultBean findSysAdminSelect() {
		SysAdminExample sysAdminExample = new SysAdminExample();
		sysAdminExample.createCriteria().andAdminStatusEqualTo("0");
		List<SysAdmin> sysAdminList = sysAdminMapper.selectByExample(sysAdminExample);
		return new DMTResultBean("0", "", sysAdminList);
	}

	@Override
	public DMTDataTableBean<Map<String, Object>> queryweeklyReadByPage(HttpServletRequest request) {
		// 初始化分页参数
		initPageParameter(request);
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		// 获取当前登录人员的ID
		String adminid = admin.getAdminid();
		// 获取提交人
		String weeklyadmin = request.getParameter("weeklyadmin");
		// 获取周报时间
		String weeklytime = request.getParameter("weeklytime");
		// 获取周报状态
		String weeklystatus = request.getParameter("weeklystatus");
		
		if (notNull(adminid)) {
			params.put("adminid", adminid);
		}
		if (notNull(weeklyadmin)) {
			params.put("weeklyadmin", weeklyadmin);
		}
		if (notNull(weeklytime)) {
			weeklytime = weeklytime.replace("-", "");
			params.put("weeklytime", weeklytime);
		}
		if (notNull(weeklystatus)) {
			params.put("weeklystatus", weeklystatus);
		}
		params.put("adminRoleId", admin.getRoleid());
		
		List<Map<String, Object>> weeklyList = weeklyMapper.queryweeklyReadListByPage(params);
		DMTStatusFormatter.formatStatusList(weeklyList, "weeklystatus", "weeklystatuscopy", "WEEKLY_AUTH_STATUS", paramManageMapper);
		List<Map<String, Object>> weeklylist = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < weeklyList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("staffno", weeklyList.get(i).get("staffno"));
			map.put("weeklyadmin", weeklyList.get(i).get("weeklyadmin"));
			map.put("authadmin", weeklyList.get(i).get("authadmin"));
			map.put("weeklystart", DMTDateUtil.packDateShort((String) weeklyList.get(i).get("weeklystart")));
			map.put("weeklyend", DMTDateUtil.packDateShort((String) weeklyList.get(i).get("weeklyend")));
			map.put("weeklystatus", weeklyList.get(i).get("weeklystatuscopy"));
			map.put("weeklyadminid", weeklyList.get(i).get("weeklyadminid"));
			map.put("realyAuth", weeklyList.get(i).get("realyAuth"));
			map.put("realyAuthname", weeklyList.get(i).get("realyAuthname"));
			map.put("roleName", weeklyList.get(i).get("roleName"));
			weeklylist.add(map);
		}
		return new DMTDataTableBean<Map<String, Object>>(pageUtil.getTotalCount(), weeklylist);
	}

	@Override
	public DMTDataTableBean<Map<String, Object>> queryDailyReadByPage(HttpServletRequest request) {
		initPageParameter(request);
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		// 提交人
		String weeklyAdmin = request.getParameter("weeklyAdmin");
		// 日报日期
		String dailyTime = request.getParameter("dailyTime");
		// 审阅状态
		String dailyStatus = request.getParameter("dailyStatus");
		if (notNull(weeklyAdmin)) {
			params.put("weeklyAdmin", weeklyAdmin);
		}
		if (notNull(dailyTime)) {
			params.put("dailyTime", dailyTime);
		}
		if (notNull(dailyStatus)) {
			params.put("dailyStatus", dailyStatus);
		}
		params.put("adminAuthId", admin.getAdminid());
		params.put("adminRoleId", admin.getRoleid());
		
		List<Map<String, Object>> dailyList = dailyMapper.queryDailyReadListByPage(params);
		DMTStatusFormatter.formatStatusList(dailyList, "dailyStatus", "dailyStatusCopy", "WEEKLY_AUTH_STATUS", paramManageMapper);
		List<Map<String, Object>> dailylist = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < dailyList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("dailyId", dailyList.get(i).get("dailyId"));
			map.put("staffNo", dailyList.get(i).get("staffNo"));
			map.put("weeklyAdminId", dailyList.get(i).get("weeklyAdminId"));
			map.put("adminName", dailyList.get(i).get("adminName"));
			map.put("authAdmin", dailyList.get(i).get("authAdmin"));
			map.put("authAdminName", dailyList.get(i).get("authAdminName"));
			map.put("realyAuth", dailyList.get(i).get("realyAuth"));
			map.put("realyAuthName", dailyList.get(i).get("realyAuthName"));
			map.put("dailyTime", dailyList.get(i).get("dailyTime"));
			map.put("dailyStatus", dailyList.get(i).get("dailyStatus"));
			map.put("dailyStatusCopy", dailyList.get(i).get("dailyStatusCopy"));
			map.put("roleName", dailyList.get(i).get("roleName"));
			dailylist.add(map);
		}
		return new DMTDataTableBean<Map<String, Object>>(pageUtil.getTotalCount(), dailylist);
	}

	@Override
	public DMTResultBean queryDaily(HttpServletRequest request) {
		// 点击审阅按钮时，修改审阅状态
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String dailyId = request.getParameter("dailyId");
		String flag = request.getParameter("flag");
		TableDaily tableDaily = tableDailyMapper.selectByPrimaryKey(dailyId);
		if ("true".equals(flag)) {
			tableDaily.setDailyStatus("00");
			String dailyRemark = tableDaily.getDailyRemark();
			if (!notNull(dailyRemark)) {
				dailyRemark = admin.getRealname() + "已审阅";
				tableDaily.setDailyRemark(dailyRemark);
			}
			String dailyRealyauth = tableDaily.getDailyRealyauth();
			if (notNull(dailyRealyauth)) {
				if (!dailyRealyauth.contains(admin.getRealname())) {
					tableDaily.setDailyRealyauth(dailyRealyauth + "," + admin.getRealname());
				}
			} else {
				tableDaily.setDailyRealyauth(admin.getRealname());
			}
			tableDailyMapper.updateByPrimaryKey(tableDaily);
		}
		return new DMTResultBean("0", "", tableDaily);
	}

	@Override
	public DMTResultBean saveDailyRead(HttpServletRequest request) {
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		// 获取当前登录人员的ID
		String dailyId = request.getParameter("dailyId");
		String dailyReadRemark = request.getParameter("dailyReadRemark");
		if (isNull(dailyReadRemark)) {
			return new DMTResultBean("1", "审阅意见不能为空！", "");
		}
		TableDaily tableDaily = tableDailyMapper.selectByPrimaryKey(dailyId);
		tableDaily.setDailyRemark(dailyReadRemark);
		tableDaily.setDailyStatus("00");
		if (!tableDaily.getDailyRealyauth().contains(admin.getRealname())) {
			tableDaily.setDailyRealyauth(tableDaily.getDailyRealyauth() + "," + admin.getRealname());
		}
		int count = tableDailyMapper.updateByPrimaryKey(tableDaily);
		if (count > 0) {
			return new DMTResultBean("0", "", "审阅成功！");
		}
		return new DMTResultBean("1", "审阅失败！", "");
	}

	@Override
	public DMTResultBean queryCountDaily(HttpServletRequest request) {
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		// 统计预期未提交日报
		if ("88888888".equals(admin.getRoleid())) {
			List<String> values = new ArrayList<String>();
//			values.add("PT20171206225533"); // 李秋燕
//			values.add("PT20180314105532"); // 武鑫勇
//			values.add("ZM044"); // 张志强
			values.add("88888888");
			values.add("ROLE0C4DF34FED2F48B4B045E4056D5BB6CE");//市场部
			values.add("ROLEEB3BA18D755840CB96F3B382E64CAD27");//销售部
			// 查询除管理员、市场部、销售部外的所有用户
			SysAdminExample sysAdminExample = new SysAdminExample();
//			sysAdminExample.createCriteria().andAdminRoleIdNotEqualTo("88888888").andAdminStatusEqualTo("0").andAdminIdNotIn(values);
			sysAdminExample.createCriteria().andAdminRoleIdNotIn(values).andAdminStatusEqualTo("0");
			List<SysAdmin> sysAdminList = sysAdminMapper.selectByExample(sysAdminExample);
			/*// 查询用户提交日报的总条数
			List<Map<String,Object>> queryDailyCount = dailyMapper.queryDailyCount();
			// 用于存放用户和最后一次提交日报距离今天的天数
			List<Map<String,Object>> resultMap = new ArrayList<Map<String,Object>>();
			if (sysAdminList != null && sysAdminList.size() > 0) {
				for (SysAdmin sysAdmin : sysAdminList) {
					Map<String, Object> sysAdminAndMap = new HashMap<String, Object>();
					String sysAdminId = sysAdmin.getAdminId();
					String createTime = sysAdmin.getAdminCreatetime().substring(0, 8);
					// 用户创建的天数
					int sysCount = getDayCount(createTime);
					// 用于标记是否提交过日报
					boolean notCommit = true;
					if (queryDailyCount != null && queryDailyCount.size() > 0) {
						for (Map<String, Object> dailyMap : queryDailyCount) {
							String dailyAdminId = (String)dailyMap.get("adminId");
							if (sysAdminId.equals(dailyAdminId)) {
								notCommit = false;
								// 用户提交日报的条数
								int dailyCount = ((Long)dailyMap.get("dailyCount")).intValue();
								sysAdminAndMap.put("adminId", sysAdmin.getAdminId());
								sysAdminAndMap.put("adminRealName", sysAdmin.getAdminRealname());
								sysAdminAndMap.put("dayCount", sysCount - dailyCount);
								break;
							}
						}
						if (notCommit) {
							sysAdminAndMap.put("adminId", sysAdmin.getAdminId());
							sysAdminAndMap.put("adminRealName", sysAdmin.getAdminRealname());
							sysAdminAndMap.put("dayCount", sysCount);
						}
					} else {
						sysAdminAndMap.put("adminId", sysAdmin.getAdminId());
						sysAdminAndMap.put("adminRealName", sysAdmin.getAdminRealname());
						sysAdminAndMap.put("dayCount", sysCount);
					}
					if (sysAdminAndMap.size() > 0 && (int)sysAdminAndMap.get("dayCount") > 0 ) {
						resultMap.add(sysAdminAndMap);
					}
				}
			}
			return new DMTResultBean("0", "", resultMap);*/
			return new DMTResultBean("0", "", sysAdminList);
		}
		return new DMTResultBean("01", "", "");
	}
	
	/**
	 * 计算目标日期距离今天的天数，周六日除外
	 * @param today 目标日期 格式：yyyyMMdd
	 * @return 距离今天的天数
	 */
	public int getDayCount (String today) {
		int count = 0;
		try {
			SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDate = new Date();
			Calendar date = Calendar.getInstance();
			date.setTime(beginDate);
			boolean flag = true;
			do {
				date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
				Date endDate = dft.parse(dft.format(date.getTime()));
				date.setTime(endDate);
				int weekIndex = date.get(Calendar.DAY_OF_WEEK) - 1;
				if (weekIndex < 0) {
					weekIndex = 0;
				}
				String dayDate = dft.format(endDate).replaceAll("-", "");
				if (!today.equals(dayDate) && 6 - weekIndex != 0 && 0 - weekIndex != 0) {
					count ++;
				} else if (today.equals(dayDate)) {
					// 如果用户的创建日期是周六日，排除当天，否则天数+1
					if (6 - weekIndex != 0 && 0 - weekIndex != 0) {
						count ++;
					}
					flag = false;
				}
			} while (flag);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return count;
	}
}
