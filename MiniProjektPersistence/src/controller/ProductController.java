package controller;

import db.DataAccessException;
import db.ProductDB;
import model.Product;

//Controller klasse for Product kører metoderne fra ProductDB
public class ProductController implements ProductControllerIF {
	
	ProductDB productDB;

	@Override
	public Product findProductById(String id) throws DataAccessException {
		return productDB.findProductById(id);
	}

}
