package com.bjdreamtech.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.util.DMTResultBean;


public interface IWeeklyService {

	DMTResultBean getWeekly(HttpServletRequest request) throws Exception;

	DMTResultBean findWeeklyAdminSelect(HttpServletRequest request);

	DMTDataTableBean<Map<String, Object>> queryWeeklyByPage(HttpServletRequest request);

	DMTResultBean queryWeeklyDetail(HttpServletRequest request) throws Exception;

	DMTResultBean weeklyReview(HttpServletRequest request);

	DMTResultBean saveWeekly(HttpServletRequest request);

	DMTResultBean findSysAdminSelect();

	DMTDataTableBean<Map<String, Object>> queryweeklyReadByPage(HttpServletRequest request);

	DMTDataTableBean<Map<String, Object>> queryDailyReadByPage(HttpServletRequest request);

	DMTResultBean queryDaily(HttpServletRequest request);

	DMTResultBean saveDailyRead(HttpServletRequest request);

	DMTResultBean queryCountDaily(HttpServletRequest request);
}
