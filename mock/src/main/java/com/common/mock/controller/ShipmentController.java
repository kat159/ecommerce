package com.common.mock.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shipment")
public class ShipmentController {

    @PostMapping("ship")
    public String ship(Long shippingTime) {
        return "shipment success";
    }
}
