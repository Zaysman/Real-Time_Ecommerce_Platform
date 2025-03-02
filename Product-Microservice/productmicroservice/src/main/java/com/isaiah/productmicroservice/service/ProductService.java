package com.isaiah.productmicroservice.service;


//import com.isaiah.productmicroservice.object.Product;
import com.realtimee_commerceplatform.common.object.Product;
import com.isaiah.productmicroservice.repository.ProductRepository;



import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		Optional<Product> existingProduct = productRepository.findById(product.getProductId());
		if(existingProduct.isPresent()) {
			throw new RuntimeException("Product ID: " + product.getProductId() + " is already taken");
		}
		
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}
	
	public Product readProductByProductid(long productId) {
		return productRepository.findByproductId(productId).orElse(null);
	}
	
	public Product readProductByProductName(String productName) {
		return productRepository.findByproductName(productName).orElse(null);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Transactional
	public void deleteProductByProductId(long productId) {
		productRepository.deleteByproductId(productId);
	}
	
	@Transactional
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
	
}
