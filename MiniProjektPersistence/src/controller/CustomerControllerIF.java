package controller;

import db.DataAccessException;
import model.Customer;


//Interface klasse for CustomerController
public interface CustomerControllerIF {

	Customer getCustomer(String phone) throws DataAccessException;
	
}
