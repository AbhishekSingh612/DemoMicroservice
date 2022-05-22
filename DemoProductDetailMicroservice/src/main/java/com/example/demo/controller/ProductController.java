package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable("productId") String productId) {
		
		return Product.builder()
			.productId(productId)
			.productName("My Product 1")
			.productDescription("This is product Description")
			.build();
	}

	
	@GetMapping("/")
	public String test() {
		
		return "Hello";
	}

}
