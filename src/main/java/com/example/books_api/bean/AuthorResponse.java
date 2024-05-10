package com.example.books_api.bean;

import com.example.books_api.entity.Author;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class AuthorResponse {
    private String code;
    private String message;
    private String responseId;
    private String responseTime;
    private Author data;
}
