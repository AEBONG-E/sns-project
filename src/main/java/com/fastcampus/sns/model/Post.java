package com.fastcampus.sns.model;

import com.fastcampus.sns.model.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
public class Post {

    private Integer id;
    private String title;
    private String body;
    private User user;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static Post fromEntity(PostEntity entity) {
        return Post.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .body(entity.getBody())
                .user(User.fromEntity(entity.getUser()))
                .registeredAt(entity.getRegisteredAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .build();
    }

}
