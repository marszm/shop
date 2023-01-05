package com.example.shop.cart.controller;

import com.example.shop.cart.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartItems")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartItemService.delete(id);
    }

    @GetMapping("/count/{cartIdrtId}")
    public Long countItemCart(@PathVariable Long cartId) {
        return cartItemService.countItemCart(cartId);
    }

}
