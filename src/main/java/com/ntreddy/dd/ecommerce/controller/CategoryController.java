package com.ntreddy.dd.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntreddy.dd.ecommerce.mapper.CategoryMapper;


@RestController
@RequestMapping("/category")

public class CategoryController {

//	@Autowired
//	private CategoryService categoryService;
	@Autowired
    private CategoryMapper categoryMapper;

	
//	@GetMapping
//    public ResponseEntity<List<Category>> getCategories(@PageableDefault(size = 15) Pageable pageable) {
//        HeaderResponse<Category> response = categoryMapper.getAllCategories(pageable);
//        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
//    }

//	@PostMapping("/create")
//	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
//		if (Helper.notNull(categoryService.readCategory(category.getCategoryName()))) {
//			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
//		}
//		categoryService.createCategory(category);
//		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
//	}
//
//	@PostMapping("/update/{categoryID}")
//	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryID, @Valid @RequestBody Category category) {
//		// Check to see if the category exists.
//		if (Helper.notNull(categoryService.readCategory(categoryID))) {
//			// If the category exists then update it.
//			categoryService.updateCategory(categoryID, category);
//			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
//		}
//
//		// If the category doesn't exist then return a response of unsuccessful.
//		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
//	}
}
