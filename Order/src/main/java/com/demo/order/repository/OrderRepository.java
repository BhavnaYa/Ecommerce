package com.demo.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.order.bean.OrderBean;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<OrderBean, String> {

    List<OrderBean> findByEmailId(String email);

}
