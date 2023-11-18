package com.ntreddy.dd.ecommerce.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ntreddy.dd.ecommerce.dto.RegistrationRequest;
import com.ntreddy.dd.ecommerce.mapper.AuthenticationMapper;

import static com.ntreddy.dd.ecommerce.constants.PathConstants.ACTIVATE_CODE;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1_REGISTRATION;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_REGISTRATION)
public class RegistrationController {
	
	@Autowired
    private AuthenticationMapper authenticationMapper;

    @PostMapping
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationRequest user, BindingResult bindingResult) {
        return ResponseEntity.ok(authenticationMapper.registerUser(user.getCaptcha(), user, bindingResult));
    }

    @GetMapping(ACTIVATE_CODE)
    public ResponseEntity<String> activateEmailCode(@PathVariable String code) {
        return ResponseEntity.ok(authenticationMapper.activateUser(code));
    }
}
