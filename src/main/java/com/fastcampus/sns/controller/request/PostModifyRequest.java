package com.fastcampus.sns.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
@AllArgsConstructor
public class PostModifyRequest {

    private String title;
    private String body;
    private String userName;
    private Integer postId;

}
