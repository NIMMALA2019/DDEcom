package com.ntreddy.dd.ecommerce.dto;

import java.util.List;

import org.springframework.http.HttpHeaders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeaderResponse<T> {
    private List<?> items;
    private HttpHeaders headers;
	
	public List<?> getItems() {
		return items;
	}
	public void setItems(List<?> items) {
		this.items = items;
	}
	public HttpHeaders getHeaders() {
		return headers;
	}
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	public HeaderResponse(List<?> items, HttpHeaders headers) {
		super();
		this.items=items;
		this.headers=headers;
		
	}
    
    
}
