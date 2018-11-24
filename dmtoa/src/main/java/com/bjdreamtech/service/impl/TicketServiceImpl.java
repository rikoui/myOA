package com.bjdreamtech.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.bean.DMTSessionBean;
import com.bjdreamtech.dmt.util.DMT3DESUtil;
import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.bjdreamtech.dmt.util.DMTDateUtil;
import com.bjdreamtech.dmt.util.DMTMoneyUtil;
import com.bjdreamtech.dmt.util.DMTPrimaryKeyUtil;
import com.bjdreamtech.dmt.util.DMTRegexUtil;
import com.bjdreamtech.entity.SysAdmin;
import com.bjdreamtech.entity.SysAdminExample;
import com.bjdreamtech.entity.SysParam;
import com.bjdreamtech.entity.SysParamExample;
import com.bjdreamtech.entity.TableTicket;
import com.bjdreamtech.entity.TableTicketExample;
import com.bjdreamtech.entity.excelbean.TicketExcelBean;
import com.bjdreamtech.format.DMTStatusFormatter;
import com.bjdreamtech.mapper.auto.SysParamMapper;
import com.bjdreamtech.mapper.auto.TableTicketMapper;
import com.bjdreamtech.mapper.custom.TableTicketCustomMapper;
import com.bjdreamtech.service.ITicketService;
import com.bjdreamtech.util.DMTResultBean;
import com.bjdreamtech.util.excel.ExportExcel;
import com.bjdreamtech.util.excel.ReadExcelUtils;

/**   
* @Title: TicketServiceImpl.java 
* @Description: 报销实现类
* @author sizk
* @date 2017年12月4日 下午6:06:10 
* @version V1.0 
* 版本信息：   
* 日期：2017年12月4日
   
*
*/
/**
 * @Title: TicketServiceImpl.java
 * @Description: 报销实现类
 * @author sizk
 * @date 2017年12月4日 下午6:06:10
 * @version V1.0 版本信息： 日期：2017年12月4日
 *
 * 
 */
@Service
public class TicketServiceImpl extends BaseServiceImpl implements ITicketService {
	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

	@Autowired
	private TableTicketMapper tableTicketMapper;
	@Autowired
	private TableTicketCustomMapper tableTicketMapperCustom;
	@Autowired
	private SysParamMapper paramMapper;

