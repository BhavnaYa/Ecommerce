package com.demo.order.bean;

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
	private int productInventory;
	private double productPrice;
	private String productDetails;
	
	
	
	
}