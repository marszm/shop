package com.example.shop.product.controller;

import com.example.shop.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        return List.of(
                new Product("nowy prodult 1", "nowa kategoria 1", "nowy opis 1", new BigDecimal("9.11"), "PLN"),
                new Product("nowy prodult 2", "nowa kategoria 2", "nowy opis 2", new BigDecimal("9.12"), "PLN"),
                new Product("nowy prodult 3", "nowa kategoria 3", "nowy opis 3", new BigDecimal("9.13"), "PLN"),
                new Product("nowy prodult 4", "nowa kategoria 4", "nowy opis 4", new BigDecimal("9.14"), "PLN")
                );
    }

}
