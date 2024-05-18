package com.example.books_api.validation;

import com.example.books_api.bean.book.BookCreateRequest;
import com.example.books_api.bean.book.BookUpdateRequest;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookValidate {
    public static boolean validateCreateRequest(BookCreateRequest createRequest) {
        if (StringUtils.isBlank(createRequest.getName())) {
            log.info("BookName cannot be null or empty or blank");
            return false;
        }
        if (null == createRequest.getAuthorId()) {
            log.info("AuthorId cannot be null");
            return false;
        }
        if (null == createRequest.getCategoryId()) {
            log.info("CategoryId cannot be null");
            return false;
        }
        if (null == createRequest.getPublishedDate()) {
            log.info("PublishedDate cannot be null");
            return false;
        }
        if (null == createRequest.getPageCount()) {
            log.info("PageCount cannot be null");
            return false;
        }
        log.info("Validate successfully");
        return true;
    }
    public static boolean validateUpdateRequest(BookUpdateRequest updateRequest) {
        if(null == updateRequest.getId()){
            log.info("BookId cannot be null or empty or blank");
            return false;
        }
        if (StringUtils.isBlank(updateRequest.getName())) {
            log.info("BookName cannot be null or empty or blank");
            return false;
        }
        if (null == updateRequest.getAuthorId()) {
            log.info("AuthorId cannot be null");
            return false;
        }
        if (null == updateRequest.getCategoryId()) {
            log.info("CategoryId cannot be null");
            return false;
        }
        if (null == updateRequest.getPublishedDate()) {
            log.info("PublishedDate cannot be null");
            return false;
        }
        if (null == updateRequest.getPageCount()) {
            log.info("PageCount cannot be null");
            return false;
        }
        log.info("Validate successfully");
        return true;
    }
}
