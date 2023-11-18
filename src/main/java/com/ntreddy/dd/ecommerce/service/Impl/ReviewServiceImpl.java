package com.ntreddy.dd.ecommerce.service.Impl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntreddy.dd.ecommerce.domain.Perfume;
import com.ntreddy.dd.ecommerce.domain.Review;
import com.ntreddy.dd.ecommerce.exception.ApiRequestException;
import com.ntreddy.dd.ecommerce.repository.PerfumeRepository;
import com.ntreddy.dd.ecommerce.repository.ReviewRepository;
import com.ntreddy.dd.ecommerce.service.ReviewService;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.PERFUME_NOT_FOUND;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private PerfumeRepository perfumeRepository;
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviewsByPerfumeId(Long perfumeId) {
        Perfume perfume = perfumeRepository.findById(perfumeId)
                .orElseThrow(() -> new ApiRequestException(PERFUME_NOT_FOUND, HttpStatus.NOT_FOUND));
        return perfume.getReviews();
    }

    @Override
    @Transactional
    public Review addReviewToPerfume(Review review, Long perfumeId) {
        Perfume perfume = perfumeRepository.findById(perfumeId)
                .orElseThrow(() -> new ApiRequestException(PERFUME_NOT_FOUND, HttpStatus.NOT_FOUND));
        List<Review> reviews = perfume.getReviews();
        reviews.add(review);
        double totalReviews = reviews.size();
        double sumRating = reviews.stream().mapToInt(Review::getRating).sum();
        perfume.setPerfumeRating(sumRating / totalReviews);
        return reviewRepository.save(review);
    }
}
