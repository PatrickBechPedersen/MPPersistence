package controller;

import db.CustomerDB;
import db.DataAccessException;
import model.Customer;

//Controller klasse for Customer kører metoderne fra CustomerDB
public class CustomerController implements CustomerControllerIF{

	private CustomerDB customerDB;
	
	@Override
	public Customer getCustomer(String phone) throws DataAccessException {
		return customerDB.findByPhone(phone);
	}
	
}
