package com.bjdreamtech.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.format.DMTTimeFormatter;
import com.bjdreamtech.dmt.util.DMTDateUtil;
import com.bjdreamtech.dmt.util.DMTPrimaryKeyUtil;
import com.bjdreamtech.dmt.util.DMTSqlTransferUtil;
import com.bjdreamtech.entity.SysLog;
import com.bjdreamtech.mapper.auto.SysLogMapper;
import com.bjdreamtech.mapper.custom.LogManageMapper;
import com.bjdreamtech.service.ILogService;

/**
 * 系统日志业务层实现类
 * @author duanwu
 *
 */
@Service("logService")
public class LogServiceImpl extends BaseServiceImpl implements ILogService{
	
	/**
	 * 系统名称，根据实际情况修改
	 */
	private final String SYSTEM = "内部管理系统";
	
	@Resource
	private SysLogMapper sysLogMapper;
	@Resource
	private LogManageMapper logManageMapper;

	/**
	 * 记录系统日志到数据库中
	 */
	public <T> void LogInfo(String logInfo, Class<T> clazz, String username, String ip) {
		SysLog log = new SysLog();
		//获取主键，前缀为'LOG'
		log.setLogId(DMTPrimaryKeyUtil.getPrimaryKey("LOG"));
		//设置日志信息
		log.setLogContent(logInfo);
		//设置日志所在类名
		log.setLogRemark(clazz.getName());
		//设置日志系统
		log.setLogSystem(SYSTEM);
		//设置日志时间
		log.setLogTime(DMTDateUtil.parseDate());
		//设置操作人员
		log.setLogUser(username);
		//设置ip
		log.setLogIp(ip);
		//保存日志信息
		sysLogMapper.insertSelective(log);
	}

	/**
	 * 分页查询日志列表
	 */
	public DMTDataTableBean<Map<String, Object>> queryLogListByPage(
			HttpServletRequest request) {
		//需要分页的情况下必须先初始化分页组件数据
		initPageParameter(request);
		//获取其它的查询条件参数
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String ip = request.getParameter("ip");
		//将其他条件参数放到查询条件中
		if(notNull(username)){
			params.put("username", DMTSqlTransferUtil.transfer(username));
		}
		if(notNull(content)){
			params.put("content", DMTSqlTransferUtil.transfer(content));
		}
		if(notNull(startTime)){
			params.put("startTime", DMTTimeFormatter.parseTime(startTime)+"000000");
		}
		if(notNull(endTime)){
			params.put("endTime", DMTTimeFormatter.parseTime(endTime)+"235959");
		}
		if(notNull(ip)){
			params.put("ip", DMTSqlTransferUtil.transfer(ip));
		}
		//调用持久层方法分页查询数据，方法名称必须以 ByPage 结尾
		List<Map<String,Object>> logList = logManageMapper.queryLogListByPage(params);
		//转换时间显示格式
		DMTTimeFormatter.formatTimeList(logList, "time", "timecopy");
		return new DMTDataTableBean<Map<String,Object>>(pageUtil.getTotalCount(),logList);
	}

}
