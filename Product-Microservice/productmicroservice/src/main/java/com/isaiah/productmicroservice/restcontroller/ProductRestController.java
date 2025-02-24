package com.isaiah.productmicroservice.restcontroller;

import com.isaiah.productmicroservice.object.Product;
import com.isaiah.productmicroservice.service.ProductService;

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
@RequestMapping("api/products")
public class ProductRestController {
	
	private final String JSON = "application/json";
	private final String LOCALHOST = "http://localhost:3000";
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/{productid}", produces = JSON)
	public Product getProductByProductId(@PathVariable long productid) {
		return productService.readProductByProductid(productid);
	} 
		
	
	

}
