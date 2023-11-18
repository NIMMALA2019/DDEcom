package com.ntreddy.dd.ecommerce.service.Impl;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.CATEGORY_INDEX;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

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
import com.ntreddy.dd.ecommerce.domain.Category;
import com.ntreddy.dd.ecommerce.domain.Order;
import com.ntreddy.dd.ecommerce.dto.category.CategoryResponse;
import com.ntreddy.dd.ecommerce.exception.ApiRequestException;
import com.ntreddy.dd.ecommerce.repository.CategoryRepository;
import com.ntreddy.dd.ecommerce.repository.OrderItemRepository;
import com.ntreddy.dd.ecommerce.repository.OrderRepository;
import com.ntreddy.dd.ecommerce.service.CategoryService;
import com.ntreddy.dd.ecommerce.service.email.MailSender;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    private OrderRepository orderRepository;
	@Autowired
    private OrderItemRepository orderItemRepository;
	@Autowired
    private CategoryRepository categoryRepository;
	@Autowired
    private MailSender mailSender;
	@Autowired
    private AmazonS3 amazonS3client;

    @Value("${amazon.s3.bucket.name}")
    private String bucketName;
    
	@Override
	@Transactional
	public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
	@Override
	public Page<CategoryResponse> getAllOrders(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Transactional
	public Category updateCategory(Long categoryId, Category categorynew, MultipartFile multipartFile) {
		Category categoryexist = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ApiRequestException(CATEGORY_INDEX, HttpStatus.NOT_FOUND));
		categoryexist = categoryRepository.findById(categoryId).get();
		categoryexist.setCategoryName(categorynew.getCategoryName());
		categoryexist.setDescription(categorynew.getDescription());
//        if (multipartFile == null) {
//        	categoryexist.setImageUrl(amazonS3client.getUrl(bucketName, "empty.jpg").toString());
//        } else {
//            File file = new File(multipartFile.getOriginalFilename());
//            try (FileOutputStream fos = new FileOutputStream(file)) {
//                fos.write(multipartFile.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            String fileName = UUID.randomUUID().toString() + "." + multipartFile.getOriginalFilename();
//            amazonS3client.putObject(new PutObjectRequest(bucketName, fileName, file));
//            categoryexist.setImageUrl(amazonS3client.getUrl(bucketName, fileName).toString());
//            file.delete();
//        }
        return categoryRepository.save(categoryexist);
    
	}
	@Override
	public Page<Category> getAllCategorys(Pageable pageable) {
	        return categoryRepository.findAllByOrderByIdAsc(pageable);
	}
    
}
