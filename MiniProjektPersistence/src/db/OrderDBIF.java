package db;

import model.Customer;
import model.SaleOrder;

//Interface klasse til at kunne køre confirmOrder, for sikkerhed, da resten af metoderne i OrderDB ikke skal bruges her


public interface OrderDBIF {

	void confirmOrder(SaleOrder order) throws DataAccessException;
	void addCustomer(SaleOrder order, Customer customer) throws DataAccessException;
	void addProducts(SaleOrder order) throws DataAccessException;
}
