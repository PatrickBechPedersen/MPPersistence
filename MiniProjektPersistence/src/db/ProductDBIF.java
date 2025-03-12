package db;

import model.Product;

public interface ProductDBIF {
	
	Product findProductById(String productId) throws DataAccessException;

}
