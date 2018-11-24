package com.bjdreamtech.service;

import java.text.ParseException;

public interface IDailyCountScheludeService {

	/**
	 * 每天凌晨1:00统计日报未提交情况
	 */
	void dailyCount();
	
	/**
	 * 每天凌晨2:00统计请假单补提和事后审核情况
	 * @throws ParseException 
	 */
	void leaveLayzeCount() throws ParseException;

	/**
	 * 每年1月1日凌晨3:00全年周末假期录入
	 */
	void weekDayEnter();

}
