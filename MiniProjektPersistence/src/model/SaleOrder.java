package model;

import java.sql.Date;
import java.util.ArrayList;

public class SaleOrder {
	
	private Date date;
	private double total;
	private boolean delivered;
	private Date deliveryDate;
	private String orderId;
	private ArrayList<OrderLine> orderLines;
	
	public SaleOrder(Date date, boolean delivered, Date deliveryDate, String orderId) {
		this.date = date;
		this.delivered = delivered;
		this.deliveryDate = deliveryDate;
		this.orderId = orderId;
		orderLines = new ArrayList<OrderLine>();
	}
	public Date getDate() {
		return date;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public double calculateTotal() {
		double total = 0;
		for(OrderLine orderLine : orderLines){
			Product p = orderLine.getProduct();
			total += p.getSalesPrice();
		}
		return total;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
	
	
	

}
