package model;

public class PrivateCustomer extends Customer{
	
	private String name;

	public PrivateCustomer(String address, String zipcode, String city, String phoneNo, String name) {
		super(address, zipcode, city, phoneNo);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
