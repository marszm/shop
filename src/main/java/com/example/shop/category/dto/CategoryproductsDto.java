package com.example.shop.category.dto;

import com.example.shop.common.model.Category;
import com.example.shop.common.dto.ProductListDto;
import org.springframework.data.domain.Page;

public record CategoryproductsDto(Category category, Page<ProductListDto> products) {
}
