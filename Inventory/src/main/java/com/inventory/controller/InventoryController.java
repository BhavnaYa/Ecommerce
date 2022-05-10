package com.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.demo.utility.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.common.base.Optional;
import com.inventory.bean.InventoryBean;
import com.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/getProductInfo/{productId}")
	public InventoryBean getProductInfo(@PathVariable String productId) {
    java.util.Optional<InventoryBean> productDetails=inventoryService.getProductDetails(productId);
	if (productDetails.isPresent()) {
		return productDetails.get();	
	}
    throw new NotFoundException("ProductId: " + productId + " not found.");
	
	}
	
	@GetMapping("/searchProduct")
	public List<InventoryBean> searchProduct() {
		
		List<InventoryBean> productList=new ArrayList<InventoryBean>();		
		productList=inventoryService.getProductInfo();
		return productList;
		
	}


	@PostMapping(path="/addProduct")
	public InventoryBean addProduct(@Valid @RequestBody InventoryBean inventoryBean) {
		
		InventoryBean add=inventoryService.addProduct(inventoryBean);
		
		return add;
		
	}
	
   @PutMapping(path="/updateProductDetails/{productId}")
   public InventoryBean updateProductDetails(@Valid @RequestBody InventoryBean inventoryBean,@PathVariable String productId) {
	
	   InventoryBean updateDetails=inventoryService.updateproductDetails(inventoryBean, productId);
	   return updateDetails;
	   
   }
	
   @PutMapping(path="/updateProductInventory/{productId}/{flag}")
   public InventoryBean updateProductInventory(@Valid @PathVariable String productId,@PathVariable String flag) {
	
	   InventoryBean updateDetails=inventoryService.updateProductInventory(productId,flag);
	   return updateDetails;
	   
   }

}
