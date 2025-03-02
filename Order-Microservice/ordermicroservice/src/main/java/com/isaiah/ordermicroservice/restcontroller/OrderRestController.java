package com.isaiah.ordermicroservice.restcontroller;

import com.isaiah.ordermicroservice.object.*;
import com.isaiah.ordermicroservice.service.OrderService;


import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderRestController {
	
	private final String JSON = "application/json";
	private final String LOCALHOST = "http://localhost:3000";
	
	@Autowired
	private OrderService orderService;

	
	@PostMapping(value = "/add", produces = JSON, consumes = JSON)
	public Order createOrder(@RequestBody Order order) {
		order = orderService.createOrder(order);
		return order;
	}
	
	@GetMapping(value = "/{orderId}", produces = JSON, consumes = JSON)
	public Order getOrder(@PathVariable long orderId) {
		Order order = orderService.readOrderByOrderId(orderId);
		order.setOrderProducts( (LinkedList<OrderedProduct>) orderService.readListOfOrderedProductsByOrderId(orderId));
		return order;
	}
	
	
	
	
	
	
}
