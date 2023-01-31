

package com.ecommerce.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.ecommerce.common.constant.Constant;
import com.ecommerce.common.page.PageData;
import com.ecommerce.common.service.CrudService;
import com.ecommerce.common.utils.ConvertUtils;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * CRUD基础服务类
 */
public abstract class CrudServiceImpl<M extends BaseMapper<EntityT>, EntityT, DtoT>
        extends BaseServiceImpl<M, EntityT>
        implements CrudService<EntityT, DtoT> {

    protected Class<DtoT> currentDtoClass() {
        return (Class<DtoT>) ReflectionKit.getSuperClassGenericType(getClass(), CrudServiceImpl.class, 2);
    }

    @Override
    public PageData<DtoT> page(Map<String, Object> params) {
        IPage<EntityT> page;
        while (true) {
            page = baseDao.selectPage(
                    getPage(params, null, false),
                    getWrapper(params)
            );
            if (page.getRecords().size() > 0 || page.getCurrent() == 1 || page.getTotal() == 0) {
                break;
            }
            // page exceeds the total number of pages, reset to the last page
            params.put(Constant.PAGE, Long.toString(page.getPages()));
        }
        return getPageData(page, currentDtoClass());
    }

    @Override
    public List<DtoT> list(Map<String, Object> params) {
        List<EntityT> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, currentDtoClass());
    }

    public abstract QueryWrapper<EntityT> getWrapper(Map<String, Object> params);

    @Override
    public DtoT get(Long id) {
        EntityT entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, currentDtoClass());
    }

    @Override
    public void save(DtoT dto) {
        EntityT entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        insert(entity);

        //copy主键值到dto
        BeanUtils.copyProperties(entity, dto);
    }

    @Override
    public void update(DtoT dto) {
        EntityT entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        updateById(entity);
    }

    @Override
    public void delete(Long[] ids) {
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }
}