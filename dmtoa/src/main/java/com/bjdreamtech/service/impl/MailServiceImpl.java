package com.bjdreamtech.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjdreamtech.dmt.bean.DMTDataTableBean;
import com.bjdreamtech.dmt.format.DMTTimeFormatter;
import com.bjdreamtech.dmt.util.DMT3DESUtil;
import com.bjdreamtech.dmt.util.DMTConfigUtil;
import com.bjdreamtech.dmt.util.DMTDateUtil;
import com.bjdreamtech.dmt.util.DMTMoneyUtil;
import com.bjdreamtech.dmt.util.DMTPrimaryKeyUtil;
import com.bjdreamtech.entity.SysAdmin;
import com.bjdreamtech.entity.SysAdminExample;
import com.bjdreamtech.entity.TableSalary;
import com.bjdreamtech.entity.TableSalaryExample;
import com.bjdreamtech.mapper.auto.SysAdminMapper;
import com.bjdreamtech.mapper.auto.TableSalaryMapper;
import com.bjdreamtech.mapper.custom.ITableSalaryDao;
import com.bjdreamtech.service.IMailService;
import com.bjdreamtech.util.DMTResultBean;
import com.bjdreamtech.util.excel.ReadExcelUtils;
import com.bjdreamtech.util.mail.EmailUtil;
import com.mysql.fabric.xmlrpc.base.Array;


