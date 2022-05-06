package com.demo.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.order.bean.OrderBean;
import com.demo.order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService service;

	@PostMapping("/addOrder")
	public OrderBean addToCart(@RequestBody OrderBean order) {
		return service.addOrder(order);
	}

	@PostMapping("/cancelOrder/{orderId}")
	public OrderBean cancelOrder(@PathVariable(name = "orderId") String orderId) {
		return service.cancelOrder(orderId);
	}

	@GetMapping("/orderHistory")
	public List<OrderBean> getOrderHistory(@RequestParam(name = "email") String email) {
		return service.getOrderHistory(email);
	}

}
