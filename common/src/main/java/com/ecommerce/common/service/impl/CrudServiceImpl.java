

package com.ecommerce.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ecommerce.common.constant.Constant;
import com.ecommerce.common.dto.BaseDto;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.entity.BaseEntity;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.common.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * CRUD基础服务类
 */
public abstract class CrudServiceImpl<
        DaoT extends BaseMapper<EntityT>,
        EntityT extends BaseEntity<EntityT>,
        DtoT extends BaseDto<DtoT>,
        VoT extends BaseVo<VoT>
        >
        implements CrudService<EntityT, DtoT, VoT> {

    @Autowired
    protected DaoT baseDao;

    private Class<VoT> currentVoClass() {
        return (Class<VoT>) ReflectionKit.getSuperClassGenericType(this.getClass(), CrudServiceImpl.class, 3);
    }

    private Class<EntityT> currentEntityClass() {
        return (Class<EntityT>) ReflectionKit.getSuperClassGenericType(this.getClass(), CrudServiceImpl.class, 1);
    }

    protected EntityT dtoToEntity(DtoT dto) {
        return ConvertUtils.sourceToTarget(dto, currentEntityClass());
    }

    protected List<EntityT> dtoToEntity(List<DtoT> dtoList) {
        List<EntityT> entityList = new ArrayList<>();
        dtoList.forEach(dto -> {
            entityList.add(dtoToEntity(dto));
        });
        return entityList;
    }

    protected VoT entityToVo(EntityT entity) {
        return ConvertUtils.sourceToTarget(entity, currentVoClass());
    }

    protected List<VoT> entityToVo(List<EntityT> entityList) {
        List<VoT> voList = new ArrayList<>();
        entityList.forEach(entity -> {
            voList.add(entityToVo(entity));
        });
        return voList;
    }
    @Override
    public VoT get(Long id) {
        EntityT entity = baseDao.selectById(id);
        // return ConvertUtils.sourceToTarget(entity, currentVoClass());
        return entityToVo(entity);
    }

    @Override
    public Long add(DtoT dto) {
        // EntityT entity = ConvertUtils.sourceToTarget(dto, currentEntityClass());
        EntityT entity = dtoToEntity(dto);
        baseDao.insert(entity);
        return entity.getId();
    }

    // TODO: optimize with sql statement
    @Override
    public List<Long> addAll(List<DtoT> dtoList) {
        // List<EntityT> entityList = ConvertUtils.sourceToTarget(dtoList, currentEntityClass());
        List<EntityT> entityList = dtoToEntity(dtoList);
        List<Long> idList = new ArrayList<>();
        entityList.forEach(entity -> {
            baseDao.insert(entity);
            idList.add(entity.getId());
        });
        return idList;
    }

    @Override
    public void update(DtoT dto) {
        // EntityT entity = ConvertUtils.sourceToTarget(dto, currentEntityClass());
        EntityT entity = dtoToEntity(dto);
        baseDao.updateById(entity);
    }

    @Override
    public void updateAll(List<DtoT> dtoList) {
        // List<EntityT> entityList = ConvertUtils.sourceToTarget(dtoList, currentEntityClass());
        List<EntityT> entityList = dtoToEntity(dtoList);
        entityList.forEach(entity -> baseDao.updateById(entity));
    }

    @Override
    public void removeAll(List<Long> idList) {
        baseDao.deleteBatchIds(idList);
    }

    @Override
    public <P extends PaginationDto> PageData<VoT> page(P params) {
        return page(params, null);
    }

    @Override
    public <P extends PaginationDto> PageData<VoT> page(P params, QueryWrapper<EntityT> queryWrapper) {
        IPage<EntityT> page = getPageResult(params, queryWrapper);
        // List<VoT> dtoList = ConvertUtils.sourceToTarget(page.getRecords(), currentVoClass());
        List<VoT> dtoList = entityToVo(page.getRecords());
        return new PageData<>(dtoList, page.getCurrent(), page.getSize(), page.getTotal());
    }

    @Override
    public <P extends PaginationDto> List<VoT> getAll() {
        List<EntityT> entityList = baseDao.selectList(null);
        return entityToVo(entityList);

    }

    @Override
    public <P extends PaginationDto> List<VoT> getAll(QueryWrapper<EntityT> queryWrapper) {
        List<EntityT> entityList = baseDao.selectList(queryWrapper);
        return entityToVo(entityList);
    }

    private <P extends PaginationDto> IPage<EntityT> getPageResult(P params, QueryWrapper<EntityT> queryWrapper) {
        IPage<EntityT> page;
        while (true) {
            page = baseDao.selectPage(getPageParams(params), queryWrapper);
            if (page.getRecords().size() > 0 || page.getCurrent() == 1 || page.getTotal() == 0) {
                break;
            }
            // page exceeds the total number of pages, reset to the last page
            params.setCurrent(page.getPages());
        }
        return page;
    }

    private <P extends PaginationDto> IPage<EntityT> getPageParams(P params) {
        // Pagination parameters
        long curPage = params.getCurrent() == null ? 1 : params.getCurrent();
        long limit = params.getPageSize() == null ? 10 : params.getPageSize();

        Page<EntityT> page = new Page<>(curPage, limit);

        if (params.getOrderFields() == null && params.getOrderTypes() == null) {
            return page;
        }

        if (params.getOrderTypes() == null) {
            throw new IllegalArgumentException("orderTypes is null while orderFields is not null");
        }

        if (params.getOrderFields() == null) {
            throw new IllegalArgumentException("orderFields is null while orderTypes is not null");
        }

        if (params.getOrderFields().size() != params.getOrderTypes().size()) {
            throw new IllegalArgumentException("the sizes of orderFields and orderTypes are not equal");
        }

        for (int i = 0; i < params.getOrderFields().size(); i++) {
            String orderField = params.getOrderFields().get(i);
            String orderType = params.getOrderTypes().get(i);
            if (Constant.ASC.equalsIgnoreCase(orderType)) {
                page.addOrder(OrderItem.asc(orderField));
            } else if (Constant.DESC.equalsIgnoreCase(orderType)) {
                page.addOrder(OrderItem.desc(orderField));
            } else {
                throw new IllegalArgumentException("orderType must be asc or desc");
            }
        }
        return page;
    }
}