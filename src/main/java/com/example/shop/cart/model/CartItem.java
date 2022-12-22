package com.example.shop.cart.model;

import com.example.shop.common.model.Product;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @OneToOne
    private Product product;
}
