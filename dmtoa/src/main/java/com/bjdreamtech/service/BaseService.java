package com.bjdreamtech.service;

/**
 * 基础业务层通用方法
 * @author duanwu
 *
 */
public class BaseService {

	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public boolean isNull(Object obj) {
		if(obj==null) {
			return true;
		}else {
			if(obj instanceof String) {
				if(((String)obj).trim().equals("")) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断对象是否不为空
	 * @param obj
	 * @return
	 */
	public boolean notNull(Object obj) {
		if(obj==null) {
			return false;
		}
		if(obj instanceof String) {
			if(((String)obj).trim().equals("")) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		BaseService ser = new BaseService();
		System.out.println(ser.isNull(null));
		System.out.println(ser.isNull(""));
		System.out.println(ser.isNull(" "));
		System.out.println(ser.isNull("a"));
		
		System.out.println(ser.notNull(null));
		System.out.println(ser.notNull(""));
		System.out.println(ser.notNull(" "));
		System.out.println(ser.notNull("a"));
	}
}
