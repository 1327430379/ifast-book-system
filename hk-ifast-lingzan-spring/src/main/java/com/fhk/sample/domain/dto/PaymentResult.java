package com.fhk.sample.domain.dto;

import com.fhk.sample.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResult {

    /**
     * 用户
     */
    private Integer userId;

    /**
     * 书籍
     */
    private Book book;

    /**
     * 支付模式
     */
    private String paymentMode;

    /**
     * 支付状态
     */
    private String status;
}
