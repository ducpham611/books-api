package com.example.books_api.bean.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class BookUpdateRequest {
    private Integer id;
    private String name;
    private Integer authorId;
    private Integer categoryId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/HCM")
    private Date publishedDate;
    private Integer pageCount;
}
