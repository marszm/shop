package com.example.shop.admin.controller;

import com.example.shop.admin.controller.dto.AdminProductDto;
import com.example.shop.admin.controller.dto.UploadResponse;
import com.example.shop.admin.model.AdminProduct;
import com.example.shop.admin.service.AdminProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
public class AdminProductController {
    private final AdminProductService adminProductService;

    @GetMapping("/admin/products")
    public Page<AdminProduct> getProducts(Pageable pageable) {
        return adminProductService.getProducts(pageable);
    }

    @GetMapping("/admin/product/{id}")
    public AdminProduct getProduct(@PathVariable Long id) {
        return adminProductService.getProduct(id);
    }

    @PostMapping("/admin/product")
    public AdminProduct createProduct(@RequestBody @Valid AdminProductDto adminProductDto) {
        return adminProductService.createProduct(AdminProduct.builder().name(adminProductDto.getName()).description(adminProductDto.getDescription()).category(adminProductDto.getCategory()).price(adminProductDto.getPrice()).currency(String.valueOf(adminProductDto.getCurrency())).image(adminProductDto.getImage()).build());
    }

    @PutMapping("/admin/product/{id}")
    public AdminProduct updateProduct(@RequestBody @Valid AdminProductDto adminProductDto, @PathVariable Long id) {
        return adminProductService.updateProduct(AdminProduct.builder().id(id).name(adminProductDto.getName()).description(adminProductDto.getDescription()).category(adminProductDto.getCategory()).price(adminProductDto.getPrice()).currency(String.valueOf(adminProductDto.getCurrency())).image(adminProductDto.getImage()).build());
    }

    @DeleteMapping("/admin/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        adminProductService.deleteProduct(id);
    }

    @PostMapping("admin/products/upload-image")
    public UploadResponse uploadImage(@RequestParam("file") MultipartFile multipartFile) {
        String filename = multipartFile.getOriginalFilename();
        String uploadDir = "./data/productImages/";
        Path filePath = Paths.get(uploadDir).resolve(filename);
        try (InputStream inputStream = multipartFile.getInputStream()) {
            OutputStream outputStream = Files.newOutputStream(filePath);
            inputStream.transferTo(outputStream);
            return new UploadResponse(filename);
        } catch (IOException e) {
            throw new RuntimeException("Can not save file!!!", e);
        }
    }

}
