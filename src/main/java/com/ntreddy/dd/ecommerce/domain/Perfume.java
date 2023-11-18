package com.ntreddy.dd.ecommerce.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.ToString;


@Entity
@Table(name = "perfume")
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfume_id_seq")
    @SequenceGenerator(name = "perfume_id_seq", sequenceName = "perfume_id_seq", initialValue = 109, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "perfume_title")
    private String perfumeTitle;

    @Column(name = "perfumer")
    private String perfumer;

    @Column(name = "year")
    private Integer year;
    
    @Column(name = "country")
    private String country;

    @Column(name = "perfume_gender")
    private String perfumeGender;

    @Column(name = "fragrance_top_notes")
    private String fragranceTopNotes;

    @Column(name = "fragrance_middle_notes")
    private String fragranceMiddleNotes;
    
    @Column(name = "fragrance_base_notes")
    private String fragranceBaseNotes;

    @Column(name = "description")
    private String description;
    
    @Column(name = "filename")
    private String filename;
    
    @Column(name = "price")
    private Integer price;
    
    @Column(name = "volume")
    private String volume;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "perfume_rating")
    private Double perfumeRating;

    @OneToMany
    @ToString.Exclude
    private List<Review> reviews;

    
    
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
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

	public Double getPerfumeRating() {
		return perfumeRating;
	}

	public void setPerfumeRating(Double perfumeRating) {
		this.perfumeRating = perfumeRating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfume perfume = (Perfume) o;
        return Objects.equals(id, perfume.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
