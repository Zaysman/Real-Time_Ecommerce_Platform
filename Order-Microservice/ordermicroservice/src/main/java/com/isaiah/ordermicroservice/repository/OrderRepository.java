package com.isaiah.ordermicroservice.repository;

import com.isaiah.ordermicroservice.object.Order;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	//Save or update Order
	<S extends Order> S save (S Order);
	
	//Read Operations
	Optional<Order> findByorderId(long orderId);
	List<Order> findAll();
	
	//Delete Operations
	void deleteByorderId(long orderId);
	void delete(Order order);
	
	
	
	

}
