package db;

import model.Customer;
import model.SaleOrder;

public interface OrderDBIF {

	void confirmOrder(SaleOrder order) throws DataAccessException;
	void addCustomer(SaleOrder order, Customer customer) throws DataAccessException;
}
