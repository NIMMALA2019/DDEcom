package com.ntreddy.dd.ecommerce.controller;

import static com.ntreddy.dd.ecommerce.constants.PathConstants.*;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntreddy.dd.ecommerce.dto.GraphQLRequest;
import com.ntreddy.dd.ecommerce.dto.HeaderResponse;
import com.ntreddy.dd.ecommerce.dto.order.OrderItemResponse;
import com.ntreddy.dd.ecommerce.dto.order.OrderRequest;
import com.ntreddy.dd.ecommerce.dto.order.OrderResponse;
import com.ntreddy.dd.ecommerce.mapper.OrderMapper;
import com.ntreddy.dd.ecommerce.security.UserPrincipal;

import graphql.ExecutionResult;
import graphql.servlet.GraphQLProvider;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_ORDER)
public class OrderController {

	@Autowired
    private OrderMapper orderMapper;
//    private final GraphQLProvider graphQLProvider;

    @GetMapping(ORDER_ID)
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderMapper.getOrderById(orderId));
    }

    @GetMapping(ORDER_ID_ITEMS)
    public ResponseEntity<List<OrderItemResponse>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderMapper.getOrderItemsByOrderId(orderId));
    }

    @GetMapping
    public ResponseEntity<List<?>> getUserOrders(@AuthenticationPrincipal UserPrincipal user,
                                                             @PageableDefault(size = 10) Pageable pageable) {
        HeaderResponse<OrderResponse> response = orderMapper.getUserOrders(user.getEmail(), pageable);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }

    @PostMapping
    public ResponseEntity<OrderResponse> postOrder(@Valid @RequestBody OrderRequest order, BindingResult bindingResult) {
        return ResponseEntity.ok(orderMapper.postOrder(order, bindingResult));
    }

//    @PostMapping(GRAPHQL)
//    public ResponseEntity<ExecutionResult> getUserOrdersByQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
}