	/*
	 * (非 Javadoc) <p>Title: saveTicke</p> <p>Description: 报销入库</p>
	 * 
	 * @author sizk
	 * 
	 * @date 2017年12月4日 下午6:10:49
	 * 
	 * @version V1.0
	 * 
	 * @param paramTicket
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.dreamtech.modules.oa.service.ITicketService#saveTicke(com.dreamtech.
	 * modules.oa.entity.TbleTicket)
	 */
	@Override
	public DMTResultBean saveTicke(TableTicket paramTicket, HttpServletRequest request) throws Exception {
		DMTResultBean resultBean = new DMTResultBean("1", "初始化失败", "初始化失败");
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String ticketCreateAdmin = admin.getAdminid();
		paramTicket.setTicketCreateAdmin(ticketCreateAdmin);
		String person = admin.getRealname();
		paramTicket.setTicketPerson(person);
		String ticketId = DMTPrimaryKeyUtil.getPrimaryKey("");
		paramTicket.setTicketId(ticketId);
		String ticketCreate = DMTDateUtil.parseDate();
		paramTicket.setTicketCreate(ticketCreate);
		// 处理报销人、报销时间的
		String ticketMonth = request.getParameter("ticketMonth");
				String Pay = request.getParameter("ticketPay");
		if (notNull(ticketMonth)) {
			ticketMonth = ticketMonth.substring(0, 7);
		}else{
			return new DMTResultBean("1", "报销月份不能为空", "报销月份不能为空");
		}
		String ticketTime = request.getParameter("ticketTime");
		if (notNull(ticketTime)) {
			paramTicket.setTicketTime(ticketTime);
		}else{
			return new DMTResultBean("1", "报销日期不能为空", "报销日期不能为空");	
		}
		String ticketItem =request.getParameter("ticketItem");
		if(notNull(ticketItem)){
			paramTicket.setTicketItem(ticketItem);
		}else{
			return new DMTResultBean("1", "事项不能为空", "事项不能为空");
		}
		String use = request.getParameter("ticketUse");
		if(notNull(use)){
			paramTicket.setTicketUse(use);
		}else{
			return new DMTResultBean("1", "用途不能为空", "用途不能为空");
		}
		  
		if (notNull(Pay)) {
			BigDecimal ticketPay = new BigDecimal(Pay);
			double pay = ticketPay.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			if(pay==0){
				return new DMTResultBean("1", "金额不能为零", "金额不能为零");
			}
			paramTicket.setTicketPay(pay);
		}else if(!DMTRegexUtil.matches(Pay, DMTRegexUtil.MONEY)){
			return new DMTResultBean("1", "请填写正确的金额", "请填写正确的金额");
		}else{
			return new DMTResultBean("1", "花费不能为空", "花费不能为空");
		}
		String ticketType = request.getParameter("ticketType");
		if(notNull(ticketType)){
			paramTicket.setTicketType(ticketType);
		}else{
			return new DMTResultBean("1", "发票情况不能为空", "发票情况不能为空");
		}
		
		paramTicket.setTicketMonth(ticketMonth);
		String ticketRemaker = request.getParameter("ticketRemaker");
		paramTicket.setTicketRemaker(ticketRemaker== null ? "" : ticketRemaker);
		// 查询是否
		int i = tableTicketMapper.insertSelective(paramTicket);
		if (i > 0) {
			resultBean = new DMTResultBean("0", "成功", "报销申请成功");
		} else {
			resultBean = new DMTResultBean("1", "失败", "报销申请保存失败");
		}
		return resultBean;
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

	/*
	 * (非 Javadoc) <p>Title: tickeQueryListByPage</p> <p>Description: 分页查询</p>
	 * 
	 * @author sizk
	 * 
	 * @date 2017年12月6日 上午11:33:37
	 * 
	 * @version V1.0
	 * 
	 * @param paramTicket
	 * 
	 * @param request
	 * 
	 * @return
	 * 
	 * @see com.bjdreamtech.service.ITicketService#tickeQueryListByPage(com.
	 * bjdreamtech.entity.TbleTicket, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> tickeQueryListByPage(TableTicket paramTicket,
			HttpServletRequest request) throws Exception {
		initPageParameter(request);
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String roleId = admin.getRoleid();
		String timeStr = paramTicket.getTicketTime();
		String ticketCreateAdmin = admin.getAdminid();
		String ticketCreate = paramTicket.getTicketCreate();

		// 处理成月份 2017-12
		if (notNull(timeStr)) {
			timeStr = timeStr.substring(0, 7);
			params.put("ticketTime", timeStr + "%");
		}
		if (notNull(ticketCreate)) {
			ticketCreate = ticketCreate.substring(0, 4) + ticketCreate.substring(5);
			params.put("ticketCreate", ticketCreate + "%");
		}
		String ticketPerson = paramTicket.getTicketPerson();
		if (notNull(ticketPerson)) {
			params.put("ticketPerson", ticketPerson);
		}
		String ticketItem = paramTicket.getTicketItem();
		if (notNull(ticketItem)) {
			params.put("ticketItem", ticketItem);
		}
		if (!roleId.equals("88888888")) {
			if (notNull(roleId)) {
				params.put("ticketCreateAdmin", ticketCreateAdmin);
			}
		}

		List<Map<String, Object>> list = tableTicketMapperCustom.QueryListByPage(params);
		DMTStatusFormatter.formatStatusList(list, "item", "itemCopy", "INCOICES_TYPE", paramManageMapper);

		return new DMTDataTableBean<Map<String, Object>>(pageUtil.getTotalCount(), list);
	}

	/*
	 * (非 Javadoc) <p>Title: expoartExcel</p> <p>Description:报销导出</p>
	 * 
	 * @author sizk
	 * 
	 * @date 2017年12月6日 下午2:46:25
	 * 
	 * @version V1.0
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @param paramTicket
	 * 
	 * @return
	 * 
	 * @see
	 * com.bjdreamtech.service.ITicketService#expoartExcel(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * com.bjdreamtech.entity.TbleTicket)
	 */
	@Override
	public Map<String, Object> expoartExcel(HttpServletRequest request, HttpServletResponse response) {
		initPageParameter(request);
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String realname = admin.getRealname();
		String roleId = admin.getRoleid();
		String timeStr = request.getParameter("ticketCreate");

		String ticketTime = request.getParameter("ticketTime");
		// 处理成月份 2017-12-06
		if (notNull(timeStr)) {

			timeStr = timeStr.substring(0, 4) + timeStr.substring(5);
			params.put("ticketCreate", timeStr + "%");

		}
		if (notNull(ticketTime)) {
			ticketTime = ticketTime.substring(0, 7);
			params.put("ticketTime", ticketTime + "%");

		}

		String ticketPerson = request.getParameter("ticketPerson");

		if (notNull(ticketPerson)) {
			params.put("ticketPerson", ticketPerson);
		} else {
			if (!roleId.equals("88888888")) {
				params.put("ticketPerson", realname);
			}

		}
		
		String ticketItem = request.getParameter("ticketItem");
		if(notNull(ticketItem)) {
			params.put("ticketItem", ticketItem);
		}
		
		try {
			String docsPath = request.getSession().getServletContext().getRealPath("docs");
			// SimpleDateFormat dsf = new SimpleDateFormat("yyyy-MM");
			// String newDateStr = dsf.format(new Date());
			String fileName = "";
			if (notNull(timeStr)) {
				if ((timeStr.substring(4)).equals("01")) {
					String yyyy = String.valueOf(Integer.parseInt(timeStr.substring(0, 4)) - 1);
					String MM = "12";
					fileName = "财务" + yyyy + "年" + MM + "月报销记录" + DMTDateUtil.parseDate() + ".xls";
				} else {
					String yyyy = timeStr.substring(0, 4);
					String MM = String.valueOf(Integer.parseInt(timeStr.substring(4)) - 1);
					if((Integer.parseInt(timeStr.substring(4)) - 1)<=9){
						fileName = "财务" + yyyy + "年" +"0"+ MM + "月报销记录" + DMTDateUtil.parseDate() + ".xls";
					}else{
						fileName = "财务" + yyyy + "年" + MM + "月报销记录" + DMTDateUtil.parseDate() + ".xls";
					}
					
				}

			} else {
				fileName = "财务" + "报销记录" + DMTDateUtil.parseDate() + ".xls";
			}
			String filePath = docsPath + FILE_SEPARATOR + fileName;
			OutputStream out = new FileOutputStream(filePath);
			List<Map<String, Object>> list = tableTicketMapperCustom.TickeQueryList(params);
			List<Map<String, Object>> list1 = tableTicketMapperCustom.TickeQuery(params);
			String[] headers = { "日期", "事项", "用途", "花费(元)", "出资人", "发票情况", "备注" };
			String[] headers1 = { "报销人", "花费(元)", "备注说明" };
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook();
			CellRangeAddress region = new CellRangeAddress(0, 0, 0, 6);
			CellRangeAddress region1 = new CellRangeAddress(2 + list.size() + 1, 2 + list.size() + 2, 3, 3);
			CellRangeAddress region2 = new CellRangeAddress(2 + list.size() + 1, 2 + list.size() + 2, 5, 5);
			HSSFSheet sheet = null;
			if (notNull(timeStr)) {
				if ((timeStr.substring(5)).equals("01")) {
					String yyyy = String.valueOf(Integer.parseInt(timeStr.substring(0, 4)) - 1);
					String MM = "12";
					sheet = workbook.createSheet(yyyy + "年" + MM + "月费用明细");
				} else {
					String yyyy = timeStr.substring(0, 4);
					String MM = String.valueOf(Integer.parseInt(timeStr.substring(4)) - 1);
					if((Integer.parseInt(timeStr.substring(4)) - 1)<=9){
						sheet = workbook.createSheet(yyyy + "年" +"0"+ MM + "月费用明细");
					}else{
						sheet = workbook.createSheet(yyyy + "年" + MM + "月费用明细");
					}
					
				}
			} else {
				sheet = workbook.createSheet("费用明细");
			}
			sheet.addMergedRegion(region);
			sheet.addMergedRegion(region1);
			sheet.addMergedRegion(region2);
			sheet.setDefaultColumnWidth((short) 15);
			// sheet.setDefaultRowHeight((short)500);
			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 生成一个字体
			HSSFFont font = workbook.createFont();
			font.setColor(HSSFColor.BLACK.index);
			font.setFontHeightInPoints((short) 15);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			// 把字体应用到当前的样式
			style.setFont(font);
			// 生成并设置另一个样式
			HSSFCellStyle style2 = workbook.createCellStyle();
			style2.setFillForegroundColor(HSSFColor.WHITE.index);
			style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 生成另一个字体
			HSSFFont font2 = workbook.createFont();
			font2.setColor(HSSFColor.BLACK.index);
			font2.setFontHeightInPoints((short) 12);
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

			// 把字体应用到当前的样式
			style2.setFont(font2);
			// 自动换行
			style2.setWrapText(true);
			// 生成并设置另一个样式
			HSSFCellStyle style3 = workbook.createCellStyle();
			style3.setFillForegroundColor(HSSFColor.WHITE.index);
			style3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);

			// 把字体应用到当前的样式
			style3.setFont(font2);

			HSSFCellStyle style4 = workbook.createCellStyle();
			style4.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			style4.setVerticalAlignment(style4.VERTICAL_CENTER);
			style4.setFont(font2);
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			cell.setCellStyle(style);
			cell.setCellValue(new HSSFRichTextString("说明：此表为费用明细表，按时间顺序逐笔记录，做备忘用"));

			// CellRangeAddress region=new CellRangeAddress(0, 0, 0, 6);
			// sheet.addMergedRegion(region);
			HSSFRow row1 = sheet.createRow(1);
			for (short i = 0; i < headers.length; i++) {
				cell = row1.createCell(i);
				HSSFRichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellStyle(style);
				cell.setCellValue(text);
			}

			if (list != null) {
				int index = 2;
				Double count = 0.00;
				for (Map<String, Object> m : list) {
					row = sheet.createRow(index);

					cell = row.createCell(0);
					cell.setCellStyle(style2);
					cell.setCellValue((String) m.get("time"));

					cell = row.createCell(1);
					cell.setCellStyle(style2);
					String item = (String) m.get("item");
					if(DMTRegexUtil.matches(item, DMTRegexUtil.NUMBER)) {
						item = getParamValueByCodeAndKey("INCOICES_TYPE",item);
					}
					cell.setCellValue(item);
					cell = row.createCell(2);
					cell.setCellStyle(style2);
					cell.setCellValue((String) m.get("use"));
					double money = (Double) m.get("pay");
					count = count + money;

					// 金额格式化处理
					DecimalFormat df = new DecimalFormat();
					df.applyPattern("##,###.00");
					String amt = "￥" + df.format(money);
					cell = row.createCell(3);
					cell.setCellStyle(style3);
					cell.setCellValue(amt);
					cell = row.createCell(4);
					cell.setCellStyle(style2);
					cell.setCellValue((String) m.get("person"));
					cell = row.createCell(5);
					cell.setCellStyle(style2);
					cell.setCellValue((String) m.get("type"));
					cell = row.createCell(6);
					cell.setCellStyle(style2);
					cell.setCellValue((String) m.get("remaker"));
					index++;
				}
				HSSFRow row2 = sheet.createRow(2 + list.size());
				HSSFCell cell2 = row2.createCell(2);
				cell2.setCellValue(new HSSFRichTextString("合计："));
				HSSFCell cell3 = row2.createCell(3);
				DecimalFormat dft = new DecimalFormat();
				dft.applyPattern("##,###.00");
				String Count = "￥" + dft.format(count);
				cell3.setCellStyle(style3);
				cell3.setCellValue(Count);

				HSSFRow row3 = sheet.createRow(2 + list.size() + 1);
				HSSFCell cell4 = row3.createCell(3);
				cell4.setCellStyle(style4);
				cell4.setCellValue(new HSSFRichTextString("初审签字："));
				// CellRangeAddress region1= new
				// CellRangeAddress(2+index,(short)2+index+1, 3, (short)3);
				// sheet.addMergedRegion(region1);
				HSSFCell cell5 = row3.createCell(5);
				cell5.setCellStyle(style4);
				cell5.setCellValue(new HSSFRichTextString("复核签字："));
			}
			HSSFSheet sheet1 = null;
			if (notNull(timeStr)) {
				if ((timeStr.substring(4)).equals("01")) {
					String yyyy = String.valueOf(Integer.parseInt(timeStr.substring(0, 4)) - 1);
					String MM = "12";
					sheet1 = workbook.createSheet(yyyy + "年" + MM + "月报销明细");
				} else {
					String yyyy = timeStr.substring(0, 4);
					String MM = String.valueOf(Integer.parseInt(timeStr.substring(4)) - 1);
					if((Integer.parseInt(timeStr.substring(4)) - 1)<=9){
						sheet1 = workbook.createSheet(yyyy + "年" +"0"+ MM + "月报销明细");
					}else{
						sheet1 = workbook.createSheet(yyyy + "年" + MM + "月报销明细");
					}
					
				}
			} else {
				sheet1 = workbook.createSheet("报销明细");

			}
			sheet1.setDefaultColumnWidth((short) 15);
			sheet1.setDefaultRowHeight((short) 500);
			HSSFRow row2 = sheet1.createRow(0);
			HSSFCell cell1 = row2.createCell(0);
			cell1.setCellValue(new HSSFRichTextString("说明：此表为报销明细表，按报销人记录，跟最终发票对应，供发报销及财务记账用"));
			HSSFRow row3 = sheet1.createRow(1);
			for (short i = 0; i < headers1.length; i++) {
				cell = row3.createCell(i);
				HSSFRichTextString text = new HSSFRichTextString(headers1[i]);
				cell.setCellStyle(style);
				cell.setCellValue(text);
			}
			if (list1 != null) {
				int index1 = 2;
				Double count = 0.00;
				for (Map<String, Object> m : list1) {
					row = sheet1.createRow(index1);
					cell = row.createCell(0);
					cell.setCellStyle(style2);
					cell.setCellValue((String) m.get("person"));
					cell = row.createCell(1);
					double money = (Double) m.get("pay");
					count = count + money;
					cell.setCellStyle(style3);
					DecimalFormat dft = new DecimalFormat();
					dft.applyPattern("##,###.00");
					String Money = dft.format(money);
					cell.setCellValue(Money);
					cell = row.createCell(2);
					cell.setCellStyle(style2);
					cell.setCellValue("");
					index1++;
				}
				HSSFRow row4 = sheet1.createRow(2 + index1 - 2);
				HSSFCell cell5 = row4.createCell(0);
				cell5.setCellStyle(style2);
				cell5.setCellValue(new HSSFRichTextString("合计金额："));

				HSSFCell cell6 = row4.createCell(1);
				DecimalFormat dft = new DecimalFormat();
				dft.applyPattern("##,###.00");
				String Count = dft.format(count);
				cell6.setCellValue(Count);
				cell6.setCellStyle(style3);
				HSSFCell cell9 = row4.createCell(2);
				cell9.setCellStyle(style2);
				cell9.setCellValue("");
				HSSFRow row5 = sheet1.createRow(2 + index1);
				HSSFCell cell7 = row5.createCell(0);
				cell7.setCellStyle(style4);
				cell7.setCellValue(new HSSFRichTextString("初审签字："));
				HSSFCell cell8 = row5.createCell(2);
				cell8.setCellStyle(style4);
				cell8.setCellValue(new HSSFRichTextString("复核签字："));
			}

			workbook.write(out);
			out.close();
			download(filePath, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> expoartExcelAccount(HttpServletRequest request, HttpServletResponse response) {
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String realname = admin.getRealname();
		String roleId = admin.getRoleid();
		String timeStr = request.getParameter("ticketCreate");
		String ticketTime = request.getParameter("ticketTime");
		// 处理成月份 2017-12-06
		if (notNull(timeStr)) {
			timeStr = timeStr.substring(0, 4) + timeStr.substring(5);
			params.put("ticketCreate", timeStr + "%");

		}
		if (notNull(ticketTime)) {
			ticketTime = ticketTime.substring(0, 7);
			params.put("ticketTime", ticketTime + "%");

		}

		String ticketPerson = request.getParameter("ticketPerson");

		if (notNull(ticketPerson)) {
			params.put("ticketPerson", ticketPerson);
		} else {
			if (!roleId.equals("88888888")) {
				params.put("ticketPerson", realname);
			}

		}
		String ticketItem = request.getParameter("ticketItem");
		if(notNull(ticketItem)) {
			params.put("ticketItem", ticketItem);
		}
		try {
			String docsPath = request.getSession().getServletContext().getRealPath("docs");
			String fileName = "";
			if (notNull(timeStr)) {
				if ((timeStr.substring(4)).equals("01")) {
					String yyyy = String.valueOf(Integer.parseInt(timeStr.substring(0, 4)) - 1);
					String MM = "12";
					fileName = yyyy + "年" + MM + "月份招行代发报销文件" + ".xlsx";
				} else {
					String yyyy = timeStr.substring(0, 4);
					String MM = String.valueOf(Integer.parseInt(timeStr.substring(4)) - 1);
					if((Integer.parseInt(timeStr.substring(4)) - 1)<=9){
						fileName = yyyy + "年" +"0"+MM + "月份招行代发报销文件" + ".xlsx";
					}else{
						fileName = yyyy + "年" + MM + "月份招行代发报销文件" + ".xlsx";
					}
					
				}
			} else {
				fileName = "招行代发报销文件" + ".xlsx";
			}
			String filePath = docsPath + FILE_SEPARATOR + fileName;
			OutputStream out = new FileOutputStream(filePath);
			List<Map<String, Object>> list = tableTicketMapperCustom.TickeBankAccountQuery(params);
			String[] headers = { "账户", "姓名", "金额", "开户行", "开户地", "注释" };
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet();
			sheet.setDefaultColumnWidth((short) 20);
			// sheet.autoSizeColumn(1);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.WHITE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 生成另一个字体
			XSSFFont font = workbook.createFont();
			font.setFontName("宋体");
			font.setColor(HSSFColor.BLACK.index);
			font.setFontHeightInPoints((short) 11);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			style.setFont(font);
			XSSFRow row = sheet.createRow(5);
			for (short i = 0; i < headers.length; i++) {
				XSSFCell cell = row.createCell(i);
				XSSFRichTextString text = new XSSFRichTextString(headers[i]);
				cell.setCellStyle(style);
				cell.setCellValue(text);
			}
			if (list != null) {
				int index1 = 6;
				Double count = 0.00;
				for (Map<String, Object> m : list) {
					row = sheet.createRow(index1);
					XSSFCell cell = row.createCell(0);
					cell.setCellStyle(style);
					cell.setCellValue((String) m.get("account"));
					cell = row.createCell(1);
					cell.setCellStyle(style);
					cell.setCellValue((String) m.get("person"));
					cell = row.createCell(2);
					double money = (Double) m.get("pay");
					count = count + money;
					cell.setCellStyle(style);
					DecimalFormat dft = new DecimalFormat();
					dft.applyPattern("##,###.00");
					String Money = dft.format(money);
					cell.setCellValue(Money);
					cell = row.createCell(3);
					cell.setCellStyle(style);
					cell.setCellValue("招商银行");
					cell = row.createCell(4);
					cell.setCellStyle(style);
					cell.setCellValue("");
					cell = row.createCell(5);
					cell.setCellStyle(style);
					if (notNull(timeStr)) {
						if ((timeStr.substring(4)).equals("01")) {
							String MM = "12";
							cell.setCellValue(MM + "月份报销");
						} else {
							String MM = String.valueOf(Integer.parseInt(timeStr.substring(4)) - 1);
							if((Integer.parseInt(timeStr.substring(4)) - 1)<=9){
								cell.setCellValue("0"+MM + "月份报销");
							}else{
								cell.setCellValue(MM + "月份报销");
							}
							
						}

					} else {
						cell.setCellValue("");
					}
					index1++;
				}

			}
			workbook.write(out);
			out.close();
			download(filePath, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}

	/*
	 * (非 Javadoc) <p>Title: downTicketTemp</p> <p>Description: 下载报销模板</p>
	 * 
	 * @author sizk
	 * 
	 * @date 2017年12月6日 下午4:19:24
	 * 
	 * @version V1.0
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @return
	 * 
	 * @see
	 * com.bjdreamtech.service.ITicketService#downTicketTemp(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public DMTResultBean downTicketTemp(HttpServletRequest request, HttpServletResponse response) {

		String docsPath = request.getSession().getServletContext().getRealPath("docs");
		String fileName = "财务2017年10月报销记录（胡楠）.xlsx";
		String filePath = docsPath + FILE_SEPARATOR + "temp" + FILE_SEPARATOR + fileName;
		download(filePath, response);
		return null;
	}

	/*
	 * (非 Javadoc) <p>Title: batchSaveTicke</p> <p>Description: 批量报销保存</p>
	 * 
	 * @author sizk
	 * 
	 * @date 2017年12月6日 下午5:43:32
	 * 
	 * @version V1.0
	 * 
	 * @param request
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.bjdreamtech.service.ITicketService#batchSaveTicke(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	public DMTResultBean batchSaveTicke(HttpServletRequest request) throws Exception {
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String ticketCreateAdmin = admin.getAdminid();
		// 报销开始时间
		String ticketMonth = (String) request.getParameter("ticketMonth");
		String ticketPerson = (String) request.getParameter("ticketPerson");
		// System.out.println(ticketPerson);
		String fileName = (String) request.getParameter("fileName");
		if (isNull(ticketMonth)) {
			return new DMTResultBean("1", "报销时间不能为空", "报销时间不能为空");
		}else{
			ticketMonth = ticketMonth.substring(0, 7);
		}
		if (isNull(ticketPerson)) {
			return new DMTResultBean("1", "报销申请人不能为空", "报销申请人不能为空");
		}
		if (isNull(fileName)) {
			return new DMTResultBean("1", "报销文件不能为空", "报销文件不能为空");
		}
		
		// 根据用户 报销月份查询时间查询是否已经存在。
		// TableTicketExample example = new TableTicketExample();
		// example.createCriteria().andTicketCreateAdminEqualTo(ticketCreateAdmin).andTicketMonthEqualTo(ticketMonth);
		// List<TableTicket> dbList =
		// tableTicketMapper.selectByExample(example);
		// if (null != dbList && dbList.size() > 0) {
		// // 进行删除
		// for (TableTicket ttket : dbList) {
		// tableTicketMapper.deleteByPrimaryKey(ttket.getTicketId());
		// }
		// }
		// 读取Excel入库
		fileName = DMTConfigUtil.CONFIGL_TICKET_PERSONAL + File.separator + fileName;
		ReadExcelUtils excelReader = new ReadExcelUtils(fileName);
		// 读取Excel表格内容
		int startLine = 2;
		Map<Integer, Map<Integer, Object>> map = excelReader.read2007ExcelContent(startLine);
		int lenth = map.size();
		List<TableTicket> ticketList = new ArrayList<TableTicket>();
		Map<String, Object> errMap = new HashMap<String, Object>();
		boolean bol = true;
		int errline = 0;
		for (int i = startLine; i < lenth - 1; i++) {
			errline = i;
			Map<Integer, Object> rtMap = map.get(i);
			String ticketTime = (String) rtMap.get(0);
			String item = (String) rtMap.get(1);
			String use = (String) rtMap.get(2);
			String tpay = (String) rtMap.get(3);
			String person = (String) rtMap.get(4);
			if (!person.equals(ticketPerson)) {
				return new DMTResultBean("1", "出资人与创建人不相同", "出资人与创建人不相同");
			}
			String type = (String) rtMap.get(5);
			StringBuffer strsb = new StringBuffer();
			// strsb.append(id);
			strsb.append(ticketTime);
			strsb.append(item);
			strsb.append(use);
			strsb.append(tpay);
			strsb.append(person);
			strsb.append(type);
			if (isNull(strsb.toString())) {
				break;
			}
			if (isNull(ticketTime)) {
				bol = false;
				errMap.put("msg", "excel文件中第" + errline + "行的报销日期不能为空");
				break;
			}
			// Double d = Double.parseDouble(time);
			// java.text.DecimalFormat df = new
			// java.text.DecimalFormat("00");//""00.00"小数点后面的0的个数表示小数点的个数
			// String b = df.format(d);

			if (isNull(item)) {
				bol = false;
				errMap.put("msg", "excel文件中第" + errline + "行的报销事项不能为空");
				break;
			}

			if (isNull(use)) {
				bol = false;
				errMap.put("msg", "excel文件中第" + errline + "行的报销用途不能为空");
				break;
			}

			if (isNull(tpay)) {
				bol = false;
				errMap.put("msg", "excel文件中第" + errline + "行的报销金额不能为空");
				break;
			}

			if (isNull(person)) {
				bol = false;
				errMap.put("msg", "excel文件中第" + errline + "行的报销出资人不能为空");
				break;
			}

			if (isNull(type)) {
				bol = false;
				errMap.put("msg", "excel文件中第" + errline + "行的报销发票不能为空");
				break;
			}
			TableTicket ttcket = new TableTicket();
			String ticketCreate = DMTDateUtil.parseDate();
			ttcket.setTicketCreate(ticketCreate);
			ttcket.setTicketCreateAdmin(ticketCreateAdmin);
			String id = DMTPrimaryKeyUtil.getPrimaryKey("");
			ttcket.setTicketId(id);
			ttcket.setTicketItem(item);
			ttcket.setTicketMonth(ticketMonth);
			BigDecimal pay = new BigDecimal(tpay);
			double tipay = pay.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			ttcket.setTicketPay(tipay);
			ttcket.setTicketPerson(person);
			ttcket.setTicketRemaker(rtMap.get(6) == null ? "" : (String) rtMap.get(6));
			ttcket.setTicketTime(DMTDateUtil.packDateShort(ticketTime));
			ttcket.setTicketType(type);
			ttcket.setTicketUse(use);
			ticketList.add(ttcket);
		}
		// 返回结果
		if (bol) {
			// 批量入库
			int ix = tableTicketMapperCustom.batchSaveTicke(ticketList);
			return new DMTResultBean("0", "导入成功", "导入成功");
		} else {
			return new DMTResultBean("1", (String) errMap.get("msg"), errMap.get("msg"));

		}

	}

	@Override
	public DMTResultBean getTicketInfo(HttpServletRequest request) {
		String ticketid = (request.getParameter("ticketId"));
		TableTicket tickte = tableTicketMapper.selectByPrimaryKey(ticketid);
		if (tickte == null) {
			return new DMTResultBean("1", "该报销已不存在", "");
		}
		return new DMTResultBean("0", "", tickte);
	}

	public boolean validateEditTicket(String ticketTime, String ticketItem, String ticketUse, String ticketPay,
			String ticketPerson, String ticketType) {
		if (isNull(ticketTime) || isNull(ticketItem) || isNull(ticketUse) || isNull(ticketPay) || isNull(ticketPerson)
				|| isNull(ticketType)) {
			return false;
		}
		return true;
	}

	@Override
	public DMTResultBean editTicket(HttpServletRequest request) {
		DMTSessionBean ticketinfo = getSessionBean(request);
		String id = (request.getParameter("ticketId"));

		String ticketTime = request.getParameter("ticketTime");

		String ticketItem = request.getParameter("ticketItem");
		String ticketUse = request.getParameter("ticketUse");
		String ticketPay = request.getParameter("ticketPay");
		String ticketPerson = request.getParameter("ticketPerson");
		String ticketType = request.getParameter("ticketType");
		String ticketRemaker = request.getParameter("ticketRemaker");
		if (!validateEditTicket(ticketTime, ticketItem, ticketUse, ticketPay, ticketPerson, ticketType)) {
			return new DMTResultBean("1", "数据校验失败", "");
		}
		TableTicket ticket = tableTicketMapper.selectByPrimaryKey(id);
		ticket.setTicketTime(ticketTime);
		ticket.setTicketItem(ticketItem);
		ticket.setTicketUse(ticketUse);
		ticket.setTicketPay((new BigDecimal(ticketPay)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		ticket.setTicketPerson(ticketPerson);
		ticket.setTicketType(ticketType);
		ticket.setTicketRemaker(ticketRemaker);
		tableTicketMapper.updateByPrimaryKeySelective(ticket);
		log.logging("修改报销信息", this.getClass(), ticketinfo.getUsername(), ticketinfo.getIp());
		return new DMTResultBean();
	}

	/**
	 * 统计报销条数，计算总金额
	 */
	@Override
	public DMTResultBean queryCountAndMoney(HttpServletRequest request) {
		DMTSessionBean admin = (DMTSessionBean) request.getSession().getAttribute("sessionBean");
		String roleId = admin.getRoleid();
		String ticketCreateAdmin = admin.getAdminid();
		String ticketTime = request.getParameter("ticketTime");
		String ticketCreate = request.getParameter("ticketCreate");
		String ticketPerson = request.getParameter("ticketPerson");
		String ticketItem = request.getParameter("ticketItem");
		if (notNull(ticketTime)) {
			ticketTime = ticketTime.substring(0, 7);
			params.put("ticketTime", ticketTime + "%");
		}
		if (notNull(ticketCreate)) {
			ticketCreate = ticketCreate.substring(0, 4) + ticketCreate.substring(5);
			params.put("ticketCreate", ticketCreate + "%");
		}
		if (notNull(ticketPerson)) {
			params.put("ticketPerson", ticketPerson);
		}
		if (notNull(ticketItem)) {
			params.put("ticketItem", ticketItem);
		}
		if (!roleId.equals("88888888")) {
			if (notNull(roleId)) {
				params.put("ticketCreateAdmin", ticketCreateAdmin);
			}
		}
		List<Map<String, Object>> list = tableTicketMapperCustom.queryCountAndMoney(params);
		return new DMTResultBean("0", "", list);
	}
	
	/**
	 * 根据参数代码和参数key获取参数值
	 * @param code 参数代码
	 * @param key 参数key
	 * @return
	 */
	private String getParamValueByCodeAndKey(String code,String key) {
		String value = "";
		SysParamExample example = new SysParamExample();
		example.createCriteria().andParamCodeEqualTo(code).andParamKeyEqualTo(key);
		List<SysParam> params = paramMapper.selectByExample(example);
		if(params!=null && params.size()>0) {
			value = params.get(0).getParamValue();
		}
		return value;
	}

}
