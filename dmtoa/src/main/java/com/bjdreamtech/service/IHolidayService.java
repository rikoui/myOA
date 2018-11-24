package com.bjdreamtech.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;

/**
 * 节假日模版下载业务层接口
 * @author duanwu
 *
 */
public interface IHolidayService extends IBaseService{

	/**
	 * 节假日模版下载
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> downHoliday(HttpServletRequest request, HttpServletResponse response);

	/**
	 * 节假日查询
	 * @param request
	 * @param response
	 * @return
	 */
	DMTDataTableBean<Map<String, Object>> holidayList(HttpServletRequest request);

	/**
	 * 节假日删除
	 * @param request
	 * @return
	 */
	DMTResultBean deleteHoliday(HttpServletRequest request);
}
