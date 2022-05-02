package com.demo.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.order.bean.OrderBean;
import com.demo.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	public OrderBean addOrder(OrderBean order) {
		return repository.save(order);
	}

}
