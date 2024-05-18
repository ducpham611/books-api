package com.example.books_api.controller;

import com.example.books_api.DTO.BookDTO;
import com.example.books_api.bean.BaseResponse;
import com.example.books_api.bean.book.BookCreateRequest;
import com.example.books_api.bean.book.BookSearchRequest;
import com.example.books_api.bean.book.BookUpdateRequest;
import com.example.books_api.constant.BaseResponseCode;
import com.example.books_api.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Slf4j
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping(value = "/create")
    public BaseResponse createBook(@RequestBody BookCreateRequest createRequest) {
        log.info("Begin create book with data: {}", createRequest);
        return bookService.createBook(createRequest);
    }

    @PostMapping(value = "/get-all")
    public BaseResponse getAllBooks() {
        log.info("Begin get all book data");
        return BaseResponse.of(BaseResponseCode.SUCCESS, bookService.getAllBooks());
    }

    @PostMapping(value = "/find-by-id")
    public BaseResponse findBookById(@RequestBody BookSearchRequest bookSearchRequest) {
        log.info("Begin find book data by id: {}", bookSearchRequest.getId());
        BookDTO bookData = bookService.findBookById(bookSearchRequest.getId());
        if (null == bookData) {
            return BaseResponse.of(BaseResponseCode.BOOK_NOT_EXIST);
        }
        return BaseResponse.of(BaseResponseCode.SUCCESS, bookData);
    }
    @PostMapping(value = "delete-by-id")
    public BaseResponse deleteBookById(@RequestBody BookSearchRequest bookSearchRequest) {
        log.info("Begin delete book data with id: {}", bookSearchRequest.getId());
        if(!bookService.deleteBookById(bookSearchRequest.getId())) {
            return BaseResponse.of(BaseResponseCode.BOOK_NOT_EXIST);
        }
        return BaseResponse.ok();
    }
    @PostMapping(value = "update")
    public BaseResponse updateBook(@RequestBody BookUpdateRequest updateRequest) {
        log.info("Begin update book with data: {}", updateRequest);
        return bookService.updateBook(updateRequest);
    }
}
