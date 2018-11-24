package com.bjdreamtech.util.excel;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
* @Title: ReadExcelUtils.java 
* @Description: 
* @author sizk
* @date 2017年11月30日 下午2:43:33 
* @version V1.0  
* 
*/
public class ReadExcelUtils {
	private Logger logger = LoggerFactory.getLogger(ReadExcelUtils.class);  
    private Workbook wb;  
    private Sheet sheet;  
    private Row row;  
    private  XSSFWorkbook xwb  ;//2007的
  
    public ReadExcelUtils(String filepath) {  
        if(filepath==null){  
            return;  
        }  
        String str ="E:\\201710.xls";
    	if(null != filepath && !"".equals(filepath)){
    		str =filepath;
    	}
        String ext = filepath.substring(filepath.lastIndexOf("."));  
        try {  
        	
            InputStream is = new FileInputStream(str);  
            if(".xls".equals(ext)){  
                wb = new HSSFWorkbook(is);  
            }else if(".xlsx".equals(ext)){  
            	 try {
					wb = WorkbookFactory.create(is);
				} catch (EncryptedDocumentException e) {
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				}
            }else{  
                wb=null;  
            }  
        } catch (FileNotFoundException e) {  
            logger.error("FileNotFoundException", e);  
        } catch (IOException e) {  
            logger.error("IOException", e);  
        }  
    }  
      
    /** 
     * 读取Excel表格表头的内容 
     *  
     * @param InputStream 
     * @return String 表头内容的数组 
     */  
    public String[] readExcelTitle() throws Exception{  
        if(wb==null){  
            throw new Exception("Workbook对象为空！");  
        }  
        sheet = wb.getSheetAt(0);  
        row = sheet.getRow(0);  
        // 标题总列数  
        int colNum = row.getPhysicalNumberOfCells();  
        System.out.println("colNum:" + colNum);  
        String[] title = new String[colNum];  
        for (int i = 0; i < colNum; i++) {  
            // title[i] = getStringCellValue(row.getCell((short) i));  
            title[i] = row.getCell(i).getCellFormula();  
        }  
        return title;  
    }  
  
    /** 
     * 读取Excel数据内容 
     *  
     * @param InputStream 
     * @return Map 包含单元格数据内容的Map对象 
     */  
    public Map<Integer, Map<Integer,Object>> readExcelContent() throws Exception{  
        if(wb==null ){  
            throw new Exception("Workbook对象为空！");  
        }  
        Map<Integer, Map<Integer,Object>> content = new HashMap<Integer, Map<Integer,Object>>();
        sheet = wb.getSheetAt(0);  
        // 得到总行数  
        int rowNum = sheet.getLastRowNum();  
        row = sheet.getRow(0);  
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第8行开始,第一行为表头的标题  
        for (int i = 8; i <= rowNum; i++) {  
            row = sheet.getRow(i);
            if(row == null){
            	continue;
            }
            int j = 0;
            Object cellFormatValue = getCellFormatValue(row.getCell(j));
            if("合计".equals(cellFormatValue)){
            	break;
            }
            Map<Integer,Object> cellValue = new HashMap<Integer, Object>();
            while (j < colNum) { 
                Object obj = getCellFormatValue(row.getCell(j));
                cellValue.put(j, obj);  
                j++;  
            }  
            content.put(i, cellValue);  
        }
        return content;  
    }  
  
    /** 
     *  
     * 根据Cell类型设置数据 
     *  
     * @param cell 
     * @return 
     */  
    private Object getCellFormatValue(Cell cell) {  
        Object cellvalue = "";  
        if (cell != null) {  
            // 判断当前Cell的Type  
            switch (cell.getCellType()) {  
            case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC  
            case Cell.CELL_TYPE_FORMULA: {  
                // 判断当前的cell是否为Date  
                if (DateUtil.isCellDateFormatted(cell)) {  
                    // 如果是Date类型则，转化为Data格式  
                    // data格式是带时分秒的：2013-7-10 0:00:00  
                    // cellvalue = cell.getDateCellValue().toLocaleString();  
                    // data格式是不带带时分秒的：2013-7-10  
                    Date date = cell.getDateCellValue();  
                    cellvalue = date;  
                } else {// 如果是纯数字  
                	
                    // 取得当前Cell的数值  
                    cellvalue = String.valueOf(cell.getNumericCellValue());  
                	//如果是纯数字，去除科学计数法或double类型
//                	DecimalFormat df = new DecimalFormat("0");
//                	cellvalue = df.format(cell.getNumericCellValue());
                }  
                break;  
            }  
            case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING  
                // 取得当前的Cell字符串  
                cellvalue = cell.getRichStringCellValue().getString();  
                break;  
            default:// 默认的Cell值  
                cellvalue = "";  
            }  
        } else {  
            cellvalue = "";  
        }  
        return cellvalue;  
    }  
  
    public static void main(String[] args) {  
        try {  
            String filepath = "‪E:\\201710.xls";  
          ReadExcelUtils excelReader = new ReadExcelUtils(filepath);  
        
            // 对读取Excel表格内容测试  
            Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();  
            System.out.println("获得Excel表格的内容:");  
            for (int i = 1; i <= map.size(); i++) {  
                System.out.println(map.get(i));  
            } 
        } catch (Exception e) {  
            System.out.println("未找到指定路径的文件!");  
            e.printStackTrace();  
        }
    }

    /**
     * 
    * @Title: read2007ExcelContent 
    * @Description: 读取2007Excel表格
    * @param @param startLine
    * @param @return    
    * @return Map<Integer,Map<Integer,Object>>   
    * @author sizk  
    * @date 2017年12月6日 下午6:24:58 
    * @version V1.0   
    * @throws
     */
	public Map<Integer, Map<Integer, Object>> read2007ExcelContent(int startLine) throws Exception{  
		  
        if( wb == null){  
            throw new Exception("Workbook对象为空！");  
        }  
        Map<Integer, Map<Integer,Object>> content = new HashMap<Integer, Map<Integer,Object>>();  
          
        sheet = wb.getSheetAt(0);  
        // 得到总行数  
        int rowNum = sheet.getLastRowNum();  
        row = sheet.getRow(0);  
        int colNum = row.getPhysicalNumberOfCells();  
        // 正文内容应该从第8行开始,第一行为表头的标题  
        for (int i = startLine; i <= rowNum; i++) {  
            row = sheet.getRow(i); 
            if(null == row){
            	System.out.println("22445");
            	break;
            }
            int j = 0;  
            Map<Integer,Object> cellValue = new HashMap<Integer, Object>();  
            while (j < colNum) {  
                Object obj = getCellFormatValue(row.getCell(j));  
                cellValue.put(j, obj);  
                j++;  
            }  
            content.put(i, cellValue);  
        }  
        return content;  
    
	}  
}

