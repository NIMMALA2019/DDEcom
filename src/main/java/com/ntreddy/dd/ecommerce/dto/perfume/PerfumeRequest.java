package com.ntreddy.dd.ecommerce.dto.perfume;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.FILL_IN_THE_INPUT_FIELD;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PerfumeRequest {

    private Long id;
    private String filename;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String perfumeTitle;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String perfumer;

    @NotNull(message = FILL_IN_THE_INPUT_FIELD)
    private Integer year;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String country;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String perfumeGender;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String fragranceTopNotes;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String fragranceMiddleNotes;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String fragranceBaseNotes;

    @NotNull(message = FILL_IN_THE_INPUT_FIELD)
    private Integer price;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String volume;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    @Length(max = 255)
    private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPerfumeGender() {
		return perfumeGender;
	}

	public void setPerfumeGender(String perfumeGender) {
		this.perfumeGender = perfumeGender;
	}

	public String getFragranceTopNotes() {
		return fragranceTopNotes;
	}

	public void setFragranceTopNotes(String fragranceTopNotes) {
		this.fragranceTopNotes = fragranceTopNotes;
	}

	public String getFragranceMiddleNotes() {
		return fragranceMiddleNotes;
	}

	public void setFragranceMiddleNotes(String fragranceMiddleNotes) {
		this.fragranceMiddleNotes = fragranceMiddleNotes;
	}

	public String getFragranceBaseNotes() {
		return fragranceBaseNotes;
	}

	public void setFragranceBaseNotes(String fragranceBaseNotes) {
		this.fragranceBaseNotes = fragranceBaseNotes;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
}
