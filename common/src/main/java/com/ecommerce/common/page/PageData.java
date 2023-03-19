

package com.ecommerce.common.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class PageData<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "total records number")
    private long total;

    @ApiModelProperty(value = "record list")
    private List<T> list;

    @ApiModelProperty(value = "current page")
    private long current;

    @ApiModelProperty(value = "size per page")
    private long pageSize;

    public PageData() {
        this.list = new ArrayList<>();
    }

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

    public PageData(org.springframework.data.domain.Page<T> page) {
        this.list = page.getContent();
        this.current = page.getNumber() + 1;
        this.pageSize = page.getSize();
        this.total = page.getTotalElements();
    }
}