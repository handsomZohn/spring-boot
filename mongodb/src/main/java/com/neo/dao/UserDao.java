package com.neo.dao;

import com.neo.entity.UserEntity;

/**
 * Created by summer on 2017/5/5.
 */
public interface UserDao {

    void saveUser(UserEntity user);

    UserEntity findUserByUserName(String userName);

    int updateUser(UserEntity user);

    void deleteUserById(Long id);

}
