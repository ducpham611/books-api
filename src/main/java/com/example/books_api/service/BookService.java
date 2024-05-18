package com.example.books_api.service;

import com.example.books_api.DTO.BookDTO;
import com.example.books_api.bean.BaseResponse;
import com.example.books_api.bean.book.BookCreateRequest;
import com.example.books_api.bean.book.BookUpdateRequest;

import java.util.List;

public interface BookService {
    BaseResponse createBook(BookCreateRequest bookCreateRequest);

    List<BookDTO> getAllBooks();
    BookDTO findBookById(Integer id);
    boolean deleteBookById(Integer id);
    BaseResponse updateBook(BookUpdateRequest updateRequest);
}
