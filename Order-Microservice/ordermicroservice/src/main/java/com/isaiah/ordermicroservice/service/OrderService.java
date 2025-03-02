package com.isaiah.ordermicroservice.service;

import com.isaiah.ordermicroservice.object.*;
import com.isaiah.ordermicroservice.repository.*;

import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderedProductRepository orderedProductRepo;
	
	public Order createOrder(Order order) {
		Optional<Order> existingOrder = orderRepo.findByorderId(order.getOrderId());
		
		if(existingOrder.isPresent()) {
			throw new RuntimeException("Order with id: " + existingOrder.get().getOrderId() + " already exists.");
		}
		
		Order savedOrder = orderRepo.save(order);
		return savedOrder;
		
	}
	
	
	public OrderedProduct createOrderedProduct(OrderedProduct orderedProduct) {
		Optional<OrderedProduct> existingOrderedProduct = orderedProductRepo.findByentryId(orderedProduct.getEntryId());
		if(existingOrderedProduct.isPresent()) {
			throw new RuntimeException("OrderedProduct with entryId: " + existingOrderedProduct.get().getEntryId() + " already exists.");
		}
		
		OrderedProduct savedOrderedProduct = orderedProductRepo.save(orderedProduct);
		return savedOrderedProduct;
	}
	
	public Order readOrderByOrderId(long orderId) {
		return orderRepo.findByorderId(orderId).orElse(null);
	}
	
	public List<Order> readOrdersByUserId(long userId) {
		return orderRepo.findByuserId(userId);
		
	}
	
	public OrderedProduct readOrderedProductByEntryId(long entryId) {
		return orderedProductRepo.findByentryId(entryId).orElse(null);
	}
	
	public List<OrderedProduct> readListOfOrderedProductsByOrderId(long orderId) {
		return orderedProductRepo.findByorderId(orderId);
	}
	
	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public OrderedProduct updateOrderedProduct(OrderedProduct orderedProduct) {
		return orderedProductRepo.save(orderedProduct);
	}
	
	@Transactional
	public void deleteOrderByOrderId(long orderId) {
		//When we delete an order, We'll want to delete the orderedProducts associated with the order.
		deleteOrderedProductByOrderId(orderId); 
		
		//Then we delete the order itself.
		orderRepo.deleteByorderId(orderId); 
		
	}
	
	@Transactional
	public void deleteOrderedProductByOrderId(long orderId) {
		orderedProductRepo.deleteByorderId(orderId);
	}
	
	@Transactional
	public void deleteOrderedProductByEntryId(long entryId) {
		orderedProductRepo.deleteByentryId(entryId);
	}
	
	
	
	
	

}
