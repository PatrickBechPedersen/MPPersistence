package controller;

import db.DataAccessException;
import model.Customer;
import model.OrderLine;
import model.Product;
import model.SaleOrder;

public interface OrderControllerIF {

	void createORder(SaleOrder order) throws DataAccessException;
	void addOrderLinesOnGivenOrder(SaleOrder order) throws DataAccessException;
	Product getProduct(int productId) throws DataAccessException;
	void addCustomerByPhone(String phone, SaleOrder order) throws DataAccessException;
	
}
