package com.example.books_api.controller;

import com.example.books_api.bean.*;
import com.example.books_api.entity.Author;
import com.example.books_api.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@Slf4j
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping(value = "/get-all")
    public BaseResponse getAllAuthors() {
        log.info("List of authors found: {}", authorService.getAllAuthors());
        return BaseResponse.of(BaseResponseCode.SUCCESS, authorService.getAllAuthors());
    }

    @PostMapping(value = "/create")
    public BaseResponse createAuthor(@RequestBody AuthorCreateRequest authorCreateRequest) {
        log.info("Author data received: {}", authorCreateRequest);
        return authorService.createAuthor(authorCreateRequest);
    }

    @PostMapping(value = "/find-by-id")
    public BaseResponse findAuthorById(@RequestBody AuthorSearchRequest authorSearchRequest) {
        log.info("Begin find author by id: {}", authorSearchRequest.getId());
        Author authorData = authorService.findAuthorById(authorSearchRequest.getId());
        if (null == authorData) {
            return BaseResponse.of(BaseResponseCode.AUTHOR_NOT_EXIST);
        }
        return BaseResponse.of(BaseResponseCode.SUCCESS, authorService.findAuthorById(authorSearchRequest.getId()));
    }

    @PostMapping(value = "delete-by-id")
    public BaseResponse deleteAuthorById(@RequestBody AuthorSearchRequest authorSearchRequest) {
        log.info("Begin delete author data by id: {}", authorSearchRequest.getId());
        if (!authorService.deleteAuthorById(authorSearchRequest.getId())) {
            return BaseResponse.of(BaseResponseCode.AUTHOR_NOT_EXIST);
        }
        return BaseResponse.ok();
    }
    @PostMapping(value = "update")
    public BaseResponse updateAuthor(@RequestBody AuthorUpdateRequest authorUpdateRequest) {
        log.info("Begin update author with data: {}", authorUpdateRequest);
        return authorService.updateAuthor(authorUpdateRequest);
    }

}
