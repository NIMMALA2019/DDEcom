//package com.ntreddy.dd.ecommerce.admin.controller;
//
//import static com.ntreddy.dd.ecommerce.constants.PathConstants.ADD;
//import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1_ADMIN;
//import static com.ntreddy.dd.ecommerce.constants.PathConstants.CATEGORY;
//import static com.ntreddy.dd.ecommerce.constants.PathConstants.CATEGORY_ALL;
//import static com.ntreddy.dd.ecommerce.constants.PathConstants.EDIT;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//import java.util.zip.DataFormatException;
//import java.util.zip.Deflater;
//import java.util.zip.Inflater;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
////import com.gmail.merikbest2015.ecommerce.service.graphql.GraphQLProvider;
//import com.ntreddy.dd.ecommerce.dto.HeaderResponse;
//import com.ntreddy.dd.ecommerce.dto.category.CategoryRequest;
//import com.ntreddy.dd.ecommerce.dto.category.CategoryResponse;
//import com.ntreddy.dd.ecommerce.mapper.CategoryMapper;
//
//@RestController
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//@RequestMapping(API_V1_ADMIN)
//public class AdminCategoryController {
//
//	@Autowired
//    private CategoryMapper categoryMapper;
//
//    @Value("${amazon.s3.bucket.name}")
//    private String bucketName;
//    @Value("${spring.mail.username}")
//    private String username;
//
//    @PostMapping(path = CATEGORY+ADD, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CategoryResponse> addCategory(@RequestPart(name = "file", required = false) MultipartFile multipartFile,
//                                                          @RequestPart("category") @Valid CategoryRequest category,
//                                                          BindingResult bindingResult) throws IOException {
//		CategoryRequest img = new CategoryRequest(category.getCategoryName(), category.getDescription(),
//				compressBytes(multipartFile.getBytes()));
//		CategoryResponse response=categoryMapper.saveCategory(img, bindingResult);
//		response.setPicByte(decompressBytes(response.getPicByte()));
//        return ResponseEntity.ok(response);
//    }
//    
//    @PostMapping(path = CATEGORY+EDIT, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CategoryResponse> updateCategory(@RequestPart(name = "file", required = false) MultipartFile file,
//                                                          @RequestPart("category") @Valid CategoryRequest category,@PathVariable Long categoryId ,
//                                                          BindingResult bindingResult) {
//        return ResponseEntity.ok(categoryMapper.updateCategory(categoryId,category, file, bindingResult));
//    }
//    
//    @GetMapping(path=CATEGORY_ALL)
//    public ResponseEntity<List<CategoryResponse>> getAllCategorys(@PageableDefault(size = 10) Pageable pageable) {
//    	System.out.println("pageable*****"+pageable);
//        HeaderResponse<CategoryResponse> response = categoryMapper.getAllCategorys(pageable);
//        System.out.println(response.getHeaders());
//        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
//    }
//    
////    @GetMapping(ORDERS)
////    public ResponseEntity<List<OrderResponse>> getAllOrders(@PageableDefault(size = 10) Pageable pageable) {
////        HeaderResponse<OrderResponse> response = orderMapper.getAllOrders(pageable);
////        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
////    }
////
////    @GetMapping(ORDER_BY_EMAIL)
////    public ResponseEntity<List<OrderResponse>> getUserOrdersByEmail(@PathVariable String userEmail, 
////                                                                    @PageableDefault(size = 10) Pageable pageable) {
////        HeaderResponse<OrderResponse> response = orderMapper.getUserOrders(userEmail, pageable);
////        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
////    }
////
////    @DeleteMapping(ORDER_DELETE)
////    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
////        return ResponseEntity.ok(orderMapper.deleteOrder(orderId));
////    }
////
////    @GetMapping(USER_BY_ID)
////    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) {
////        return ResponseEntity.ok(userMapper.getUserById(userId));
////    }
////
////    @GetMapping(USER_ALL)
////    public ResponseEntity<List<BaseUserResponse>> getAllUsers(@PageableDefault(size = 10) Pageable pageable) {
////        HeaderResponse<BaseUserResponse> response = userMapper.getAllUsers(pageable);
////        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
////    }
//
//    
//    public static byte[] compressBytes(byte[] data) {
//		Deflater deflater = new Deflater();
//		deflater.setInput(data);
//		deflater.finish();
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		while (!deflater.finished()) {
//			int count = deflater.deflate(buffer);
//			outputStream.write(buffer, 0, count);
//		}
//		try {
//			outputStream.close();
//		} catch (IOException e) {
//		}
//		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//		return outputStream.toByteArray();
//	}
//    
//    public static byte[] decompressBytes(byte[] data) {
//		Inflater inflater = new Inflater();
//		inflater.setInput(data);
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		try {
//			while (!inflater.finished()) {
//				int count = inflater.inflate(buffer);
//				outputStream.write(buffer, 0, count);
//			}
//			outputStream.close();
//		} catch (IOException ioe) {
//		} catch (DataFormatException e) {
//		}
//		return outputStream.toByteArray();
//	}
//}
