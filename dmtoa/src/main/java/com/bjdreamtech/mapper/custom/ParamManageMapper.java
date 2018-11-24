package com.bjdreamtech.mapper.custom;

import java.util.List;
import java.util.Map;


/**
 * 参数管理模块持久层
 * @author duanwu
 *
 */
public interface ParamManageMapper {

	/**
	 * 分页查询参数数据
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> queryParamListByPage(Map<String,Object> params);

	/**
	 * 获取系统下的所有核心企业
	 * @return
	 */
	List<Map<String, String>> getCompanyByCode();
	
	/**
	 * 根据参数代码获取参数KEY和参数VALUE
	 * @param code
	 * @return
	 */
	List<Map<String, String>> getParamByCode(String code);

	/**
	 * 获取系统下的所有资方
	 * @return
	 */
	List<Map<String, String>> getCapitalByCode();

	List<Map<String, Object>> queryEmailParams();
	
}