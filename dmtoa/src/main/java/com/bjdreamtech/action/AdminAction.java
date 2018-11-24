package com.bjdreamtech.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.exception.DMTBusinessException;
import com.bjdreamtech.service.IAdminService;

/**
 * 操作员管理控制层
 * @author duanwu
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("adminAction")
public class AdminAction extends BaseAction{
	
	@Resource
	IAdminService adminService;

	/**
	 * 操作员列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("adminList.do")
	public DMTDataTableBean<Map<String,Object>> adminList(HttpServletRequest request){
		return adminService.queryAdminByPage(request);
	}
	
	/**
	 * 新增操作员
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("adminAdd.do")
	public DMTResultBean adminAdd(HttpServletRequest request){
		return adminService.addAdmin(request);
	}
	
	/**
	 * 获取操作员详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getAdminInfo.do")
	public DMTResultBean getAdminInfo(HttpServletRequest request){
		return adminService.getAdminInfo(request);
	}
	
	/**
	 * 修改操作员信息
	 * @param request
	 * @return
	 * @throws DMTBusinessException 
	 */
	@ResponseBody
	@RequestMapping("adminEdit.do")
	public DMTResultBean adminEdit(HttpServletRequest request) throws DMTBusinessException{
		return adminService.editAdmin(request);
	}
	
	/**
	 * 删除操作员
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("adminDelete.do")
	public DMTResultBean adminDelete(HttpServletRequest request){
		return null;
	}

	/**
	 * 启用或者禁用用户状态
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("adminStatus.do")
	public DMTResultBean adminStatus(HttpServletRequest request){
		return adminService.statusAdmin(request);
	}

	/**
	 * 初始化密码
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("initRole.do")
	public DMTResultBean initRole(HttpServletRequest request){
		return adminService.initRole(request);
	}
	/**
	 * 获取操作员详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryAdmin.do")
	public DMTResultBean queryAdmin(HttpServletRequest request){
		return adminService.queryAdmin(request);
	}
	/**
	 * 加载当前用户所属机构
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryBranch.do")
	public DMTResultBean queryBranch(HttpServletRequest request){
		return adminService.queryBranch(request);
	}
	
	/**
	 * 用户剩余倒休天数列表
	 * @param request
	 * @return
	 */
	@RequestMapping("adminLeiuDayList.do")
	@ResponseBody
	public DMTDataTableBean adminLeiuDayList(HttpServletRequest request) {
		return adminService.adminLeiuDayList(request);
	}
	
	/**
	 * 获取所有员工
	 * @param request
	 * @return
	 */
	@RequestMapping("queryAllAdmin.do")
	@ResponseBody
	public DMTResultBean queryAllAdmin(HttpServletRequest request) {
		return adminService.queryAllAdmin(request);
	}
	
	/**
	 * 修改员工倒休天数
	 * @param request
	 * @return
	 */
	@RequestMapping("editAdminLeiuDay.do")
	@ResponseBody
	public DMTResultBean editAdminLeiuDay(HttpServletRequest request) {
		return adminService.editAdminLeiuDay(request);
	}
}
