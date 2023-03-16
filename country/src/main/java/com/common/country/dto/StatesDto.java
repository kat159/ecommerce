package com.common.country.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "")
public class StatesDto extends BaseDto<StatesDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

		private Long id;

		private String name;

		private Integer countryId;

		private String countryCode;

		private String fipsCode;

		private String iso2;

		private String type;

		private BigDecimal latitude;

		private BigDecimal longitude;

		private Date createdAt;

		private Date updatedAt;

		private Integer flag;

		private String wikidataid;


}