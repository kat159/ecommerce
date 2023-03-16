package com.common.country.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("countries")
public class CountriesEntity extends BaseEntity<CountriesEntity> {

    @TableId
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