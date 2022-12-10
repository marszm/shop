package com.example.shop.admin.controller;

import com.example.shop.admin.model.AdminProduct;
import com.example.shop.admin.service.AdminProductService;
import com.example.shop.product.model.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

class AdminProductControllerTest {

    @MockBean
    AdminProductService adminProductService;

//    @Test
//    @Disabled
//    void shouldReturntProducts() {
//
//        AdminProduct product = AdminProduct.builder()
//                .id(1L)
//                .name("name")
//                .price(BigDecimal.valueOf(11.1))
//                .currency("PLN")
//                .description("opis")
//                .image("aaa")
//                .build();
//        when(adminProductService.getProducts((Pageable) Mockito.any(AdminProduct.class).builder()
//                .id(1L)
//                .name("name")
//                .price(BigDecimal.valueOf(11.1))
//                .currency("PLN")
//                .description("opis")
//                .image("aaa")
//                .build()).thenReturn(Mockito.any());
//
//    }
}