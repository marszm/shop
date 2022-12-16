package com.example.shop.category.service;

import com.example.shop.category.model.Category;
import com.example.shop.category.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoriesWithProducts(String slug) {
        return categoryRepository.findBySlug(slug);
    }
}
