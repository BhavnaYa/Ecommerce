package com.inventory.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Document(collection="Inventory")
public class InventoryBean {

	
	@Id
	private String productId;
	@NotNull
	private int productInventory;
	@NotNull @Positive
	private double productPrice;
	@NotNull
	private String productDetails;
	
	
		
	
}
