package com.demo.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order.bean.OrderBean;
import com.demo.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@PostMapping("/addtocart")
	public OrderBean addToCart(@RequestBody OrderBean order) {
		return service.addOrder(order);
		
	}

}
