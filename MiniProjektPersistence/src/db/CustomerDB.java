package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

public class CustomerDB implements CustomerDBIF {

	private static final String findByPhoneQ = "select * from customer where phone = ?";
	private PreparedStatement findByPhone;
	
	public CustomerDB() throws DataAccessException {
		try {
			findByPhone = DBConnection.getInstance().getConnection()
					.prepareStatement(findByPhoneQ);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	

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
			throw new DataAccessException(e, "Could not find by id = " + phone);
		}
	}
	
	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer c = new Customer(
				rs.getString("address"),
				rs.getString("zipcode"),
				rs.getString("city"),
				rs.getString("phoneNo")
				);
		return c;
	}
	
}
