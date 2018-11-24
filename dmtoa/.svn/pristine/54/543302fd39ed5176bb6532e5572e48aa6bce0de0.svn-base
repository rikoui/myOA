package com.bjdreamtech.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
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
import com.bjdreamtech.dmt.exception.DMTBusinessException;
import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.bjdreamtech.entity.TableTicket;
import com.bjdreamtech.service.ITicketService;
import com.bjdreamtech.util.DMTResultBean;

/**   
* @Title: TicketController.java 
* @Description: 报销相关的
* @author sizk
* @date 2017年12月4日 下午5:26:37 
* @version V1.0 
* 版本信息：   
* 日期：2017年12月4日
   
*
*/
@Controller
@RequestMapping("ticketController")
public class TicketController extends BaseAction{
	@Autowired
	private ITicketService ticketService;

	/**
	 * 
	* @Title: saveTicke 
	* @Description: 提交报销申请
	* @param @param paramTicket
	* @param @param request
	* @param @return    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月6日 上午11:09:11 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="saveTicke.do",method=RequestMethod.POST)
	@ResponseBody
	public DMTResultBean saveTicke(TableTicket paramTicket,HttpServletRequest request){
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		try {
			resultBean = ticketService.saveTicke(paramTicket,request);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			new DMTResultBean("1","保存异常",msg);
		}
		return resultBean;
	}

	/**
	 * 
	* @Title: expoartExcel 
	* @Description: 导出报销数据
	* @param @param request
	* @param @param response
	* @param @throws Exception    
	* @return void   
	* @author sizk  
	* @date 2017年12月6日 上午11:09:25 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="expoartExcel.do")
	public void expoartExcel(HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws Exception{
		Map<String,Object> map   = ticketService.expoartExcel(request,response);
	}
	
	@RequestMapping(value="expoartExcelAccount.do")
	public void expoartExcelAccount(HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws Exception{
		Map<String,Object> map   = ticketService.expoartExcelAccount(request,response);
	}
	
	/**
	 * 
	* @Title: tickeQuerList 
	* @Description: 查询报销数据
	* @param @param paramTicket
	* @param @param request
	* @param @return    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月6日 上午11:09:08 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="tickeQuerList.do")
	@ResponseBody
	public DMTDataTableBean<Map<String,Object>> tickeQuerList(TableTicket paramTicket,HttpServletRequest request){
		DMTDataTableBean<Map<String,Object>>  resultBean = new DMTDataTableBean(0,null);
		try {
			resultBean=	ticketService.tickeQueryListByPage(paramTicket,request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	
	
	/**
	 * 
	* @Title: downTicketTemp 
	* @Description: 下载报销模板
	* @param @param request
	* @param @param response
	* @param @return    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月6日 下午4:18:23 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="downTicketTemp.do")
	public DMTResultBean downTicketTemp(HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response){
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		try {
			resultBean = ticketService.downTicketTemp(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			new DMTResultBean("1","保存异常",msg);
		}
		return resultBean;
	}
	
	
	
	/**
	 * 附件大小检查&上传
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("checkFileSize.do")
	@ResponseBody
	public DMTResultBean checkFileSize(@RequestParam("merCertZip") MultipartFile merCertPic
			,HttpServletRequest request,HttpServletResponse response)throws FileNotFoundException
			, IOException, ParseException{
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
				FileOutputStream fos = new FileOutputStream(DMTConfigUtil.CONFIGL_TICKET_PERSONAL+File.separator+oldName);
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
	* @Title: saveTicke 
	* @Description: 批量提交报销申请
	* @param @param request
	* @param @return    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月6日 上午11:09:11 
	* @version V1.0   
	* @throws
	 */
	@RequestMapping(value="batchSaveTicke.do",method=RequestMethod.POST)
	@ResponseBody
	public DMTResultBean batchSaveTicke(HttpServletRequest request){
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		try {
			resultBean = ticketService.batchSaveTicke(request);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			resultBean = new DMTResultBean("1","保存异常",msg);
		}
		return resultBean;
	}
	/**
	 * 获取报销详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getTicketInfo.do")
	public DMTResultBean getTicketInfo(HttpServletRequest request){
		return ticketService.getTicketInfo(request);
	}
	
	/**
	 * 修改报销信息
	 * @param request
	 * @return
	 * @throws DMTBusinessException 
	 */
	@ResponseBody
	@RequestMapping("ticketEdit.do")
	public DMTResultBean ticketEdit(HttpServletRequest request) throws DMTBusinessException{
		return ticketService.editTicket(request);
	}
	
	/**
	 * 统计报销条数，计算总金额
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ticketCountAndMoney.do")
	public DMTResultBean ticketCountAndMoney(HttpServletRequest request) {
		return ticketService.queryCountAndMoney(request);
	}
	
}
	