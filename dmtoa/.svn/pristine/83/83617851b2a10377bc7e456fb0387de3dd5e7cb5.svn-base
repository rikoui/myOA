package com.bjdreamtech.util.mail;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.sun.mail.util.MailSSLSocketFactory;

public class EmailUtil {
	class MyAuthenticator extends Authenticator{
		private String strUser;
	    private String strPwd;
	    public MyAuthenticator(String user, String password) {
	      this.strUser = user;
	      this.strPwd = password;
	    }

	    protected PasswordAuthentication getPasswordAuthentication() {
	      return new PasswordAuthentication(strUser, strPwd);
	    }
	}

	/**
	 * 邮件发送
	 * @param to
	 * 			邮件接收方
	 * @param content
	 * 			邮件内容
	 * @param subject
	 * 			邮件主题
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws GeneralSecurityException
	 */
	public static void sendMail(String to,String content,String subject
			)throws AddressException, MessagingException, GeneralSecurityException{
		
						
		Properties prop = new Properties();
		prop.put("mail.smtp.host", DMTConfigUtil.EMAIL_SMTP);
		prop.put("mail.smtp.auth", DMTConfigUtil.EMAIL_AUTH);
		prop.put("mail.smtp.port",DMTConfigUtil.EMAIL_PORT);
		//添加SSL安全认证
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf); 
		Authenticator auth = new EmailUtil().new MyAuthenticator(DMTConfigUtil.EMAIL_ACCOUNT, DMTConfigUtil.EMAIL_PWD);
		Session session = Session.getDefaultInstance(prop, auth);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(DMTConfigUtil.EMAIL_ACCOUNT));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setContent(content, "text/html;charset=utf-8");  
		message.saveChanges();
		Transport.send(message);
	
	}
}
