package com.bjdreamtech.format;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjdreamtech.mapper.custom.ParamManageMapper;

/**
 * 状态格式转换器，转换一条或者一个集合中所有的状态数据
 * @author duanwu
 *
 */
public class DMTStatusFormatter {
		
	/**
	 * 转换一条数据中的状态
	 * @param map 需要转换的数据
	 * @param key 需要转换的字段key
	 * @param copyKey 转换后复制的字段key
	 * @param valueMap 转换的对照标准
	 */
	public static void formatStatus(Map<String,Object> map,String key,String copyKey,String code,ParamManageMapper mapper){
		//获取mapper类实例
//		ParamManageMapper paramManageMapper = DMTMapperUtil.getMapper(ParamManageMapper.class);
		//根据参数代码查询所有数据
		List<Map<String,String>> paramList = mapper.getParamByCode(code);
		//将查询出的数据构建成key-value对
		Map<String,String> valueMap = new HashMap<String,String>();
		for(Map<String,String> m : paramList){
			valueMap.put(m.get("key"), m.get("value"));
		}
		for(String k:map.keySet()){
			if(k.equals(key)){
				String status = (String)map.get(k);
				map.put(copyKey, valueMap.get(status));
				break;
			}
		}
	}
	
	/**
	 * 转换一个集合数据中的状态
	 * @param list 需要转换的集合数据
	 * @param key 需要转换的字段key
	 * @param copyKey 转后复制的字段key
	 * @param code 转换的参数代码
	 */
	public static void formatStatusList(List<Map<String,Object>> list,String key,String copyKey,String code,ParamManageMapper mapper){
		//获取mapper类实例
//		ParamManageMapper paramManageMapper = DMTMapperUtil.getMapper(ParamManageMapper.class);
		//根据参数代码查询所有数据
		List<Map<String,String>> paramList = mapper.getParamByCode(code);
		//将查询出的数据构建成key-value对
		Map<String,String> valueMap = new HashMap<String,String>();
		for(Map<String,String> map : paramList){
			valueMap.put(map.get("key"), map.get("value"));
		}
		//转换集合中的数据
		for(int i=0;i<list.size();i++){
			for(String k:list.get(i).keySet()){
				if(k.equals(key)){
					String status = (String)list.get(i).get(k);
					list.get(i).put(copyKey, valueMap.get(status));
					break;
				}
			}
		}
	}
}
