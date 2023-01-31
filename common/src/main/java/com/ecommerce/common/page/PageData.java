

package com.ecommerce.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 */
@Data
@ApiModel(value = "分页数据")
public class PageData<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总记录数")
    private long total;

    @ApiModelProperty(value = "列表数据")
    private List<T> list;

    @ApiModelProperty(value = "当前页码")
    private long current;

    @ApiModelProperty(value = "每页记录数")
    private long pageSize;

    /**
     * 分页
     * @param list   列表数据
     * @param total  总记录数
     */
    public PageData(List<T> list, long current, long pageSize, long total) {
        this.list = list;
        this.current = current;
        this.pageSize = pageSize;
        this.total = (int)total;
    }
}