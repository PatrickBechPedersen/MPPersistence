package model;

//Setters, getters og en constructor for SaleOrder


import java.sql.Date;
import java.util.ArrayList;
//Pakke for Datee attribute

public class SaleOrder {
	
	private Date date;
	private double total;
	private String deliveryStatus;
	private Date deliveryDate;
	private int orderId;
	private ArrayList<OrderLine> orderLines;
	
	public SaleOrder(Date date, String deliveryStatus, Date deliveryDate, int orderId) {
		this.date = date;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.orderId = orderId;
		orderLines = new ArrayList<OrderLine>();
	}
	public Date getDate() {
		return date;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public void setOrderId(int orderId) {
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
