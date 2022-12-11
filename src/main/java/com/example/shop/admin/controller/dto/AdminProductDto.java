package com.example.shop.admin.controller.dto;

import com.example.shop.admin.model.AdminProducrCurrency;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Getter
public class AdminProductDto {
    @NotBlank
    @Length(min = 4)
    private String name;
    @NotBlank
    @Length(min = 4)
    private String category;
    @NotBlank
    @Length(min = 4)
    private String description;
    private String fullDescription;
    @NotBlank
    @Min(0)
    private BigDecimal price;
    private AdminProducrCurrency currency;
    private String image;
    @NotBlank
    @Length(min = 4)
    private String slug;
}
