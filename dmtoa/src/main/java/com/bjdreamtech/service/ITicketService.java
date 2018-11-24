package com.bjdreamtech.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.entity.TableTicket;
import com.bjdreamtech.util.DMTResultBean;

/**   
* @Title: ITicketService.java 
* @Description: 报销service
* @author sizk
* @date 2017年12月4日 下午6:01:10 
* @version V1.0 
* 版本信息：   
* 日期：2017年12月4日
   
*
*/
public interface ITicketService {

	DMTResultBean saveTicke(TableTicket paramTicket,HttpServletRequest request) throws Exception;

		
	/**
	 * @throws Exception 
	 * 
	* @Title: tickeQuerList 
	* @Description: 查询list数据
	* @param @param paramTicket
	* @param @param request
	* @param @return
	* @param @throws Exception    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月6日 上午11:10:51 
	* @version V1.0   
	* @throws
	 */


	DMTDataTableBean<Map<String,Object>> tickeQueryListByPage(TableTicket paramTicket,
			HttpServletRequest request) throws Exception;

	
	/**
	 * 
	* @Title: expoartExcel 
	* @Description: 报销导出
	* @param @param request
	* @param @param response
	* @param @param paramTicket
	* @param @return    
	* @return Map<String,Object>   
	* @author sizk  
	* @date 2017年12月6日 下午2:46:06 
	* @version V1.0   
	* @throws
	 */
	Map<String, Object> expoartExcel(HttpServletRequest request,
			HttpServletResponse response);
	Map<String, Object> expoartExcelAccount(HttpServletRequest request, 
			HttpServletResponse response);
	/**
	 * 
	* @Title: downTicketTemp 
	* @Description: 下载报销模板
	* @param @param request
	* @param @param response
	* @param @return    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月6日 下午4:18:57 
	* @version V1.0   
	* @throws
	 */
	DMTResultBean downTicketTemp(HttpServletRequest request,
			HttpServletResponse response);


	/**
	 * 
	* @Title: batchSaveTicke 
	* @Description: 批量报销申请导入
	* @param @param request
	* @param @return
	* @param @throws Exception    
	* @return DMTResultBean   
	* @author sizk  
	* @date 2017年12月6日 下午5:42:45 
	* @version V1.0   
	* @throws
	 */
	DMTResultBean batchSaveTicke(HttpServletRequest request) throws Exception;

	/**
	 * 根据ID获取报销信息
	 * @param request
	 * @return
	 */
	DMTResultBean getTicketInfo(HttpServletRequest request);
	/**
	 * 修改用户信息
	 * @param request
	 * @return
	 */
	DMTResultBean editTicket(HttpServletRequest request);

	/**
	 * 统计报销条数，计算总金额
	 * @param request
	 * @return
	 */
	DMTResultBean queryCountAndMoney(HttpServletRequest request);


	
}

