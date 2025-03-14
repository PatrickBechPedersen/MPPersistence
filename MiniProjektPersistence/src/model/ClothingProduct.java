package model;


//Setters, getters og en constructor for ClothingProduct som er en underklasse for Product
public class ClothingProduct extends Product {

	private String size;
	private String colour;
	
	public ClothingProduct(int productId, String productName, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, String size, String colour) {
		super(productId, productName, salesPrice, rentPrice, countryOfOrigin, minStock);
		this.colour = colour;
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public String getColour() {
		return colour;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
}
