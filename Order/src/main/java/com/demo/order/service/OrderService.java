package com.demo.order.service;

import com.demo.order.enums.OrderStatus;
import com.demo.utility.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.stereotype.Service;

import com.demo.order.bean.OrderBean;
import com.demo.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	public OrderBean addOrder(OrderBean order) {
		order.setOrderStatus(OrderStatus.ORDER_CREATED);
		order.setQuantity(order.getOrderInfo().split(",").length);
		order.setOrderTotal(0);
		return repository.save(order);
	}

	public OrderBean cancelOrder(String orderId) {
		//OrderBean orderBean = repository.findOrderByOrderId(orderId);
		Optional<OrderBean> optionalOrderBean = repository.findById(orderId);
		if (optionalOrderBean.isPresent()) {
			OrderBean orderBean = optionalOrderBean.get();
			orderBean.setOrderStatus(OrderStatus.ORDER_CANCELLED);
			return repository.save(orderBean);
		} else {
			throw new NotFoundException("OrderId: " + orderId + " not found.");
		}
	}

	public List<OrderBean> getOrderHistory(String email) {
		return repository.findByEmailId(email);
	}

}