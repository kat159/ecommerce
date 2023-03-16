package com.common.country.vo;

import com.ecommerce.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel(value = "")
public class StatesVo extends BaseVo<StatesVo>
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