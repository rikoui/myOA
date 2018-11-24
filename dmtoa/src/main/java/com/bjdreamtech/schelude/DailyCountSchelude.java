package com.bjdreamtech.schelude;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bjdreamtech.service.IDailyCountScheludeService;

/**
 * 统计日报未提交次数
 * @author huangqiang
 *
 */
@Component
public class DailyCountSchelude {
	@Autowired
	private IDailyCountScheludeService dailyCountScheludeService;
	
	/**
	 * 每天凌晨1:00统计日报未提交情况
	 * 0 0 1 * * ?
	 */
	@Scheduled(cron="0 0 1 * * ?")
	public void dailyCount() {
		dailyCountScheludeService.dailyCount();
	}
	
	/**
	 * 每天凌晨2:00统计请假单补提和事后审核情况
	 * @throws ParseException 
	 */
	@Scheduled(cron="0 0 2 * * ?")
	public void leaveLayzeCount() throws ParseException {
		dailyCountScheludeService.leaveLayzeCount();
	}
	
	/**
	 * 每年1月1日凌晨3:00全年周末假期录入
	 * @throws ParseException 
	 */
	@Scheduled(cron="0 0 3 1 1 ?")
	public void weekDayEnter() {
		dailyCountScheludeService.weekDayEnter();
	}
	
}
