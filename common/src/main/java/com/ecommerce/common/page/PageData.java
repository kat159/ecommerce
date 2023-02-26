

package com.ecommerce.common.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    public PageData(Page<T> page) {
        this.list = page.getRecords();
        this.current = page.getCurrent();
        this.pageSize = page.getSize();
        this.total = page.getTotal();
    }

    public PageData(List<T> list, long current, long pageSize, long total) {
        this.list = list;
        this.current = current;
        this.pageSize = pageSize;
        this.total = (int) total;
    }

}