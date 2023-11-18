package com.ntreddy.dd.ecommerce.dto.perfume;

import com.ntreddy.dd.ecommerce.enums.SearchPerfume;

import lombok.Data;

@Data
public class SearchTypeRequest {
    private SearchPerfume searchType;
    private String text;
	public SearchPerfume getSearchType() {
		return searchType;
	}
	public void setSearchType(SearchPerfume searchType) {
		this.searchType = searchType;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
    
    
}
