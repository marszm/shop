package com.example.shop.admin.controller.dto;

import com.example.shop.admin.model.AdminProducrCurrency;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AdminProductDto {
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @NotBlank
    private String description;
    @NotBlank
    @Min(0)
    private BigDecimal price;
    private AdminProducrCurrency currency;
    private String image;
}
