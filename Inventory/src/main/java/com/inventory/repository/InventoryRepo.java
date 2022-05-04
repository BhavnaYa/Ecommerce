package com.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.bean.InventoryBean;

@Repository
public interface InventoryRepo extends MongoRepository<InventoryBean, String>{

	
}