/**   
* @Title: MailServiceImpl.java 
* @Description: 接口实现类
* @author sizk
* @date 2017年11月29日 下午7:00:02 
* @version V1.0  
* 
*/
/**   
* @Title: MailServiceImpl.java 
* @Description: 接口实现类
* @author sizk
* @date 2017年11月29日 下午7:00:02 
* @version V1.0  
* 
*/
@Service
public class MailServiceImpl extends BaseServiceImpl implements IMailService {
	@Autowired
	private ITableSalaryDao tableSalaryDao;
	@Resource
	private SysAdminMapper adminMapper;
	@Resource
	private TableSalaryMapper tableSalaryMapperAuto;
		

	

	
	public Map<String,Object> sendHtmlSalaryMail(List<TableSalary> list ){
		 Map<String,Object> returnMap = new HashMap<String, Object>();
			
			try {
				for (TableSalary salary :list) {
					String email=salary.getSalaryMail();
					email = DMT3DESUtil.decryptMode(email);
					//工资所属月份 201710
					String salarayPayrollPeriodMonth =salary.getSalarayPayrollPeriodMonth();
					//邮件主题
					String subject = salarayPayrollPeriodMonth.substring(0,4)+"年"+salarayPayrollPeriodMonth.substring(5,7)+"月工资条-【工资邮件】";
					//工资发放日期
					String salaraySendTime = salary.getSalaraySendTime();
					//制表时间
					String salarayTableTime = salary.getSalarayTableTime();
					
					//邮件内容
					StringBuffer sb = new StringBuffer();
					sb.append(salary.getSalaryStaffName());
					sb.append(": 你好 <br/>");
					
					sb.append("以下是你"+salarayPayrollPeriodMonth.substring(5,7)+"月工资条，请查收。<br>");
					
					sb.append("单 位：  北京追梦科技有限公司<br>");
					sb.append("工资所属期： "+salarayPayrollPeriodMonth.substring(0,4)+"年"+salarayPayrollPeriodMonth.substring(5,7)+"月<br>");
					sb.append("工资发放期："+salaraySendTime.substring(0,4)+"年"+salaraySendTime.substring(5,7)+"月<br>");
					sb.append("制表日期：       "+salarayTableTime.substring(0,4)+"年"+salarayTableTime.substring(5,7)+"月<br>");
					
					sb.append("<table border=\"1px\" style=\"border-collapse:collapse;margin:0px;padding:0px;width:1840px;\">");
					sb.append("<tr> <td rowspan=\"2\">员工类型</td> ");
					sb.append("<td rowspan=\"2\">员工编号</td> ");
					sb.append("<td rowspan=\"2\">姓名</td> ");
					sb.append("<td rowspan=\"2\">身份证号</td> ");
					sb.append("<td colspan=\"4\" >考勤天数</td> ");
					sb.append("<td >基本工资</td> ");
					sb.append("<td >绩效工资</td> ");
					sb.append("<td >工资总额</td> ");
					sb.append("<td >应发工资</td> ");
					sb.append("<td >其他增发</td> ");
					sb.append("<td >病假扣款</td> ");
					sb.append("<td >事假扣款</td> ");
					sb.append("<td >其他扣款</td> ");
					sb.append("<td >扣减合计</td> ");
					sb.append("<td >收入总额</td> ");
					sb.append("<td >社保基数</td> ");
					sb.append("<td >公积金基数</td> ");
					sb.append("<td >养老保险</td> ");
					sb.append("<td >失业保险</td> ");
					sb.append("<td >基本医疗</td> ");
					sb.append("<td >住房公积金</td> ");
					sb.append("<td >减发合计</td> ");
					sb.append("<td >纳税所得</td> ");
					sb.append("<td >应扣税金</td> ");
					sb.append("<td >实发工资</td> </tr> ");
					sb.append("<tr> <td >月标准天数</td> ");
					sb.append("<td >正式工天数</td> ");
					sb.append("<td >试用工天数</td> ");
					sb.append("<td >出勤天数</td> ");
					sb.append("<td >1</td> 	 <td >2</td> ");
					sb.append("<td >3=2+1</td> ");
					sb.append("<td >4=正式工资/试用期工资</td> ");
					sb.append("<td >5</td>  <td >6</td> ");
					sb.append("<td >7</td>  <td >8</td> ");
					sb.append("<td >9=6+7+8</td> ");
					sb.append("<td >10=4+5-9</td> ");
					sb.append("<td >11</td>  <td >12</td>  <td >13</td> ");
					sb.append("<td >14</td>  <td >15</td>  <td >16</td> ");
					sb.append("<td >17=13+14+15+16</td> ");
					sb.append("<td >18=10-17</td> ");
					sb.append("<td >19</td>  <td >20=18-19</td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					
					sb.append("<td> ");
					sb.append(salary.getSalaryType());
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(salary.getSalaryStaffNo());
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(salary.getSalaryStaffName());
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(salary.getSalaryStaffCarno());
					sb.append("</td>");
					
					

					sb.append("<td> ");
					sb.append(salary.getSalaryCheckStandardDay());
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(salary.getSalaryFormalDay());
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(salary.getSalaryUseDay());
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(salary.getSalaryYcqtsDay());
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalaryBasePay())));
					sb.append("</td>");
					
					

					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalaryMeritPay())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalaryAccount())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalaryPaid())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalaryOtherAdd())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarySickPay())));
					sb.append("</td>");
					
					

					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalaryAbsPay())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalaryOtherPay())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarySumPay())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarySumAccount())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarySecurityBase())));
					sb.append("</td>");
					
					

					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalaryFundBase())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarayInsurance())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarayUnemployment())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarayMedicalBase())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarayHousingFund())));
					sb.append("</td>");
					
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarayReductionSum())));
					sb.append("</td>");
					
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarayTax())));
					sb.append("</td>");
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarayTaxPay())));
					sb.append("</td>");
					
					sb.append("<td> ");
					sb.append(DMTMoneyUtil.moneyFormat(Double.toString(salary.getSalarayPayroll())));
					sb.append("</td>");
					
					
					
					sb.append("</tr> ");
					sb.append("</table> ");
					sb.append("如有问题，随时沟通。 <br> 致礼~！<br> ");
					sb.append("hr@bjdreamtech.com <br>");
					sb.append("综合部 <br>");
					sb.append("北京追梦科技有限公司<br>");
					sb.append("金融科技创新解决方案提供商<br>");
					sb.append("公司地址：北京市海淀区西三环北路50号院6号楼豪柏大厦11层1101<br>");
					sb.append("公司官网：www.bjdreamtech.com  <br>");
					sb.append("免责声明：本邮件仅发给指定人员，邮件内容可能涉及保密信息，如果误发贵处请邮件通知发件人并删除此邮件，任何形式的复制、转发或散布本邮件及其内容均属违法行为。<br> ");
					sb.append("This email should be sent only to designated receipient(s). The email content may involve confidential information. <br>");
					sb.append("If you are not an intended recipient, please kindly notify the sender to delete the email. It is illegal to reproduce, forward or distribute this email and its content in any form or by any means. <br>");
					EmailUtil.sendMail(email,sb.toString(),subject);
					break;
				}
				
			} catch (MessagingException | GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return returnMap;
	}


	/*
	 * (非 Javadoc) 
	* <p>Title: batchSaveSalary</p> 
	* <p>Description: 批量保存工资条</p> 
	* @author sizk
	* @date 2017年12月6日 下午10:00:07 
	* @version V1.0   
	* @param request
	* @return
	* @throws Exception 
	* @see com.bjdreamtech.service.IMailService#batchSaveSalary(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public DMTResultBean batchSaveSalary(HttpServletRequest request)
			throws Exception {
		DMTResultBean resultBean = new DMTResultBean("1","","");
		String salarayPayrollPeriodMonth = (String)request.getParameter("salarayPayrollPeriodMonth");
		String salaraySendTime = (String)request.getParameter("salaraySendTime");
		String tableDate = (String)request.getParameter("tableDate");
		String fileName = (String)request.getParameter("fileName");
		
		if(isNull(fileName)){
			return new DMTResultBean("1","文件不能为空","文件不能为空");
		}
		
		if(isNull(salarayPayrollPeriodMonth)){
			return new DMTResultBean("1","工资所属月份不能为空","工资所属月份不能为空");
		}
		
		if(isNull(salaraySendTime)){
			return new DMTResultBean("1","工资发放日期不能为空","工资发放日期不能为空");
		}
		
		if(isNull(tableDate)){
			return new DMTResultBean("1","制表日期不能为空","制表日期不能为空");
		}
		//根据工资所在月份查询 如果存在。直接删除
		TableSalaryExample selectExample = new TableSalaryExample();
		selectExample.createCriteria().andSalarayPayrollPeriodMonthEqualTo(salarayPayrollPeriodMonth.substring(0,7));
		List<TableSalary> deleteList = tableSalaryMapperAuto.selectByExample(selectExample);
		if(null!= deleteList && deleteList.size()>0){
			tableSalaryMapperAuto.deleteByExample(selectExample);
		}
		//读取Excel入库
		fileName=DMTConfigUtil.CONFIG_SALARY+File.separator+fileName;
		String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1); 	 
		if (fileExtName.toLowerCase().equals("xls") ||fileExtName.toLowerCase().equals("xlsx")) {
			  ReadExcelUtils excelReader = new ReadExcelUtils(fileName);  
			    try {  
		            // 对读取Excel表格内容测试  
		            Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent(); 
		            List<TableSalary> list = new ArrayList<TableSalary>();
		            List<TableSalary> updateList= new ArrayList<TableSalary>();
		            int lenth = map.size();
		            String ids = "";
		            for (int i = 10; i < lenth+8; i++) { 
		            	String id = DMTPrimaryKeyUtil.getPrimaryKey("");
		            	if(i==lenth+8-1){
		            		ids=ids+id;
		            	}else{
		            		ids=ids+id+",";
		            	}
		            	//TODO 这里需要优化
		            	 TableSalary tbl = new TableSalary();
		                Map<Integer,Object> rtMap = map.get(i);
		                tbl.setSalaryId(id);
		                String type = (String)rtMap.get(0);
		                tbl.setSalaryType(type);
		                String no =( String)rtMap.get(1);
		                tbl.setSalaryStaffNo(no);
		                String staffName =((String)rtMap.get(2)).replace(" ","");
		                tbl.setSalaryStaffName(staffName);
		                tbl.setSalaryStaffCarno((String)rtMap.get(3));
		                tbl.setSalaryBankAccount((String)rtMap.get(4));
		               // System.out.println(rtMap.get(5));
		                tbl.setSalaryCheckStandardDay(Double.valueOf((String)rtMap.get(5)));
		                tbl.setSalaryFormalDay(Double.valueOf((String)rtMap.get(6)));
		                tbl.setSalaryUseDay(Double.valueOf((String)rtMap.get(7)));
		                tbl.setSalaryYcqtsDay(Double.valueOf((String)rtMap.get(8)));
		                BigDecimal salaryBasePay = new BigDecimal((String)rtMap.get(9));  
		                double sbp = salaryBasePay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
		                tbl.setSalaryBasePay(sbp);
		                BigDecimal salaryMeritPay = new BigDecimal((String)rtMap.get(10));  
		                double smp = salaryMeritPay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalaryMeritPay(smp);
		                BigDecimal salaryAccount = new BigDecimal((String)rtMap.get(11));  
		                double sa = salaryAccount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalaryAccount(sa);
		                BigDecimal salaryPaid = new BigDecimal((String)rtMap.get(12));  
		                double sp = salaryPaid.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalaryPaid(sp);
		                BigDecimal salaryOtherAdd = new BigDecimal((String)rtMap.get(13));  
		                double soa = salaryOtherAdd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalaryOtherAdd(soa);
		                BigDecimal salarySickPay = new BigDecimal((String)rtMap.get(14));  
		                double ssp = salarySickPay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarySickPay(ssp);
		                BigDecimal salaryAbsPay = new BigDecimal((String)rtMap.get(15));  
		                double sap = salaryAbsPay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalaryAbsPay(sap);
		                BigDecimal salaryOtherPay = new BigDecimal((String)rtMap.get(16));  
		                double sop = salaryOtherPay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalaryOtherPay(sop);
		                BigDecimal salarySumPay = new BigDecimal((String)rtMap.get(17));  
		                double sspa = salarySumPay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarySumPay(sspa);
		                BigDecimal salarySumAccount = new BigDecimal((String)rtMap.get(18));  
		                double ssa = salarySumAccount.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarySumAccount(ssa);
		                BigDecimal salarySecurityBase = new BigDecimal((String)rtMap.get(19));  
		                double ssb = salarySecurityBase.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarySecurityBase(ssb);
		                BigDecimal salaryFundBase = new BigDecimal((String)rtMap.get(20));  
		                double sfb = salaryFundBase.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalaryFundBase(sfb);
		                BigDecimal salaryInsurance = new BigDecimal((String)rtMap.get(21));  
		                double si = salaryInsurance.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarayInsurance(si);
		                BigDecimal salaryUnemployment = new BigDecimal((String)rtMap.get(22));  
		                double su = salaryUnemployment.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarayUnemployment(su);
		                BigDecimal salaryMedicalBase = new BigDecimal((String)rtMap.get(23));  
		                double smd = salaryMedicalBase.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarayMedicalBase(smd);
		                BigDecimal salaryHousingFund = new BigDecimal((String)rtMap.get(24));  
		                double shf = salaryHousingFund.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarayHousingFund(shf);
		                BigDecimal salaryReductionSum = new BigDecimal((String)rtMap.get(25));  
		                double srs = salaryReductionSum.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarayReductionSum(srs);
		                BigDecimal salaryTax = new BigDecimal((String)rtMap.get(26));  
		                double st = salaryTax.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarayTax(st);
		                BigDecimal salaryTaxPay = new BigDecimal((String)rtMap.get(27));  
		                double stp = salaryTaxPay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarayTaxPay(stp);
		                BigDecimal salaryPayroll = new BigDecimal((String)rtMap.get(28));  
		                double spa = salaryPayroll.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		                tbl.setSalarayPayroll(spa);
		                tbl.setSalarayCreateTime(DMTDateUtil.parseDate());
		                tbl.setSalarayPayrollPeriodMonth(salarayPayrollPeriodMonth.substring( 0,7));
		                tbl.setSalaraySendTime(salaraySendTime.substring(0,7));
		                tbl.setSalarayTableTime(tableDate.substring(0,7));
		                //邮箱
		               // String staffName = (String)rtMap.get(2);
		                SysAdminExample sysExample= new SysAdminExample();
		                sysExample.createCriteria().andAdminUsernameEqualTo(staffName.replaceAll("\\s*", ""));
		                List<SysAdmin> sysList = adminMapper.selectByExample(sysExample);
		                if(null != sysList && sysList.size()>0){
		                	SysAdmin adminSys = sysList.get(0);
		                	String mail = adminSys.getAdminEmail();
		                	tbl.setSalaryMail(mail);
		                }
		                list.add(tbl);
		            
		            } 
		            int count = 0;
		            //入库
		            if(null != list && !list.isEmpty()){	
		            	count = tableSalaryDao.batchInsert(list);	
		           }
//		            String ids="";
//		            for(int i = 8; i < lenth+8; i++){
//		            	if(i==lenth+8-1){
//		            		ids=ids+id;
//		            	}else{
//		            		ids = ids+id+",";}
//		            	
//		            }
		           // System.out.println(ids);
		           resultBean = new DMTResultBean("0","",ids);
		        } catch (Exception e) {  
		            System.out.println("未找到指定路径的文件!");  
		            e.printStackTrace(); 
		            resultBean = new DMTResultBean("1","异常","");
		        }
			   
		}
		return resultBean;
	}


	/*
	 * (非 Javadoc) 
	* <p>Title: sendEmailyDetail</p> 
	* <p>Description: 单条发送工资邮件</p> 
	* @author sizk
	* @date 2017年12月7日 下午5:03:38 
	* @version V1.0   
	* @param request
	* @return
	* @throws Exception 
	* @see com.bjdreamtech.service.IMailService#sendEmailyDetail(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public DMTResultBean sendEmailyDetail(HttpServletRequest request)
			throws Exception {
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		String salaryId=request.getParameter("salaryId");
		TableSalary  tableSalary=tableSalaryMapperAuto.selectByPrimaryKey(salaryId);
		String email = tableSalary.getSalaryMail();
		if(notNull(email)){
			//发邮件
			List<TableSalary> list = new ArrayList<TableSalary>();
			list.add(tableSalary);
			sendHtmlSalaryMail(list);
			resultBean=new DMTResultBean("0","邮件发送成功","邮件发送成功");
		}else{
			resultBean  = new DMTResultBean("1","未查询到"+tableSalary.getSalaryStaffName()+"用户邮箱","未查询到"+tableSalary.getSalaryStaffName()+"用户邮箱");
		}
		return resultBean;
	}
	/*
	 * (非 Javadoc) 
	* <p>Title: groupMailDetail</p> 
	* <p>Description: 群发工资邮件</p> 
	* @author songj
	* @date 2017年12月7日 下午5:03:38 
	* @version V1.0   
	* @param request
	* @return
	* @throws Exception 
	* @see com.bjdreamtech.service.IMailService#sendEmailyDetail(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public DMTResultBean groupMailDetail(HttpServletRequest request) throws Exception {
		DMTResultBean resultBean = new DMTResultBean("1","初始化","初始化");
		String idss = request.getParameter("ids");
		
		System.out.println(" ======  "+idss);
		String[] salaryIds = idss.split(",");
		for (String salaryId : salaryIds) {
			//System.out.println("工资条id"+salaryId);
			System.out.println(salaryId);
			TableSalary  tableSalary=tableSalaryMapperAuto.selectByPrimaryKey(salaryId);
			//System.out.println("工资条"+tableSalary);
			String email = tableSalary.getSalaryMail();
			if(notNull(email)){
				//发邮件
				List<TableSalary> list = new ArrayList<TableSalary>();
				list.add(tableSalary);
				sendHtmlSalaryMail(list);
				resultBean=new DMTResultBean("0","邮件发送成功","邮件发送成功");
			}else{
				resultBean  = new DMTResultBean("1","未查询到"+tableSalary.getSalaryStaffName()+"用户邮箱","未查询到"+tableSalary.getSalaryStaffName()+"用户邮箱");
			}
			
		}
		return resultBean;
	}

	/*
	 * (非 Javadoc) 
	* <p>Title: tickeQueryListByPage</p> 
	* <p>Description: 分页查询</p> 
	* @author sizk
	* @date 2017年12月7日 下午5:24:29 
	* @version V1.0   
	* @param request
	* @return
	* @throws Exception 
	* @see com.bjdreamtech.service.IMailService#tickeQueryListByPage(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public DMTDataTableBean<Map<String, Object>> tickeQueryListByPage(
			HttpServletRequest request) throws Exception {
		//初始化分页
		initPageParameter(request);
		String salaryStaffName = request.getParameter("salaryStaffName");
		//System.out.println(salaryStaffName);
		String salarayPayrollMin = request.getParameter("salarayPayrollMin");
		//System.out.println(salarayPayrollMin);
		String salarayPayrollMax = request.getParameter("salarayPayrollMax");
		//System.out.println(salarayPayrollMax);
		String salarayPayrollPeriodMonth = request.getParameter("salarayPayrollPeriodMonth");
		String sAdd="  ";
		if(notNull(salaryStaffName)){
			salaryStaffName = salaryStaffName.replaceAll("\\s*", "");
			if(salaryStaffName.length()==2){
				salaryStaffName = salaryStaffName.substring(0,1)+sAdd+salaryStaffName.substring(1,2);
				params.put("salaryStaffName", salaryStaffName);
			}else{
				params.put("salaryStaffName", salaryStaffName);
			}
		}
		if(notNull(salarayPayrollPeriodMonth)){
			salarayPayrollPeriodMonth = salarayPayrollPeriodMonth.substring(0,7);
			params.put("salarayPayrollPeriodMonth", salarayPayrollPeriodMonth);
		}
		
		if(notNull(salarayPayrollMin)){
			salarayPayrollMin = salarayPayrollMin.intern();	
			params.put("salarayPayrollMin", salarayPayrollMin);
		}
		if(notNull(salarayPayrollMax)){
			salarayPayrollMax = salarayPayrollMax.intern();	
			params.put("salarayPayrollMax", salarayPayrollMax);
		}
		
		List<Map<String, Object>> list = tableSalaryDao.QueryListByPage(params);
		DMTTimeFormatter.formatDateList(list, "salaray_create_time", "salaray_create_time");
				
		return new DMTDataTableBean<Map<String,Object>>(pageUtil.getTotalCount(),list);
	}


	
	
}

