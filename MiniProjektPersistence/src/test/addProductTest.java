package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import controller.ProductController;
import db.DataAccessException;

class addProductByIdTest {

	static ProductController ap;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ap = new ProductController();
	}


	@Test
	void UC1_S1() throws DataAccessException {
		//Arrange
		int productId = 1001;
		
		//Act
		ap.findProductById(productId);
		
		//Assert
		assertNotNull(productId);
		
		
	}
	
	@Test
	void UC1_S2() throws DataAccessException {
		//Arrange
		int productId = 999;
		
		
		//Act
		ap.findProductById(productId);
		
		//Assert
		assertNull(productId);
		
		
	}

}
