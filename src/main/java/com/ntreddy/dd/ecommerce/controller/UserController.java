package com.ntreddy.dd.ecommerce.controller;

import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1_USERS;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CART;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntreddy.dd.ecommerce.dto.perfume.PerfumeResponse;
import com.ntreddy.dd.ecommerce.dto.user.UpdateUserRequest;
import com.ntreddy.dd.ecommerce.dto.user.UserResponse;
import com.ntreddy.dd.ecommerce.mapper.UserMapper;
import com.ntreddy.dd.ecommerce.security.UserPrincipal;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_USERS)
public class UserController {
	
	@Autowired
    private UserMapper userMapper;
//	@Autowired
//    private GraphQLProvider graphQLProvider;

    @GetMapping
    public ResponseEntity<UserResponse> getUserInfo(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(userMapper.getUserInfo(user.getEmail()));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUserInfo(@AuthenticationPrincipal UserPrincipal user,
                                                       @Valid @RequestBody UpdateUserRequest request,
                                                       BindingResult bindingResult) {
        return ResponseEntity.ok(userMapper.updateUserInfo(user.getEmail(), request, bindingResult));
    }

    @PostMapping(CART)
    public ResponseEntity<List<PerfumeResponse>> getCart(@RequestBody List<Long> perfumesIds) {
        return ResponseEntity.ok(userMapper.getCart(perfumesIds));
    }

//    @PostMapping(GRAPHQL)
//    public ResponseEntity<ExecutionResult> getUserInfoByQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
}
