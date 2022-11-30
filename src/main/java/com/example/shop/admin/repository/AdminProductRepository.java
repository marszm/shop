package com.example.shop.admin.repository;

import com.example.shop.admin.model.AdminProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminProductRepository extends JpaRepository<AdminProduct, Long> {
}
