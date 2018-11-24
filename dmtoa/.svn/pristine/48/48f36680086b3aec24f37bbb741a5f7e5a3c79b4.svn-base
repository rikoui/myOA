package com.bjdreamtech.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.bean.DMTSessionBean;
import com.bjdreamtech.dmt.util.DMTPageUtil;
import com.bjdreamtech.mapper.custom.ParamManageMapper;
import com.bjdreamtech.service.IBaseService;
import com.bjdreamtech.util.DMTLogUtil;

/**
 * 基础业务层实现类
 * @author duanwu
 *
 */
@Service
public class BaseServiceImpl implements IBaseService{
	
	/**
	 * 分页工具
	 */
	
	public DMTPageUtil pageUtil;
	
	/**
	 * 查询参数
	 */
	public Map<String,Object> params;
	
	/**
	 * 日志工具
	 */
	@Resource
	public DMTLogUtil log;
	
	@Resource
	public ParamManageMapper paramManageMapper;
	
	/**
	 * 初始化分页查询参数
	 * @param request
	 */
	public void initPageParameter(HttpServletRequest request){
		//默认查询第一页
		Integer page = 1;
		//默认每页大小为分页工具中设定的默认值
		Integer pageSize = DMTPageUtil.DEFAULT_PAGE_SIZE;
		try{
			//获取每页大小，不传递情况下使用默认值
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}catch(Exception e){
			
		}
		try{
			//获取查询页码，不传递情况下查询第一页
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e){
			
		}
		//初始化分页工具
		pageUtil = new DMTPageUtil(page, pageSize);
		//初始化参数容器
		params = new HashMap<String,Object>();
		//将分页信息作为参数放到参数容器中
		params.put("pageUtil", pageUtil);
	}
	
	/**
	 * 判断字符串是否不为空或者空字符串
	 * @param str
	 * @return
	 */
	public boolean notNull(String str){
		if(str!=null&&!"".equals(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否为空或者空字符串
	 * @param str
	 * @return
	 */
	public boolean isNull(String str){
		if(str==null||"".equals(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断BigDecimal型是否为空或者空字符串
	 * @param productprop
	 * @return
	 */
	public boolean isNull(BigDecimal bdc){
		if(bdc==null||"".equals(bdc)){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断int型是否为空或者空字符串
	 * @param fixedterm
	 * @return
	 */
	public boolean isNull(int fixedterm){
		if("".equals(fixedterm)){
			return true;
		}
		return false;
	}
	/**
	 * 获取用户的session信息
	 * @param request
	 * @return
	 */
	public DMTSessionBean getSessionBean(HttpServletRequest request){
		return (DMTSessionBean)request.getSession().getAttribute("sessionBean");
	}
	
	/**
	 * 根据参数代码获取参数KEY和参数VALUE
	 * @param code 参数代码
	 * @return
	 */
	public Map<String,String> getParamByCode(String code){
		List<Map<String,String>> paramList = paramManageMapper.getParamByCode(code);
		Map<String,String> resultMap = new HashMap<String,String>();
		for(Map<String,String> map : paramList){
			resultMap.put(map.get("key"), map.get("value"));
		}
		return resultMap;
	}

}
