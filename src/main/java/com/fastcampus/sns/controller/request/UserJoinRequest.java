package com.fastcampus.sns.controller.request;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserJoinRequest {

    private String name;
    private String password;

    @Builder
    public UserJoinRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
