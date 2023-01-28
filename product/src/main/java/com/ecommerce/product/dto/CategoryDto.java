package com.ecommerce.product.dto;

import com.ecommerce.common.dto.TreeDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@ApiModel(value = "product category, up to three-level categorization")
public class CategoryDto extends TreeDto<CategoryDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "category id")
	private Long id;

	@ApiModelProperty(value = "category name")
	private String name;

	@ApiModelProperty(value = "parent category id")
	private Long parentId;

	@ApiModelProperty(value = "level")
	private Integer level;

	@ApiModelProperty(value = "for soft delete[0-deleted; 1-non-deleted]")
	private Integer nonDeleted;

	@ApiModelProperty(value = "sort order")
	private Integer sort;

	@ApiModelProperty(value = "icon address")
	private String icon;

	@ApiModelProperty(value = "unit of measurement")
	private String productUnit;

	@ApiModelProperty(value = "number of products")
	private Integer productCount;

	private List<CategoryDto> subCategories;

	@Override
	public List<CategoryDto> getChildren() {
		return subCategories;
	}

	@Override
	public void setChildren(List<CategoryDto> children) {
		this.subCategories = children;
	}
}