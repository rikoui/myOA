package com.bjdreamtech.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.entity.SysAdmin;

/**
 * 用户管理模块业务层接口
 * @author duanwu
 *
 */
public interface IAdminService extends IBaseService{

	/**
	 * 分页查询角色数据
	 * @param request
	 * @return
	 */
	DMTDataTableBean<Map<String, Object>> queryAdminByPage(HttpServletRequest request);

	/**
	 * 新增用户
	 * @param request
	 * @return
	 */
	DMTResultBean addAdmin(HttpServletRequest request);

	/**
	 * 根据ID获取用户信息
	 * @param request
	 * @return
	 */
	DMTResultBean getAdminInfo(HttpServletRequest request);

	/**
	 * 修改用户信息
	 * @param request
	 * @return
	 */
	DMTResultBean editAdmin(HttpServletRequest request);

	/**
	 * 删除用户信息
	 * @param request
	 * @return
	 */
	DMTResultBean deleteAdmin(HttpServletRequest request);

	/**
	 * 启用/禁用/解冻 用户
	 * @param request
	 * @return
	 */
	DMTResultBean statusAdmin(HttpServletRequest request);

	
	/**
	 * 初始化密码
	 * @param request
	 * @return
	 */
	DMTResultBean initRole(HttpServletRequest request);

	/**
	 * 查看操作员详情
	 * @param request
	 * @return
	 */
	DMTResultBean queryAdmin(HttpServletRequest request);
	
	/**
	 * 加载当前用户所属机构
	 * */
	DMTResultBean queryBranch(HttpServletRequest request);

	/**
	 * 用户剩余倒休天数列表
	 * @param request
	 * @return
	 */
	DMTDataTableBean adminLeiuDayList(HttpServletRequest request);

	/**
	 * 获取所有员工
	 * @param request
	 * @return
	 */
	DMTResultBean queryAllAdmin(HttpServletRequest request);

	/**
	 * 修改员工倒休天数
	 * @param request
	 * @return
	 */
	DMTResultBean editAdminLeiuDay(HttpServletRequest request);
	
	
}
