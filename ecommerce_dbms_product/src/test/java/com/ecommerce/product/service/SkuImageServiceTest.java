package com.ecommerce.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SkuImageServiceTest {
    @Autowired
    private SkuImageService skuImageService;
    @Test
    public void test() {
        skuImageService.removeAllByProductId(List.of(26L));
    }
}
