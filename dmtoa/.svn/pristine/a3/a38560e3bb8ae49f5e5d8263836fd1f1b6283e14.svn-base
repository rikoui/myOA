package com.bjdreamtech.mapper.custom;

import java.util.List;
import java.util.Map;


/**
 * 登陆模块持久层
 * @author duanwu
 *
 */
public interface LoginMapper {

	/**
	 * 根据角色ID获取对应的功能权限信息
	 * @param roleId
	 * @return
	 */
	List<Map<String, String>> getMenu(Map<String,Object> p);
	
	List<Map<String, String>> getNewSessionid(String adminid);

	/**
	 * 根据角色编号查询该角色下所有的action集合
	 * @param adminRoleId
	 * @return
	 */
	List<Map<String, String>> getActions(String roleId);
	
	
}