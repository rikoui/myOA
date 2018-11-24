package com.bjdreamtech.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.exception.DMTBusinessException;
import com.bjdreamtech.service.IRoleService;

/**
 * 角色管理控制层
 * @author duanwu
 *
 */
@Controller
@RequestMapping("roleAction")
public class RoleAction extends BaseAction{
	
	@Resource
	IRoleService roleService;

	/**
	 * 角色列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("roleList.do")
	public DMTDataTableBean<Map<String,Object>> roleList(HttpServletRequest request){
		return roleService.queryRoleByPage(request);
	}
	
	/**
	 * 查询菜单列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("menuList.do")
	public DMTDataTableBean<Map<String,Object>> menuList(HttpServletRequest request){
		return roleService.queryMenuList(request);
	}
	
	/**
	 * 查询角色详情菜单列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selectMenuList.do")
	public DMTDataTableBean<Map<String,Object>> selectMenuList(HttpServletRequest request){
		return roleService.selectMenuList(request);
	}
	
	/**
	 * 获取菜单列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getMenuList.do")
	public DMTResultBean getMenuList(HttpServletRequest request){
		return roleService.getMenuList(request);
	}
	
	/**
	 * 添加角色
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("roleAdd.do")
	public DMTResultBean roleAdd(HttpServletRequest request){
		return roleService.addRole(request);
	}
	
	/**
	 * 获取角色详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getRoleInfo.do")
	public DMTResultBean getRoleInfo(HttpServletRequest request){
		return roleService.getRoleInfo(request);
	}
	
	/**
	 * 修改角色信息
	 * @param request
	 * @return
	 * @throws DMTBusinessException
	 */
	@ResponseBody
	@RequestMapping("roleEdit.do")
	public DMTResultBean roleEdit(HttpServletRequest request) throws DMTBusinessException{
		return roleService.editRole(request);
	}
	
	/**
	 * 删除角色信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("roleDelete.do")
	public DMTResultBean roleDelete(HttpServletRequest request){
		return roleService.deleteRole(request);
	}
	
	/**
	 * 修改角色状态
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("roleStatus.do")
	public DMTResultBean roleStatus(HttpServletRequest request){
		return roleService.statusRole(request);
	}
	
	/**
	 * 加载角色下拉框
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findRoleSelect.do")
	public DMTResultBean findRoleSelect(HttpServletRequest request){
		return roleService.findRoleSelect(request);
	}
	
	/**
	 * 查看角色详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryRole.do")
	public DMTResultBean queryRole(HttpServletRequest request){
		return roleService.queryRole(request);
	}
	
	/**
	 * 查看用户信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("adminList.do")
	public DMTDataTableBean<Map<String,Object>> adminList(HttpServletRequest request){
		return roleService.adminList(request);
	}

	/**
	 * 查询菜单详情列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("menuDetailList.do")
	public DMTDataTableBean<Map<String,Object>> menuDetailList(HttpServletRequest request){
		return roleService.queryMenuDetailList(request);
	}
}
