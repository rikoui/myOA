package com.bjdreamtech.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.bean.DMTSessionBean;
import com.bjdreamtech.dmt.exception.DMTBusinessException;
import com.bjdreamtech.dmt.format.DMTTimeFormatter;
import com.bjdreamtech.dmt.util.DMTDateUtil;
import com.bjdreamtech.dmt.util.DMTPrimaryKeyUtil;
import com.bjdreamtech.dmt.util.DMTSqlTransferUtil;
import com.bjdreamtech.entity.SysAuth;
import com.bjdreamtech.entity.SysAuthExample;
import com.bjdreamtech.entity.SysMenu;
import com.bjdreamtech.entity.SysRole;
import com.bjdreamtech.entity.SysRoleExample;
import com.bjdreamtech.format.DMTStatusFormatter;
import com.bjdreamtech.mapper.auto.SysAuthMapper;
import com.bjdreamtech.mapper.auto.SysMenuMapper;
import com.bjdreamtech.mapper.auto.SysRoleMapper;
import com.bjdreamtech.mapper.custom.RoleManageMapper;
import com.bjdreamtech.service.IRoleService;

/**
 * 角色管理模块业务层实现类
 * @author duanwu
 *
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl implements IRoleService {
	
	@Resource
	private RoleManageMapper roleManageMapper;
	@Resource
	private SysRoleMapper roleMapper;
	@Resource
	private SysAuthMapper authMapper;
	@Resource
	private SysMenuMapper menuMapper;

	/**
	 * 分页查询角色数据
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> queryRoleByPage(HttpServletRequest request) {
		//初始化分页参数，将分页参数自动注入到查询条件params中
		initPageParameter(request);
		//将其他查询条件注入到查询条件params中
		String name = request.getParameter("name");
		String status = request.getParameter("status");
		if(name!=null&&!"".equals(name)){
			params.put("name", DMTSqlTransferUtil.transfer(name));
		}
		if(status!=null&&!"".equals(status)){
			params.put("status", status);
		}
		//分页查询数据
		List<Map<String,Object>> roleList = roleManageMapper.queryRoleListByPage(params);
		//转换数据中的createtime为标准时间格式显示
		DMTTimeFormatter.formatTimeList(roleList, "createtime", "createtimeCopy");
		//转换数据中的状态为中文状态显示
		DMTStatusFormatter.formatStatusList(roleList, "status", "statusCopy", "SIMPLE_STATUS",paramManageMapper);
		//返回数据列表bean对象
		return new DMTDataTableBean<Map<String, Object>>(pageUtil.getTotalCount(),roleList);
	}

	/**
	 * 新增角色
	 */
	@Override
	public DMTResultBean addRole(HttpServletRequest request) {
		DMTSessionBean userinfo = getSessionBean(request);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String ids = request.getParameter("menuids");
		if(!validateAddRole(name,description,ids)){
			return new DMTResultBean("1","请输入正确的信息!","");
		}
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andRoleNameEqualTo(name);
		List<SysRole> roleList = roleMapper.selectByExample(example);
		if(null != roleList && roleList.size() != 0){
			return new DMTResultBean("1","该角色名称已存在!","");
		}
		//添加角色数据
		SysRole role = new SysRole();
		String roleid = DMTPrimaryKeyUtil.getPrimaryKey("ROLE");
		role.setRoleId(roleid);
		role.setRoleName(name);
		role.setRoleDescription(description);
		role.setRoleStatus("0");
		role.setRoleCreatetime(DMTDateUtil.parseDate());
		roleMapper.insertSelective(role);
		//绑定角色的权限
		String[] menuids = ids.split(";");
		for(String menuid:menuids){
			//根据ID查询出此二级菜单数据
			SysMenu menu = menuMapper.selectByPrimaryKey(menuid);
			if(menu==null){
				return new DMTResultBean("1","菜单数据已更新","");
			}
			//判断该角色是否已添加该二级菜单的一级菜单权限
			SysAuthExample sae = new SysAuthExample();
			sae.createCriteria().andAuthRoleIdEqualTo(roleid).andAuthMenuIdEqualTo(menu.getMenuParentId());
			List<SysAuth> authList = authMapper.selectByExample(sae);
			if(authList==null||authList.size()==0){
				//没有添加一级菜单权限的情况下，先添加一级菜单权限
				SysAuth auth = new SysAuth();
				auth.setAuthId(DMTPrimaryKeyUtil.getPrimaryKey("AUTH"));
				auth.setAuthMenuId(menu.getMenuParentId());
				auth.setAuthRoleId(roleid);
				authMapper.insertSelective(auth);
			}
			SysAuth auth = new SysAuth();
			auth.setAuthId(DMTPrimaryKeyUtil.getPrimaryKey("AUTH"));
			auth.setAuthMenuId(menuid);
			auth.setAuthRoleId(roleid);
			authMapper.insertSelective(auth);
		}
		log.logging("新增系统角色", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean();
	}
	
	/**
	 * 新增角色数据校验
	 * @param name
	 * @param description
	 * @return
	 */
	public boolean validateAddRole(String name,String description,String menuids){
		if(isNull(name)||isNull(description)||isNull(menuids)){
			return false;
		}
		if(name.length()>20||description.length()>100){
			return false;
		}
		return true;
	}

	/**
	 * 根据ID获取角色信息
	 */
	@Override
	public DMTResultBean getRoleInfo(HttpServletRequest request) {
		String roleId = request.getParameter("roleid");
		SysRole role = roleMapper.selectByPrimaryKey(roleId);
		if(role==null){
			return new DMTResultBean("1","角色信息不存在","");
		}
		return new DMTResultBean("0","",role);
	}

	/**
	 * 修改角色信息
	 */
	@Override
	public DMTResultBean editRole(HttpServletRequest request) {
		DMTSessionBean userinfo = getSessionBean(request);
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andRoleNameEqualTo(name).andRoleIdNotEqualTo(id);
		List<SysRole> roleList = roleMapper.selectByExample(example);
		if(null != roleList && roleList.size() != 0){
			return new DMTResultBean("1","该角色名称已存在!","");
		}
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		String ids = request.getParameter("menuids");
		/*if(userinfo.getRoleid().equals(id)){
			return new DMTResultBean("1","不允许修改自己所属角色","");
		}*/
		if(!validateEditRole(name,description,status,id,ids)){
			return new DMTResultBean("1","请输入正确的信息!","");
		}
		SysRole role = roleMapper.selectByPrimaryKey(id);
		if(role==null){
			return new DMTResultBean("1","该角色不存在!","");
		}
		//修改系统角色
		role.setRoleDescription(description);
		role.setRoleName(name);
		role.setRoleStatus(status);
		roleMapper.updateByPrimaryKeySelective(role);
		//先删除角色所有的权限
		SysAuthExample sae = new SysAuthExample();
		sae.createCriteria().andAuthRoleIdEqualTo(id);
		authMapper.deleteByExample(sae);
		//绑定角色的权限
		String[] menuids = ids.split(";");
		for(String menuid:menuids){
			//根据ID查询出此二级菜单数据
			SysMenu menu = menuMapper.selectByPrimaryKey(menuid);
			if(menu==null){
				return new DMTResultBean("1","菜单数据已更新","");
			}
			//判断该角色是否已添加该二级菜单的一级菜单权限
			SysAuthExample sae2 = new SysAuthExample();
			sae2.createCriteria().andAuthRoleIdEqualTo(id).andAuthMenuIdEqualTo(menu.getMenuParentId());
			List<SysAuth> authList = authMapper.selectByExample(sae2);
			if(authList==null||(authList!=null&&authList.size()==0)){
				//没有添加一级菜单权限的情况下，先添加一级菜单权限
				SysAuth auth = new SysAuth();
				auth.setAuthId(DMTPrimaryKeyUtil.getPrimaryKey("AUTH"));
				auth.setAuthMenuId(menu.getMenuParentId());
				auth.setAuthRoleId(id);
				authMapper.insertSelective(auth);
			}
			SysAuth auth = new SysAuth();
			auth.setAuthId(DMTPrimaryKeyUtil.getPrimaryKey("AUTH"));
			auth.setAuthMenuId(menuid);
			auth.setAuthRoleId(id);
			authMapper.insertSelective(auth);
		}
		log.logging("修改系统角色", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean();
	}
	
	/**
	 * 修改角色数据校验
	 * @param name
	 * @param description
	 * @param status
	 * @return
	 */
	public boolean validateEditRole(String name,String description,String status, String id,String ids){
		if(isNull(name)||isNull(description)||isNull(status)||isNull(id)||isNull(ids)){
			return false;
		}
		if(name.length()>20||description.length()>100||status.length()>1){
			return false;
		}
		return true;
	}

	/**
	 * 删除角色信息
	 */
	@Override
	public DMTResultBean deleteRole(HttpServletRequest request) {
		DMTSessionBean userinfo = getSessionBean(request);
		String id = request.getParameter("id");
		if(userinfo.getRoleid().equals(id)){
			return new DMTResultBean("1","不允许删除自己所属角色","");
		}
		//判断该角色下是否存在
		List<Map<String,Object>> list = roleManageMapper.queryAdminCount(id);
		if(list!=null&&list.size()>0){
			return new DMTResultBean("1","该角色已存在用户，不可删除","");
		}
		int row = roleMapper.deleteByPrimaryKey(id);
		if(row!=1){
			return new DMTResultBean("1","数据不存在","");
		}else{
			log.logging("删除系统角色", this.getClass(), userinfo.getUsername(), userinfo.getIp());
			return new DMTResultBean();
		}
	}

	/**
	 * 启用或禁用角色
	 */
	@Override
	public DMTResultBean statusRole(HttpServletRequest request) {
		DMTSessionBean userinfo = getSessionBean(request);
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		SysRole role = roleMapper.selectByPrimaryKey(id);
		if(role==null){
			return new DMTResultBean("1","数据不存在","");
		}
		role.setRoleStatus(status);
		roleMapper.updateByPrimaryKeySelective(role);
		if(status.equals("0")){
			log.logging("启用系统角色", this.getClass(), userinfo.getUsername(), userinfo.getIp());
			return new DMTResultBean("0","","启用成功");
		}
		log.logging("禁用系统角色", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean("0","","禁用成功");
	}

	/**
	 * 查询所有的角色列表作为select选项
	 */
	@Override
	public DMTResultBean findRoleSelect(HttpServletRequest request) {
		List<SysRole> roleList = roleManageMapper.queryRoleSelect();
		return new DMTResultBean("0","",roleList);
	}

	/**
	 * 查询所有的正常状态菜单
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> queryMenuList(
			HttpServletRequest request) {
		//获取正在操作的角色ID，如为空则说明为添加角色操作，不为空则为修改角色操作
		String roleid = request.getParameter("roleid");
		//查询所有可用的菜单权限
		List<Map<String,Object>> menuList = roleManageMapper.queryMenuList();
		if(roleid!=null){
			//如果角色ID不为空的情况下查询所有的菜单权限判断改角色是否拥有该菜单权限
			for(int i=0;i<menuList.size();i++){
				SysAuthExample sae = new SysAuthExample();
				sae.createCriteria().andAuthRoleIdEqualTo(roleid).andAuthMenuIdEqualTo((String)menuList.get(i).get("id"));
				List<SysAuth> authList = authMapper.selectByExample(sae);
				if(authList!=null&&authList.size()>0){
					//拥有该菜单权限的情况下，设置checked为true
					menuList.get(i).put("checked", true);
				}else{
					//没有该菜单权限的情况下，设置checked为false
					menuList.get(i).put("checked", false);
				}
			}
		}
		return new DMTDataTableBean<Map<String,Object>>(0,menuList);
	}

	/**
	 * 根据角色ID查询该角色所有的菜单权限
	 */
	@Override
	public DMTResultBean getMenuList(
			HttpServletRequest request) {
		String roleid = request.getParameter("roleid");
		List<Map<String,Object>> menuList = roleManageMapper.getMenuList(roleid);
		return new DMTResultBean("0","",menuList);
	}
	
	/**
	 * 角色信息详情
	 */
	@Override
	public DMTResultBean queryRole(HttpServletRequest request) {
		String roleId = request.getParameter("roleid");
		
		Map<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("roleId", roleId);
		Map<String, Object> role=roleManageMapper.queryRole(hashMap);
		DMTStatusFormatter.formatStatus(role, "status", "copyStatus", "SIMPLE_STATUS", paramManageMapper);
		DMTTimeFormatter.formatTime(role, "createtime", "createtimecopy");
		if(role==null){
			return new DMTResultBean("1","角色信息不存在","");
		}
		return new DMTResultBean("0","",role);
	}
	/**
	 * 该角色绑定的用户详情
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> adminList(HttpServletRequest request) throws DMTBusinessException{
		String roleId=request.getParameter("id");
		List<Map<String, Object>> admin = roleManageMapper.adminList(roleId);
		DMTTimeFormatter.formatTimeList(admin , "createtime", "createtimeCopy");
		if(roleId==null){
			throw new DMTBusinessException("该角色暂时未绑定用户");
		}
		return new DMTDataTableBean<Map<String, Object>>(pageUtil.getTotalCount(),admin);
	}

	/**
	 * 查询所有的正常状态菜单
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> queryMenuDetailList(
			HttpServletRequest request) {
		//获取正在操作的角色ID，如为空则说明为添加角色操作，不为空则为修改角色操作
		String roleid = request.getParameter("roleid");
		//查询所有可用的菜单权限
		List<Map<String,Object>> menuList = roleManageMapper.queryMenuDeitalList();
		if(roleid!=null){
			//如果角色ID不为空的情况下查询所有的菜单权限判断改角色是否拥有该菜单权限
			for(int i=0;i<menuList.size();i++){
				SysAuthExample sae = new SysAuthExample();
				sae.createCriteria().andAuthRoleIdEqualTo(roleid).andAuthMenuIdEqualTo((String)menuList.get(i).get("id"));
				List<SysAuth> authList = authMapper.selectByExample(sae);
				if(authList!=null&&authList.size()>0){
					//拥有该菜单权限的情况下，设置checked为true
					menuList.get(i).put("checked", true);
				}else{
					//没有该菜单权限的情况下，设置checked为false
					menuList.get(i).put("checked", false);
				}
			}
		}
		return new DMTDataTableBean<Map<String,Object>>(0,menuList);
	}

	/**
	 * 查询角色详情菜单列表
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> selectMenuList(HttpServletRequest request) {
		//获取正在操作的角色ID，如为空则说明为添加角色操作，不为空则为修改角色操作
		String roleid = request.getParameter("roleid");
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("roleid", roleid);
		//查询所有可用的菜单权限
		List<Map<String,Object>> menuList = roleManageMapper.selectMenuList(hashMap);
		if(roleid!=null){
			//如果角色ID不为空的情况下查询所有的菜单权限判断改角色是否拥有该菜单权限
			for(int i=0;i<menuList.size();i++){
				SysAuthExample sae = new SysAuthExample();
				sae.createCriteria().andAuthRoleIdEqualTo(roleid).andAuthMenuIdEqualTo((String)menuList.get(i).get("id"));
				List<SysAuth> authList = authMapper.selectByExample(sae);
				if(authList!=null&&authList.size()>0){
					//拥有该菜单权限的情况下，设置checked为true
					menuList.get(i).put("checked", true);
				}else{
					//没有该菜单权限的情况下，设置checked为false
					menuList.get(i).put("checked", false);
				}
			}
		}
		return new DMTDataTableBean<Map<String,Object>>(0,menuList);
	}

}
