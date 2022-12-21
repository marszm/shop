package com.example.shop.admin.review.service;

import com.example.shop.admin.review.model.AdminReview;
import com.example.shop.admin.review.repository.AdminReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminReviewService {

    private final AdminReviewRepository adminReviewRepository;

    public List<AdminReview> getReviews() {
        return adminReviewRepository.findAll();
    }

    public void delete(Long id) {
        adminReviewRepository.deleteById(id);
    }

    public void moderate(Long id) {
        adminReviewRepository.moderate(id);
    }
}
