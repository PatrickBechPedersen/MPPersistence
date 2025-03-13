package model;


//Setters, getters og en constructor for ClubCustomer som er en underklasse for Customer
public class ClubCustomer extends Customer {

	private String clubName;
	private String cvrNumber;
	private String contactName;
	
	public ClubCustomer(String address, String zipcode, String city, String phoneNo, String clubName, String cvrNumber, String contactName) {
		super(address, zipcode, city, phoneNo);
		this.clubName = clubName;
		this.cvrNumber = cvrNumber;
		this.contactName = contactName;
	}

	public String getClubName() {
		return clubName;
	}

	public String getCvrNumber() {
		return cvrNumber;
	}
	
	public String getContactName() {
		return contactName;
	}

	public void setBusinessName(String clubName) {
		this.clubName = clubName;
	}

	public void setCvrNumber(String cvrNumber) {
		this.cvrNumber = cvrNumber;
	}	
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

}
