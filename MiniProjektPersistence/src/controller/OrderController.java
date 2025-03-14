package controller;

import db.DataAccessException;
import db.OrderDB;
import model.Customer;
import model.OrderLine;
import model.Product;
import model.SaleOrder;

public class OrderController implements OrderControllerIF {

	private OrderDB orderDB;
	private CustomerController customerController;
	private ProductController productController;
	
	@Override
	public void createORder(SaleOrder order) throws DataAccessException {
		orderDB.confirmOrder(order);
	}

	@Override
	public void addCustomerByPhone(String phone, SaleOrder order) throws DataAccessException {
		Customer c = customerController.getCustomer(phone);
		orderDB.addCustomer(order, c);
	}


	@Override
	public void addOrderLinesOnGivenOrder(SaleOrder order) throws DataAccessException {
		orderDB.addProducts(order);
	}

	@Override
	public Product getProduct(int productId) throws DataAccessException {
		return productController.findProductById(productId);
	}

}
