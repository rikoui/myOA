package com.bjdreamtech.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.service.ILeaveService;

@Controller
@RequestMapping("/leaveAction")
public class LeaveAction {
	@Autowired
	private ILeaveService leaveService;
	
	/**
	 * 请假单列表查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/leaveApplyList.do")
	@ResponseBody
	public DMTDataTableBean queryLeaves(HttpServletRequest request) {
		return leaveService.queryLeaves(request);
	}
	
	/**
	 * 请假申请
	 * @param request
	 * @return
	 */
	@RequestMapping("/leaveAdd.do")
	@ResponseBody
	public DMTResultBean leaveAdd(HttpServletRequest request) {
		return leaveService.leaveAdd(request);
	}
	
	/**
	 * 请假申请信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getLeaveInfo.do")
	@ResponseBody
	public DMTResultBean getLeaveInfo(HttpServletRequest request) {
		return leaveService.getLeaveInfo(request);
	}
	
	/**
	 * 请假申请修改
	 * @param request
	 * @return
	 */
	@RequestMapping("/leaveEdit.do")
	@ResponseBody
	public DMTResultBean leaveEdit(HttpServletRequest request) {
		return leaveService.leaveEdit(request);
	}
	
	/**
	 * 获取所有操作员
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllAdmin.do")
	@ResponseBody
	public DMTResultBean getAllAdmin(HttpServletRequest request) {
		return leaveService.getAllAdmin(request);
	}
	
	/**
	 * 获取请假申请详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/getLeaveDetail.do")
	@ResponseBody
	public DMTResultBean getLeaveDetail(HttpServletRequest request) {
		return leaveService.getLeaveDetail(request);
	}
	
	/**
	 * 请假申请审阅
	 * @param request
	 * @return
	 */
	@RequestMapping("/leaveAuth.do")
	@ResponseBody
	public DMTResultBean leaveAuth(HttpServletRequest request) {
		return leaveService.leaveAuth(request);
	}
	
	/**
	 * 附件大小检查&上传
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @throws ParseException 
	 */
	@RequestMapping("checkFileSize.do")
	@ResponseBody
	public DMTResultBean checkFileSize(@RequestParam("merCertZip") MultipartFile merCertPic,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return leaveService.checkFileSize(merCertPic, request, response);
	}
	
	/**
	 * 编辑附件上传
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @throws ParseException 
	 */
	@RequestMapping("editcheckFileSize.do")
	@ResponseBody
	public DMTResultBean editcheckFileSize(@RequestParam("edit_merCertZip") MultipartFile merCertPic,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return leaveService.checkFileSize(merCertPic, request, response);
	}
	
	/**
	 * 附件下载
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("fileDownload.do")
	@ResponseBody
	public ResponseEntity<byte[]> fileDownload(HttpServletRequest request) throws IOException {
		return leaveService.fileDownload(request);
	}
}
