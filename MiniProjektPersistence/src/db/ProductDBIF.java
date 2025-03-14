package db;

import model.Product;

public interface ProductDBIF {
	
	Product findProductById(int productId) throws DataAccessException;

}
