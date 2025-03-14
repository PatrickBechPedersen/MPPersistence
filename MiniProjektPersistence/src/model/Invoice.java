package model;


//Setters, getters og en constructor for Invoice

import java.sql.Date;
import java.util.ArrayList;
//Pakke for Date attributten

public class Invoice {

	private String invoiceNo;
	private Date paymentDate;
	private ArrayList<SaleOrder> orders;
	
	public Invoice(String invoiceNo, Date paymentDate) {
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		orders = new ArrayList<SaleOrder>();
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public ArrayList<SaleOrder> getOrders() {
		return orders;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public void addSaleOrder(SaleOrder order) {
		orders.add(order);
	}
	
	
	
	
}
