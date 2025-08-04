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

}
