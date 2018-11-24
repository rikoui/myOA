package com.bjdreamtech.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.service.ILogService;

/**
 * 日志管理控制层
 * @author duanwu
 *
 */
@Controller
@RequestMapping("logAction")
public class LogAction extends BaseAction{
	
	@Resource
	ILogService logService;
	
	/**
	 * 查询日志列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("logList")
	public DMTDataTableBean<Map<String,Object>> logList(HttpServletRequest request){
		return logService.queryLogListByPage(request);
	}

}
