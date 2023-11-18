package com.ntreddy.dd.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.domain.Perfume;
import com.ntreddy.dd.ecommerce.domain.Product;
import com.ntreddy.dd.ecommerce.dto.perfume.PerfumeSearchRequest;
import com.ntreddy.dd.ecommerce.enums.SearchPerfume;
import com.ntreddy.dd.ecommerce.repository.projection.PerfumeProjection;

import graphql.schema.DataFetcher;

public interface ProductService {
//
//    Perfume getPerfumeById(Long perfumeId);
//
//    Page<PerfumeProjection> getAllPerfumes(Pageable pageable);
//
//    List<PerfumeProjection> getPerfumesByIds(List<Long> perfumesId);
//
//    Page<PerfumeProjection> findPerfumesByFilterParams(PerfumeSearchRequest filter, Pageable pageable);
//
//    List<Perfume> findByPerfumer(String perfumer);
//
//    List<Perfume> findByPerfumeGender(String perfumeGender);
//    
//    Page<PerfumeProjection> findByInputText(SearchPerfume searchType, String text, Pageable pageable);

    Product saveProduct(Product product);

//    String deletePerfume(Long perfumeId);
//
//    DataFetcher<Perfume> getPerfumeByQuery();
//
//    DataFetcher<List<PerfumeProjection>> getAllPerfumesByQuery();
//
//    DataFetcher<List<Perfume>> getAllPerfumesByIdsQuery();
}
