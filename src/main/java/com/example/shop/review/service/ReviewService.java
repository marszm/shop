package com.example.shop.review.service;

import com.example.shop.review.model.Review;
import com.example.shop.review.reoisitory.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
