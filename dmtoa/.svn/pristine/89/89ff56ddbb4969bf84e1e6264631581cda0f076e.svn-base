package com.bjdreamtech.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;

/**
 * 角色管理模块业务层接口
 * @author duanwu
 *
 */
public interface IRoleService extends IBaseService{

	/**
	 * 分页查询角色数据
	 * @param request
	 * @return
	 */
	DMTDataTableBean<Map<String, Object>> queryRoleByPage(HttpServletRequest request);

	/**
	 * 新增角色
	 * @param request
	 * @return
	 */
	DMTResultBean addRole(HttpServletRequest request);

	/**
	 * 根据ID获取角色信息
	 * @param request
	 * @return
	 */
	DMTResultBean getRoleInfo(HttpServletRequest request);

	/**
	 * 修改角色信息
	 * @param request
	 * @return
	 */
	DMTResultBean editRole(HttpServletRequest request);

	/**
	 * 删除角色信息
	 * @param request
	 * @return
	 */
	DMTResultBean deleteRole(HttpServletRequest request);

	/**
	 * 启用或禁用角色
	 * @param request
	 * @return
	 */
	DMTResultBean statusRole(HttpServletRequest request);

	/**
	 * 查询所有的角色列表作为select选项
	 * @param request
	 * @return
	 */
	DMTResultBean findRoleSelect(HttpServletRequest request);

	/**
	 * 查询所有的菜单
	 * @param request
	 * @return
	 */
	DMTDataTableBean<Map<String, Object>> queryMenuList(
			HttpServletRequest request);

	/**
	 * 根据角色ID查询该角色所有的菜单权限
	 * @param request
	 * @return
	 */
	DMTResultBean getMenuList(HttpServletRequest request);

	/**
	 * 查询角色的详细信息
	 * @param request
	 * @return
	 */
	DMTResultBean queryRole(HttpServletRequest request);

	/**
	 * 查看当前角色用户
	 * @param request
	 * @return
	 */
	DMTDataTableBean<Map<String, Object>> adminList(HttpServletRequest request);

	/**
	 * 查询所有的菜单详情
	 * @param request
	 * @return
	 */
	DMTDataTableBean<Map<String, Object>> queryMenuDetailList(
			HttpServletRequest request);

	/**
	 * 查询角色详情菜单列表
	 * @param request
	 * @return
	 */
	DMTDataTableBean<Map<String, Object>> selectMenuList(HttpServletRequest request);
	
}
