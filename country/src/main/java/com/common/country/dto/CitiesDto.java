package com.common.country.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "")
public class CitiesDto extends BaseDto<CitiesDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

		private Long id;

		private String name;

		private Integer stateId;

		private String stateCode;

		private Integer countryId;

		private String countryCode;

		private BigDecimal latitude;

		private BigDecimal longitude;

		private Date createdAt;

		private Date updatedAt;

		private Integer flag;

		private String wikidataid;


}