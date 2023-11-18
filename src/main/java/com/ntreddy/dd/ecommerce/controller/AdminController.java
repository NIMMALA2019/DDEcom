
package com.ntreddy.dd.ecommerce.controller;

import static com.ntreddy.dd.ecommerce.constants.PathConstants.ADD;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1_ADMIN;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CATEGORY;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CATEGORY_ALL;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.DELETE;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.DELETE_BY_PERFUME_ID;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.EDIT;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.ORDERS;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.ORDER_BY_EMAIL;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.ORDER_DELETE;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.USER_ALL;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.USER_BY_ID;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.PRODUCT;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
//import com.gmail.merikbest2015.ecommerce.service.graphql.GraphQLProvider;
import com.ntreddy.dd.ecommerce.dto.HeaderResponse;
import com.ntreddy.dd.ecommerce.dto.Product.FullProductResponse;
import com.ntreddy.dd.ecommerce.dto.Product.ProductRequest;
import com.ntreddy.dd.ecommerce.dto.Product.ProductResponse;
import com.ntreddy.dd.ecommerce.dto.category.CategoryRequest;
import com.ntreddy.dd.ecommerce.dto.category.CategoryResponse;
import com.ntreddy.dd.ecommerce.dto.order.OrderResponse;
import com.ntreddy.dd.ecommerce.dto.perfume.FullPerfumeResponse;
import com.ntreddy.dd.ecommerce.dto.perfume.PerfumeRequest;
import com.ntreddy.dd.ecommerce.dto.user.BaseUserResponse;
import com.ntreddy.dd.ecommerce.dto.user.UserResponse;
import com.ntreddy.dd.ecommerce.mapper.CategoryMapper;
import com.ntreddy.dd.ecommerce.mapper.OrderMapper;
import com.ntreddy.dd.ecommerce.mapper.ProductMapper;
import com.ntreddy.dd.ecommerce.mapper.UserMapper;


@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping(API_V1_ADMIN)
public class AdminController {

	@Autowired
    private UserMapper userMapper;
	@Autowired
    private ProductMapper producteMapper;
	@Autowired
    private OrderMapper orderMapper;
	@Autowired
    private CategoryMapper categoryMapper;
	@Autowired
    private AmazonS3 amazonS3client;

    @Value("${amazon.s3.bucket.name}")
    private String bucketName;
    @Value("${spring.mail.username}")
    private String username;
    
    
    @Autowired
    private JavaMailSender mailSender;
    
//    private GraphQLProvider graphQLProvider;
    
    							//CATEGORY ADD
    
