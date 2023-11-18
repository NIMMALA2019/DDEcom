package com.ntreddy.dd.ecommerce.dto.perfume;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FullPerfumeResponse extends PerfumeResponse {
    private Integer year;
    private String country;
    private String perfumeGender;
    private String fragranceTopNotes;
    private String fragranceMiddleNotes;
    private String fragranceBaseNotes;
    private String description;
    private String type;
    private MultipartFile file;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
    
    
}
