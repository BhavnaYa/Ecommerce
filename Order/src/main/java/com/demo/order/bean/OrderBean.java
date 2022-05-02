package com.demo.order.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "OrderDB")
public class OrderBean {
	
	@Id
	private String orderId;
	private String emailId;
	private String address;
	private String orderStatus;
	private String orderInfo;
	private int quantity;
	private double orderTotal;

}
