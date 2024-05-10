package com.example.books_api.bean;

import lombok.Data;

@Data
public class AuthorUpdateRequest {
    private Integer id;
    private String authorName;
    private String gender;
    private String bornAddress;
    private Integer age;
}
