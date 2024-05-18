package com.example.books_api.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class BookDTO {
    private Integer bookId;
    private String bookName;
    private Integer authorId;
    private String authorName;
    private Integer categoryId;
    private String categoryName;
    private Date publishedDate;
    private Integer pageCount;
}
