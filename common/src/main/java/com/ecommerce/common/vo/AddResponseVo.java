package com.ecommerce.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "success add response")
public class AddResponseVo implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "inserted entity id")
    Long id;

    @ApiModelProperty(value = "inserted entity id")
    List<Long> idList;

    public AddResponseVo() {
    }

    public AddResponseVo(Long id) {
        this.id = id;
    }

    public AddResponseVo(List<Long> idList) {
        this.idList = idList;
    }
}
