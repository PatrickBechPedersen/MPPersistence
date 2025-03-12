package model;

public class EquipmentProduct extends Product {

	private String type;
	private String description;
	
	public EquipmentProduct(String productId, String productName, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, String type, String description) {
		super(productId, productName, salesPrice, rentPrice, countryOfOrigin, minStock);
		this.description = description;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
