package com.bjdreamtech.mapper.custom;

import java.util.List;
import java.util.Map;

public interface LeaveManageMapper {
	
	/**
	 * 请假单列表查询
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> queryLeavesByPage(Map<String, Object> params);

	/**
	 * 获取请假申请详细信息
	 * @param request
	 * @return
	 */
	List<Map<String, Object>> getLeaveDetail(String id);

}
