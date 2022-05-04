package com.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.inventory.bean.InventoryBean;
import com.inventory.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/getProductInfo/{productId}")
	public java.util.Optional<InventoryBean> getProductInfo(@PathVariable String productId) {
    java.util.Optional<InventoryBean> productDetails=inventoryService.getProductDetails(productId);
	if (productDetails.isPresent()) {
		return productDetails;	
	}
    return null;	
	
	}
	
	@GetMapping("/searchProduct")
	public List<InventoryBean> searchProduct() {
		
		List<InventoryBean> productList=new ArrayList<InventoryBean>();		
		productList=inventoryService.getProductInfo();
		return productList;
		
	}
	
	
	@PostMapping(path="/addProduct")
	public InventoryBean addProduct(@RequestBody InventoryBean inventoryBean) {
		
		InventoryBean add=inventoryService.addProduct(inventoryBean);
		
		return add;
		
	}
	
   @PutMapping(path="/updateProductDetails/{productId}")
   public InventoryBean updateProductDetails(@RequestBody InventoryBean inventoryBean,@PathVariable String productId) {
	
	   InventoryBean updateDetails=inventoryService.updateproductDetails(inventoryBean, productId);
	   return updateDetails;
	   
   }
	
}
