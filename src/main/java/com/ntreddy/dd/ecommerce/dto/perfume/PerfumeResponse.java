package com.ntreddy.dd.ecommerce.dto.perfume;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfumeResponse {
    private Long id;
    private String perfumeTitle;
    private String perfumer;
    private Integer price;
    private Double perfumeRating;
    private String filename;
    private Integer reviewsCount;
    private String volume;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPerfumeTitle() {
		return perfumeTitle;
	}
	public void setPerfumeTitle(String perfumeTitle) {
		this.perfumeTitle = perfumeTitle;
	}
	public String getPerfumer() {
		return perfumer;
	}
	public void setPerfumer(String perfumer) {
		this.perfumer = perfumer;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Double getPerfumeRating() {
		return perfumeRating;
	}
	public void setPerfumeRating(Double perfumeRating) {
		this.perfumeRating = perfumeRating;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Integer getReviewsCount() {
		return reviewsCount;
	}
	public void setReviewsCount(Integer reviewsCount) {
		this.reviewsCount = reviewsCount;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
    
    
}
