package com.demo.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.order.bean.OrderBean;

@Repository
public interface OrderRepository extends MongoRepository<OrderBean, String>{

}
