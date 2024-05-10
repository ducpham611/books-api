package com.example.books_api.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthorCreateRequest {
    private String authorName;
    private String gender;
    private String bornAddress;
    private Integer age;
}
