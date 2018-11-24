package com.bjdreamtech.service.impl;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.bean.DMTSessionBean;
import com.bjdreamtech.dmt.format.DMTDESDataFormatter;
import com.bjdreamtech.dmt.format.DMTTimeFormatter;
import com.bjdreamtech.dmt.util.DMT3DESUtil;
import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.bjdreamtech.dmt.util.DMTDateUtil;
import com.bjdreamtech.dmt.util.DMTMD5Util;
import com.bjdreamtech.dmt.util.DMTPrimaryKeyUtil;
import com.bjdreamtech.dmt.util.DMTRegexUtil;
import com.bjdreamtech.dmt.util.DMTSendMessage;
import com.bjdreamtech.dmt.util.DMTSendMsgHttp;
import com.bjdreamtech.dmt.util.DMTSqlTransferUtil;
import com.bjdreamtech.entity.SysAdmin;
import com.bjdreamtech.entity.SysAdminExample;
import com.bjdreamtech.entity.SysParam;
import com.bjdreamtech.format.DMTStatusFormatter;
import com.bjdreamtech.mapper.auto.SysAdminMapper;
import com.bjdreamtech.mapper.auto.SysParamMapper;
import com.bjdreamtech.mapper.custom.AdminManageMapper;
import com.bjdreamtech.service.IAdminService;

/**
 * 用户管理模块业务层实现类
 * @author duanwu
 *
 */
