package com.ecommerce.common.exception;

public enum ErrorCodeEnum {
    //



    // payment error code
    PAYMENT_ERROR(10001, "payment error"),

    // inventory error code
    STOCK_NOT_ENOUGH(20001, "stock not enough"),

    ;

    private Integer code;

    private String message;

    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
