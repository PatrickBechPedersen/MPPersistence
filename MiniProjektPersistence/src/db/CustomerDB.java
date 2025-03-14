package db;


//Database for Customer

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

public class CustomerDB implements CustomerDBIF {
	//Prepared statement for at finde en customer ved hjælp af tlf nr.
	private static final String findByPhoneQ = "select * from customer where phone = ?";
	private PreparedStatement findByPhone;
	//Metoden der laver prepared statement
	public CustomerDB() throws DataAccessException {
		try {
			findByPhone = DBConnection.getInstance().getConnection()
					.prepareStatement(findByPhoneQ);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	
	//Selve metoden der finder en customer ved hjælp af tlf nr.
	@Override
	public Customer findByPhone(String phone) throws DataAccessException {
		try {
			findByPhone.setString(1, phone);
			ResultSet rs = findByPhone.executeQuery();
			Customer c = null;
			if(rs.next()) {
				c = buildObject(rs);
			}
			return c;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by phone = " + phone);
		}
	}
	
	//Laver resten af customeren fra databasen, ud fra resultalt sættet fra den forrige metode
	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer c = new Customer(
				rs.getString("address"),
				rs.getString("zipcode"),
				rs.getString("city"),
				rs.getString("phoneNo")
				);
		        c.setId(rs.getInt("id"));
		return c;
	}
	
}
