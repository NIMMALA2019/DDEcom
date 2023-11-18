package com.ntreddy.dd.ecommerce.dto.category;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.FILL_IN_THE_INPUT_FIELD;
import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.IMAGE_CAT_INDEX;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {
	
	
	
	@NotBlank(message = FILL_IN_THE_INPUT_FIELD)
	private String categoryName;
	@NotBlank(message = FILL_IN_THE_INPUT_FIELD)
	private String description;
	private byte[] picByte;
	
	
	public CategoryRequest(@NotBlank String categoryName, @NotBlank String description, byte[] picByte) {
		this.categoryName = categoryName;
		this.description = description;
		this.picByte = picByte;
	}

	
	public String getCategoryName() {
		return categoryName;
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
	public byte[] getPicByte() {
		return picByte;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	

	
}
