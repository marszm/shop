package com.example.shop.cart.mapper;

import com.example.shop.cart.controller.dto.CartSummartDto;
import com.example.shop.cart.controller.dto.CartSummaryItemDto;
import com.example.shop.cart.controller.dto.SummaryDto;
import com.example.shop.cart.model.Cart;
import com.example.shop.cart.model.CartItem;
import com.example.shop.common.model.Product;
import com.example.shop.product.service.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public class CartMapper {
    public static CartSummartDto mapToCartSummary(Cart cart) {

        return CartSummartDto.builder()
                .id(cart.getId())
                .items(mapToCartItems(cart.getItems()))
                .summary(mapToSummary(cart.getItems()))
                .build();
    }

    private static SummaryDto mapToSummary(List<CartItem> items) {
        return SummaryDto.builder()
                .grossValue(sumValues(items))
                .build();
    }

    private static BigDecimal sumValues(List<CartItem> items) {
        return items.stream()
                .map(CartMapper::calculatedLineValue)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static CartSummaryItemDto mapToCartItems(CartItem cartItem) {
        return CartSummaryItemDto.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .product(mapToProductDto(cartItem.getProduct()))
                .lineValue(calculatedLineValue(cartItem))
                .build();
    }

    private static BigDecimal calculatedLineValue(CartItem cartItem) {
        return cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
    }

    private static ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .currency(product.getCurrency())
                .image(product.getImage())
                .price(product.getPrice())
                .slug(product.getSlug())
                .build();
    }

    private static List<CartSummaryItemDto> mapToCartItems(List<CartItem> items) {
        return items.stream()
                .map(CartMapper::mapToCartItems)
                .toList();
    }
}
