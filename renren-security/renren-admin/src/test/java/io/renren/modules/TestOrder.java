package io.renren.modules;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.order.dao.OmsOrderDao;
import io.renren.modules.order.entity.OmsOrderEntity;
import io.renren.modules.order.service.OmsOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOrder {

    @Autowired
    private OmsOrderService orderService;

    @Autowired
    private OmsOrderDao orderDao;

    @Test
    void testOrder() {

        for (int i = 0; i < 20; i++) {
            OmsOrderEntity orderEntity = new OmsOrderEntity();
            orderEntity.setOrderSn("orderSn" + i);
            orderEntity.setMemberId(1L);
            orderEntity.setMemberUsername("memberUsername" + i);
            orderEntity.setPayType(1);
            orderEntity.setSourceType(0);
            orderEntity.setStatus(0);
            orderEntity.setDeliveryCompany("deliveryCompany" + i);
            orderEntity.setDeliverySn("deliverySn" + i);
            orderEntity.setAutoConfirmDay(7);
            orderEntity.setIntegration(0);
            orderEntity.setGrowth(0);
            orderEntity.setBillType(0);
            orderEntity.setBillHeader("billHeader" + i);
            orderEntity.setBillContent("billContent" + i);
            orderEntity.setBillReceiverPhone("billReceiverPhone" + i);
            orderEntity.setBillReceiverEmail("billReceiverEmail" + i);
            orderEntity.setReceiverName("receiverName" + i);
            orderEntity.setReceiverPhone("receiverPhone" + i);
            orderEntity.setReceiverPostCode("receiverPostCode" + i);
            orderEntity.setReceiverProvince("receiverProvince" + i);
            orderEntity.setReceiverCity("receiverCity" + i);
            orderEntity.setReceiverRegion("receiverRegion" + i);
            orderEntity.setReceiverDetailAddress("receiverDetailAddress" + i);
            orderEntity.setNote("note" + i);
            orderEntity.setConfirmStatus(0);
            orderEntity.setDeleteStatus(0);
            orderEntity.setUseIntegration(0);
            orderEntity.setPaymentTime(null);
            orderEntity.setDeliveryTime(null);
            orderEntity.setReceiveTime(null);
            orderEntity.setCommentTime(null);
            orderEntity.setModifyTime(null);
            orderDao.insert(orderEntity);
        }

        IPage<OmsOrderEntity> page = new Page<>(2, 5);
        orderDao.selectPage(
                new Page<>(3, 3),
                new QueryWrapper<>()
        );
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

}
