package model;

public class GunReplicaProduct extends Product{

	private String calibre;
	private String material;
	
	
	public GunReplicaProduct(String productId, String productName, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, String calibre, String material) {
		super(productId, productName, salesPrice, rentPrice, countryOfOrigin, minStock);
		this.calibre = calibre;
		this.material = material;
		
	}


	public String getCalibre() {
		return calibre;
	}


	public String getMaterial() {
		return material;
	}


	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}


	public void setMaterial(String material) {
		this.material = material;
	}

}
