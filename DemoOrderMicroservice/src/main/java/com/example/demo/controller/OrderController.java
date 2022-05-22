package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderStatus;
import com.example.demo.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@Autowired
	OrderService service;

	@GetMapping("/{productId}")
	public OrderStatus getOrder(@PathVariable("productId") String productId) {
		
		log.info("Request Recieved");
		return service.processOrder(productId);
	}

	
}
