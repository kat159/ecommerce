package com.ecommerce.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ecommerce.common.utils.PageUtils;
import com.ecommerce.common.utils.Query;
import com.ecommerce.product.dao.CategoryDao;
import com.ecommerce.product.dto.CategoryDto;
import com.ecommerce.product.entity.CategoryEntity;
import com.ecommerce.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryDto> listWithTree() {
        //1.查出所有分类
        //    这里的baseMapper是继承了ServiceImpl的，所以可以直接调用
        List<CategoryEntity> entities = baseMapper.selectList(null);
        List<CategoryDto> dtoList = new ArrayList<>();
        for (CategoryEntity entity : entities) {
            CategoryDto dto = new CategoryDto();
            dto.setCatId(entity.getCatId());
            dto.setName(entity.getName());
            dto.setParentCid(entity.getParentCid());
            dto.setCatLevel(entity.getCatLevel());
            dto.setShowStatus(entity.getShowStatus());
            dto.setSort(entity.getSort());
            dto.setIcon(entity.getIcon());
            dto.setProductUnit(entity.getProductUnit());
            dto.setProductCount(entity.getProductCount());
            dto.setChildren(new ArrayList<>());
            dtoList.add(dto);
        }

        return buildCategoryTree(dtoList);
    }

    private List<CategoryDto> buildCategoryTree(List<CategoryDto> dtoList) {
        List<CategoryDto> roots = new ArrayList<>();
        Map<Long, CategoryDto> map = new HashMap<>();  // map cid to Dto object
        for (CategoryDto dto : dtoList) {
            map.put(dto.getCatId(), dto);
        }

        for (CategoryDto dto : dtoList) {
            if (dto.getParentCid() == 0) {  // parentCid == 0 --> is root
                roots.add(dto);
            } else {  // not root --> has parent
                CategoryDto parent = map.get(dto.getParentCid());
                parent.getChildren().add(dto);
            }
        }
        return roots;
    }
}