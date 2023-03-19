package com.ecommerce.order.controller;

import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.dto.internal_dto.OrderSkuInternalDto;
import com.ecommerce.common.dto.internal_dto.SkuReviewInternalDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.utils.Result;
import com.ecommerce.order.dto.*;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.entity.OrderSku;
import com.ecommerce.order.entity.OrderSkuRefundRequest;
import com.ecommerce.order.open_feign.ProductClient;
import com.ecommerce.order.repository.OrderRepository;
import com.ecommerce.order.repository.OrderSkuRefundRequestRepository;
import com.ecommerce.order.repository.OrderSkuRepository;
import com.ecommerce.order.service.OrderService;
import com.ecommerce.order.vo.OrderCheckoutVo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderSkuRepository orderSkuRepository;
    @Autowired
    OrderSkuRefundRequestRepository orderSkuRefundRequestRepository;
    @Autowired
    ProductClient productClient;

    @PostMapping("checkout")
    public Result checkout(@RequestBody OrderCheckoutDto orderCheckoutDto) {
        OrderCheckoutVo orderCheckoutVo = orderService.checkout(orderCheckoutDto);
        return new Result().ok(orderCheckoutVo);
    }
    @PostMapping
    public Result placeOrder(@RequestBody PlaceOrderDto placeOrderDto) {
        orderService.placeOrder(placeOrderDto);
        return new Result();
    }
    @PostMapping("request-refund/{orderSkuId}")
    public Result requestRefund(@PathVariable("orderSkuId") Long orderSkuId, @RequestBody OrderSkuRefundRequestDto orderSkuRefundRequestDto) {
        System.out.println("requestRefund, orderSkuRefundRequestDto = " + orderSkuRefundRequestDto);
        OrderSku orderSku = orderSkuRepository.findById(orderSkuId).orElse(null);
        if (orderSku == null) {
            return new Result().error("orderSkuId is not exist");
        }

        OrderSkuRefundRequest orderSkuRefundRequest = new OrderSkuRefundRequest();
        BeanUtils.copyProperties(orderSkuRefundRequestDto, orderSkuRefundRequest);
        orderSkuRefundRequest.setOrderSku(orderSku);
        orderSkuRefundRequest.setStatus(OrderSkuRefundRequest.Status.UNDER_REVIEW);
        orderSkuRefundRequestRepository.save(orderSkuRefundRequest);  // todo: currently only support refund without return

        orderSku.setStatus(OrderSku.Status.REFUND_WITHOUT_RETURN_REQUESTED_AND_DELIVERED); // todo: currently only support refund without return
        orderSku.setRefundRequestQuantity(orderSkuRefundRequestDto.getRefundQuantity());
        orderSku.setRefundRequestPricePerSku(orderSkuRefundRequestDto.getRefundPerSkuPrice());
        orderSku.setRefundRequestReason(orderSkuRefundRequestDto.getReason());
        orderSku.setRefundRequestId(orderSkuRefundRequest.getId());
        orderSku.setRefundRequestDate(LocalDateTime.now());

        orderSkuRepository.save(orderSku);
        return new Result<>();
    }
    @PostMapping("refund-request-manage")
    public Result<?> manageRefundRequest(@RequestBody ManageRefundRequestDto manageRefundRequestDto) {
        Long refundRequestId = manageRefundRequestDto.getRefundRequestId();
        Integer isApproved = manageRefundRequestDto.getIsApproved();
        String username = manageRefundRequestDto.getUsername();
        String reason = manageRefundRequestDto.getReason();

        OrderSkuRefundRequest refundRequest = orderSkuRefundRequestRepository.findById(refundRequestId).orElse(null);
        if (refundRequest == null) {
            return new Result<>().error("refundRequest not found");
        }

        if (isApproved == 1) {
            refundRequest.setStatus(OrderSkuRefundRequest.Status.APPROVED);
            refundRequest.setHandlerUsername(username);
            refundRequest.setHandleReason(reason);
            refundRequest.setHandleDate(LocalDateTime.now());
            orderSkuRefundRequestRepository.save(refundRequest);

            // Update refunded total quantity and price per sku
            OrderSku orderSku = refundRequest.getOrderSku();

            BigDecimal refundPricePerSku = refundRequest.getRefundPerSkuPrice();
            Long refundQuantity = refundRequest.getRefundQuantity();

            BigDecimal refundedPricePerSku = orderSku.getRefundedPricePerSku() != null ? orderSku.getRefundedPricePerSku() : BigDecimal.ZERO;
            Long refundedQuantity = orderSku.getRefundedQuantity() != null ? orderSku.getRefundedQuantity() : 0L;

            BigDecimal newTotalRefund = refundPricePerSku.multiply(new BigDecimal(refundQuantity)).add(
                    refundedPricePerSku.multiply(new BigDecimal(refundedQuantity)));
            Long newRefundedTotalQuantity = refundedQuantity + refundQuantity;
            BigDecimal newRefundedPricePerSku = newTotalRefund.divide(new BigDecimal(newRefundedTotalQuantity), 2, RoundingMode.HALF_UP);

            orderSku.setRefundedPricePerSku(newRefundedPricePerSku);
            orderSku.setRefundedQuantity(newRefundedTotalQuantity);
            orderSku.setStatus(OrderSku.Status.REFUND_WITHOUT_RETURN_APPROVED_AND_DELIVERED);
            orderSku.setRefundHandlerNote(reason);
            orderSku.setRefundHandlerUsername(username);
            orderSku.setRefundHandleDate(LocalDateTime.now());
            orderSkuRepository.save(orderSku);
        } else {
            refundRequest.setStatus(OrderSkuRefundRequest.Status.REJECTED);
            refundRequest.setHandlerUsername(username);
            refundRequest.setHandleReason(reason);
            refundRequest.setHandleDate(LocalDateTime.now());
            orderSkuRefundRequestRepository.save(refundRequest);

            OrderSku orderSku = refundRequest.getOrderSku();
            orderSku.setStatus(OrderSku.Status.REFUND_WITHOUT_RETURN_REJECTED_AND_DELIVERED);
            orderSku.setRefundHandlerNote(reason);
            orderSku.setRefundHandlerUsername(username);
            orderSku.setRefundHandleDate(LocalDateTime.now());
            orderSkuRepository.save(orderSku);
        }
        return new Result<>();
    }
    @PostMapping("reject-refund/{orderSkuId}")
    public Result rejectRefund(@PathVariable("orderSkuId") Long orderSkuId) {
        OrderSku orderSku = orderSkuRepository.findById(orderSkuId).orElse(null);
        if (orderSku == null) {
            return new Result().error("orderSkuId is not exist");
        }
        orderSku.setStatus(OrderSku.Status.REFUND_WITHOUT_RETURN_REJECTED_AND_DELIVERED);
        orderSkuRepository.save(orderSku);
        return new Result<>();
    }
    @GetMapping("page")
    public Result<PageData<Order>> page(OrderPaginationDto paginationDto) {
        PageRequest pageRequest = PageRequest.of(
                paginationDto.getCurrent().intValue() - 1,
                paginationDto.getPageSize().intValue()
        );
        OrderSku.Status status = paginationDto.getStatus();
        String username = paginationDto.getUsername();
        Specification<Order> sp = Specification.where(null);
        if (status != null) {
            sp = sp.and((root, query, cb) -> {
                query.distinct(true);
                Join<Order, OrderSku> orderSkuJoin = root.join("orderSkus", JoinType.INNER);
                return cb.equal(orderSkuJoin.get("status"), status);
            });
        }
        if (username != null) {
            sp = sp.and((root, criteriaQuery, criteriaBuilder) -> {
                return criteriaBuilder.equal(root.get("username"), username);
            });
        }
        Page<Order> page = orderRepository.findAll(sp, pageRequest);
        PageData<Order> pageData = new PageData<>(page);
        return new Result<PageData<Order>>().ok(pageData);
    }

    @PostMapping("review/{orderSkuId}")
    public Result<?> review(@PathVariable("orderSkuId") Long orderSkuId, @RequestBody SkuReviewInternalDto skuReviewInternalDto) {
        OrderSku orderSku = orderSkuRepository.findById(orderSkuId).orElse(null);
        if (orderSku == null) {
            return new Result().error("orderSku not found");
        }
        orderSku.setRating(skuReviewInternalDto.getRating());
        orderSkuRepository.save(orderSku);

        skuReviewInternalDto.setSkuId(orderSku.getSkuId());
        productClient.review(skuReviewInternalDto);
        return new Result<>();
    }

    @GetMapping("{id}")
    public Result<Order> getOrder(@PathVariable Long id) {
       Order order = orderRepository.findById(id).orElse(null);
       return new Result<Order>().ok(order);
    }

    @GetMapping
    public Result<Order> getAll(
            @RequestParam(value = "uuid", required = false) String uuid
    ) {
        Order order = orderRepository.findByOrderUUID(uuid);
        return new Result<Order>().ok(order);
    }

    @GetMapping("test")
    public Result test() {
        System.out.println("test");
        // Object obj = productClient.test();
        // System.out.println(obj);
        // Result skus = productClient.getAll(new PaginationDto());
        // System.out.println(skus);
        Result res = productClient.test(new PaginationDto());
        System.out.println(res);
        return res;
    }
    @PostMapping("test")
    public Result test2(PaginationDto paginationDto) {
        Result res = productClient.test2(new PaginationDto());
        System.out.println(res);
        return res;
    }

    @GetMapping("test3")
    public Result test3(PaginationDto paginationDto) {
        return new Result().ok(paginationDto);
    }
    @PostMapping("test3")
    public Result test4(PaginationDto paginationDto) {
        return new Result().ok(paginationDto);
    }
    @PutMapping("test3")
    public Result test5() {
        List<OrderSkuInternalDto> list = new ArrayList<>();
        OrderSkuInternalDto dto = new OrderSkuInternalDto();
        dto.setSkuId(1L);
        list.add(dto);
        return new Result().ok(productClient.deductInventory(list));
        // return new Result().ok(productClient.test3(list));
    }
}
