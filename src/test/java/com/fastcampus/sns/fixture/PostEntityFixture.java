package com.fastcampus.sns.fixture;

import com.fastcampus.sns.model.entity.PostEntity;
import com.fastcampus.sns.model.entity.UserEntity;

public class PostEntityFixture {

    public static PostEntity get(Integer postId, String userName, String title, String body) {
        return PostEntity.builder()
                .id(postId)
                .user(UserEntity.builder()
                        .id(1)
                        .userName(userName)
                        .build()
                )
                .title(title)
                .body(body)
                .build();
    }

    public static PostEntity get(Integer postId, Integer userId, String userName, String title, String body) {
        return PostEntity.builder()
                .id(postId)
                .user(UserEntity.builder()
                        .id(userId)
                        .userName(userName)
                        .build()
                )
                .title(title)
                .body(body)
                .build();
    }

}
