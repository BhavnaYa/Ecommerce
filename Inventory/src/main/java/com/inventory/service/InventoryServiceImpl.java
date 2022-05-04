package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.bean.InventoryBean;
import com.inventory.repository.InventoryRepo;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;
	
	@Override
	public List<InventoryBean> getProductInfo() {
		
		return inventoryRepo.findAll();
		
	}

	@Override
	public InventoryBean addProduct(InventoryBean inventoryBean) {
		// TODO Auto-generated method stub
		return inventoryRepo.save(inventoryBean);
	}

	@Override
	public Optional<InventoryBean> getProductDetails(String productId) {
		return inventoryRepo.findById(productId);
	}

	@Override
	public InventoryBean updateproductDetails(InventoryBean inventoryBean, String productId) {
		Optional<InventoryBean> productDetails = inventoryRepo.findById(productId);
		  if (productDetails.isPresent()) {
			return  inventoryRepo.save(inventoryBean);			  
		  }
		return null;
	}

	
	
	
}
