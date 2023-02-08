package com.ecommerce.coupon;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ecommerce.coupon.dao.CouponDao;
import com.ecommerce.coupon.entity.CouponEntity;
import com.ecommerce.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CouponApplicationTests {

    // @Autowired
    // CouponDao couponDao;
    //
    // @Autowired
    // CouponService couponService;
    //
    // @Test
    // void contextLoads() {
    //
    // }
    //
    // @Test
    // void testPage() {
    //     IPage<CouponEntity> page = new Page<>(2, 5);
    //     couponDao.selectPage(
    //             // new Page<>(3, 3),
    //             page,
    //             new QueryWrapper<>()
    //     );
    //     System.out.println(page.getCurrent());
    //     System.out.println(page.getSize());
    //     System.out.println(page.getTotal());
    //     System.out.println(page.getPages());
    //     System.out.println(page.getRecords());
    // }
    //
    // @Test
    // void testInsert() {
    //     for (int i = 0; i < 20; i++) {
    //         CouponEntity couponEntity = new CouponEntity();
    //         // couponEntity.setCouponName("test" + i);
    //         // couponService.save(couponEntity);
    //     }
    // }
}
