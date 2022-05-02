package com.inventory.bean;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Document(collection="inventoryDB")
public class InventoryBean {

	private String productId;
	private String productSize;
	private String productInventory;
	private String productPrice;
	private String productDetails;
}
