package com.example.shop.admin.controller.dto;

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
    private BigDecimal price;
    @NotBlank
    @Min(0)
    private String currency;

}
