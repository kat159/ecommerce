package com.ecommerce.product.dto;

import com.ecommerce.common.validation.annotation.IntegerEnum;
import com.ecommerce.common.validation.annotation.IntegerRange;
import com.ecommerce.common.validation.group.Save;
import com.ecommerce.common.validation.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;


@Data
@ApiModel(value = "brand")
public class BrandDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "brand ID")
	@NotNull(message = "brand ID is required to update", groups = {Update.class})
	@Null(message = "brand ID must be null to insert", groups = {Save.class})
	private Long id;

	@ApiModelProperty(value = "brand name")
	@NotBlank(message = "brand name cannot be empty", groups = {Save.class, Update.class})
	private String name;

	@ApiModelProperty(value = "brand logo url")
	@NotNull(message = "brand logo url cannot be empty", groups = {Save.class}) // url can be null when update
	@URL(message = "brand logo url is not valid", groups = {Save.class, Update.class}) // but have to be valid url if not null
	private String logo;

	@ApiModelProperty(value = "introduction")
	@NotBlank(message = "brand introduction cannot be empty", groups = {Save.class, Update.class})
	private String description;

	@ApiModelProperty(value = "for soft delete[0-deleted; 1-non-deleted]")
	@Null(message = "brand status must be null to insert", groups = {Save.class})
	// @IntegerRange(min = 0, max = 1, message = "brand status must between {min} and {max} or null", groups = {Update.class})
	@IntegerEnum(values = {0, 1}, message = "brand status must be in {values} or null", groups = {Update.class})
	private Integer nonDeleted;

	@ApiModelProperty(value = "search first letter")
	private String firstLetter;

	@ApiModelProperty(value = "sort order")
	private Integer sort;


}