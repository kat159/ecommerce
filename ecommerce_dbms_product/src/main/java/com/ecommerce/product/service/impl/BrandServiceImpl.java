package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.BrandDao;
import com.ecommerce.product.dao.CategoryBrandDao;
import com.ecommerce.product.dao.CategoryDao;
import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.dto.BrandDto;
import com.ecommerce.product.dto.CategoryBrandDto;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.dto.pagination.BrandPaginationDto;
import com.ecommerce.product.entity.BrandEntity;
import com.ecommerce.product.entity.CategoryBrandEntity;
import com.ecommerce.product.entity.CategoryEntity;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.service.BrandService;
import com.ecommerce.product.service.CategoryBrandService;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.product.vo.BrandVo;
import com.ecommerce.product.vo.ProductVo;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class BrandServiceImpl
        extends CrudServiceImpl<BrandDao, BrandEntity, BrandDto, BrandVo>
        implements BrandService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryBrandDao categoryBrandDao;

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryBrandService categoryBrandService;
    @Override
    public List<CategoryBrandEntity> getAllCategoryBrand(Long brandId) {
        List<CategoryBrandEntity> categoryBrandList = categoryBrandDao.selectByBrandId(brandId);

        categoryBrandList.forEach(categoryBrand -> {
            Long categoryId = categoryBrand.getCategoryId();
            CategoryEntity category = categoryDao.selectById(categoryId);
            if (category != null) {
                categoryBrand.setCategoryName(category.getName());
            } else {
                log.error("data inconsistency: category not found, categoryId: {}, categoryBrand: {}", categoryId, categoryBrand);
                categoryBrandService.removeAll(List.of(categoryBrand.getId()));
            }
            // categoryBrand.setCategoryName(categoryDao.selectById(categoryBrand.getCategoryId()).getName());
        });
        
        return categoryBrandList;
    }
    @Override
    public List<Long> addCategoryBrand(Long brandId, Long categoryId) {
        CategoryBrandDto dto = new CategoryBrandDto();
        dto.setBrandId(brandId);
        dto.setCategoryId(categoryId);
        return List.of(categoryBrandService.add(dto));
    }
    class P extends PaginationDto {
        private Long categoryId;
        public Long getCategoryId() {
            return categoryId;
        }
        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }
    }
    @Override
    public PageData<BrandVo> page(BrandPaginationDto params) {
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight(!StringUtils.isNullOrEmpty(params.getName()),"name", params.getName());
        queryWrapper.orderByAsc("sort");
        PageData<BrandVo> voList = super.page(params, queryWrapper);

        voList.getList().forEach(brandVo -> {
            List<CategoryBrandEntity> categoryBrandList = categoryBrandDao.selectByBrandId(brandVo.getId());
            List<String> categoryNameList = new ArrayList<>();
            categoryBrandList.forEach(categoryBrand -> {
                Long categoryId = categoryBrand.getCategoryId();
                CategoryEntity category = categoryDao.selectById(categoryId);
                if (category != null) {
                    categoryNameList.add(category.getName());
                } else {
                    log.error("data inconsistency: category not found, categoryId: {}, categoryBrand: {}", categoryId, categoryBrand);
                    categoryBrandService.removeAll(List.of(categoryBrand.getId()));
                }
            });
            brandVo.setCategoryNames(categoryNameList);
        });
        return voList;
    }
    @Override
    public List<ProductVo> getAllProduct(Long brandId) {
        List<ProductEntity> productEntities = productDao.selectByBrandId(brandId);
        List<ProductVo> productVos = ConvertUtils.sourceToTarget(productEntities, ProductVo.class);
        return productVos;
    }

    @Override
    public List<Long> addAllProduct(Long brandId, List<ProductDto> productDtoList) {
        productDtoList.forEach(productDto -> {
            productDto.setBrandId(brandId);
        });
        return productService.addAll(productDtoList);
    }
}