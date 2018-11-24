package com.bjdreamtech.util;

public class DMTResultBean {
	/**
	 * 请求状态 0：成功   1：失败
	 */
	private String status;
	
	/**
	 * 错误信息 当status为1时存放错误信息
	 */
	private String errorMsg;
	
	/**
	 * 请求数据 当status为0时存放返回到客户端的数据
	 */
	private Object result;
	
	public DMTResultBean(){
		status = "0";
	};
	
	public DMTResultBean(String status, String errorMsg, Object result){
		this.status = status;
		this.errorMsg = errorMsg;
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	/**
	 * 设置返回对象的所有属性
	 * @param status
	 * @param errorMsg
	 * @param result
	 */
	public void setAttr(String status, String errorMsg, Object result){
		this.status = status;
		this.errorMsg = errorMsg;
		this.result = result;
	}
	
}
