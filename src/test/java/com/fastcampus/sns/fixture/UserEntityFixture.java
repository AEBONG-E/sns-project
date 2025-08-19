package com.fastcampus.sns.fixture;

import com.fastcampus.sns.model.entity.UserEntity;

public class UserEntityFixture {

    public static UserEntity get(String userName, String password) {
        return UserEntity.builder()
                .id(1)
                .userName(userName)
                .password(password)
                .build();
    }

    public static UserEntity get(Integer userId, String userName, String password) {
        return UserEntity.builder()
                .id(userId)
                .userName(userName)
                .password(password)
                .build();
    }

}
