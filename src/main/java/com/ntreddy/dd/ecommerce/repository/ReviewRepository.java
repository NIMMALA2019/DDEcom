package com.ntreddy.dd.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntreddy.dd.ecommerce.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
