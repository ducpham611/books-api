package com.example.books_api.bean;

import lombok.Data;

@Data
public class CategoryUpdateRequest {
    private Integer categoryId;
    private String categoryName;
}
