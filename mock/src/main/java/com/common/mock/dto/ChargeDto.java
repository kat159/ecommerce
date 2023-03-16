package com.common.mock.dto;


import lombok.Data;

@Data
public class ChargeDto {

    private String card;
    private String cvv;
    private String expiry;
    private String amount;
    private String currency;
}
