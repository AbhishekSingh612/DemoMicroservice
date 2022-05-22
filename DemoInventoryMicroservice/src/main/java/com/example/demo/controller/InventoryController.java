package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Inventory;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@GetMapping("/{productId}")
	public Inventory getInventory(@PathVariable String productId) {

		return Inventory.builder()
				.productId(productId)
				.availableAmount(10)
				.build();
	}
}
