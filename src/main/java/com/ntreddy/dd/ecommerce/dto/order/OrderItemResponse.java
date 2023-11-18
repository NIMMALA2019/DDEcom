package com.ntreddy.dd.ecommerce.dto.order;

import com.ntreddy.dd.ecommerce.dto.perfume.PerfumeResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponse {
    private Long id;
    private Long amount;
    private Long quantity;
    private PerfumeResponse perfume;
}
