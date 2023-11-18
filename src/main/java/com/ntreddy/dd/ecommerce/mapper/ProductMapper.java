package com.ntreddy.dd.ecommerce.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.domain.Product;
import com.ntreddy.dd.ecommerce.dto.HeaderResponse;
import com.ntreddy.dd.ecommerce.dto.Product.FullProductResponse;
import com.ntreddy.dd.ecommerce.dto.Product.ProductRequest;
import com.ntreddy.dd.ecommerce.dto.Product.ProductResponse;
import com.ntreddy.dd.ecommerce.dto.perfume.FullPerfumeResponse;
import com.ntreddy.dd.ecommerce.dto.perfume.PerfumeResponse;
import com.ntreddy.dd.ecommerce.dto.perfume.PerfumeSearchRequest;
import com.ntreddy.dd.ecommerce.enums.SearchPerfume;
import com.ntreddy.dd.ecommerce.exception.InputFieldException;
import com.ntreddy.dd.ecommerce.repository.projection.PerfumeProjection;
import com.ntreddy.dd.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper {

	@Autowired
    private CommonMapper commonMapper;
	@Autowired
    private ProductService productService;

//    public FullPerfumeResponse getPerfumeById(Long perfumeId) {
//        return commonMapper.convertToResponse(perfumeService.getPerfumeById(perfumeId), FullPerfumeResponse.class);
//    }
//
//    public List<PerfumeResponse> getPerfumesByIds(List<Long> perfumesId) {
//        return commonMapper.convertToResponseList(perfumeService.getPerfumesByIds(perfumesId), PerfumeResponse.class);
//    }
//
//    public HeaderResponse<PerfumeResponse> getAllPerfumes(Pageable pageable) {
//        Page<PerfumeProjection> perfumes = perfumeService.getAllPerfumes(pageable);
//        return commonMapper.getHeaderResponse(perfumes.getContent(), perfumes.getTotalPages(), perfumes.getTotalElements(), PerfumeResponse.class);
//    }
//
//    public HeaderResponse<PerfumeResponse> findPerfumesByFilterParams(PerfumeSearchRequest filter, Pageable pageable) {
//        Page<PerfumeProjection> perfumes = perfumeService.findPerfumesByFilterParams(filter, pageable);
//        return commonMapper.getHeaderResponse(perfumes.getContent(), perfumes.getTotalPages(), perfumes.getTotalElements(), PerfumeResponse.class);
//    }
//
//    public List<PerfumeResponse> findByPerfumer(String perfumer) {
//        return commonMapper.convertToResponseList(perfumeService.findByPerfumer(perfumer), PerfumeResponse.class);
//    }
//
//    public List<PerfumeResponse> findByPerfumeGender(String perfumeGender) {
//        return commonMapper.convertToResponseList(perfumeService.findByPerfumeGender(perfumeGender), PerfumeResponse.class);
//    }
//    
//    public HeaderResponse<PerfumeResponse> findByInputText(SearchPerfume searchType, String text, Pageable pageable) {
//        Page<PerfumeProjection> perfumes = perfumeService.findByInputText(searchType, text, pageable);
//        return commonMapper.getHeaderResponse(perfumes.getContent(), perfumes.getTotalPages(), perfumes.getTotalElements(), PerfumeResponse.class);
//    }

    public ProductResponse saveProduct(ProductRequest productRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        Product product = commonMapper.convertToEntity(productRequest, Product.class);
        return commonMapper.convertToResponse(productService.saveProduct(product), ProductResponse.class);
    }

//    public String deletePerfume(Long perfumeId) {
//        return perfumeService.deletePerfume(perfumeId);
//    }
}
