//package com.ntreddy.dd.ecommerce.dto.Product;
//
//import javax.validation.constraints.NotNull;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.ntreddy.dd.ecommerce.domain.Product;
//
//public class ProductDto {
//
//    private Integer id;
//    private @NotNull String name;
//    private @NotNull double price;
//    private @NotNull String description;
//    private byte[] proudct_img;
//    private @NotNull Integer categoryId;
//    private MultipartFile img;
//    
//
//    public ProductDto(Product product) {
//        this.setId(product.getId());
//        this.setName(product.getName());
//        this.setProudct_img(product.getProudct_img());
//        this.setDescription(product.getDescription());
//        this.setPrice(product.getPrice());
//        this.setCategoryId(product.getCategory().getId());
//    }
//
//    public ProductDto(@NotNull String name, @NotNull byte[] proudct_img,
//    		@NotNull double price, @NotNull String description, @NotNull Integer categoryId) {
//        this.name = name;
//        this.proudct_img = proudct_img;
//        this.price = price;
//        this.description = description;
//        this.categoryId = categoryId;
//    }
//
//    public ProductDto() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public byte[] getProudct_img() {
//		return proudct_img;
//	}
//
//	public void setProudct_img(byte[] proudct_img) {
//		this.proudct_img = proudct_img;
//	}
//
//	public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//	public MultipartFile getImg() {
//		return img;
//	}
//
//	public void setImg(MultipartFile img) {
//		this.img = img;
//	}
//    
//    
//}
