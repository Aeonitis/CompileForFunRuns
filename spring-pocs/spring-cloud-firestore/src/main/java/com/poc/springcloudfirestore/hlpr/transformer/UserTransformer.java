package com.poc.springcloudfirestore.hlpr.transformer;

import com.poc.springcloudfirestore.modl.User;
import com.poc.springcloudfirestore.modl.dao.UserDao;
import com.poc.springcloudfirestore.modl.rqst.CreateUserRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {

    public static User transformToBaseEntity(UserDao userDao) {

        return User.builder()
                .emailAddress(userDao.getEmailAddress())
                .userId(userDao.getUserId())
                .firstName(userDao.getFirstName())
                .lastName(userDao.getLastName())
                .build();
    }

    public static User transformToBaseEntity(CreateUserRequest createUserRequest) {

        return User.builder()
                .emailAddress(createUserRequest.getEmailAddress())
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .build();
    }

    public static UserDao transformToDao(User user) {

        return UserDao.builder()
                .emailAddress(user.getEmailAddress())
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

}
