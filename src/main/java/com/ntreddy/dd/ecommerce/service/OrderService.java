package com.ntreddy.dd.ecommerce.service;

import graphql.schema.DataFetcher;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntreddy.dd.ecommerce.domain.Order;
import com.ntreddy.dd.ecommerce.domain.OrderItem;

public interface OrderService {

    Order getOrderById(Long orderId);

    List<OrderItem> getOrderItemsByOrderId(Long orderId);
    
    Page<Order> getAllOrders(Pageable pageable);

    Page<Order> getUserOrders(String email, Pageable pageable);

    Order postOrder(Order validOrder, Map<Long, Long> perfumesId);

    String deleteOrder(Long orderId);

    DataFetcher<List<Order>> getAllOrdersByQuery();

    DataFetcher<List<Order>> getUserOrdersByEmailQuery();
}
