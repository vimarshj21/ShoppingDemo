package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
//	@Query("select p from Product p where p.productPrice between ?1 and ?2")
//	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice);
//	
//	@Query("select p from Product p where p.productCategory = ?1")
//	public List<Product> getALlProductsByCategory(String category);
	
	public List<Product> findByProductPriceBetween(int initialPrice, int finalPrice);
	public List<Product> findByProductCategory(String category);
}
