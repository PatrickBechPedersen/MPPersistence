package db;

import model.SaleOrder;

public interface OrderDBIF {

	void confirmOrder(SaleOrder order) throws DataAccessException;
	
}
