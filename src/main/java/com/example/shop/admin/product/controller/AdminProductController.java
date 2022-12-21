package com.example.shop.admin.product.controller;

import com.example.shop.admin.product.dto.AdminProductDto;
import com.example.shop.admin.product.dto.UploadResponse;
import com.example.shop.admin.product.service.AdminProductImageService;
import com.example.shop.admin.product.service.AdminProductService;
import com.example.shop.product.model.AdminProduct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.shop.admin.common.utils.SlugifyUtils.slugifySlug;

@RestController
@RequiredArgsConstructor
public class AdminProductController {
    private final AdminProductService adminProductService;
    private final AdminProductImageService adminProductImageService;

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
        return adminProductService.createProduct(AdminProduct.builder()
                .name(adminProductDto.getName())
                .description(adminProductDto.getDescription())
                .fullDescription(adminProductDto.getFullDescription())
                .categoryId(adminProductDto.getCategoryId())
                .price(adminProductDto.getPrice())
                .currency(String.valueOf(adminProductDto.getCurrency()))
                .image(adminProductDto.getImage())
                .slug(slugifySlug(adminProductDto.getSlug()))
                .build());
    }

    @PutMapping("/admin/product/{id}")
    public AdminProduct updateProduct(@RequestBody @Valid AdminProductDto adminProductDto, @PathVariable Long id) {
        return adminProductService.updateProduct(AdminProduct.builder()
                .id(id)
                .name(adminProductDto.getName())
                .description(adminProductDto.getDescription())
                .fullDescription(adminProductDto.getDescription())
                .categoryId(adminProductDto.getCategoryId())
                .price(adminProductDto.getPrice())
                .currency(String.valueOf(adminProductDto.getCurrency()))
                .image(adminProductDto.getImage())
                .slug(slugifySlug(adminProductDto.getSlug()))
                .build());
    }

    @DeleteMapping("/admin/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        adminProductService.deleteProduct(id);
    }

    @PostMapping("admin/products/upload-image")
    public UploadResponse uploadImage(@RequestParam("file") MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            String savedFile = adminProductImageService.uploadImage(multipartFile.getOriginalFilename(), inputStream);
            return new UploadResponse(savedFile);
        } catch (IOException e) {
            throw new RuntimeException("Smth went wrong during file loading ;(", e);
        }
    }

    @GetMapping("/data/productImages/{filename}")
    public ResponseEntity<Resource> serveFiles(@PathVariable String filename) throws IOException {
        Resource resource = adminProductImageService.serveFiles(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Path.of(filename)))
                .body(resource);
    }
}
