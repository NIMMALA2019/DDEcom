package com.ntreddy.dd.ecommerce.dto;

import lombok.Data;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.PASSWORD2_CHARACTER_LENGTH;
import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.PASSWORD_CHARACTER_LENGTH;

import javax.validation.constraints.Size;

@Data
public class PasswordResetRequest {

    private String email;

    @Size(min = 6, max = 16, message = PASSWORD_CHARACTER_LENGTH)
    private String password;

    @Size(min = 6, max = 16, message = PASSWORD2_CHARACTER_LENGTH)
    private String password2;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
    
    
}
