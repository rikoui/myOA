package com.bjdreamtech.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.util.DMTResultBean;



/**   
* @Title: IMailService.java 
* @Description: 
* @author sizk
* @date 2017年11月29日 下午6:58:38 
* @version V1.0  
* 
*/
public interface IMailService {

	


	  /**
	   * 
	  * @Title: batchSaveSalary 
	  * @Description: 批量保存工资
	  * @param @param request
	  * @param @return
	  * @param @throws Exception    
	  * @return DMTResultBean   
	  * @author sizk  
	  * @date 2017年12月6日 下午9:59:06 
	  * @version V1.0   
	  * @throws
	   */
	  DMTResultBean batchSaveSalary(HttpServletRequest request)throws Exception;

	  /**
	   * 
	  * @Title: sendEmailyDetail 
	  * @Description: 单条工资条发送邮件
	  * @param @param request
	  * @param @return
	  * @param @throws Exception    
	  * @return DMTResultBean   
	  * @author sizk  
	  * @date 2017年12月7日 下午5:01:58 
	  * @version V1.0   
	  * @throws
	   */
	 DMTResultBean sendEmailyDetail(HttpServletRequest request)throws Exception;

	 /**
	   * 
	  * @Title: sendEmailyDetail 
	  * @Description: 工资条群发邮件
	  * @param @param request
	  * @param @return
	  * @param @throws Exception    
	  * @return DMTResultBean   
	  * @author songj 
	  * @date 2017年12月7日 下午5:01:58 
	  * @version V1.0   
	  * @throws
	   */
	 DMTResultBean groupMailDetail(HttpServletRequest request)throws Exception;
	 
	 /**
	  * 
	 * @Title: tickeQueryListByPage 
	 * @Description: 分页查询
	 * @param @param request
	 * @param @return
	 * @param @throws Exception    
	 * @return DMTDataTableBean<Map<String,Object>>   
	 * @author sizk  
	 * @date 2017年12月7日 下午5:22:50 
	 * @version V1.0   
	 * @throws
	  */
	DMTDataTableBean<Map<String, Object>> tickeQueryListByPage(
			HttpServletRequest request) throws Exception;

	

	
}

