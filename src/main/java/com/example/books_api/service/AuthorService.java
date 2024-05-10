package com.example.books_api.service;

import com.example.books_api.bean.AuthorCreateRequest;
import com.example.books_api.bean.AuthorUpdateRequest;
import com.example.books_api.bean.BaseResponse;
import com.example.books_api.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    BaseResponse createAuthor(AuthorCreateRequest authorCreateRequest);
    Author findAuthorById(Integer id);
    boolean deleteAuthorById(Integer id);
    BaseResponse updateAuthor(AuthorUpdateRequest authorUpdateRequest);

}
