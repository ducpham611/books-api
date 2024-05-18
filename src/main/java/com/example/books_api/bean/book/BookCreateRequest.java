package com.example.books_api.bean.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class BookCreateRequest {
    private String name;
    private Integer authorId;
    private Integer categoryId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/HCM")
    private Date publishedDate;
    private Integer pageCount;
}