    @PostMapping(path = CATEGORY+ADD, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> addCategory(@RequestPart(name = "file", required = false) MultipartFile multipartFile,
                                                          @RequestPart("category") @Valid CategoryRequest category,
                                                          BindingResult bindingResult) throws IOException {
		CategoryRequest img = new CategoryRequest(category.getCategoryName(), category.getDescription(),
				compressBytes(multipartFile.getBytes()));
		CategoryResponse response=categoryMapper.saveCategory(img, bindingResult);
		response.setPicByte(decompressBytes(response.getPicByte()));
        return ResponseEntity.ok(response);
    }
    
    @PostMapping(path = CATEGORY+EDIT, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> updateCategory(@RequestPart(name = "file", required = false) MultipartFile file,
                                                          @RequestPart("category") @Valid CategoryRequest category,@PathVariable Long categoryId ,
                                                          BindingResult bindingResult) {
        return ResponseEntity.ok(categoryMapper.updateCategory(categoryId,category, file, bindingResult));
    }
    
    @PostMapping(path = CATEGORY+DELETE, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> deleteCategory(@RequestPart(name = "file", required = false) MultipartFile file,
                                                          @RequestPart("category") @Valid CategoryRequest category,@PathVariable Long categoryId ,
                                                          BindingResult bindingResult) {
        return ResponseEntity.ok(categoryMapper.updateCategory(categoryId,category, file, bindingResult));
    }
    
    @GetMapping(path=CATEGORY_ALL)
    public ResponseEntity<List<?>> getAllCategorys(@PageableDefault(size = 10) Pageable pageable) {
    	System.out.println("pageable*****"+pageable);
        HeaderResponse<CategoryResponse> response = categoryMapper.getAllCategorys(pageable);
        System.out.println(response.getHeaders());
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }
    
    
    
    //PRODUCT

//    @PostMapping(ADD)
//    public ResponseEntity<ProductResponse> addProuct(@RequestPart(name = "file", required = false) MultipartFile file,
//                                                          @RequestPart("product") @Valid ProductRequest product,
//                                                          BindingResult bindingResult) throws IOException {
//    	product.setPicture(file.getBytes());
//        return ResponseEntity.ok(producteMapper.saveProduct(product, file, bindingResult));
//    }
    
    @PostMapping(path = PRODUCT+ADD)
    public ResponseEntity<ProductResponse> addProuct(@RequestPart(name = "file", required = false) MultipartFile file,
    													@RequestPart("product") @Valid ProductRequest product,
    													BindingResult bindingResult) throws IOException {
    	product.setPicture(file.getBytes());
    	ProductResponse response=producteMapper.saveProduct(product, bindingResult);
		response.setPicture(decompressBytes(response.getPicture()));
        return ResponseEntity.ok(response);
    }

//    @PostMapping(EDIT)
//    public ResponseEntity<FullPerfumeResponse> updatePerfume(@RequestPart(name = "file", required = false) MultipartFile file,
//                                                             @RequestPart("perfume") @Valid PerfumeRequest perfume,
//                                                             BindingResult bindingResult) {
//        return ResponseEntity.ok(perfumeMapper.savePerfume(perfume, file, bindingResult));
//    }
//
//    @DeleteMapping(DELETE_BY_PERFUME_ID)
//    public ResponseEntity<String> deletePerfume(@PathVariable Long perfumeId) {
//        return ResponseEntity.ok(perfumeMapper.deletePerfume(perfumeId));
//    }

    //Category
    
//    @PostMapping(path = CATEGORY+ADD, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CategoryResponse> addCategory(@RequestPart(name = "file", required = false) MultipartFile multipartFile,
//    		 @RequestPart("category") CategoryRequest categorydto
//                                                          ) {
//    	 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//         long size = multipartFile.getSize();
//         String filecode ="312324";
////         String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
//          
//         CategoryResponse response = new CategoryResponse();
//         response.setFileName(fileName);
//         response.setSize(size);
//         response.setDownloadUri("/downloadFile/" + filecode);
//         return new ResponseEntity<>(response, HttpStatus.OK);
//    	
////        return ResponseEntity.ok(categoryMapper.saveCategory( file));
//    }
    
//    @PostMapping(path = CATEGORY+ADD, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CategoryResponse> addCategory(@RequestPart(name = "file", required = false) MultipartFile multipartFile,
//                                                          @RequestPart("category") @Valid CategoryRequest category,
//                                                          BindingResult bindingResult) throws IOException {
////    	File file =null;
//    	System.out.println(category.getCategoryName()+""+category.getDescription()+"*****multipartFile****"+multipartFile.isEmpty());
//		CategoryRequest img = new CategoryRequest(category.getCategoryName(), category.getDescription(),
//				compressBytes(multipartFile.getBytes()));
    	
//    	 if (multipartFile == null || multipartFile.isEmpty()) {
//         	category.setImageUrl(amazonS3client.getUrl(bucketName, "empty.jpg").toString());
//         } else {
//             file = new File(multipartFile.getOriginalFilename());
//             try (FileOutputStream fos = new FileOutputStream(file)) {
//                 fos.write(multipartFile.getBytes());
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             String fileName = UUID.randomUUID().toString() + "." + multipartFile.getOriginalFilename();
//             System.out.println("fileName*******>>>"+fileName);
//             System.out.println("bucketName****>>>"+bucketName);
//             System.out.println("file******>>>"+file);
//             System.out.println(new PutObjectRequest(bucketName, fileName, file));
//             amazonS3client.putObject(new PutObjectRequest(bucketName, fileName, file));
//            System.out.println("setImageUrl***********"+amazonS3client.getUrl(bucketName, fileName).toString());
//             category.setImageUrl(amazonS3client.getUrl(bucketName, fileName).toString());
//             file.delete();
//         }
//    	
//		CategoryResponse response=categoryMapper.saveCategory(img, bindingResult);
//		response.setPicByte(decompressBytes(response.getPicByte()));
//    	
//        return ResponseEntity.ok(response);
//    }
    
//    @PostMapping(CATEGORY+EDIT)
//    public ResponseEntity<CategoryResponse> updateCategory(@RequestPart(name = "file", required = false) MultipartFile file,
//                                                          @RequestPart("category") @Valid CategoryRequest category,@PathVariable Long categoryId ,
//                                                          BindingResult bindingResult) {
//        return ResponseEntity.ok(categoryMapper.updateCategory(categoryId,category, file, bindingResult));
//    }
    
    
    
    
    
    
//    @GetMapping(ORDERS)
//    public ResponseEntity<List<OrderResponse>> getAllCategorys(@PageableDefault(size = 10) Pageable pageable) {
//        HeaderResponse<OrderResponse> response = orderMapper.getAllOrders(pageable);
//        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
//    }
//    
    @GetMapping(ORDERS)
    public ResponseEntity<List<?>> getAllOrders(@PageableDefault(size = 10) Pageable pageable) {
        HeaderResponse<OrderResponse> response = orderMapper.getAllOrders(pageable);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }

    @GetMapping(ORDER_BY_EMAIL)
    public ResponseEntity<List<?>> getUserOrdersByEmail(@PathVariable String userEmail, 
                                                                    @PageableDefault(size = 10) Pageable pageable) {
        HeaderResponse<OrderResponse> response = orderMapper.getUserOrders(userEmail, pageable);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }

    @DeleteMapping(ORDER_DELETE)
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderMapper.deleteOrder(orderId));
    }

    @GetMapping(USER_BY_ID)
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userMapper.getUserById(userId));
    }

    @GetMapping(USER_ALL)
    public ResponseEntity<List<?>> getAllUsers(@PageableDefault(size = 10) Pageable pageable) {
        HeaderResponse<BaseUserResponse> response = userMapper.getAllUsers(pageable);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }

//    @PostMapping(GRAPHQL_USER)
//    public ResponseEntity<ExecutionResult> getUserByQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
//
//    @PostMapping(GRAPHQL_USER_ALL)
//    public ResponseEntity<ExecutionResult> getAllUsersByQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
//
//    @PostMapping(GRAPHQL_ORDERS)
//    public ResponseEntity<ExecutionResult> getAllOrdersQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
//
//    @PostMapping(GRAPHQL_ORDER)
//    public ResponseEntity<ExecutionResult> getUserOrdersByEmailQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
    
    
    public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
    
    public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}



