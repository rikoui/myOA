package com.bjdreamtech.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTResultBean;
import com.bjdreamtech.dmt.util.DMTSqlTransferUtil;
import com.bjdreamtech.mapper.auto.HolidayMapper;
import com.bjdreamtech.mapper.custom.HolidaysMapper;
import com.bjdreamtech.service.IHolidayService;

/**
 * 节假日模版下载业务层实现类
 * @author 
 *
 */
@Service("holidayService")
public class HolidayServiceImpl extends BaseServiceImpl implements IHolidayService {
	
	@Autowired
	private HolidaysMapper holidaysMapper;
	@Autowired
	private HolidayMapper holidayMapper;

	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");
	
	@Override
	public Map<String, Object> downHoliday(HttpServletRequest request, HttpServletResponse response) {
		String docsPath = request.getSession().getServletContext().getRealPath("docs");
		String fileName = "节假日导入模版.txt";
		String filePath = docsPath + FILE_SEPARATOR + fileName;
		download(filePath, response);
		return null;
	}
	
	private void download(String path, javax.servlet.http.HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(filename.getBytes(), "ISO-8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;charset=utf8");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 节假日查询
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> holidayList(HttpServletRequest request) {
		//需要分页的情况下必须先初始化分页组件数据
		initPageParameter(request);
		String holidayMonth = request.getParameter("holidayMonth");
		if(notNull(holidayMonth)){
			params.put("holidayMonth", DMTSqlTransferUtil.transfer(holidayMonth.replaceAll("-", "")));
		}
		List<Map<String,Object>> queryHolidayByPage = holidaysMapper.queryHolidayByPage(params);
		return new DMTDataTableBean<Map<String, Object>>(pageUtil.getTotalCount(), queryHolidayByPage);
	}

	/**
	 * 节假日删除
	 */
	@Override
	public DMTResultBean deleteHoliday(HttpServletRequest request) {
		String holidayId = request.getParameter("holidayId").replaceAll("-", "");
		int count = holidayMapper.deleteByPrimaryKey(holidayId);
		if (count == 0) {
			return new DMTResultBean("1", "删除假期失败", "删除假期失败!");
		}
		return new DMTResultBean("0", "", "删除假期成功!");
	}

}
