package com.ecommerce.common.service.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.ecommerce.common.dao.BaseJpaDao;
import com.ecommerce.common.dto.BaseJpaDto;
import com.ecommerce.common.dto.PaginationDto;
import com.ecommerce.common.entity.BaseJpaEntity;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.BaseJpaCrudService;
import com.ecommerce.common.utils.ConvertUtils;
import com.ecommerce.common.vo.BaseJpaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Selection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseJpaCrudServiceImpl <
        DaoT extends BaseJpaDao<EntityT, ID>,
        EntityT extends BaseJpaEntity<EntityT>,
        DtoT extends BaseJpaDto<DtoT>,
        VoT extends BaseJpaVo<VoT>,
        ID extends Serializable
        >
        implements BaseJpaCrudService<EntityT, DtoT, VoT, ID>
{

    @Autowired
    protected DaoT baseDao;

    @SuppressWarnings("unchecked")
    private Class<VoT> currentVoClass() {
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(getClass(), BaseJpaCrudServiceImpl.class);
        if (generics == null) {
            throw new RuntimeException("Internal error in BaseJpaCrudServiceImpl: Type arguments cannot be determined automatically");
        }
        return (Class<VoT>) generics[3];

    }
    @SuppressWarnings("unchecked")
    private Class<EntityT> currentEntityClass() {
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(getClass(), BaseJpaCrudServiceImpl.class);
        if (generics == null) {
            throw new RuntimeException("Internal error in BaseJpaCrudServiceImpl: Type arguments cannot be determined automatically");
        }
        return (Class<EntityT>) generics[1];
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
    public VoT get(ID id) {
        EntityT e =  baseDao.findById(id).orElse(null);
        return entityToVo(e);
    }

    @Override
    public void saveAll(List<DtoT> dtoList) {
        if (dtoList == null || dtoList.size() == 0) {
            return;
        }
        List<EntityT> entityList = dtoToEntity(dtoList);
        List<EntityT> res = baseDao.saveAll(entityList);
    }

    @Override
    public void removeAll(List<ID> idList) {
        if (idList == null || idList.size() == 0) {
            return;
        }
        baseDao.deleteAllById(idList);
    }
    @Override
    public List<VoT> getAll() {
        List<EntityT> entityList = baseDao.findAll();
        return entityToVo(entityList);
    }

    @Override
    public <P extends PaginationDto> List<VoT> getAll(P pagination) {
        List<EntityT> entityList = baseDao.findAll();
        return entityToVo(entityList);
    }
/*
    @Override
    public <P extends PaginationDto> PageData<VoT> page(P params) {
        Pageable pageable = PageRequest.of(params.getCurrent().intValue() - 1, params.getPageSize().intValue());
        if (params.getOrderFields() != null && !params.getOrderFields().isEmpty()) {
            List<Order> orders = new ArrayList<>();
            for (int i = 0; i < params.getOrderFields().size(); i++) {
                String field = params.getOrderFields().get(i);
                String type = params.getOrderTypes().get(i);
                Order order = new Order(Direction.fromString(type), field);
                orders.add(order);
            }
            Sort sort = Sort.by(orders);
            pageable = PageRequest.of(params.getCurrent().intValue() - 1, params.getPageSize().intValue(), sort);
        }
        Specification<EntityT> specification = (root, query, builder) -> {
            Predicate predicate = builder.conjunction();
            if (params.getInclude() != null && !params.getInclude().isEmpty()) {
                List<Selection<?>> selections = new ArrayList<>();
                for (String field : params.getInclude()) {
                    Selection<?> selection = root.get(field);
                    selections.add(selection);
                }
                query.multiselect(selections);
            }
            if (params.getIds() != null && !params.getIds().isEmpty()) {
                Expression<Long> idExpression = root.get("id");
                predicate = builder.and(predicate, idExpression.in(params.getIds()));
            }
            return predicate;
        };
        Page<EntityT> page = baseDao.findAll(specification, pageable);
        List<MyEntity> content = page.getContent();
        List<VoT> items = content.stream().map(entity -> {
            VoT vo = new VoT();
            vo.setField1(entity.getField1());
            vo.setField2(entity.getField2());
            return vo;
        }).collect(Collectors.toList());
        PageData<VoT> result = new PageData<>();
        result.setItems(items);
        result.setTotal(page.getTotalElements());
        return result;
    }
   */
}
