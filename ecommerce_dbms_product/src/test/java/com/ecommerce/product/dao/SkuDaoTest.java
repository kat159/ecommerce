// package com.ecommerce.product.dao;
//
// import com.ecommerce.product.entity.SkuEntity;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import java.math.BigDecimal;
// import java.util.List;
//
// @SpringBootTest
// public class SkuDaoTest {
//
//     @Autowired
//     private SkuDao skuDao;
//     @Test
//     public void test() {
//         List<SkuEntity> res = skuDao.selectByProductIdListAndPriceRange(List.of(17L, 18L), new BigDecimal("0.01"), new BigDecimal("100000"));
//         System.out.println(res);
//     }
// }
