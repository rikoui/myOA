package com.bjdreamtech.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.util.DMTImageUtil;
import com.bjdreamtech.service.ILoginService;
import com.bjdreamtech.service.IParamManageService;

/**
 * 登陆模块控制层
 * 
 * @author duanwu
 * 
 */
@Controller
@RequestMapping("systemAction")
public class SystemAction extends BaseAction {

	// 通过 @resource注解注入业务层实例
	@Resource
	ILoginService loginService;
	@Resource
	IParamManageService paramManageService;

	/**
	 * ResponseBody注解表示通过异步的方式返回给客户端信息 RequestMapping注解配置此方法的访问方式
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login.do")
	public DMTResultBean login(HttpServletRequest request) {
		return loginService.login(request);

	}

	/**
	 * 登陆后根据登陆用户的角色获取相应的菜单权限
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("menu.do")
	public DMTResultBean menu(HttpServletRequest request) {
		return loginService.menu(request);
	}

	/**
	 * 校验session信息，没有登录或者session过时或者被其它客户端登录的情况下都会返回校验失败
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("validateSession.do")
	public DMTResultBean validateSession(HttpServletRequest request) {
		return loginService.validateSession(request);
	}

	/**
	 * 退出
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("logout.do")
	public DMTResultBean logout(HttpServletRequest request) {
		return loginService.logout(request);
	}

	/**
	 * 修改密码
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updatePassword.do")
	public DMTResultBean updatePassword(HttpServletRequest request) {
		return loginService.updatePassword(request);
	}

	/**
	 * 获取用户session信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getSession.do")
	public DMTResultBean getSession(HttpServletRequest request) {
		return loginService.getSession(request);
	}

	/**
	 * 获取index页面地址
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("rankIndex.do")
	public DMTResultBean rankIndex(HttpServletRequest request) {
		return new DMTResultBean("0", "", request.getContextPath());
	}

	/**
	 * 获取验证码
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("getImage.do")
	public void getImage(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		// 得到验证码
		String code = DMTImageUtil.getCode();
		// 将验证码保存到Session中
		HttpSession session = request.getSession();
		session.setAttribute("code", code.toString());
		// 禁止图像缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// 创建验证码图片
		BufferedImage image = DMTImageUtil.getBufferImage(code);
		// 将图片通过流输出到客户端
		ImageIO.write(image, "JPEG", response.getOutputStream());

	}
	
	/**
	 * 根据参数代码查询参数列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findParamByCode.do")
	public DMTResultBean findParamByCode(HttpServletRequest request){
		return paramManageService.findParamByCode(request);
	}
}
