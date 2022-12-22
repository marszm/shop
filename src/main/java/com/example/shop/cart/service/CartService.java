package com.example.shop.cart.service;

import com.example.shop.cart.model.Cart;
import com.example.shop.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }
}
