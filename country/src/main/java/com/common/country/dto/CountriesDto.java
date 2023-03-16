package com.common.country.dto;

import com.ecommerce.common.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "")
public class CountriesDto extends BaseDto<CountriesDto>
		implements Serializable {
    private static final long serialVersionUID = 1L;

		private Long id;

		private String name;

		private String iso3;

		private String numericCode;

		private String iso2;

		private String phonecode;

		private String capital;

		private String currency;

		private String currencyName;

		private String currencySymbol;

		private String tld;

		private String region;

		private String subregion;

		private String timezones;

		private String translations;

		private BigDecimal latitude;

		private BigDecimal longitude;

		private String emoji;

		private String emojiu;

		private Date createdAt;

		private Date updatedAt;

		private Integer flag;

		private String wikidataid;


}