package com.example.books_api.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    private final String code;
    private final String message;
    private final Object data;

    public static BaseResponse ok() {
        return BaseResponse.builder()
                .code(BaseResponseCode.SUCCESS.getCode())
                .message(BaseResponseCode.SUCCESS.getMessage())
                .build();
    }

    public static BaseResponse of(BaseResponseCode baseResponseCode, Object data) {
        return BaseResponse.builder()
                .code(baseResponseCode.getCode())
                .message(baseResponseCode.getMessage())
                .data(data)
                .build();
    }

    public static BaseResponse of(BaseResponseCode baseResponseCode) {
        return BaseResponse.builder()
                .code(baseResponseCode.getCode())
                .message(baseResponseCode.getMessage())
                .build();
    }
}
