package com.demo.order.bean;

import com.demo.order.enums.OrderStatus;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("Order")
public class OrderBean {
	
	@Id
	private String orderId;
	@NotNull
	private String emailId;
	@NotNull
	private Address address;
	private OrderStatus orderStatus;
	@NotNull
	private List<String> orderInfo;
	private int quantity;
	private double orderTotal;

}
