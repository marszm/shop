package com.example.shop.cart.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime created;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cartId")
    private List<CartItem> items;

    public void addProduct(CartItem cartItem) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(cartItem);
    }
}