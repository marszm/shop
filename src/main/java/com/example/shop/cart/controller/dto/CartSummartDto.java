package com.example.shop.cart.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CartSummartDto {
    private Long id;
    private List<CartSummaryItemDto> items;
    private SummaryDto summary;
}
