package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService{
	
	CartRepository repository;
	@Override
	public Cart addToCart(Cart cart) {
		return repository.save(cart);
	}
	@Override
	public String clearCart(int cartId) {
		repository.deleteById(cartId);
		return "Cart deleted successfully";
	}
	@Override
	public List<Cart> getAllCart() {
		return repository.findAll();
	}

}
