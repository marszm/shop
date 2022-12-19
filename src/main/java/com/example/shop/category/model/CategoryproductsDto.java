package com.example.shop.category.model;

import com.example.shop.product.dto.ProductListDto;
import org.springframework.data.domain.Page;

public record CategoryproductsDto(Category category, Page<ProductListDto> products) {
}
