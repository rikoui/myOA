package com.bjdreamtech.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.service.IParamManageService;

/**
 * 参数管理控制层
 * @author duanwu
 *
 */
@Controller
@RequestMapping("paramAction")
public class ParamAction extends BaseAction{
	
	@Resource
	IParamManageService paramManageService;
	
	/**
	 * 分页查询参数数据
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("paramList.do")
	public DMTDataTableBean<Map<String,Object>> paramList(HttpServletRequest request){
		return paramManageService.queryParamListByPage(request);
	}
	
	/**
	 * 新增参数
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("paramAdd.do")
	public DMTResultBean paramAdd(HttpServletRequest request){
		return paramManageService.addParam(request);
	}
	
	/**
	 * 根据参数ID获取参数详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getParamInfo.do")
	public DMTResultBean getParamInfo(HttpServletRequest request){
		return paramManageService.getParamInfo(request);
	}
	
	/**
	 * 修改参数信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("paramEdit.do")
	public DMTResultBean paramEdit(HttpServletRequest request){
		return paramManageService.editParam(request);
	}
	
	/**
	 * 删除参数信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("paramDelete.do")
	public DMTResultBean paramDelete(HttpServletRequest request){
		return paramManageService.deleteParam(request);
	}

	/**
	 * 启用或者禁用参数
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("paramStatus.do")
	public DMTResultBean paramStatus(HttpServletRequest request){
		return paramManageService.statusParam(request);
	}

	/**
	 * 批量删除参数
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("paramDeleteBatch.do")
	public DMTResultBean paramDeleteBatch(HttpServletRequest request){
		return paramManageService.paramDeleteBatch(request);
	}
	

}
