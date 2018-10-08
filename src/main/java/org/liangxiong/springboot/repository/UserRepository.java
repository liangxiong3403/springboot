package org.liangxiong.springboot.repository;

import org.liangxiong.springboot.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author liangxiong
 * Date:2018-10-08
 * Time:21:01
 * @Description
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

}
