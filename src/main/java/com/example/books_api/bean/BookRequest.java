package com.example.books_api.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
public class BookRequest {
    private String name;
    private Integer authorId;
    private Integer categoryId;
    private Date publishedDate;
    private String description;
    private Integer pageCount;
}
