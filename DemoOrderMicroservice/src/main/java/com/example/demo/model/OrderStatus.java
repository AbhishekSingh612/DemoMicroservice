package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderStatus {

	String orderId;
	Boolean success;
	String productId;
	String productDescription;
	Integer availableNumber;
}
