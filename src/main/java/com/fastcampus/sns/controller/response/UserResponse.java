package com.fastcampus.sns.controller.response;

import com.fastcampus.sns.model.User;
import com.fastcampus.sns.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String userName;
    private String password;
    private UserRole userRole;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static UserResponse fromUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .password(user.getPassword())
                .userRole(user.getUserRole())
                .registeredAt(user.getRegisteredAt())
                .updatedAt(user.getUpdatedAt())
                .deletedAt(user.getDeletedAt())
                .build();
    }

}
