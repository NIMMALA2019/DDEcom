package com.ntreddy.dd.ecommerce.mapper;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.EMAIL_NOT_FOUND;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.domain.Category;
import com.ntreddy.dd.ecommerce.domain.Order;
import com.ntreddy.dd.ecommerce.domain.User;
import com.ntreddy.dd.ecommerce.dto.HeaderResponse;
import com.ntreddy.dd.ecommerce.dto.category.CategoryRequest;
import com.ntreddy.dd.ecommerce.dto.category.CategoryResponse;
import com.ntreddy.dd.ecommerce.dto.order.OrderResponse;
import com.ntreddy.dd.ecommerce.exception.ApiRequestException;
import com.ntreddy.dd.ecommerce.exception.InputFieldException;
import com.ntreddy.dd.ecommerce.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

	@Autowired
    private CommonMapper commonMapper;
	@Autowired
    private CategoryService categoryService;
    
    
    public CategoryResponse saveCategory(CategoryRequest categoryRequest, BindingResult bindingResult) {
    	System.out.println("count****"+bindingResult.getErrorCount());
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        Category category = commonMapper.convertToEntity(categoryRequest, Category.class);
        return commonMapper.convertToResponse(categoryService.saveCategory(category), CategoryResponse.class);
    }


	public CategoryResponse updateCategory(Long categoryId, @Valid CategoryRequest categoryRequest, MultipartFile file,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
		 Category category = commonMapper.convertToEntity(categoryRequest, Category.class);
		 return commonMapper.convertToResponse(categoryService.updateCategory(categoryId,category, file), CategoryResponse.class);
	}


	public HeaderResponse<CategoryResponse> getAllCategorys(Pageable pageable) {
        Page<Category> categoryList = categoryService.getAllCategorys(pageable);
        System.out.println("categoryList********"+categoryList );
        return commonMapper.getHeaderResponse(categoryList.getContent(), categoryList.getTotalPages(), categoryList.getTotalElements(), CategoryResponse.class);
	}

    
//    public HeaderResponse<CategoryResponse> getAllCategories(Pageable pageable) {
//        Page<PerfumeProjection> perfumes = categoryService.getAllPerfumes(pageable);
//        return commonMapper.getHeaderResponse(perfumes.getContent(), perfumes.getTotalPages(), perfumes.getTotalElements(), PerfumeResponse.class);
//    }
    
//    public OrderResponse getOrderById(Long orderId) {
//        return commonMapper.convertToResponse(orderService.getOrderById(orderId), OrderResponse.class);
//    }
//    
//    public List<OrderItemResponse> getOrderItemsByOrderId(Long orderId) {
//        return commonMapper.convertToResponseList(orderService.getOrderItemsByOrderId(orderId), OrderItemResponse.class);
//    }
//
//    public HeaderResponse<OrderResponse> getAllOrders(Pageable pageable) {
//        Page<Order> orders = orderService.getAllOrders(pageable);
//        return commonMapper.getHeaderResponse(orders.getContent(), orders.getTotalPages(), orders.getTotalElements(), OrderResponse.class);
//    }
//
//    public HeaderResponse<OrderResponse> getUserOrders(String email, Pageable pageable) {
//        Page<Order> orders = orderService.getUserOrders(email, pageable);
//        return commonMapper.getHeaderResponse(orders.getContent(), orders.getTotalPages(), orders.getTotalElements(), OrderResponse.class);
//    }
//
//    public String deleteOrder(Long orderId) {
//        return orderService.deleteOrder(orderId);
//    }
//
//    public OrderResponse postOrder(OrderRequest orderRequest, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new InputFieldException(bindingResult);
//        }
//        Order order = orderService.postOrder(commonMapper.convertToEntity(orderRequest, Order.class), orderRequest.getPerfumesId());
//        return commonMapper.convertToResponse(order, OrderResponse.class);
//    }
}
