package com.bjdreamtech.action;



import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.exception.DMTBusinessException;
import com.bjdreamtech.service.IWeeklyService;
import com.bjdreamtech.util.DMTResultBean;

@Controller
@RequestMapping("weeklyController")
public class WeeklyController extends BaseAction {
	@Resource
	private IWeeklyService weeklyService;
	@ResponseBody
	@RequestMapping("getWeekly.do")
	public DMTResultBean getWeekly(HttpServletRequest request) {
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		try {
			resultBean = weeklyService.getWeekly(request);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@ResponseBody
	@RequestMapping("findWeeklyAdminSelect.do")
	public DMTResultBean findWeeklyAdminSelect(HttpServletRequest request){
		return weeklyService.findWeeklyAdminSelect(request);
	}
	
	@ResponseBody
	@RequestMapping("weeklyList.do")
	public DMTDataTableBean<Map<String,Object>> weeklyList(HttpServletRequest request){
		return weeklyService.queryWeeklyByPage(request);
	}
	@ResponseBody
	@RequestMapping("queryWeeklyDetail.do")
	public DMTResultBean queryWeeklyDetail(HttpServletRequest request) throws Exception{
		return weeklyService.queryWeeklyDetail(request);
	}
	
	@ResponseBody
	@RequestMapping("weeklyReview.do")
	public DMTResultBean weeklyReview(HttpServletRequest request) throws DMTBusinessException{
		return weeklyService.weeklyReview(request);
	}
	
	@ResponseBody
	@RequestMapping("findSysAdminSelect.do")
	public DMTResultBean findSysAdminSelect(){
		return weeklyService.findSysAdminSelect();
	}
	
	@ResponseBody
	@RequestMapping("weeklyReadList.do")
	public DMTDataTableBean<Map<String,Object>> weeklyReadList(HttpServletRequest request){
		return weeklyService.queryweeklyReadByPage(request);
	}
	
	/**
	 * 日报审阅列表查询
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("dailyReadList.do")
	public DMTDataTableBean<Map<String,Object>> dailyReadList(HttpServletRequest request){
		return weeklyService.queryDailyReadByPage(request);
	}
	
	/**
	 * 日报详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryDaily.do")
	public DMTResultBean queryDaily(HttpServletRequest request){
		return weeklyService.queryDaily(request);
	}
	
	/**
	 * 日报审阅
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveDailyRead.do")
	public DMTResultBean saveDailyRead(HttpServletRequest request){
		return weeklyService.saveDailyRead(request);
	}
	
	/**
	 * 统计逾期未提交日报
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryCountDaily.do")
	public DMTResultBean queryCountDaily(HttpServletRequest request){
		return weeklyService.queryCountDaily(request);
	}
	
	/**
	 * 
	* @Title: saveWeekly
	* @Description: 提交周报
	* @param @param request
	* @param @return    
	* @return DMTResultBean   
	* @author songj 
	* @date 2018年02月11日 13:47:11 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="saveWeekly.do",method=RequestMethod.POST)
	@ResponseBody
	public DMTResultBean saveWeekly(HttpServletRequest request){
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		try {
			resultBean = weeklyService.saveWeekly(request);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			new DMTResultBean("1","保存异常",msg);
		}
		return resultBean;
	}

}
