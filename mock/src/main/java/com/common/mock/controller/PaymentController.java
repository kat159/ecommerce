package com.common.mock.controller;


import com.common.mock.dto.ChargeDto;
import com.ecommerce.common.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @PostMapping("charge")
    public Result charge(@RequestBody ChargeDto chargeDto) {
        if (chargeDto.getCard().replaceAll(" ", "").equals("4242424242424242")) {
            return new Result().ok("payment success");
        }
        return new Result().error("payment failed");
    }
}
