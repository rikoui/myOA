package com.bjdreamtech.mapper.custom;

import java.util.List;
import java.util.Map;

import com.bjdreamtech.entity.SysRole;


/**
 * 角色管理模块持久层
 * @author duanwu
 *
 */
public interface RoleManageMapper {

	/**
	 * 分页查询角色数据
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> queryRoleListByPage(Map<String,Object> params);
	
	/**
	 * 查询角色对应的用户数量
	 * @param roleId
	 * @return
	 */
	List<Map<String,Object>> queryAdminCount(String roleId);

	/**
	 * 查询所有的角色id、name作为select选项用
	 * @return
	 */
	List<SysRole> queryRoleSelect();

	/**
	 * 查询所有的正常菜单权限
	 * @return
	 */
	List<Map<String,Object>> queryMenuList();

	/**
	 * 根据角色ID查询该角色所有的菜单权限
	 * @param roleid
	 * @return
	 */
	List<Map<String, Object>> getMenuList(String roleid);

	/**
	 * 查询角色详细信息
	 * @param role
	 * @return
	 */
	Map<String, Object> queryRole(Map<String, Object> role);

	/**
	 * 所属角色的用户信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> adminList(String id);

	/**
	 * 查询所有的正常菜单权限详情
	 * @return
	 */
	List<Map<String,Object>> queryMenuDeitalList();

	/**
	 * 查询角色详情菜单列表
	 * @return
	 */
	List<Map<String, Object>> selectMenuList(Map<String, Object> hashMap);

}