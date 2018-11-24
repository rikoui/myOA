package com.bjdreamtech.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;

public interface ILeaveService {
	
	/**
	 * 请假单列表查询
	 * @param request
	 * @return
	 */
	DMTDataTableBean queryLeaves(HttpServletRequest request);

	/**
	 * 请假申请
	 * @param request
	 * @return
	 */
	DMTResultBean leaveAdd(HttpServletRequest request);

	/**
	 * 请假申请信息查询
	 * @param request
	 * @return
	 */
	DMTResultBean getLeaveInfo(HttpServletRequest request);

	/**
	 * 请假申请修改
	 * @param request
	 * @return
	 */
	DMTResultBean leaveEdit(HttpServletRequest request);

	/**
	 * 获取所有操作员
	 * @param request
	 * @return
	 */
	DMTResultBean getAllAdmin(HttpServletRequest request);

	/**
	 * 获取请假申请详细信息
	 * @param request
	 * @return
	 */
	DMTResultBean getLeaveDetail(HttpServletRequest request);

	/**
	 * 请假申请审阅
	 * @param request
	 * @return
	 */
	DMTResultBean leaveAuth(HttpServletRequest request);

	/**
	 * 附件大小检查&上传
	 * @param merCertPic
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	DMTResultBean checkFileSize(MultipartFile merCertPic, HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * 附件下载
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws IOException 
	 */
	ResponseEntity<byte[]> fileDownload(HttpServletRequest request) throws UnsupportedEncodingException, IOException;

}
