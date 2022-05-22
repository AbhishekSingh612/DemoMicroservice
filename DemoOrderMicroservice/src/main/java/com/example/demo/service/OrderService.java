package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.OrderStatus;
import com.example.demo.model.dto.Inventory;
import com.example.demo.model.dto.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	RestTemplate rest;

	@Value("${demo.microservice.product.url}")
	String productServiceUrl;

	@Value("${demo.microservice.inventory.url}")
	String inventoryServiceUrl;

	public OrderStatus processOrder(String productId) {

		log.info("Inside process {} {} {} ",productId, productServiceUrl, inventoryServiceUrl);

		Inventory inventory = rest.getForObject(inventoryServiceUrl + productId, Inventory.class);

		log.info("Inventory {}", inventory);

		Product product = rest.getForObject(productServiceUrl + productId, Product.class);

		log.info("Product {}", product);

		if (inventory != null && inventory.getAvailableAmount() > 0) {

			return OrderStatus.builder().orderId(String.valueOf(Math.round(Math.random() * 1000))).productId(productId)
					.availableNumber(inventory.getAvailableAmount()).productDescription(product.getProductDescription())
					.success(true).build();
		}

		return OrderStatus.builder().orderId(String.valueOf(Math.round(Math.random() * 1000))).productId(productId)
				.availableNumber(inventory.getAvailableAmount()).productDescription(product.getProductDescription())
				.success(false).build();

	}
}
