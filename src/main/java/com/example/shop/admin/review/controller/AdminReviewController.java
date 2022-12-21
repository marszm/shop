package com.example.shop.admin.review.controller;

import com.example.shop.admin.review.model.AdminReview;
import com.example.shop.admin.review.service.AdminReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/reviews")
public class AdminReviewController {

    private final AdminReviewService adminReviewService;

    @GetMapping
    public List<AdminReview> getReviews() {
        return adminReviewService.getReviews();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adminReviewService.delete(id);
    }

    @PostMapping("/{id}/moderate")
    public void moderate(@PathVariable Long id) {
        adminReviewService.moderate(id);
    }
}
