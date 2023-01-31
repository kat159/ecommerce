

package com.ecommerce.common.utils;

import com.ecommerce.common.exception.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 响应数据
 */
@ApiModel(value = "响应")
public class Result implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * to be compatible with antd-pro
     */
    private boolean success = true;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    @ApiModelProperty(value = "编码：0表示成功，其他值表示失败")
    private int code = 0;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String msg = "success";
    /**
     * 响应数据
     */
    @ApiModelProperty(value = "响应数据")
    private Object data;

    public Result ok(Object data) {
        this.setData(data);
        return this;
    }

    public boolean success(){
        return code == 0;
    }

    public Result error() {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = MessageUtils.getMessage(this.code);
        this.success = false;
        return this;
    }

    public Result error(int code) {
        this.code = code;
        this.msg = MessageUtils.getMessage(this.code);
        this.success = false;
        return this;
    }

    public Result error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = false;
        return this;
    }

    public Result error(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = false;
        return this;
    }

    public Result error(String msg) {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
