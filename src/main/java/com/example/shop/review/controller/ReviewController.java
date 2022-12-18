package com.example.shop.review.controller;

import com.example.shop.review.dto.ReviewDto;
import com.example.shop.review.model.Review;
import com.example.shop.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/Rewiev")
    public Review addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(Review.builder()
                .authorName(reviewDto.authorName())
                .productId(reviewDto.productId())
                .content(reviewDto.content())
                .build());
    }
}