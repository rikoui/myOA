package com.bjdreamtech.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;

/**
 * 系统日志业务层接口
 * @author duanwu
 *
 */
public interface ILogService extends IBaseService{

	/**
	 * 日志存储（只存储info和error级别日志，debug级别日志直接打印）
	 * @param logInfo 日志信息
	 * @param result 操作结果 0：成功  1：失败
	 * @param clazz 日志所在类
	 * @param username 操作用户名
	 * @param ip 操作用户IP
	 */
	public <T> void LogInfo(String logInfo, Class<T> clazz, String username, String ip);

	/**
	 * 分页查询日志列表
	 * @param request
	 * @return
	 */
	public DMTDataTableBean<Map<String,Object>> queryLogListByPage(HttpServletRequest request);
	
}
