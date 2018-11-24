package com.bjdreamtech.mapper.custom;

import java.util.List;
import java.util.Map;


/**
 * 用户管理模块持久层
 * @author duanwu
 *
 */
public interface AdminManageMapper {

	/**
	 * 分页查询用户数据
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> queryAdminListByPage(Map<String,Object> params);

	/**
	 * 初始化密码
	 * @param params
	 */
	void initRole(Map<String, Object> params);

	/**
	 * 查看详情
	 * @param hashMap
	 * @return
	 */
	Map<String, Object> queryAdmin(Map<String, Object> hashMap);

	/**
	 * 倒休天数列表查询
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> queryAdminLeiuDayListByPage(Map<String, Object> params);
	
	
	
}