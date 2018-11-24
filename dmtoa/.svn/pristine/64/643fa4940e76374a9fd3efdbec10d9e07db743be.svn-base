package com.bjdreamtech.service;
/**
 * @author wp
 * @since
 * 发送邮件，短信息公共方法
 */
public interface ISendMessageService {
	
	/* 
	 * subject 邮件主题
	 * content 邮件内容
	 * user 发送者名称
	 * SMTP 服务器
	 * fromAccount 发送者账号
	 * Pwd 发送者密码
	 * toAccount 收件人账号
	 * return 状态
	 */
	public String sendEmailMessage(final String subject, final String content, final String userName, final String smtp, final String fromAccount,
			final String pwd, final String toAccount );
	
    
	/**
	 * 易云平台短信接口
	 * @param content 短信内容
	 * @param url 短信平台地址
	 * @param sendAccount 发送账号
	 * @param pwd 发送密码
	 * @param phone 接收方手机号码
	 * return 状态
	 */
	public String sendPhoneMessage(String content,String url,String sendAccount,String pwd,String phone);
	

}
