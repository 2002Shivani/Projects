package com.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductDetails {

	// fields
	@Id
	private int productID;
	private String productName;
	private String productType;
	private float productPrice;
	private int productAvailable;
	private String productSource;

	// No-Argument Constructor
	public ProductDetails() {

	}

	// Argument Constructor

	public ProductDetails(int productID, String productName, String productType, float productPrice,
			int productAvailable, String productSource) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.productAvailable = productAvailable;
		this.productSource = productSource;
	}

	// Getter and Setter

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(int productAvailable) {
		this.productAvailable = productAvailable;
	}

	public String getProductSource() {
		return productSource;
	}

	public void setProductSource(String productSource) {
		this.productSource = productSource;
	}

	// toString

	@Override
	public String toString() {
		return "ProductDetails [productID=" + productID + ", productName=" + productName + ", productType="
				+ productType + ", productPrice=" + productPrice + ", productAvailable=" + productAvailable
				+ ", productSource=" + productSource + "]";
	}

}