@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl implements IAdminService {
	
	@Resource
	AdminManageMapper adminManageMapper;
	
	@Resource
	SysAdminMapper adminMapper;

	@Autowired
	SysParamMapper sysParamMapper;
	
	@Override
	public DMTDataTableBean<Map<String, Object>> queryAdminByPage(
			HttpServletRequest request) {
		//初始化分页参数
		initPageParameter(request);
		String username = request.getParameter("username");
		String realname = request.getParameter("realname");
		String status = request.getParameter("status");
		String roleid = request.getParameter("roleid");
		String phone = request.getParameter("phone");
		if(notNull(username)){
			params.put("username", DMTSqlTransferUtil.transfer(username));
		}
		if(notNull(realname)){
			params.put("realname", DMTSqlTransferUtil.transfer(realname));
		}
		if(notNull(status)){
			params.put("status", status);
		}
		if(notNull(roleid)){
			params.put("roleid", roleid);
		}
		if(notNull(phone)){
			params.put("phone", DMT3DESUtil.encryptMode(phone));
//			System.out.println("=================");
//			System.out.println(phone);
//			System.out.println(DMTSqlTransferUtil.transfer(phone));
		}
		List<Map<String,Object>> adminList = adminManageMapper.queryAdminListByPage(params);
		DMTTimeFormatter.formatTimeList(adminList, "createtime", "createtimecopy");
		DMTStatusFormatter.formatStatusList(adminList, "status", "statuscopy", "ADMIN_STATUS",paramManageMapper);
		//手机号解密
		DMTDESDataFormatter.formatTimeList(adminList, "phone");
		//邮箱解密
		DMTDESDataFormatter.formatTimeList(adminList, "email");
		return new DMTDataTableBean<Map<String,Object>>(pageUtil.getTotalCount(), adminList);
	}

	/**
	 * 新增用户
	 */
	@Override
	public DMTResultBean addAdmin(HttpServletRequest request) {
		DMTSessionBean adminuser=(DMTSessionBean)request.getSession().getAttribute("sessionBean");
		String createuser = adminuser.getRealname();
		DMTSessionBean userinfo = getSessionBean(request);
		String staffno = request.getParameter("staffno");
		//校验员工编号的唯一性
		SysAdminExample sysExampleno= new SysAdminExample();
		sysExampleno.createCriteria().andAdminUsernameEqualTo(staffno);
		List<SysAdmin> sysListno = adminMapper.selectByExample(sysExampleno);
		if(null != sysListno && sysListno.size() != 0){
			return new DMTResultBean("1","该员工编号已存在!","");
		}
		String username = request.getParameter("username");
		//校验用户名的唯一性
		SysAdminExample sysExample= new SysAdminExample();
		sysExample.createCriteria().andAdminUsernameEqualTo(username);
		List<SysAdmin> sysList = adminMapper.selectByExample(sysExample);
		if(null != sysList && sysList.size() != 0){
			return new DMTResultBean("1","该用户名已存在!","");
		}
		String realname = request.getParameter("realname");
		String roleid = request.getParameter("roleid");
		String phone = request.getParameter("phone");
		//校验手机号码的唯一性
		SysAdminExample example = new SysAdminExample();
		example.createCriteria().andAdminPhoneEqualTo(DMT3DESUtil.encryptMode(phone));
		List<SysAdmin> phList = adminMapper.selectByExample(example);
		if(null != phList && phList.size() != 0){
			return new DMTResultBean("1","该手机号已存在!","");
		}
		String email = request.getParameter("email");
		//校验邮箱的唯一性
		SysAdminExample exam = new SysAdminExample();
		exam.createCriteria().andAdminEmailEqualTo(DMT3DESUtil.encryptMode(email));
		List<SysAdmin> emList = adminMapper.selectByExample(exam);
		if(null != emList && emList.size() != 0){
			return new DMTResultBean("1","该邮箱已存在!","");
		}
//		String password = generateWord();
		String password = "cVt5_l1k";
		if(!validateAddAdmin(staffno,username,realname,roleid,phone)){
			return new DMTResultBean("1","数据校验失败","");
		}
		if(!DMTRegexUtil.matches(phone, DMTRegexUtil.PHONE)){
			return new DMTResultBean("1","手机号输入有误","");
		}
		SysAdmin admin = new SysAdmin();
		admin.setAdminCreatetime(DMTDateUtil.parseDate());
		admin.setAdminStaffNo(staffno);
		admin.setAdminErrortimes(0);
		admin.setAdminId("PT"+DMTDateUtil.parseDate());
		admin.setAdminMark("1");
		admin.setAdminPassword(DMTMD5Util.string2MD5(password));
		admin.setAdminPhone(DMT3DESUtil.encryptMode(phone)); //手机号加密
		admin.setAdminEmail(DMT3DESUtil.encryptMode(email)); //邮箱解密
		admin.setAdminRealname(realname);
		admin.setAdminRoleId(roleid);
		admin.setAdminStatus("0");
		admin.setAdminErrortimes(0);
		admin.setAdminUsername(username);
		admin.setAdminCreateuser(createuser);
		admin.setAdminCreatetime(DMTDateUtil.parseDate());
		admin.setAdminCountday("0");
		
		adminMapper.insertSelective(admin);
		log.logging("新增用户", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		//发送邮件
		//查询邮箱参数
		List<Map<String, Object>> emailParams = paramManageMapper.queryEmailParams();
		String[] params=new String[3];
		for (Map<String, Object> map : emailParams) {
			if("服务器".equals(map.get("key"))){
				params[0] = (String)map.get("value");
			}
			else if("账号".equals(map.get("key"))){
				params[1] = (String)map.get("value");
			}else{
				params[2] = (String)map.get("value");
			}
		}
		String emailContent = "尊敬的"+realname+"，您好！您的追梦运营管理系统登录名为："+username+"，初始密码为："+password+"，请及时登录到系统对初始用户名和密码进行修改。";
		String eres = DMTSendMessage.sendEmailMessage("运营管理员账号创建成功通知", emailContent, "追梦运营管理系统", 
				params[0], params[1], params[2], email);
		log.debug("邮箱发送结果："+eres, this.getClass());
		//获取新增数据admin的主键
		String adminId = DMTPrimaryKeyUtil.getPrimaryKey("ADMIN");
		
		
		adminId.toCharArray();
		
		/*
		 * 发送短信
		 * */
//		boolean IsSuccess = false;
//		String Msg = "";
//		long QueueID = 0;
//		//短信发送url
//		SysParam sps1 = sysParamMapper.selectByPrimaryKey("PC4CE86E26F75470C9C384A954AD7BA83");
//		String url = "";
//			url = sps1.getParamValue();
//		//短信发送密码
//		SysParam sps2= sysParamMapper.selectByPrimaryKey("PBDF08B9B59F14D72A09A233BF8AC9C55");
//		String MSMpassword = "";
//			MSMpassword = sps2.getParamValue();
//		//短信发送用户id
//		SysParam sps3= sysParamMapper.selectByPrimaryKey("PD60F5B2A7D7B4949AD3E17FF3A1F271E");
//		String UserId="";
//			UserId = sps3.getParamValue();
//		//短信发送账号
//		SysParam sps4= sysParamMapper.selectByPrimaryKey("PF39393AC887243189BB2F6A64A116805");
//		String account="";
//		account = sps4.getParamValue();
//		//发送的手机号
//	    String mobile = phone;
//		//发送的内容
//		String content="【追梦】尊敬的"+realname+"，您好！您的追梦管理系统登录名为："
//																   +username
//																   +"，密码已经初始化，您的密码是："
//																   +password
//																   +"  请及时登录到系统对初始密码进行修改。";
//		try{
//		String str = url + "?action=send&UserId="
//				+ URLEncoder.encode(UserId, "UTF-8")+"&account="
//				+ URLEncoder.encode(account, "UTF-8") + "&password="
//				+ URLEncoder.encode(MSMpassword, "UTF-8") +  "&mobile="
//				+ URLEncoder.encode(mobile, "UTF-8") + "&content="
//				+ URLEncoder.encode(content, "UTF-8") +"&sendTime=&checkcontent=1";
		/*String sendsmsTestString = DMTSendMsgHttp.http(str, null);
		if (sendsmsTestString.startsWith("success")) {
			String[] str1 = sendsmsTestString.split(";");
			System.out.println(str1);
			IsSuccess = true;
			Msg = str1[0];
			QueueID = Long.parseLong(str1[1].trim());
			System.out.println(IsSuccess+Msg+QueueID);
		} else if (sendsmsTestString.startsWith("fail")) {
			IsSuccess = false;
			// 当前错误信息
			Msg = sendsmsTestString;

		} else if (sendsmsTestString.startsWith("NetWorkConnectionFailed!")) {

			IsSuccess = false;
			// 当前错误信息
			Msg = sendsmsTestString;
			System.out.println("当前网络已经断开！请尝试重新连接网络……");
		}*/
//		}catch(Exception ex){
//			
//		}
		
		return new DMTResultBean();
	}
	
	/**
	 * 校验新增用户提交数据
	 * @param username
	 * @param realname
	 * @param roleid
	 * @param phone
	 */
	public boolean validateAddAdmin(String staffno,String username,String realname,String roleid,String phone){
		if(isNull(username)||isNull(realname)||isNull(roleid)||isNull(phone)){
			return false;
		}
		if(username.length()>20||realname.length()>10||phone.length()>20){
			return false;
		}
		return true;
	}
	
	public boolean validateEditAdmin(String staffno, String id,String username,String realname,String roleid,String phone,String status){
		if(isNull(id)||isNull(realname)||isNull(realname)||isNull(roleid)||isNull(phone)||isNull(status)){
			return false;
		}
		if(username.length()>20||realname.length()>10||phone.length()>20||status.length()>1){
			return false;
		}
		return true;
	}

	/**
	 * 根据用户ID获取用户信息
	 */
	@Override
	public DMTResultBean getAdminInfo(HttpServletRequest request) {
		String adminid = request.getParameter("adminid");
		SysAdmin admin = adminMapper.selectByPrimaryKey(adminid);
		if(admin==null){
			return new DMTResultBean("1","该用户已不存在","");
		}
		admin.setAdminPhone(DMT3DESUtil.decryptMode(admin.getAdminPhone()));
		admin.setAdminEmail(DMT3DESUtil.decryptMode(admin.getAdminEmail()));
		return new DMTResultBean("0","",admin);
	}

	/**
	 * 修改用户信息
	 */
	@Override
	public DMTResultBean editAdmin(HttpServletRequest request) {
		DMTSessionBean userinfo = getSessionBean(request);
		String id = request.getParameter("id");
		String staffno = request.getParameter("staffno");
		String username = request.getParameter("username");
		//校验用户名的唯一性
		SysAdminExample sysExample= new SysAdminExample();
		sysExample.createCriteria().andAdminUsernameEqualTo(username).andAdminIdNotEqualTo(id);
		List<SysAdmin> sysList = adminMapper.selectByExample(sysExample);
		if(null != sysList && sysList.size() != 0){
			return new DMTResultBean("1","该用户名已存在!","");
		}
		String realname = request.getParameter("realname");
		String roleid = request.getParameter("roleid");
		String phone = request.getParameter("phone");
		//校验手机号的唯一性
		SysAdminExample example= new SysAdminExample();
		example.createCriteria().andAdminPhoneEqualTo(DMT3DESUtil.encryptMode(phone)).andAdminIdNotEqualTo(id);
		List<SysAdmin> list = adminMapper.selectByExample(example);
		if(null != list && list.size() != 0){
			return new DMTResultBean("1","该手机号已存在!","");
		}
		String email = request.getParameter("email");
		//校验邮箱唯一性
		SysAdminExample exam = new SysAdminExample();
		exam.createCriteria().andAdminEmailEqualTo(DMT3DESUtil.encryptMode(email)).andAdminIdNotEqualTo(id);
		List<SysAdmin> emList = adminMapper.selectByExample(exam);
		if(null != emList && emList.size() != 0){
			return new DMTResultBean("1","该邮箱已存在!","");
		}
		String status = request.getParameter("status");
		if(status.equals("1")||status.equals("2")){
			return new DMTResultBean("1","该用户已被禁用或冻结","");
		}
		if(!validateEditAdmin(staffno,id,username,realname,roleid,phone,status)){
			return new DMTResultBean("1","数据校验失败","");
		}
		if(!DMTRegexUtil.matches(phone, DMTRegexUtil.PHONE)){
			return new DMTResultBean("1","手机号输入有误","");
		}
		SysAdmin admin = adminMapper.selectByPrimaryKey(id);
		if(admin==null){
			return new DMTResultBean("1","改用户已不存在","");
		}
		admin.setAdminStaffNo(staffno);
		admin.setAdminPhone(DMT3DESUtil.encryptMode(phone)); //手机号加密
		admin.setAdminEmail(DMT3DESUtil.encryptMode(email)); //邮箱加密
		admin.setAdminRealname(realname);
		admin.setAdminRoleId(roleid);
		admin.setAdminStatus(status);
		admin.setAdminUsername(username);
		adminMapper.updateByPrimaryKeySelective(admin);
		log.logging("修改用户信息", this.getClass(), userinfo.getUsername(), userinfo.getIp());
		return new DMTResultBean();
	}

	@Override
	public DMTResultBean deleteAdmin(HttpServletRequest request) {
		//  Auto-generated method stub
		return null;
	}

	/**
	 * 启用/禁用/解冻用户
	 */
	@Override
	public DMTResultBean statusAdmin(HttpServletRequest request) {
		DMTSessionBean session = getSessionBean(request);
		String id = request.getParameter("id");
		String status =request.getParameter("status");
		SysAdmin admin = adminMapper.selectByPrimaryKey(id);
		if(admin==null){
			return new DMTResultBean("1","改用户已不存在","");
		}
		admin.setAdminStatus(status);
		adminMapper.updateByPrimaryKeySelective(admin);
		log.logging("启用禁用", this.getClass(), session.getUsername(), session.getIp());
		return new DMTResultBean("0","","操作成功");
	}

	/**
	 * 初始化密码
	 */
	@Override
	public DMTResultBean initRole(HttpServletRequest request) {
		DMTSessionBean session = getSessionBean(request);
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		if(status.equals("1")){
			return new DMTResultBean("1","该用户已被禁用","");
		}
		//查询用户信息
		SysAdmin admin = adminMapper.selectByPrimaryKey(id);
		String realName = admin.getAdminRealname();
		String userName = admin.getAdminUsername();
		String email = DMT3DESUtil.decryptMode(admin.getAdminEmail()) ;
//		String password = generateWord();
		String password = "cVt5_l1k";
		params.put("id", id);
		params.put("password", DMTMD5Util.string2MD5(password));
		adminManageMapper.initRole(params);
		log.logging("初始化密码", this.getClass(), session.getUsername(), session.getIp());
		//发送邮件
		//查询邮箱参数
		List<Map<String, Object>> emailParams = paramManageMapper.queryEmailParams();
		String[] params=new String[3];
		for (Map<String, Object> map : emailParams) {
			if("服务器".equals(map.get("key"))){
				params[0] = (String)map.get("value");
			}
			else if("账号".equals(map.get("key"))){
				params[1] = (String)map.get("value");
			}else{
				params[2] = (String)map.get("value");
			}
		}
		String emailContent = "尊敬的"+realName+"，您好！您的追梦运营管理系统登录名为："+userName+"，密码已经初始化成功，初始化后的密码为："+password+"，请及时登录到系统对初始用户名和密码进行修改。";
		String eres = DMTSendMessage.sendEmailMessage("运营管理员账号密码初始化成功通知", emailContent, "追梦运营系统", 
				params[0], params[1], params[2], email);
		log.debug("邮箱发送结果："+eres, this.getClass());
		
		/*
		 * 发送短信
		 * */
//		boolean IsSuccess = false;
//		String Msg = "";
//		long QueueID = 0;
//		//短信发送url
//		SysParam sps1 = sysParamMapper.selectByPrimaryKey("PC4CE86E26F75470C9C384A954AD7BA83");
//		String url = "";
//			url = sps1.getParamValue();
//		//短信发送密码
//		SysParam sps2= sysParamMapper.selectByPrimaryKey("PBDF08B9B59F14D72A09A233BF8AC9C55");
//		String MSMpassword = "";
//			MSMpassword = sps2.getParamValue();
//		//短信发送用户id
//		SysParam sps3= sysParamMapper.selectByPrimaryKey("PD60F5B2A7D7B4949AD3E17FF3A1F271E");
//		String UserId="";
//			UserId = sps3.getParamValue();
//		//短信发送账号
//		SysParam sps4= sysParamMapper.selectByPrimaryKey("PF39393AC887243189BB2F6A64A116805");
//		String account="";
//		account = sps4.getParamValue();
//		//发送的手机号
//	    String mobile = DMT3DESUtil.decryptMode(admin.getAdminPhone());
//		//发送的内容
//		String content="【追梦】尊敬的"+realName+"，您好！您的追梦管理系统登录名为："
//																   +userName
//																   +"，密码已经初始化，您的密码是："
//																   +password
//																   +"  请及时登录到系统对初始密码进行修改。";
//		try{
//		String str = url + "?action=send&UserId="
//				+ URLEncoder.encode(UserId, "UTF-8")+"&account="
//				+ URLEncoder.encode(account, "UTF-8") + "&password="
//				+ URLEncoder.encode(MSMpassword, "UTF-8") +  "&mobile="
//				+ URLEncoder.encode(mobile, "UTF-8") + "&content="
//				+ URLEncoder.encode(content, "UTF-8") +"&sendTime=&checkcontent=1";
		/*String sendsmsTestString = DMTSendMsgHttp.http(str, null);
		if (sendsmsTestString.startsWith("success")) {
			String[] str1 = sendsmsTestString.split(";");
			System.out.println(str1);
			IsSuccess = true;
			Msg = str1[0];
			QueueID = Long.parseLong(str1[1].trim());
			System.out.println(IsSuccess+Msg+QueueID);
		} else if (sendsmsTestString.startsWith("fail")) {
			IsSuccess = false;
			// 当前错误信息
			Msg = sendsmsTestString;

		} else if (sendsmsTestString.startsWith("NetWorkConnectionFailed!")) {

			IsSuccess = false;
			// 当前错误信息
			Msg = sendsmsTestString;
			System.out.println("当前网络已经断开！请尝试重新连接网络……");
		}*/
//		}catch(Exception ex){
//			
//		}
		
		return new DMTResultBean("0", "", "初始化密码成功");
	}

	/**
	 * 查看操作员详情
	 */
	@Override
	public DMTResultBean queryAdmin(HttpServletRequest request) {
		String adminid = request.getParameter("adminid");
		Map<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("adminId", adminid);
		Map<String, Object> admin=adminManageMapper.queryAdmin(hashMap);
		DMTStatusFormatter.formatStatus(admin, "status", "copyStatus", "ADMIN_STATUS", paramManageMapper);
		DMTTimeFormatter.formatTime(admin, "createtime", "createtimecopy");
		//手机解密
		DMTDESDataFormatter.formatTime(admin, "phone");
		//邮箱解密
		DMTDESDataFormatter.formatTime(admin, "email");
		if(admin==null){
			return new DMTResultBean("1","该用户已不存在","");
		}
		return new DMTResultBean("0","",admin);
	}
	
	/**
	 * 加载当前用户所属机构
	 * */
	@Override
	public DMTResultBean queryBranch(HttpServletRequest request) {
//		DMTSessionBean session = getSessionBean(request);
//		String branchId = session.getBranchid();
//		SysBranch branchList = (SysBranch)sysBranchMapper.selectByPrimaryKey(branchId);
		return new DMTResultBean("0","","");
	}
	/**
	 * 生成6位数字字母组合随机密码
	 * @return
	 */
	public String generateWord(){
		String[] beforeShuffle = new String[] { "0","1","2", "3", "4", "5", "6", "7",  
	            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",  
	                                                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
	                                                  "W", "X", "Y", "Z" };  
        
        String result = "";
        while(!result.matches(DMTRegexUtil.PASSWORD)){
        	List<String> list = Arrays.asList(beforeShuffle);
	        //打乱排序
	        Collections.shuffle(list); 
	        StringBuilder sb = new StringBuilder();  
	        for (int i = 0; i < list.size(); i++)
	        {  
	            sb.append(list.get(i));  
	        }  
	        String afterShuffle = sb.toString();  
	        result = afterShuffle.substring(4, 12); 
        }
        return result;
	}

	@Override
	public DMTDataTableBean adminLeiuDayList(HttpServletRequest request) {
		//初始化分页参数
		initPageParameter(request);
		String amdinId = request.getParameter("amdinId");
		if(notNull(amdinId)){
			params.put("amdinId", amdinId);
		}
		List<Map<String,Object>> adminList = adminManageMapper.queryAdminLeiuDayListByPage(params);
		return new DMTDataTableBean(pageUtil.getTotalCount(), adminList);
	}

	/**
	 * 获取所有员工
	 * @param request
	 * @return
	 */
	@Override
	public DMTResultBean queryAllAdmin(HttpServletRequest request) {
		SysAdminExample example = new SysAdminExample();
		example.createCriteria().andAdminStatusEqualTo("0").andAdminRoleIdNotEqualTo("88888888");
		List<SysAdmin> admins = adminMapper.selectByExample(example);
		return new DMTResultBean("0","",admins);
	}

	/**
	 * 修改员工倒休天数
	 * @param request
	 * @return
	 */
	@Override
	public DMTResultBean editAdminLeiuDay(HttpServletRequest request) {
		String adminId = request.getParameter("adminId");
		String leiuDay = request.getParameter("leiuDay");
		if(StringUtils.isBlank(leiuDay)) {
			return new DMTResultBean("1","请输入员工剩余倒休天数","");
		}
		float leiuday = Float.parseFloat(leiuDay);
		if(leiuday < 0) {
			return new DMTResultBean("1","请输入大于等于0的员工剩余倒休天数","");
		}
		SysAdmin admin = new SysAdmin();
		admin.setAdminId(adminId);
		admin.setAdminLieuDay(leiuday);
		adminMapper.updateByPrimaryKeySelective(admin);
		return new DMTResultBean();
	}

}
