package com.ecommerce.product.dto.aggregate;


import com.ecommerce.product.vo.aggregate.CategoryManageVo;
import lombok.Data;

import java.util.List;

@Data
public class CategoryManageDto {

    private List<CategoryManageVo> originalForest;
    private List<CategoryManageVo> newForest;
}
