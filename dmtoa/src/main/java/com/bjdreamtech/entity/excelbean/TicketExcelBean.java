package com.bjdreamtech.entity.excelbean;
/**   
* @Title: TicketExcelBean.java 
* @Description: 报销下载Excel bean
* @author sizk
* @date 2017年12月6日 下午3:24:21 
* @version V1.0 
* 版本信息：   
* 日期：2017年12月6日
   
*
*/
public class TicketExcelBean {
	private String ticketTime;		//报销日期
    private String ticketItem;		//报销事项
    private String ticketUse;		//用途
    private Double ticketPay;		//花费

    
    private String ticketPerson;	//出资人
    private String ticketType;		//发票情况
    private String ticketRemaker;	//备注
	public String getTicketTime() {
		return ticketTime;
	}
	public void setTicketTime(String ticketTime) {
		this.ticketTime = ticketTime;
	}
	public String getTicketItem() {
		return ticketItem;
	}
	public void setTicketItem(String ticketItem) {
		this.ticketItem = ticketItem;
	}
	public String getTicketUse() {
		return ticketUse;
	}
	public void setTicketUse(String ticketUse) {
		this.ticketUse = ticketUse;
	}
	public Double getTicketPay() {
		return ticketPay;
	}
	public void setTicketPay(Double ticketPay) {
		this.ticketPay = ticketPay;
	}
	public String getTicketPerson() {
		return ticketPerson;
	}
	public void setTicketPerson(String ticketPerson) {
		this.ticketPerson = ticketPerson;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getTicketRemaker() {
		return ticketRemaker;
	}
	public void setTicketRemaker(String ticketRemaker) {
		this.ticketRemaker = ticketRemaker;
	}
    
}

