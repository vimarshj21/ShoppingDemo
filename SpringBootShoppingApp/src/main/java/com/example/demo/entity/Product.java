package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Product {
	@Id
	private int productId;
	
	@NotBlank(message = "Product name is mandatory")
	@Size(max = 25, message = "Product name should not exceed 100 characters")
	private String productName;

	@NotNull(message = "Product price is mandatory")
	@Min(value = 100, message = "Product price should be greater than or equal to 0")
	private int productPrice;
	
	@NotBlank(message = "Product category is mandatory")
	private String productCategory;
	
	private Date productValidity;
	
}
