package com.bjdreamtech.mapper.custom;

import java.util.List;
import java.util.Map;


public interface DailyCountScheludeMapper {
	int dailySubmitCount(Map<String, Object> map);

	int leaveCountByCondition(Map<String, Object> map);

	List<Map<String, Object>> selectLeaveByAdmin(Map<String, Object> param);

	List<Map<String, Object>> queryDailys(String preDay);
}
