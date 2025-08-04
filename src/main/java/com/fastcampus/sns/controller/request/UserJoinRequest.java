package com.fastcampus.sns.controller.request;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserJoinRequest {

    private String userName;
    private String password;

    @Builder
    public UserJoinRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
