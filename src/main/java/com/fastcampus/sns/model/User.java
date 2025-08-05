package com.fastcampus.sns.model;

import com.fastcampus.sns.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

// TODO : implement
@Getter
@Builder
@AllArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private String password;
    private UserRole userRole;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static User fromEntity(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .userRole(userEntity.getRole())
                .registeredAt(userEntity.getRegisteredAt())
                .updatedAt(userEntity.getUpdatedAt())
                .deletedAt(userEntity.getDeletedAt())
                .build();
    }

}
