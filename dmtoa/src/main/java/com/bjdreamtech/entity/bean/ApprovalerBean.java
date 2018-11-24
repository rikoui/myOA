package com.bjdreamtech.entity.bean;

public enum ApprovalerBean {
	//第二审阅人
	SECONDAPPROVALER("PT20171206225730"),
	//第三审阅人
	THIRDAPPROVALER("PT20171206160840");
	
	private String adminId;
	
	private ApprovalerBean(String adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminId() {
		return this.adminId;
	}
}
