package com.bjdreamtech.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.bjdreamtech.dmt.util.DMTRegexUtil;
import com.bjdreamtech.service.IMailService;
import com.bjdreamtech.util.DMTResultBean;

/**   
* @Title: SalaryMailController.java 
* @Description: 工资条controller
* @author sizk
* @date 2017年12月4日 下午2:03:00 
* @version V1.0 
* 版本信息：   
* 日期：2017年12月4日
   
*
*/
@Controller
@RequestMapping("/salarayMailController")
public class SalarayMailController {
	
	@Autowired
	private IMailService mailService;
	
	/**
	 * 附件大小检查&上传
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("checkFileSize.do")
	@ResponseBody
	public DMTResultBean checkFileSize(@RequestParam("merCertZip") MultipartFile merCertPic,HttpServletRequest request,HttpServletResponse response)throws FileNotFoundException, IOException, ParseException{
		//校验文件大小
		if(StringUtils.isNotEmpty(merCertPic.getOriginalFilename())){
			/*//判断是否是图片
			BufferedImage image = ImageIO.read(merCertPic.getInputStream());
			if(null==image||image.getWidth()<=0||image.getHeight()<=0){//如果iamge=null 表示上传的不是图片格式
				return new DMTResultBean("1","上传的文件不是图片格式，请重新上传","");
			}
			else*/ if(merCertPic.getSize()>10485760){
				return new DMTResultBean("1","文件大小不能超过10M","");
			}else{
				String oldName = merCertPic.getOriginalFilename();
				InputStream is = merCertPic.getInputStream();
				FileOutputStream fos = new FileOutputStream(DMTConfigUtil.CONFIG_SALARY+File.separator+oldName);
				byte[] b = new byte[1024];
				int length = 0;
				while((length = is.read(b))!=-1){
					fos.write(b,0,length);
				}
				fos.flush();
				fos.close();
				is.close();
				Map<String,String> res = new HashMap<String,String>();
				res.put("fileName", oldName);
				return new DMTResultBean("0","",res);
			}
		}
		return null;
	}
	
	
	
	/**
	 * 
	* @Title: batchSaveSalary 
	* @Description: 批量入库
	* @param @param request
	* @param @return    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月7日 下午5:00:28 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="batchSaveSalary.do",method=RequestMethod.POST)
	@ResponseBody
	public DMTResultBean batchSaveSalary(HttpServletRequest request){
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		try {
			resultBean = mailService.batchSaveSalary(request);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			new DMTResultBean("1","保存异常",msg);
		}
		return resultBean;
	}
	
	/**
	 * 
	* @Title: sendEmailyDetail 
	* @Description: 单条发邮件
	* @param @param request
	* @param @return    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月7日 下午5:01:12 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="sendEmailyDetail.do")
	@ResponseBody
	public DMTResultBean sendEmailyDetail(HttpServletRequest request){
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		try {
			resultBean = mailService.sendEmailyDetail(request);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			new DMTResultBean("1","发送异常",msg);
		}
		return resultBean;
	}
	/**
	 * 
	* @Title: sendEmailyDetail 
	* @Description: 群发邮件
	* @param @param request
	* @param @return    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月7日 下午5:01:12 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="groupMailDetail.do")
	@ResponseBody
	public DMTResultBean groupMailDetail(HttpServletRequest request){
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		System.out.println("============"+request.getParameter("ids"));
		try {
			resultBean = mailService.groupMailDetail(request);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			new DMTResultBean("1","发送异常",msg);
		}
		return resultBean;
	}
	
	@RequestMapping(value="salarayQueryList.do")
	@ResponseBody
	public DMTDataTableBean<Map<String,Object>> salarayQueryList(HttpServletRequest request){
		DMTDataTableBean<Map<String,Object>>  resultBean = new DMTDataTableBean<Map<String, Object>>(0,null);
		try {
			resultBean=	mailService.tickeQueryListByPage(request);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
}

