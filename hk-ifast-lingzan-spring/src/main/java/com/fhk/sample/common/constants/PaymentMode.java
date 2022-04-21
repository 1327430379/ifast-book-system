package com.fhk.sample.common.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentMode {

    CASH("cash", "余额支付"),
    CHEQUE("cheque", "支票支付");

    private final String type;

    private final String desc;

    public static PaymentMode getByType(String type) {
        PaymentMode[] values = values();
        for (PaymentMode paymentMode : values) {
            if (paymentMode.getType().equals(type)) {
                return paymentMode;
            }
        }
        return null;
    }


}
