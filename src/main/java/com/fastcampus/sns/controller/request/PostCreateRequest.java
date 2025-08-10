package com.fastcampus.sns.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostCreateRequest {

    private String title;
    private String body;

}
