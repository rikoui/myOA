package com.bjdreamtech.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * action权限校验过滤器
 * 
 * @author duanwu
 */
public class DMTActionValidateFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//获取访问路径
		String url = request.getRequestURI();
		//如果所访问的action不属于公共或者不需要登陆的action，则无需校验
		if(!url.contains("systemAction")){
			//从session中获取登录用户所属角色的权限信息
			List<Map<String,String>> actionList = (List<Map<String,String>>)request.getSession().getAttribute("actionList");
			if(actionList==null){
				response.setStatus(403);
				return;
			}
			boolean temp = false;
			//循环所有的action权限集，判断当前访问的action是否存在于权限集中
			for(int i=0;i<actionList.size();i++){
				Map<String,String> action = actionList.get(i);
				String path = action.get("path");
				if(url.contains(path)){
					temp = true;
					break;
				}
			}
			//如果当前访问的action不在权限集中，则拒绝访问
			if(!temp){
				response.setStatus(403);
				return;
			}
			
		}
		chain.doFilter(request, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
