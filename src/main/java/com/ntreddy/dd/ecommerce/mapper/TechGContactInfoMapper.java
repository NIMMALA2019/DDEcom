package com.ntreddy.dd.ecommerce.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.ntreddy.dd.ecommerce.domain.TechGContactInfo;
import com.ntreddy.dd.ecommerce.dto.TechGContactInfoRequest;
import com.ntreddy.dd.ecommerce.exception.InputFieldException;
import com.ntreddy.dd.ecommerce.service.TechGContactInfoService;

@Component
public class TechGContactInfoMapper {

	@Autowired
    private TechGContactInfoService techGService;
	@Autowired
    private CommonMapper commonMapper;
  

    public String registerUser(TechGContactInfoRequest registrationRequest, BindingResult bindingResult) {
       
    	if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        TechGContactInfo user = commonMapper.convertToEntity(registrationRequest, TechGContactInfo.class);
        return techGService.registerUser(user);
    }
}
