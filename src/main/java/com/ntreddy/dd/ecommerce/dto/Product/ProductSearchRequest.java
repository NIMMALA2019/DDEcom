package com.ntreddy.dd.ecommerce.dto.Product;

import lombok.Data;

import java.util.List;

@Data
public class ProductSearchRequest {
    private List<String> perfumers;
    private List<String> genders;
    private List<Integer> prices;
    private Boolean sortByPrice;
    private String perfumer;
    private String perfumeGender;
	public List<String> getPerfumers() {
		return perfumers;
	}
	public void setPerfumers(List<String> perfumers) {
		this.perfumers = perfumers;
	}
	public List<String> getGenders() {
		return genders;
	}
	public void setGenders(List<String> genders) {
		this.genders = genders;
	}
	public List<Integer> getPrices() {
		return prices;
	}
	public void setPrices(List<Integer> prices) {
		this.prices = prices;
	}
	public Boolean getSortByPrice() {
		return sortByPrice;
	}
	public void setSortByPrice(Boolean sortByPrice) {
		this.sortByPrice = sortByPrice;
	}
	public String getPerfumer() {
		return perfumer;
	}
	public void setPerfumer(String perfumer) {
		this.perfumer = perfumer;
	}
	public String getPerfumeGender() {
		return perfumeGender;
	}
	public void setPerfumeGender(String perfumeGender) {
		this.perfumeGender = perfumeGender;
	}
    
    
}
