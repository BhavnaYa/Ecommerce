package com.demo.order.bean;

import com.demo.order.enums.OrderStatus;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("OrderDB")
public class OrderBean {
	
	@Id
	private String orderId;
	private String emailId;
	private String address;
	private OrderStatus orderStatus;
	private List<String> orderInfo;
	private int quantity;
	private double orderTotal;

}
