package com.bjdreamtech.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期校验工具
 * @author 
 *
 */
public class DMTValidDateUtil {
	/**
	 * 
	 * @param str 日期
	 * @param pattern 日期格式
	 * @return
	 */
	public static boolean isValidDate(String str, String pattern) {
		boolean convertSuccess=true;
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			convertSuccess=false;
		}
		return convertSuccess;
	}
	
	public static void main(String[] args) {
		boolean validDate = isValidDate("2018-03-31", "yyyy-MM-dd");
		System.out.println(validDate);
	}
	
}
