package com.fastcampus.sns.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Response<T> {

    private String resultCode;
    private T result;

    public static <T> Response<T> error(String errorCode) {
        return Response.<T>builder()
                .resultCode(errorCode)
                .result(null)
                .build();
    }

    public static <T> Response<T> success(T result) {
        return Response.<T>builder()
                .resultCode("SUCCESS")
                .result(result)
                .build();
    }

}
