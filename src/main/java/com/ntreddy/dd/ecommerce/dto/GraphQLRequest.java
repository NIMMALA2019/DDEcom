package com.ntreddy.dd.ecommerce.dto;

import lombok.Data;

@Data
public class GraphQLRequest {
    private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
    
}
