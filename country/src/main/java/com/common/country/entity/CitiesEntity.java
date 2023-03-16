package com.common.country.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ecommerce.common.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("cities")
public class CitiesEntity extends BaseEntity<CitiesEntity> {

    @TableId
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