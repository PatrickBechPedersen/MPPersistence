package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.OrderLine;
import model.Product;
import model.SaleOrder;
//Database for Order

public class OrderDB implements OrderDBIF {
	//Prepared statement for at lave en ordre og tilføje produkter 
	private static final String confirmOrderQ = "insert into SaleOrder subtotal, deliveryStatus, deliveryDate";
	private PreparedStatement confirmOrder;
	private static final String addProductQ = "insert into orderLineSaleOrder productId, orderId";
	private PreparedStatement addProduct;
	//Metode der implementerer de prepared statementts
	public OrderDB() throws DataAccessException{
		try {
		confirmOrder = DBConnection.getInstance().getConnection().prepareStatement(confirmOrderQ);
		addProduct = DBConnection.getInstance().getConnection().prepareStatement(addProductQ);
		}
		catch(SQLException e) {
			throw new DataAccessException(e, "Could not prepared statements");
		}
	}
	//Metode til at lave en ordre 
	@Override
	public void confirmOrder(SaleOrder order) throws DataAccessException {
		addProducts(order);
		order.calculateTotal();
		final double subtotal = order.getTotal();
		final String deliveryStatus = order.getDeliveryStatus();
		final Date deliveryDate = order.getDate();
		try {
			confirmOrder.setDouble(1, subtotal);
			confirmOrder.setString(2, deliveryStatus);
			confirmOrder.setDate(3, deliveryDate);
			confirmOrder.execute();
		} catch(SQLException e) {
			throw new DataAccessException(e, "could not create order ");
			
		}
	}
	//Metode der tilføjer produkter til en OrderLine
	private void addProducts(SaleOrder order) throws DataAccessException {
		try {
		ArrayList<OrderLine>orderLines = order.getOrderLines();
		final int orderId = order.getOrderId();
		for(OrderLine orderLine : orderLines) {
			Product p = orderLine.getProduct();
			final int productId = p.getProductId();
			addProduct.setInt(1, orderId);
			addProduct.setInt(2, productId);
			addProduct.execute();
			}
		}catch(SQLException e) {
			throw new DataAccessException(e, "coul not addProducts");
		}
		
	}
		

}
