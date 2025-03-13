package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;
import model.Product;
//Database for Product

public class ProductDB implements ProductDBIF {
	//Det samme som i de to andre
	private static final String findByIdQ = "select * from product where id = ?";
	private PreparedStatement findById;
	
	public ProductDB() throws DataAccessException {
		try {
			findById = DBConnection.getInstance().getConnection()
					.prepareStatement(findByIdQ);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	
	//Metode til at finde et product med Id
	@Override
	public Product findProductById(String productId) throws DataAccessException {
		try {
			findById.setString(1, productId);
			ResultSet rs = findById.executeQuery();
			Product p = null;
			if(rs.next()) {
				p = buildObject(rs);
			}
			return p;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by id = " + productId);
		}
	}
	//Laver resten af produktet
	private Product buildObject(ResultSet rs) throws SQLException {
		Product p = new Product(
				rs.getInt("productId"),
				rs.getString("productName"),
				rs.getDouble("salesPrice"),
				rs.getDouble("rentPrice"),
				rs.getString("countryOfOrigin"),
				rs.getInt("minStock")
				);
		return p;
	}

}
