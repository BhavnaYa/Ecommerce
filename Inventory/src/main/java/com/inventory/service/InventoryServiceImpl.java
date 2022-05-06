package com.inventory.service;

import java.util.List;
import java.util.Optional;

import com.demo.utility.exceptions.NotFoundException;
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
//InventoryBean existingProductDetails=productDetails.get();
			inventoryBean.setProductId(productId);
			return inventoryRepo.save(inventoryBean);
		}
		throw new NotFoundException("product Id not found"+productId);
	}

	@Override
	public InventoryBean updateProductInventory(String productId,String flag) {
		Optional<InventoryBean> productDetails = inventoryRepo.findById(productId);
		if (productDetails.isPresent()) {
            InventoryBean updatingInventoryQuantity=productDetails.get();
            if(flag.equalsIgnoreCase("add")) {
			updatingInventoryQuantity.setProductInventory(updatingInventoryQuantity.getProductInventory()-1);
            }
            else {
            	updatingInventoryQuantity.setProductInventory(updatingInventoryQuantity.getProductInventory()+1);	
            }
			return inventoryRepo.save(updatingInventoryQuantity);
		}
		throw new NotFoundException("product Id not found"+productId);
		
	}

	
	
	
}
