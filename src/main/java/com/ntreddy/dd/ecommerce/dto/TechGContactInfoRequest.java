package com.ntreddy.dd.ecommerce.dto;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.EMAIL_CANNOT_BE_EMPTY;
import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.EMPTY_FIRST_NAME;
import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.EMPTY_LAST_NAME;
import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.INCORRECT_EMAIL;
import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.EMPTY_PHONE_NUMBER;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TechGContactInfoRequest {

	@NotBlank(message = EMPTY_FIRST_NAME)
    private String firstName;

    @NotBlank(message = EMPTY_LAST_NAME)
    private String lastName;

    @Email(message = INCORRECT_EMAIL)
    @NotBlank(message = EMAIL_CANNOT_BE_EMPTY)
    private String email;
    
    @NotBlank(message = EMPTY_PHONE_NUMBER)
    private String mobileNo;
//    @NotBlank(message = "Message should not be empty.")
    private String message;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	

	
    
}
