package com.bjdreamtech.util;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bjdreamtech.service.ILogService;


/**
 * 系统日志类
 * @author duanwu
 *
 */
@Component
public class DMTLogUtil{
	
	@Resource
	private ILogService logService;
	

	/**
	 * 记录日志，操作成功调用
	 */
	public <T> void logging(String logInfo, Class<T> clazz, String username, String ip) {
		//初始化Log4j日志类
		Logger logger = Logger.getLogger(clazz);
		//打印普通日志信息
		logger.info(logInfo);
		//存入数据库中
		logService.LogInfo(logInfo, clazz, username, ip);
	}
	
	/**
	 * 调试日志，调试时使用，不记录数据库
	 * @param logInfo
	 * @param clazz
	 */
	public <T> void debug(String logInfo, Class<T> clazz){
		//初始化Log4j日志类
		Logger logger = Logger.getLogger(clazz);
		//打印调试日志信息
		logger.info(logInfo);
	}

}
