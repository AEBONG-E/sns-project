package com.fastcampus.sns.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized // @Builder 어노테이션을 사용할 때 JSON 객체 역직렬화 적용
@AllArgsConstructor
public class PostCreateRequest {

    private String title;
    private String body;

}
