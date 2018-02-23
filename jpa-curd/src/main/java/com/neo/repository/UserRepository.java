package com.neo.repository;

import com.neo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring data jpa 默认预先生成了一些基本的CURD的方法，例如：增、删、改等等
 *
 * 相当于dao
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findUserByUserName(String username);

    Long deleteById(Long id);
}