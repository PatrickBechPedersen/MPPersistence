package controller;

import db.DataAccessException;
import model.Customer;

public interface CustomerControllerIF {

	Customer getCustomer(String phone) throws DataAccessException;
	
}
