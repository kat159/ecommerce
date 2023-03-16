package com.ecommerce.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * JPA Dao
 */
public interface BaseJpaDao<T, ID extends Serializable> extends JpaRepository<T, ID>{
}
