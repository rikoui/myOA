package com.bjdreamtech.service;

import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.dmt.bean.DMTResultBean;


/**
 * 登陆模块业务层接口
 * @author duanwu
 *
 */
public interface ILoginService extends IBaseService{

	/**
	 * 用户登录判断
	 * @param request
	 * @return
	 */
	DMTResultBean login(HttpServletRequest request);

	/**
	 * 获取菜单权限
	 * @param request
	 * @return
	 */
	DMTResultBean menu(HttpServletRequest request);

	/**
	 * 检验用户session是否存在或者是否过期
	 * @param request
	 * @return
	 */
	DMTResultBean validateSession(HttpServletRequest request);

	/**
	 * 退出
	 * @param request
	 * @return
	 */
	DMTResultBean logout(HttpServletRequest request);

	/**
	 * 修改密码
	 * @param request
	 * @return
	 */
	DMTResultBean updatePassword(HttpServletRequest request);

	/**
	 * 获取登录用户session信息
	 * @param request
	 * @return
	 */
	DMTResultBean getSession(HttpServletRequest request);
	
}
