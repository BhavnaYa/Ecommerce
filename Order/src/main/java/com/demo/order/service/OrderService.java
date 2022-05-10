package com.demo.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.order.bean.InventoryBean;
import com.demo.order.bean.OrderBean;
import com.demo.order.enums.OrderStatus;
import com.demo.order.repository.OrderRepository;
import com.demo.utility.exceptions.NotFoundException;

@Service
public class OrderService {
	@Autowired
	OrderRepository repository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${inventory.update.url}")
	String updateInvenUri;

	@Value("${inventory.product.info}")
	String productInfoUri;

	public OrderBean addOrder(OrderBean order) {
		
		List<String> productIdList=order.getOrderInfo();
		double totalCost=0.0;
		int totalQuantity=0;
		for(String productId:productIdList) {
			InventoryBean productDetails= webClientBuilder.build()
					.get().uri(productInfoUri+productId).header("validated","true")
					.retrieve().bodyToMono(InventoryBean.class).block();
			totalCost+=	productDetails.getProductPrice();
			totalQuantity+=1;
			if(productDetails.getProductInventory()<1) {
				throw new NotFoundException("ProductId: " + productId + "Inventory not found.");			
			}
		}
		order.setOrderStatus(OrderStatus.ORDER_CREATED);
		order.setQuantity(totalQuantity);
		order.setOrderTotal(totalCost);
		for(String productId:productIdList) {
			webClientBuilder.build().put().uri(updateInvenUri+productId+"/add")
					.header("validated","true")
					.retrieve().bodyToMono(InventoryBean.class).block();
			
		}
		
		return repository.save(order);
	}
	
	
	public OrderBean cancelOrder(String orderId) {
	
		Optional<OrderBean> orderDetails = repository.findById(orderId);
		if (orderDetails.isPresent()) {
		
		OrderBean orderBean = orderDetails.get();
		for(String productId:orderBean.getOrderInfo()) {
			webClientBuilder.build().put().uri(updateInvenUri+productId+"/cancel").header("validated","true")
					.retrieve().bodyToMono(InventoryBean.class).block();
		    
		  }
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
