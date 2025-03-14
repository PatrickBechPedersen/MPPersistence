package model;

//Setters, getters og en constructor for Customer


public class Customer {
	
	private int id;
	private String address;
	private String zipcode;
	private String city;
	private String phoneNo;
	
	public Customer(String address, String zipcode,String city, String phoneNo) {
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	
	public int getId() {
		return id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
