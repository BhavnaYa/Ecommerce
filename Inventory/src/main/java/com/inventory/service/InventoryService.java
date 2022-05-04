package com.inventory.service;

import java.util.List;
import java.util.Optional;

import com.inventory.bean.InventoryBean;

public interface InventoryService {

	public List<InventoryBean> getProductInfo();
	
	InventoryBean addProduct(InventoryBean inventoryBean);
	
	Optional<InventoryBean> getProductDetails(String productId);
	
	InventoryBean updateproductDetails(InventoryBean inventoryBean ,String productId);
}
