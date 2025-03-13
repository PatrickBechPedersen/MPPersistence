package db;

import model.Product;

//Det samme som de andre
public interface ProductDBIF {
	
	Product findProductById(String productId) throws DataAccessException;

}
