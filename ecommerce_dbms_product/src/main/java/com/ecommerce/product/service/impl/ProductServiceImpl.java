package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecommerce.common.constant.Constant;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.impl.CrudServiceImpl;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.product.dao.*;
import com.ecommerce.product.dto.*;
import com.ecommerce.product.dto.aggregate.*;
import com.ecommerce.product.dto.pagination.AttrFilter;
import com.ecommerce.product.dto.pagination.ProductPaginationDto;
import com.ecommerce.product.dto.pagination.ProductSearchParams;
import com.ecommerce.product.entity.*;
import com.ecommerce.product.service.*;
import com.ecommerce.product.vo.*;
import com.ecommerce.product.vo.aggregate.ProductSearchVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl
        extends CrudServiceImpl<ProductDao, ProductEntity, ProductDto, ProductVo>
        implements ProductService {
    @Autowired
    private CategoryBrandService categoryBrandService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ProductAttrbuteValueService productAttrbuteValueService;
    @Autowired
    private SkuService skuService;
    @Autowired
    private SkuImageService skuImageService;
    @Autowired
    private SkuSkuImageService skuSkuImageService;
    @Autowired
    private SkuAttributeValueService skuAttributeValueService;
    @Autowired
    private AttributeGroupService attributeGroupService;
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductAttrbuteValueDao productAttrbuteValueDao;
    @Autowired
    private SkuDao skuDao;
    @Autowired
    private SkuAttributeValueDao skuAttributeValueDao;
    @Autowired
    SkuImageDao skuImageDao;
    @Override
    public Long add(ProductDto dto) {
        // if (productDao.selectByName(dto.getName()) != null) { // product name should be unique
        //     throw new RuntimeException("product name already exists");
        // }
        return super.add(dto);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeAll(List<Long> ids) {
        // 1. remove product
        super.removeAll(ids);
        // 2. remove product images
        productImageService.removeAllByProductId(ids);
        // 3. remove product attribute values
        productAttrbuteValueService.removeAllByProductId(ids);
        // 4. remove sku images, sku many to many sku images, removing sku will not remove sku images
        //     remove it first as it will need sku & sku_sku_images
        skuImageService.removeAllByProductId(ids);
        // 5. remove sku & related table
        skuService.removeAllByProductId(ids);
    }

    @Override
    public ProductVo getDetailBySkuId(Long skuId) {
        // 1. get sku by sku id
        SkuEntity skuEntity = skuDao.selectById(skuId);
        if (skuEntity == null) {
            log.error("data inconsistency: sku from front end not found, sku id: {}", skuId);
            return null;
        }
        // 2. get product, brand name & category name by sku product id
        //  2.1 get product
        ProductVo productVo = super.get(skuEntity.getProductId());
        if (productVo == null) {
            log.error("data inconsistency: product of sku not found, sku id: {}", skuId);
            return null;
        }
        //  2.2 get brand & category names TODO: save brand & category name in product table, update product table when brand & category name changed
        BrandEntity brandEntity = brandDao.selectById(productVo.getBrandId());
        if (brandEntity == null) {
            productVo.setBrandName("Brand not found");
        } else {
            productVo.setBrandName(brandEntity.getName());
        }
        CategoryEntity categoryEntity = categoryDao.selectById(productVo.getCategoryId());
        if (categoryEntity == null) {
            productVo.setCategoryName("Category not found");
        } else {
            productVo.setCategoryName(categoryEntity.getName());
        }
        // 3. get product images
        List<ProductImageVo> productImageVoList = productImageService.getAllByProductId(productVo.getId());
        // 4. get category attribute groups
        List<AttributeGroupVo> attributeGroupVoList = attributeGroupService.getAllByCategoryId(productVo.getCategoryId(), null);
        for (AttributeGroupVo attributeGroupVo : attributeGroupVoList) {
            // 4.1 get attributes
            List<AttributeVo> attributeVoList = attributeService.getAllByAttributeGroupId(attributeGroupVo.getId(), null);
            attributeGroupVo.setAttributes(attributeVoList);
        }
        // 5. get product attribute values
        List<ProductAttrbuteValueVo> productAttrbuteValueVoList = productAttrbuteValueService.getAllByProductId(productVo.getId());
        // 6. get skus
        List<SkuVo> skuVoList = skuService.getAllByProductId(productVo.getId());
        // 7. get sku sale attr values && sku images && sku sku images relation
        List<SkuImageVo> skuImageVoList = new ArrayList<>();
        Set<Long> skuImageIds = new HashSet<>();
        if (skuVoList != null && skuVoList.size() > 0) {
            for (SkuVo skuVo : skuVoList) {
                // 7.1 get sku sku images relation
                List<SkuSkuImageVo> skuSkuImageVoList = skuSkuImageService.getAllBySkuId(skuVo.getId());
                skuVo.setSkuSkuImages(skuSkuImageVoList);
                if (skuSkuImageVoList != null && skuSkuImageVoList.size() > 0) {
                    for (SkuSkuImageVo skuSkuImageVo : skuSkuImageVoList) {
                        skuImageIds.add(skuSkuImageVo.getSkuImageId());
                    }
                }
                // 7.2 get sku sale attr values
                List<SkuAttributeValueVo> skuAttributeValueVoList = skuAttributeValueService.getAllBySkuId(skuVo.getId());
                skuVo.setSaleAttrValues(skuAttributeValueVoList);
            }
        }
        // 7.3 get sku images
        for (Long skuImageId : skuImageIds) {
            SkuImageVo skuImageVo = skuImageService.get(skuImageId);
            if (skuImageVo != null) {
                skuImageVoList.add(skuImageVo);
            } else log.error("data inconsistency: sku image not found, sku image id from sku_sku_image table: {}", skuImageId);
        }
        productVo.setImages(productImageVoList);
        productVo.setSkuImages(skuImageVoList);
        productVo.setProductAttributeValues(productAttrbuteValueVoList);
        productVo.setAttributeGroups(attributeGroupVoList);
        productVo.setSkus(skuVoList);
        return productVo;
    }

    private void fetchInclude(ProductVo productVo, List<String> include) {
        if (include == null || include.size() == 0) {
            return;
        }
        if (include.contains("image")) {
            // 1. get images
            List<ProductImageVo> productImageVoList = productImageService.getAllByProductId(productVo.getId());
            productVo.setImages(productImageVoList);
        }
        if (include.contains("attr")) {
            // 2.1 get category attribute groups
            List<AttributeGroupVo> attributeGroupVoList = attributeGroupService.getAllByCategoryId(productVo.getCategoryId(), null);
            attributeGroupVoList = attributeGroupVoList == null ? new ArrayList<>() : attributeGroupVoList;
            for (AttributeGroupVo attributeGroupVo : attributeGroupVoList) {
                // 2.2 get category attribute group attributes
                List<AttributeVo> attributeVoList = attributeService.getAllByAttributeGroupId(attributeGroupVo.getId(), null);
                attributeGroupVo.setAttributes(attributeVoList);
            }
            productVo.setAttributeGroups(attributeGroupVoList);
            // 2.3 get product attribute values
            List<ProductAttrbuteValueVo> productAttrbuteValueVoList = productAttrbuteValueService.getAllByProductId(productVo.getId());
            productVo.setProductAttributeValues(productAttrbuteValueVoList);
        }

        if (include.contains("sku")) {
            // 3. get sku && sku images && sku attributes
            List<SkuVo> skuVoList = skuService.getAllByProductId(productVo.getId());
            Set<SkuImageVo> skuImageVoSet = new HashSet<>();
            for (SkuVo skuVo : skuVoList) {
                // 3.1 get sku images
                List<SkuSkuImageVo> skuSkuImageVoList = skuSkuImageService.getAllBySkuId(skuVo.getId());
                List<SkuSkuImageVo> validSkuSkuImageVoList = new ArrayList<>();
                for (SkuSkuImageVo skuSkuImageVo : skuSkuImageVoList) {
                    SkuImageVo skuImageVo = skuImageService.get(skuSkuImageVo.getSkuImageId());
                    System.out.println("skuImageVo = " + skuImageVo);
                    if (skuImageVo == null) {
                        // throw new RuntimeException("sku image not found: image id = " + skuSkuImageVo.getSkuImageId() );
                    } else {
                        skuImageVoSet.add(skuImageVo);
                        skuSkuImageVo.setUrl(skuImageVo.getImg());
                        validSkuSkuImageVoList.add(skuSkuImageVo);
                    }
                }
                skuVo.setSkuSkuImages(validSkuSkuImageVoList);
                // 3.2 get sku attributes
                List<SkuAttributeValueVo> skuAttributeValueVoList = skuAttributeValueService.getAllBySkuId(skuVo.getId());
                skuVo.setSaleAttrValues(skuAttributeValueVoList);
            }
            productVo.setSkuImages(new ArrayList<>(skuImageVoSet));
            productVo.setSkus(skuVoList);
        }
    }

    @Override
    public PageData<ProductVo> page(ProductPaginationDto params) {
        PageData<ProductVo> pageData = super.page(params);

        List<ProductVo> productVoList = pageData.getList();
        for (ProductVo productVo : productVoList) {
            // 1. get brand name
            BrandEntity be = brandDao.selectById(productVo.getBrandId());
            productVo.setBrandName(be == null ? "brand not found" : be.getName());
            // 2. get category name
            CategoryEntity ce = categoryDao.selectById(productVo.getCategoryId());
            productVo.setCategoryName(ce == null ? "category not found" : ce.getName());
        }
        List<String> include = params.getInclude();
        for (ProductVo productVo : productVoList) {
            fetchInclude(productVo, include);
        }
        return pageData;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Long> publishAll(List<ProductPublishDto> dtoList) {
        System.out.println("ProductServiceImpl.publishAll");
        System.out.println("dtoList = " + dtoList);

        class ProductPublishHelper {
            ProductPublishDto dto;

            Long handleOneDto(ProductPublishDto dto) {
                this.dto = dto;
                // 1. save product
                Long productId = addProduct();
                // 2. connect the brand of the product to category
                addCategoryBrand();
                // 3. save product images
                addProductImages(productId);
                // 4. save product attribute values
                addProductAttributeValue(productId);
                // 5. save sku-related data
                handleSkuInfo(productId);
                return productId;
            }

            private Long addProduct() {
                ProductDto productDto = new ProductDto();
                // productDto.setBrandId(dto.getBrandId());
                // productDto.setCategoryId(dto.getCategoryId());
                // productDto.setName(dto.getName());
                // productDto.setDescription(dto.getDescription());
                BeanUtils.copyProperties(dto, productDto);
                System.out.println("productDto = " + productDto);
                Long productId = add(productDto);
                return productId;
            }

            private void addCategoryBrand() {
                CategoryBrandDto categoryBrandDto = new CategoryBrandDto();
                categoryBrandDto.setBrandId(dto.getBrandId());
                categoryBrandDto.setCategoryId(dto.getCategoryId());
                categoryBrandService.add(categoryBrandDto);

            }

            private void addProductImages(Long productId) {
                for (Image image : dto.getProductImageList()) {
                    ProductImageDto productImageDto = new ProductImageDto();
                    productImageDto.setProductId(productId);
                    productImageDto.setUrl(image.getUrl());
                    productImageService.add(productImageDto);
                }
            }

            private void addProductAttributeValue(Long productId) {
                for (MultiValueAttribute a : dto.getSaleAttrs()) {
                    Long attrId = a.getId();
                    ProductAttrbuteValueDto productAttrbuteValueDto = new ProductAttrbuteValueDto();
                    productAttrbuteValueDto.setProductId(productId);
                    productAttrbuteValueDto.setAttributeId(attrId);
                    productAttrbuteValueDto.setAttributeValue(ConvertUtils.listToString(a.getValues()));
                    productAttrbuteValueService.add(productAttrbuteValueDto);
                }
                for (MultiValueAttribute a : dto.getSpecAttrs()) {
                    Long attrId = a.getId();
                    ProductAttrbuteValueDto productAttrbuteValueDto = new ProductAttrbuteValueDto();
                    productAttrbuteValueDto.setProductId(productId);
                    productAttrbuteValueDto.setAttributeId(attrId);
                    productAttrbuteValueDto.setAttributeValue(ConvertUtils.listToString(a.getValues()));
                    productAttrbuteValueService.add(productAttrbuteValueDto);
                }
            }

            // handle saving of Sku/Sku Images/Sku-Image Relations/Sku Sale Attribute Values
            private void handleSkuInfo(Long productId) {
                Map<String, Long> tmpImgIdToDataId = new HashMap<>();
                class SkuHelper {
                    Sku sku;

                    void handleSku(Sku sku) {
                        this.sku = sku;
                        // 1. save sku
                        Long skuId = addSku();
                        // 2. save sku images & save sku-image relations
                        handleSkuImages(skuId);
                        // 3. save sku sale attribute values
                        addSkuSaleAttributeValues(skuId);
                        // 4. TODO: save gift-card-bonus, prime-discount
                    }

                    Long addSku() {
                        SkuDto skuDto = new SkuDto();
                        skuDto.setProductId(productId);
                        // skuDto.setName(sku.getName());
                        // skuDto.setDescription(sku.getDescription());
                        // skuDto.setTitle(sku.getTitle());
                        // skuDto.setSubtitle(sku.getSubtitle());
                        // // BigDecimal price = sku.getPrice() != null ? new BigDecimal(sku.getPrice()) : null;
                        // skuDto.setPrice(sku.getPrice());
                        BeanUtils.copyProperties(sku, skuDto);
                        System.out.println("skuDto = " + skuDto);
                        Long skuId = skuService.add(skuDto);
                        return skuId;
                    }

                    void handleSkuImages(Long skuId) {
                        // Map<String, Long> tmpImgIdToDataId = new HashMap<>();
                        // // save sku images and record the mapping from tmp id to data id
                        // for (Image image : dto.getSkuImageList()) {
                        //     SkuImageDto skuImageDto = new SkuImageDto();
                        //     skuImageDto.setImg(image.getUrl());
                        //     Long skuImageId = skuImageService.add(skuImageDto);
                        //     tmpImgIdToDataId.put(image.getId(), skuImageId);
                        // }
                        // save sku-image relations
                        for (String tmpId : sku.getImageIdList()) {
                            Long dataId = tmpImgIdToDataId.get(tmpId);
                            SkuSkuImageDto skuSkuImageDto = new SkuSkuImageDto();
                            skuSkuImageDto.setSkuImageId(dataId);
                            skuSkuImageDto.setSkuId(skuId);
                            skuSkuImageService.add(skuSkuImageDto);
                        }
                    }

                    void addSkuSaleAttributeValues(Long skuId) {
                        for (SingleValueAttribute a : sku.getSaleAttrs()) {
                            SkuAttributeValueDto skuAttributeValueDto = new SkuAttributeValueDto();
                            skuAttributeValueDto.setSkuId(skuId);
                            skuAttributeValueDto.setAttributeId(a.getId());
                            skuAttributeValueDto.setAttributeValue(a.getValue());
                            skuAttributeValueService.add(skuAttributeValueDto);
                        }
                    }

                }

                // save sku images and record the mapping from tmp id to data id
                for (Image image : dto.getSkuImageList()) {
                    SkuImageDto skuImageDto = new SkuImageDto();
                    skuImageDto.setImg(image.getUrl());
                    Long skuImageId = skuImageService.add(skuImageDto);
                    tmpImgIdToDataId.put(image.getId(), skuImageId);
                }

                SkuHelper helper = new SkuHelper();
                List<Sku> skuList = dto.getSkuList();
                for (Sku sku : skuList) {
                    helper.handleSku(sku);
                }
            }
        }

        ProductPublishHelper helper = new ProductPublishHelper();
        List<Long> productIdList = new ArrayList<>();
        for (ProductPublishDto dto : dtoList) {
            Long id = helper.handleOneDto(dto);
            productIdList.add(id);
        }
        return productIdList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void manageAll(List<ProductManageDto> dtoList) {
        class ProductManageHelper {
            ProductManageDto dto;

            void handleOneDto(ProductManageDto dto) {
                this.dto = dto;
                // 1. update product
                updateProduct();
                // 2. update product images
                updateProductImages();
                // 3. update product attributes
                updateProductAttributes();
                // 4. update sku info
            }

            void updateProduct() {
                ProductDto productDto = dto.getProductToUpdate();
                if (productDto == null) {
                    return;
                }
                productDto.setId(dto.getId());
                update(productDto);
            }

            void updateProductImages() {
                // 1. delete all product images
                if (dto.getProductImageIdsToDelete() != null)
                    productImageService.removeAll(dto.getProductImageIdsToDelete());
                // 2. add new product images
                if (dto.getProductImagesToAdd() != null) {
                    for (ProductImageDto productImageDto : dto.getProductImagesToAdd()) {
                        productImageDto.setProductId(dto.getId());
                        productImageService.add(productImageDto);
                    }
                }
            }

            void updateProductAttributes() {
                List<ProductAttrbuteValueDto> list = dto.getProductAttrValuesToUpdate();
                if (list != null) {
                    for (ProductAttrbuteValueDto productAttrbuteValueDto : list) {
                        productAttrbuteValueService.update(productAttrbuteValueDto);
                    }
                }
            }

            void updateSkuInfo() {
                Map<String, Long> tmpImgIdToDataId = new HashMap<>();
                // 1. update sku
                // 2. update sku images
                //  2.1 delete sku images
                List<Long> skuImageIdsToDelete = dto.getSkuImageIdsToDelete();
                if (skuImageIdsToDelete != null) {
                    skuImageService.removeAll(skuImageIdsToDelete);
                }
                // 2.2 add sku images
                List<SkuImageDto> skuImagesToAdd = dto.getSkuImagesToAdd();
                if (skuImagesToAdd != null) {
                    for (SkuImageDto skuImageDto : skuImagesToAdd) {
                        Long skuImageId = skuImageService.add(skuImageDto);
                        tmpImgIdToDataId.put(skuImageDto.getUid(), skuImageId);
                    }
                }
                // 3. update sku sale attribute values
            }

        }
        ProductManageHelper helper = new ProductManageHelper();
        for (ProductManageDto dto : dtoList) {
            helper.handleOneDto(dto);
        }
    }

    @Override
    public PageData<ProductSearchVo> search(ProductSearchParams params) {
        List<AttrFilter> specAttrFilters = removeFilterWithEmptyValue(params.getSpecAttrFilters());
        List<AttrFilter> saleAttrFilters = removeFilterWithEmptyValue(params.getSaleAttrFilters());
        // 1. get product ids by 3rd level category id or spec attributes
        Long categoryId = params.getCategoryId();
        if (categoryId == null && (specAttrFilters == null || specAttrFilters.isEmpty())) {
            throw new IllegalArgumentException("ProductServiceImpl: both categoryId and specAttrFilters are null");
        }
        List<Long> productIdList = new ArrayList<>();
        if (specAttrFilters != null && !specAttrFilters.isEmpty()) {
            // attributes many to one category, product many to one category
            //  thus product satisfying a attribute must belong to the corresponding category
            productIdList = getProductIdListBySpecAttrFilters(specAttrFilters);
        } else {
            productIdList = productDao.selectProductIdsByCategoryId(categoryId);
        }
        System.out.println("productIdList = " + productIdList);
        if (productIdList == null || productIdList.isEmpty()) {
            return new PageData<>(new ArrayList<>(), 1, params.getPageSize(), 0);
        }
        // 2. get sku ids by product id & filter by price, TODO: filter by saleCount, reviews
        List<Long> skuIds = getSkuIdsByProductIdListAndPriceRange(productIdList, params.getMinPrice(), params.getMaxPrice());
        if (skuIds == null || skuIds.isEmpty()) {
            return new PageData<>(new ArrayList<>(), 1, params.getPageSize(), 0);
        }
        // 3. filter pre result skus by sale attributes
        if (saleAttrFilters != null && !saleAttrFilters.isEmpty()) {
            skuIds = getSkuIdListBySkuIdListAndSaleAttrFilters(skuIds, saleAttrFilters);
        }
        if (skuIds == null || skuIds.isEmpty()) {
            return new PageData<>(new ArrayList<>(), 1, params.getPageSize(), 0);
        }
        // 4. page & sort skus
        Set<String> validSortFields = new HashSet<>(List.of("final_price"));
        Set<String> validSortOrders = new HashSet<>(List.of(Constant.ASC, Constant.DESC));
        List<String> sortFields = params.getOrderFields();
        List<String> sortOrders = params.getOrderTypes();

        QueryWrapper<SkuEntity> wrapper = new QueryWrapper<>();
        wrapper.in("id", skuIds);
        if (sortFields != null && sortOrders != null && sortFields.size() == sortOrders.size()) {
            for (int i = 0; i < sortFields.size(); i++) {
                String sortField = sortFields.get(i);
                String sortOrder = sortOrders.get(i);
                if (validSortFields.contains(sortField) && validSortOrders.contains(sortOrder)) {
                    wrapper.orderBy(true, sortOrder.equals(Constant.ASC), sortField);
                }
            }
        }
        PageData<SkuVo> skuVoPageData = skuService.page((PaginationDto) params, wrapper);
        List<ProductSearchVo> result = new ArrayList<>();
        if (skuVoPageData.getList() == null || skuVoPageData.getList().isEmpty()) {
            return new PageData<>(result, skuVoPageData.getCurrent(), skuVoPageData.getPageSize(), skuVoPageData.getTotal());
        }
        for (SkuVo skuVo : skuVoPageData.getList()) {
            List<SkuImageVo> images = skuImageService.getAllBySkuId(skuVo.getId());
            skuVo.setSkuImages(images);
            ProductSearchVo productSearchVo = new ProductSearchVo();
            productSearchVo.setSku(skuVo);
            result.add(productSearchVo);
        }
        return new PageData<>(result, skuVoPageData.getCurrent(), skuVoPageData.getPageSize(), skuVoPageData.getTotal());
    }
    private List<Long> getSkuIdListBySkuIdListAndSaleAttrFilters(List<Long> skuIds, List<AttrFilter> saleAttrFilters) {
        if (saleAttrFilters == null || saleAttrFilters.isEmpty()) {
            return skuIds == null ? new ArrayList<>() : skuIds;
        }
        if (skuIds == null || skuIds.isEmpty()) {
            return new ArrayList<>();
        }
        QueryWrapper<SkuAttributeValueEntity> wrapper = new QueryWrapper<>();
        wrapper.in("sku_id", skuIds);
        wrapper.and(w -> {
            for (AttrFilter attrFilter : saleAttrFilters) {
                if (attrFilter.getValues() == null || attrFilter.getValues().isEmpty()) {
                    continue;
                }
                for (String value : attrFilter.getValues()) {
                    w.or().eq("attribute_id", attrFilter.getId()).eq("attribute_value", value);
                }
            }
        });
        wrapper.groupBy("sku_id").having("count(*) = {0}", saleAttrFilters.size());
        wrapper.select("sku_id");
        List<SkuAttributeValueEntity> skuAttributeValueEntities = skuAttributeValueDao.selectList(wrapper);
        if (skuAttributeValueEntities == null || skuAttributeValueEntities.isEmpty()) {
            return new ArrayList<>();
        }
        return skuAttributeValueEntities.stream().map(SkuAttributeValueEntity::getSkuId).collect(Collectors.toList());
    }
    private List<Long> getSkuIdsByProductIdListAndPriceRange(List<Long> productIdList, BigDecimal minPrice, BigDecimal maxPrice) {
        if (productIdList == null || productIdList.isEmpty()) {
            return new ArrayList<>();
        }
        QueryWrapper<SkuEntity> wrapper = new QueryWrapper<>();
        wrapper.in("product_id", productIdList);
        wrapper.ge(minPrice != null, "final_price", minPrice);
        wrapper.le(maxPrice != null, "final_price", maxPrice);
        wrapper.select("id");
        List<SkuEntity> skuEntities = skuDao.selectList(wrapper);
        if (skuEntities == null || skuEntities.isEmpty()) {
            return new ArrayList<>();
        }
        return skuEntities.stream().map(SkuEntity::getId).collect(Collectors.toList());
    }
    private List<Long> getProductIdListBySpecAttrFilters(List<AttrFilter> specAttrFilters) {
        if (specAttrFilters == null || specAttrFilters.isEmpty()) {
            return new ArrayList<>();
        }
        QueryWrapper<ProductAttrbuteValueEntity> queryWrapper = new QueryWrapper<>();
        for (AttrFilter attrFilter : specAttrFilters) {
            Long id = attrFilter.getId();
            List<String> values = attrFilter.getValues();
            if (values == null || values.isEmpty()) {
                continue;
            }
            for (String value : values) {
                queryWrapper.or().eq("attribute_id", id).eq("attribute_value", value);
            }
        }
        queryWrapper.groupBy("product_id").having("count(product_id) = {0}", specAttrFilters.size());
        queryWrapper.select("product_id");
        List<ProductAttrbuteValueEntity> list = productAttrbuteValueDao.selectList(queryWrapper);
        list = list == null ? new ArrayList<>() : list;
        return list.stream().map(ProductAttrbuteValueEntity::getProductId).collect(Collectors.toList());
    }
    private List<AttrFilter> removeFilterWithEmptyValue(List<AttrFilter> attrFilters) {
        if (attrFilters == null || attrFilters.isEmpty()) {
            return new ArrayList<>();
        }
        return attrFilters.stream().filter(attrFilter -> attrFilter.getValues() != null && !attrFilter.getValues().isEmpty()).collect(Collectors.toList());
    }
}