package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	ProductRepository repository;

	@Override
	public String addProduct(Product product) {

		Product product1 = repository.save(product);
		if (product1 != null) {
			return "Product saved successfully";
		} else {
			return "Failed to save product";
		}
	}

	@Override
	public Product updateProduct(Product product) {

		return repository.save(product);
	}

	@Override
	public String deleteProduct(int productId) {

		repository.deleteById(productId);
		return "Product deleted successfully";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFound {

		Optional<Product> optional = repository.findById(productId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new ProductNotFound("No product found with given id");
		}
	}

	@Override
	public List<Product> getAllProduct() {
		return repository.findAll();
	}

	@Override
	public List<Product> findByProductPriceBetween(int initialPrice, int finalPrice) {

		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}
	
	@Override
	public List<Product> findByProductCategory(String productCategory) {

		return repository.findByProductCategory(productCategory);
	}

	
}
