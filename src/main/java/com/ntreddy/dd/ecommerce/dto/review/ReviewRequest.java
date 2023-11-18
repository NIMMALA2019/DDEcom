package com.ntreddy.dd.ecommerce.dto.review;

import lombok.Data;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.FILL_IN_THE_INPUT_FIELD;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReviewRequest {

    private Long perfumeId;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    private String author;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    private String message;

    @NotNull(message = "Choose perfume rating")
    private Integer rating;

	public Long getPerfumeId() {
		return perfumeId;
	}

	public void setPerfumeId(Long perfumeId) {
		this.perfumeId = perfumeId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
    
    
}
