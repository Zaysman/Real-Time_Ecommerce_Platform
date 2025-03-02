package com.isaiah.productmicroservice.repository;

//import com.isaiah.productmicroservice.object.Product;
import com.realtimee_commerceplatform.common.object.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//Save or update product
	<S extends Product> S save (S product);
	
	//Read Operations
	Optional<Product> findByproductId(long productId);
	Optional<Product> findByproductName(String productName);
	
	
	//Delete operations
	void deleteByproductId(long productId);
	void delete(Product product);

}
