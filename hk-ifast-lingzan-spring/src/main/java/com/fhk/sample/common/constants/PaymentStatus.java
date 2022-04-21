package com.fhk.sample.common.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentStatus {
    UNPAID(0,"待支付"),
    HAVE_PAID(1,"已支付"),
    TO_AUDIT(2,"待审核支票");

    private final Integer status;

    private final String desc;


}
