package controller;

import db.DataAccessException;
import model.Product;

public interface ProductControllerIF {
	
	Product findProductById(int id) throws DataAccessException;

}
