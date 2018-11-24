package com.bjdreamtech.mapper.custom;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bjdreamtech.entity.TableTicket;



/**   
* @Title: TbleTicketMapperCustom.java 
* @Description: 报销相关自定义dao层 
* @author sizk
* @date 2017年12月6日 上午11:36:47 
* @version V1.0 
* 版本信息：   
* 日期：2017年12月6日
   
*
*/
public interface TableTicketCustomMapper {
	
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


	List<Map<String,Object>> TickeQueryList(Map<String, Object> params) throws Exception;
	List<Map<String,Object>> TickeQuery(Map<String, Object> params)throws Exception;
	List<Map<String,Object>> TickeBankAccountQuery(Map<String, Object> params)throws Exception;
	/**
	 * 
	* @Title: QueryListByPage 
	* @Description: 自定义分页查询
	* @param @param params
	* @param @return
	* @param @throws Exception    
	* @return List<Map<String,Object>>   
	* @author sizk  
	* @date 2017年12月6日 上午11:41:24 
	* @version V1.0   
	* @throws
	 */
	List<Map<String, Object>> QueryListByPage(Map<String, Object> params) throws Exception;

	/**
	 * 
	* @Title: batchSaveTicke 
	* @Description: 批量入库
	* @param @param ticketList
	* @param @return
	* @param @throws Exception    
	* @return int   
	* @author sizk  
	* @date 2017年12月7日 下午4:33:40 
	* @version V1.0   
	* @throws
	 */
	int batchSaveTicke(List<TableTicket> ticketList) throws Exception;
	/**
	 * 统计报销条数，计算总金额
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> queryCountAndMoney(Map<String, Object> params);

}

