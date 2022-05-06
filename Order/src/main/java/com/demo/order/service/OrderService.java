package com.demo.order.service;
import com.demo.order.enums.OrderStatus;
import com.demo.utility.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.demo.order.bean.OrderBean;
import com.demo.order.client.IntegrationClient;
import com.demo.order.repository.OrderRepository;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
	@Autowired
	OrderRepository repository;
	@Autowired
	IntegrationClient integrationClient;
	public OrderBean addOrder(OrderBean order) {
		// check if inventory is present
		HttpHeaders headers = buildCommonHeader();
		String uri = "http://localhost:8083/getProductInfo/{productId}";
		String[] productIds = order.getOrderInfo().split(",");
		for(String eachProductId : productIds) {
			uri = uri.replace("{productId}", eachProductId);
			ResponseEntity<HashMap> response = integrationClient.getResponse(uri, HttpMethod.GET, new HttpEntity<>(headers), HashMap.class);
			int productInventory = Integer.parseInt((String)response.getBody().get("productInventory"));
			if(productInventory < 1) {
				throw new NotFoundException("Inventory for ProductId: " + eachProductId + " not found.");
			}
		}
		order.setOrderStatus(OrderStatus.ORDER_CREATED);
		order.setQuantity(order.getOrderInfo().split(",").length);
		order.setOrderTotal(0);
		return repository.save(order);
		//update inventory based on order
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
	public static HttpHeaders buildCommonHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}
}