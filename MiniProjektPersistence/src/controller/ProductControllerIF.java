package controller;

import db.DataAccessException;
import model.Product;

public interface ProductControllerIF {
	
	Product findProductById(String id) throws DataAccessException;

}
