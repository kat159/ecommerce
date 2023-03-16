

package com.ecommerce.common.utils;

import com.ecommerce.common.exception.ErrorCode;
import com.ecommerce.common.exception.MyBusinessException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private boolean success = true;
    private int code = 0;
    private String msg = "success";
    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public boolean success(){
        return code == 0;
    }

    public Result<T> error() {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = MessageUtils.getMessage(this.code);
        this.success = false;
        return this;
    }

    public Result<T> error(int code) {
        this.code = code;
        this.msg = MessageUtils.getMessage(this.code);
        this.success = false;
        return this;
    }

    public Result<T> error(MyBusinessException e) {
        this.code = Integer.parseInt(e.getErrorCode());
        this.msg = e.getMessage();
        this.success = false;
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = false;
        return this;
    }

    public Result<T> error(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = false;
        return this;
    }

    public Result<T> error(String msg) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
        this.success = false;
        return this;
    }

    public int getCode() {
        return code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
