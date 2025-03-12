package model;

public class Product {
	
	private String productId;
	private String productName;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	
	public Product(String productId, String productName, double salesPrice, double rentPrice, String countryOfOrigin,
			int minStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
	}

	public String getProductId() {
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

	public void setProductId(String productId) {
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
