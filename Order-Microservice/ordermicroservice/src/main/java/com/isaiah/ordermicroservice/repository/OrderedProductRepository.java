package com.isaiah.ordermicroservice.repository;

import com.isaiah.ordermicroservice.object.OrderedProduct;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long>{
	
	//Save or update user
	<S extends OrderedProduct> S savee (S OrderedProduct);
	
	//Read Operations
	Optional<OrderedProduct> findByentryId(long entryId);
	List<OrderedProduct> findByorderId(long orderId);
	
	//Delete operations
	void deleteByentryId(long entryId);
	void deleteByorderId(long orderId);
	void delete(OrderedProduct orderedProduct);
	

}
