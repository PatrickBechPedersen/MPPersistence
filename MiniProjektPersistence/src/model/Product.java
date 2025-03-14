package model;

//Setters, getters og en constructor for Product


public class Product {
	
	private int productId;
	private String productName;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	
	public Product(int productId, String productName, double salesPrice, double rentPrice, String countryOfOrigin,
			int minStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
}
