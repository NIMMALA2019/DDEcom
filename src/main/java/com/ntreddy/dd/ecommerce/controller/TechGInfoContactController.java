package com.ntreddy.dd.ecommerce.controller;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.ERROR_MSG;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1_TECHG_INFO_CONTACT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntreddy.dd.ecommerce.dto.ApiResponse;
import com.ntreddy.dd.ecommerce.dto.TechGContactInfoRequest;
import com.ntreddy.dd.ecommerce.mapper.TechGContactInfoMapper;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_TECHG_INFO_CONTACT)
public class TechGInfoContactController {

	@Autowired
    private TechGContactInfoMapper techGcontactinfoMapper;
   @PostMapping
    public ResponseEntity<ApiResponse> registration(@Valid @RequestBody TechGContactInfoRequest user, BindingResult bindingResult) {
    	String msg=ERROR_MSG;
    	String status= techGcontactinfoMapper.registerUser(user, bindingResult);
    	if("SUCCESS".equals(status))
    		msg="Request submitted successfully";
    	
    	return new ResponseEntity<ApiResponse>(new ApiResponse(msg), HttpStatus.CREATED);
    	//return ResponseEntity.ok(techGcontactinfoMapper.registerUser(user, bindingResult));
    }
}
