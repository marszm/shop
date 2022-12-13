package com.example.shop.category.service;

import com.example.shop.category.model.AdminCategory;
import com.example.shop.category.reoisitory.AdminCategoryReoisitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCategoryService {

    private final AdminCategoryReoisitory adminCategoryReoisitory;

    public List<AdminCategory> getCategories() {
        return adminCategoryReoisitory.findAll();
    }

    public AdminCategory getCategory(Long id) {
        return adminCategoryReoisitory.findById(id).orElseThrow();
    }

    public AdminCategory createCategory(AdminCategory adminCategoryy) {
        return adminCategoryReoisitory.save(adminCategoryy);
    }

    public AdminCategory updateCategory(AdminCategory adminCategory) {
        return adminCategoryReoisitory.save(adminCategory);
    }

    public void deleteCategory(Long id) {
        adminCategoryReoisitory.deleteById(id);
    }
}
