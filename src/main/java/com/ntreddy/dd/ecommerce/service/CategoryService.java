package com.ntreddy.dd.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.domain.Category;
import com.ntreddy.dd.ecommerce.dto.category.CategoryResponse;


public interface CategoryService {
	Category saveCategory(Category category);
	Page<CategoryResponse> getAllOrders(Pageable pageable);
	Category updateCategory(Long categoryId, Category category, MultipartFile file);
	Page<Category> getAllCategorys(Pageable pageable);

}
