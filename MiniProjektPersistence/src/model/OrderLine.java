package model;

//Setters, getters og en constructor for OrderLine


public class OrderLine {
	
	private int quantity;
	private Product product;
	private double currentUnitPrice;
	
	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		currentUnitPrice = product.getSalesPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
