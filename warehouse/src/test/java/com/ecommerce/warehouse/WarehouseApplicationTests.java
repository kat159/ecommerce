package com.ecommerce.warehouse;

import com.ecommerce.warehouse.entity.WareInfoEntity;
import com.ecommerce.warehouse.service.WareInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WarehouseApplicationTests {

    @Autowired
    WareInfoService wareInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsert() {
        WareInfoEntity wareInfoEntity = new WareInfoEntity();
        wareInfoEntity.setName("test");
        wareInfoEntity.setAddress("test");
        wareInfoEntity.setAreacode("test");
        wareInfoService.save(wareInfoEntity);
    }
}
