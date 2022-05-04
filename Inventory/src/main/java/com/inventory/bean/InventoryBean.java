package com.inventory.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Document(collection="inventoryDB")
public class InventoryBean {

	
	@Id
	private String productId;
	//private String productSize;
	private String productInventory;
	private String productPrice;
	private String productDetails;
	
	
	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getProductInventory() {
		return productInventory;
	}


	public void setProductInventory(String productInventory) {
		this.productInventory = productInventory;
	}


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}


	public InventoryBean(String productId,  String productInventory, String productPrice,
			String productDetails) {
		super();
		this.productId = productId;
	//	this.productSize = productSize;
		this.productInventory = productInventory;
		this.productPrice = productPrice;
		this.productDetails = productDetails;
	}
	
	
}
