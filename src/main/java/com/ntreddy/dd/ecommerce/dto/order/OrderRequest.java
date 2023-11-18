package com.ntreddy.dd.ecommerce.dto.order;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.*;

import java.util.Map;

@Data
public class OrderRequest {

    private Double totalPrice;
    private Map<Long, Long> perfumesId;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    private String firstName;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    private String lastName;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    private String city;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    private String address;

    @Email(message = INCORRECT_EMAIL)
    @NotBlank(message = EMAIL_CANNOT_BE_EMPTY)
    private String email;

    @NotBlank(message = EMPTY_PHONE_NUMBER)
    private String phoneNumber;

    @NotNull(message = EMPTY_POST_INDEX)
    @Min(value = 5, message = "Post index must contain 5 digits")
    private Integer postIndex;

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<Long, Long> getPerfumesId() {
		return perfumesId;
	}

	public void setPerfumesId(Map<Long, Long> perfumesId) {
		this.perfumesId = perfumesId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getPostIndex() {
		return postIndex;
	}

	public void setPostIndex(Integer postIndex) {
		this.postIndex = postIndex;
	}
    
    
}
