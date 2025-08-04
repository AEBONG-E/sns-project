package com.fastcampus.sns.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// TODO : implement
@Getter
@Builder
@AllArgsConstructor
public class User {

    private String userName;
    private String password;

}
