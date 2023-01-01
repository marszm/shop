package com.example.shop.cart.controller;

import com.example.shop.cart.controller.dto.CartSummartDto;
import com.example.shop.cart.mapper.CartMapper;
import com.example.shop.cart.model.dto.CartProductDto;
import com.example.shop.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{id}")
    public CartSummartDto getCart(@PathVariable Long id) {
        return CartMapper.mapToCartSummary(cartService.getCart(id));
    }

    @PutMapping("/{id}")
    public CartSummartDto addProductToCart(@PathVariable Long id, CartProductDto cartProductDto) {
        return CartMapper.mapToCartSummary(cartService.addProductToCart(id, cartProductDto));
    }

    @PutMapping("/{id}/update")
    public CartSummartDto updateCart(@PathVariable Long id, @RequestBody List<CartProductDto> cartProductDtos) {
        return CartMapper.mapToCartSummary(cartService.updateCart(id, cartProductDtos));
    }

}
