package com.ecommerce.common.exception;

public class MyBusinessException extends RuntimeException {
    private final String errorCode;

    public MyBusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public MyBusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.errorCode = errorCodeEnum.getCode().toString();
    }

    public String getErrorCode() {
        return errorCode;
    }
}
