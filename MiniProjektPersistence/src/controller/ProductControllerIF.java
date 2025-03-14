package controller;

import db.DataAccessException;
import model.Product;

//Interface klasse for ProductController
public interface ProductControllerIF {
	
	Product findProductById(int id) throws DataAccessException;

}
