package com.example.books_api.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryCreateRequest {
    private String categoryName;
}
