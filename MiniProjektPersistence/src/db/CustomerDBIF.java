package db;

import model.Customer;

public interface CustomerDBIF {

	Customer findByPhone(String phone) throws DataAccessException;
}
