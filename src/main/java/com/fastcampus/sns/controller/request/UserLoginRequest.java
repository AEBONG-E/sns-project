package com.fastcampus.sns.controller.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserLoginRequest {

    private String userName;
    private String password;

    @Builder
    public UserLoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
