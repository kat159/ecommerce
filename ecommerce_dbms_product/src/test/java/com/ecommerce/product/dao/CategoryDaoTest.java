// package com.ecommerce.product.dao;
//
// import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
// import com.ecommerce.product.entity.BrandEntity;
// import com.ecommerce.product.entity.CategoryEntity;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import java.util.List;
// import java.util.stream.Collectors;
//
// @SpringBootTest
// public class CategoryDaoTest {
//
//     @Autowired
//     private CategoryDao categoryDao;
//     @Autowired
//     private BrandDao brandDao;
//     @Test
//     public void test() {
//
//         List<String> names = brandDao.selectBatchIds(List.of(1L, 2L, 8L, 8L)).stream().map(BrandEntity::getName).collect(Collectors.toList());
//         System.out.println(names);
//         System.out.println(brandDao.selectById(999L));
//     }
// }
