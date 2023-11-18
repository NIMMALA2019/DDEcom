package com.ntreddy.dd.ecommerce.service.Impl;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.PERFUME_NOT_FOUND;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ntreddy.dd.ecommerce.domain.Perfume;
import com.ntreddy.dd.ecommerce.domain.Product;
import com.ntreddy.dd.ecommerce.dto.perfume.PerfumeSearchRequest;
import com.ntreddy.dd.ecommerce.enums.SearchPerfume;
import com.ntreddy.dd.ecommerce.exception.ApiRequestException;
import com.ntreddy.dd.ecommerce.repository.PerfumeRepository;
import com.ntreddy.dd.ecommerce.repository.ProductRepository;
import com.ntreddy.dd.ecommerce.repository.projection.PerfumeProjection;
import com.ntreddy.dd.ecommerce.service.ProductService;

import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


	@Autowired
    private ProductRepository productRepository;
    private AmazonS3 amazonS3client;

    @Value("${amazon.s3.bucket.name}")
    private String bucketName;

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


}
