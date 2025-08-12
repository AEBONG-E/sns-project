package com.fastcampus.sns.controller.response;

import com.fastcampus.sns.model.User;
import com.fastcampus.sns.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserJoinResponse {

    private Integer id;
    private String userName;
    private UserRole role;

    public static UserJoinResponse fromUser(User user) {
        return UserJoinResponse.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .role(user.getUserRole())
                .build();
    }

}
