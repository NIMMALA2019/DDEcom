package com.ntreddy.dd.ecommerce.mapper;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.ntreddy.dd.ecommerce.domain.Review;
import com.ntreddy.dd.ecommerce.dto.review.ReviewRequest;
import com.ntreddy.dd.ecommerce.dto.review.ReviewResponse;
import com.ntreddy.dd.ecommerce.exception.InputFieldException;
import com.ntreddy.dd.ecommerce.service.ReviewService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewMapper {

	@Autowired
    private CommonMapper commonMapper;
    private ReviewService reviewService;

    public List<ReviewResponse> getReviewsByPerfumeId(Long perfumeId) {
        return commonMapper.convertToResponseList(reviewService.getReviewsByPerfumeId(perfumeId), ReviewResponse.class);
    }

    public ReviewResponse addReviewToPerfume(ReviewRequest reviewRequest, Long perfumeId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        Review review = commonMapper.convertToEntity(reviewRequest, Review.class);
        return commonMapper.convertToResponse(reviewService.addReviewToPerfume(review, perfumeId), ReviewResponse.class);
    }
}
