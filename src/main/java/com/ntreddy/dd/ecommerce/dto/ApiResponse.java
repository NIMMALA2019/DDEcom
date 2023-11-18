package com.ntreddy.dd.ecommerce.dto;

import lombok.Data;

@Data
public class ApiResponse {

	
    private String message;

	
	public ApiResponse(String msg) {
		this.message=msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	

	
    
}
