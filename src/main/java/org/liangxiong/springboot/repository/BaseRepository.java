package org.liangxiong.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author liangxiong
 * Date:2018-10-08
 * Time:20:59
 * @Description 基础公共Repository
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
}
