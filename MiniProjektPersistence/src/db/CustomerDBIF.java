package db;

import model.Customer;

//Interface klasse til at kunne køre findByPhone, for sikkerhed, da resten af metoderne i CustomerDB ikke skal bruges her

public interface CustomerDBIF {

	Customer findByPhone(String phone) throws DataAccessException;
}
