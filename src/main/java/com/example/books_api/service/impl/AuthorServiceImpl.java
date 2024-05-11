package com.example.books_api.service.impl;

import com.example.books_api.bean.AuthorCreateRequest;
import com.example.books_api.bean.AuthorUpdateRequest;
import com.example.books_api.bean.BaseResponse;
import com.example.books_api.constant.BaseResponseCode;
import com.example.books_api.entity.Author;
import com.example.books_api.repository.AuthorRepository;
import com.example.books_api.service.AuthorService;
import com.example.books_api.validation.AuthorValidate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public BaseResponse createAuthor(AuthorCreateRequest authorCreateRequest) {
        if (!AuthorValidate.validateAuthorRequest(authorCreateRequest)) {
            log.info("Invalid create author request");
            return BaseResponse.of(BaseResponseCode.INVALID_REQUEST);
        }
        if (null != authorRepository.findByAuthorNameAndGenderAndBornAddressAndAge(
                authorCreateRequest.getAuthorName(), authorCreateRequest.getGender(), authorCreateRequest.getBornAddress(), authorCreateRequest.getAge())) {
            log.info("Author data existed in database");
            return BaseResponse.of(BaseResponseCode.AUTHOR_EXIST);
        }
        Author newAuthor = Author.builder()
                .authorName(authorCreateRequest.getAuthorName())
                .gender(authorCreateRequest.getGender())
                .bornAddress(authorCreateRequest.getBornAddress())
                .age(authorCreateRequest.getAge())
                .build();
        authorRepository.save(newAuthor);
        log.info("Save new author successfully");
        return BaseResponse.ok();
    }

    @Override
    public Author findAuthorById(Integer id) {
        Optional<Author> authorDataOptional = authorRepository.findById(id);
        if (authorDataOptional.isEmpty()) {
            log.info("Author data not found");
            return null;
        }
        log.info("Find author successfully with data: {}", authorDataOptional.get());
        return authorDataOptional.get();
    }

    @Override
    public boolean deleteAuthorById(Integer id) {
        Optional<Author> authorDataOptional = authorRepository.findById(id);
        if (authorDataOptional.isEmpty()) {
            log.info("Author data not found, failed to delete author data by id");
            return false;
        }
        authorRepository.delete(authorDataOptional.get());
        log.info("Delete author data successfully");
        return true;
    }

    @Override
    public BaseResponse updateAuthor(AuthorUpdateRequest authorUpdateRequest) {
        if (!AuthorValidate.validateAuthorUpdateRequest(authorUpdateRequest)) {
            log.info("Invalid update author request");
            return BaseResponse.of(BaseResponseCode.INVALID_REQUEST);
        }
        Optional<Author> authorDataOptional = authorRepository.findById(authorUpdateRequest.getId());
        if (authorDataOptional.isEmpty()) {
            log.info("Author data not found");
            return BaseResponse.of(BaseResponseCode.AUTHOR_NOT_EXIST);
        }
        Author authorDataUpdate = authorDataOptional.get();
        log.info("Author data found: {}", authorDataUpdate);
        authorDataUpdate.setAuthorName(authorUpdateRequest.getAuthorName());
        authorDataUpdate.setGender(authorUpdateRequest.getGender());
        authorDataUpdate.setBornAddress(authorUpdateRequest.getBornAddress());
        authorDataUpdate.setAge(authorUpdateRequest.getAge());
        authorRepository.save(authorDataUpdate);
        log.info("Update author data successfully");
        return BaseResponse.ok();
    }
}
