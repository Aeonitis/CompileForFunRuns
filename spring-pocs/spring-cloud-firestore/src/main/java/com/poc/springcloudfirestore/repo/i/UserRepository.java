package com.poc.springcloudfirestore.repo.i;

import com.poc.springcloudfirestore.modl.dao.UserDao;

public interface UserRepository {

    void insertUser(UserDao userDao);

    boolean existsByEmailAddress(String emailAddress);

    void updateUser(UserDao userDao);
}
