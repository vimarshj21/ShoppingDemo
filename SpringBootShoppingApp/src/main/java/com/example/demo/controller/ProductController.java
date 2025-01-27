package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	//@Autowired
	ProductService service;
	
	@PostMapping("/save")
	public String saveProduct(@Valid @RequestBody Product product) {
		logger.info("Product saved successfully: {}", product);
		return service.addProduct(product);
	}
	@PutMapping("/update")
	public Product updateProduct(@Valid @RequestBody Product product) {
		logger.info("Product updated successfully: {}", product);
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int productId) {
		logger.info("Product deleted successfully with ID: {}", productId);
		return service.deleteProduct(productId);
	}

	@GetMapping("/getById/{id}")
	public Product getProduct(@PathVariable("id") int productId) throws ProductNotFound {
		logger.info("Product found successfully with ID: {}", productId);
		return service.getProductById(productId);
	}

	@GetMapping("/getAll")
	public List<Product> getAllProduct() {
		logger.info("All products found successfully: {}");
		return service.getAllProduct();
	}

	@GetMapping("/getBetween/{price1}/{price2}")
	public List<Product> getAllBetween(@PathVariable("price1") int initialPrice, @PathVariable("price2") int finalPrice) {
		logger.info("Products found successfully between: {} and {}", initialPrice, finalPrice);
		return service.findByProductPriceBetween(initialPrice, finalPrice);
	}
	
	@GetMapping("/getByCategory/{category}")
	public List<Product> findByProductCategory(@PathVariable("category") String productCategory) throws ProductNotFound{
		logger.info("Product found successfully of category: {}", productCategory);
		return service.findByProductCategory(productCategory);
	}
	

}
