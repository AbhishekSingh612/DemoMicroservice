package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inventory {

	String productId;
	Integer availableAmount;
}
