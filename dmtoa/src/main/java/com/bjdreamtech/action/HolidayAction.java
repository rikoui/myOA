package com.bjdreamtech.action;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.entity.Holiday;
import com.bjdreamtech.entity.HolidayExample;
import com.bjdreamtech.entity.HolidayExample.Criteria;
import com.bjdreamtech.mapper.auto.HolidayMapper;
import com.bjdreamtech.service.IHolidayService;
import com.bjdreamtech.service.ILoginService;
import com.bjdreamtech.service.IParamManageService;
import com.bjdreamtech.util.DMTValidDateUtil;

/**
 * 节假日导入管理
 * 
 * @author 
 * 
 */
@Controller
@RequestMapping("/holidayAction")
public class HolidayAction extends BaseAction {

	// 通过 @resource注解注入业务层实例
	@Resource
	ILoginService loginService;
	@Resource
	IParamManageService paramManageService;
	@Resource
	HolidayMapper holidayMapper;
	@Resource
	IHolidayService holidayService;
	
	/**
	 * 附件大小检查&上传
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("checkFileSize.do")
	@ResponseBody
	public DMTResultBean checkFileSize(@RequestParam("merCertZip") MultipartFile merCertPic,HttpServletRequest request,HttpServletResponse response)throws FileNotFoundException, IOException, ParseException{
		List<String> resultList = new ArrayList<String>();
		//校验文件大小
		if(StringUtils.isNotEmpty(merCertPic.getOriginalFilename())){
			if(merCertPic.getSize() > 10240){
				return new DMTResultBean("1","文件大小不能超过10k","");
			}else{
				HolidayExample holidayExample = new HolidayExample();
				Holiday holiday = new Holiday();
				InputStream is = merCertPic.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = "";
				StringBuffer errorDate = new StringBuffer();
				while (line != null) {
					line = br.readLine(); // 一次读入一行数据
					if (line != null && !"".equals(line)) {
						if (line.trim().length() == 8) {
							boolean validDate = DMTValidDateUtil.isValidDate(line, "yyyyMMdd");
							if (validDate) {
								Criteria holidayCriteria = holidayExample.createCriteria();
								holidayCriteria.andHolidayIdEqualTo(line);
								List<Holiday> selectByExample = holidayMapper.selectByExample(holidayExample);
								holidayExample.clear();
								if (selectByExample == null || selectByExample.size() == 0) {
									resultList.add(line);
								}
							} else {
								errorDate.append(line).append("，");
							}
						} else {
							errorDate.append(line).append("，");
						}
					}
				}
				isr.close();
				is.close();
				if (errorDate.length() > 0) {
					String errorMsg = errorDate.toString();
					return new DMTResultBean("1", "【" + errorMsg.substring(0, errorMsg.length() - 1)+ "】日期格式不正确，请确认。", "");
				}
				if (resultList.size() > 0) {
					for (String date : resultList) {
						holiday.setHolidayId(date);
						holidayMapper.insertSelective(holiday);
					}
				}
			}
		}
		return new DMTResultBean("0", "节假日导入成功！", resultList);
	}
	
	/**
	 * 节假日导入模版下载
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="downHoliday.do")
	public void downHoliday(HttpServletRequest request, HttpServletResponse response) throws Exception{
		holidayService.downHoliday(request,response);
	}
	
	/**
	 * 节假日查询
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("holidayList.do")
	public DMTDataTableBean<Map<String, Object>> holidayList(HttpServletRequest request) {
		return holidayService.holidayList(request);
	}
	
	/**
	 * 节假日删除
	 * @param request
	 */
	@ResponseBody
	@RequestMapping("deleteHoliday.do")
	public DMTResultBean deleteHoliday(HttpServletRequest request) {
		return holidayService.deleteHoliday(request);
	}

}
