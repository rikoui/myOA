package com.bjdreamtech.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;

/**
 * 参数管理业务层接口
 * @author duanwu
 *
 */
public interface IParamManageService extends IBaseService{

	/**
	 * 分页查询参数数据
	 * @param request
	 * @return
	 */
	DMTDataTableBean<Map<String, Object>> queryParamListByPage(
			HttpServletRequest request);

	/**
	 * 新增参数
	 * @param request
	 */
	DMTResultBean addParam(HttpServletRequest request);

	/**
	 * 获取参数详情
	 * @param request
	 * @return
	 */
	DMTResultBean getParamInfo(HttpServletRequest request);

	/**
	 * 修改参数
	 * @param request
	 * @return
	 */
	DMTResultBean editParam(HttpServletRequest request);

	/**
	 * 删除参数信息
	 * @param request
	 * @return
	 */
	DMTResultBean deleteParam(HttpServletRequest request);

	/**
	 * 启用或者禁用参数
	 * @param request
	 * @return
	 */
	DMTResultBean statusParam(HttpServletRequest request);

	/**
	 * 批量删除参数数据
	 * @param request
	 * @return
	 */
	DMTResultBean paramDeleteBatch(HttpServletRequest request);

	/**
	 * 根据参数代码获取参数key-value对
	 * @param request
	 * @return
	 */
	DMTResultBean findParamByCode(HttpServletRequest request);
	
	/**
	 * 获取系统下的所有核心企业
	 * @param request
	 * @return
	 */
	DMTResultBean findCompanyByCode(HttpServletRequest request);

	/**
	 * 获取系统下的所有资方
	 * @param request
	 * @return
	 */
	DMTResultBean findCapitalByCode(HttpServletRequest request);

}
