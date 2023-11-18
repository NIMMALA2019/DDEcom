package com.ntreddy.dd.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntreddy.dd.ecommerce.domain.TechGContactInfo;

@Repository
public interface TechGContactInfoRepository extends JpaRepository<TechGContactInfo, Long> {

	Optional<TechGContactInfo> findByEmail(String email);
}
