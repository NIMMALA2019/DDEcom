package com.ntreddy.dd.ecommerce.service;

import java.util.List;

import com.ntreddy.dd.ecommerce.domain.Review;

public interface ReviewService {

    List<Review> getReviewsByPerfumeId(Long perfumeId);

    Review addReviewToPerfume(Review review, Long perfumeId);
}
