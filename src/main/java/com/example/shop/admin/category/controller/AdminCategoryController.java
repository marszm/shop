package com.example.shop.admin.category.controller;

import com.example.shop.admin.category.dto.AdminCategoryDto;
import com.example.shop.admin.category.model.AdminCategory;
import com.example.shop.admin.category.repository.AdminCategoryReoisitory;
import com.example.shop.admin.category.service.AdminCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.shop.admin.common.utils.SlugifyUtils.slugifySlug;

@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class AdminCategoryController {

    public static final Long EMPTY_ID = null;
    private final AdminCategoryService adminCategoryService;
    private final AdminCategoryReoisitory adminCategoryReoisitory;

    @GetMapping
    public List<AdminCategory> getCategories() {
        return adminCategoryService.getCategories();
    }

    @GetMapping("/{id}")
    public AdminCategory getCategory(@PathVariable Long id) {
        return adminCategoryService.getCategory(id);
    }

    @PostMapping
    public AdminCategory createCategory(@RequestBody AdminCategoryDto adminCategoryDto) {
        return adminCategoryService.createCategory(mapToAdminCategory(EMPTY_ID, adminCategoryDto));
    }

    private AdminCategory mapToAdminCategory(Long id, AdminCategoryDto adminCategoryDto) {
        return AdminCategory.builder()
                .id(id)
                .name(adminCategoryDto.getName())
                .description(adminCategoryDto.getDescription())
                .slug(slugifySlug(adminCategoryDto.getSlug()))
                .build();
    }

    @PutMapping("/{id}")
    public AdminCategory updateCategory(@PathVariable Long id, @RequestBody AdminCategoryDto adminCategoryDto) {
        return adminCategoryService.updateCategory(mapToAdminCategory(id, adminCategoryDto));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        adminCategoryService.deleteCategory(id);
    }
}
