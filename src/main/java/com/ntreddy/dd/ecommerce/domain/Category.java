package com.ntreddy.dd.ecommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.ToString;

import java.util.Set;

@ToString
@Entity
@Table(name = "Categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category_name")
	private @NotBlank String categoryName;

	private @NotBlank String description;

//	private @NotBlank String imageUrl;
	@Column(name = "picByte", length = 1000)
	private byte[] picByte;

	// add imageURL here

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	Set<Product> products;

	
//	public Category(@NotBlank String categoryName, @NotBlank String description) {
//		this.categoryName = categoryName;
//		this.description = description;
//	}
//
//	public Category(@NotBlank String categoryName, @NotBlank String description, @NotBlank byte[] picByte) {
//		this.categoryName = categoryName;
//		this.description = description;
//		this.picByte = picByte;
//	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "User {category id=" + id + ", category name='" + categoryName + "', description='" + description + "'}";
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
