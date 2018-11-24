package com.bjdreamtech.mapper.custom;

import java.util.List;
import java.util.Map;

import com.bjdreamtech.entity.TableNextplan;

public interface NextPlanManageMapper {
	List<Map<String,Object>> nextPlanQueryList(String weeklyId)throws Exception;
}
