// package com.ecommerce.product.service;
//
// import com.ecommerce.common.page.PageData;
// import com.ecommerce.product.dto.aggregate.ProductPublishDto;
// import com.ecommerce.product.dto.pagination.AttrFilter;
// import com.ecommerce.product.dto.pagination.ProductSearchParams;
// import com.ecommerce.product.vo.aggregate.ProductSearchVo;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import java.util.ArrayList;
// import java.util.List;
//
// @SpringBootTest
// public class ProductServiceTest {
//
//     @Autowired
//     private ProductService productService;
//     // @Test
//     // public void getProductIdListBySpecAttrFilters() {
//     //     List<AttrFilter> attrFilters = new ArrayList<>();
//     //     attrFilters.add(new AttrFilter(12L, "123"));
//     //     attrFilters.add(new AttrFilter(14L, "266 ppi"));
//     //     productService.getProductIdListBySpecAttrFilters(attrFilters);
//     // }
//     @Test
//     public void searchBySpecAttrs() {
//         ProductSearchParams params = new ProductSearchParams();
//         List<AttrFilter> attrFilters = new ArrayList<>();
//         attrFilters.add(new AttrFilter(12L, "123"));
//         attrFilters.add(new AttrFilter(14L, "266 ppi"));
//         params.setSpecAttrFilters(attrFilters);
//         PageData<ProductSearchVo> res = productService.search(params);
//         System.out.println(res);
//     }
//
//     @Test
//     public void searchByCategoryId() {
//         ProductSearchParams params = new ProductSearchParams();
//         List<AttrFilter> attrFilters = new ArrayList<>();
//         attrFilters.add(new AttrFilter(12L, "123"));
//         attrFilters.add(new AttrFilter(14L, "266 ppi"));
//         params.setSpecAttrFilters(attrFilters);
//         PageData<ProductSearchVo> res = productService.search(params);
//         System.out.println(res);
//     }
//
//     @Test
//     public void searchBySaleAttrs() {
//         ProductSearchParams params = new ProductSearchParams();
//         List<AttrFilter> attrFilters = new ArrayList<>();
//         attrFilters.add(new AttrFilter(12L, "123"));
//         attrFilters.add(new AttrFilter(14L, "266 ppi"));
//         params.setSpecAttrFilters(attrFilters);
//         PageData<ProductSearchVo> res = productService.search(params);
//         System.out.println(res);
//     }
// }
