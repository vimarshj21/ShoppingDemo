package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
	CartService service;
	@PostMapping("/save")
	public Cart saveCart(@RequestBody Cart cart) {
		return service.addToCart(cart);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteCart(@PathVariable("id") int cartId) {
		return service.clearCart(cartId);
	}
	
	@GetMapping("/getAllCarts")
	public List<Cart> getAllProducts(){
		return service.getAllCart();
	}
}
