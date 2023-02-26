package com.ecommerce.product.dto.aggregate;

import com.ecommerce.product.dto.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class ProductManageDto
        implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    Long id;
    ProductDto productToUpdate;
    List<Long> productImageIdsToDelete;
    List<ProductImageDto> productImagesToAdd;
    List<ProductAttrbuteValueDto> productAttrValuesToUpdate;
    List<Long> skuImageIdsToDelete;
    List<SkuImageDto> skuImagesToAdd;
    List<SkuDto> skus;
}
