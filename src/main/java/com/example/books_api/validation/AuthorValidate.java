package com.example.books_api.validation;

import com.example.books_api.bean.AuthorCreateRequest;
import com.example.books_api.bean.AuthorUpdateRequest;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorValidate {
    public static boolean validateAuthorRequest(AuthorCreateRequest authorCreateRequest) {
        if (StringUtils.isBlank(authorCreateRequest.getAuthorName())) {
            log.info("authorName cannot be null or empty or blank");
            return false;
        }
        if (StringUtils.isBlank(authorCreateRequest.getGender())) {
            log.info("gender cannot be null or empty or blank");
            return false;
        }
        if (StringUtils.isBlank(authorCreateRequest.getBornAddress())) {
            log.info("bornAddress cannot be null or empty or blank");
            return false;
        }
        if (null == authorCreateRequest.getAge()) {
            log.info("age cannot be null or empty or blank");
            return false;
        }
        log.info("Validate successfully!");
        return true;
    }

    public static boolean validateAuthorUpdateRequest(AuthorUpdateRequest authorUpdateRequest) {
        if (StringUtils.isBlank(authorUpdateRequest.getAuthorName())) {
            log.info("authorName cannot be null or empty or blank");
            return false;
        }
        if (StringUtils.isBlank(authorUpdateRequest.getGender())) {
            log.info("gender cannot be null or empty or blank");
            return false;
        }
        if (StringUtils.isBlank(authorUpdateRequest.getBornAddress())) {
            log.info("bornAddress cannot be null or empty or blank");
            return false;
        }
        if (null == authorUpdateRequest.getAge()) {
            log.info("age cannot be null or empty or blank");
            return false;
        }
        log.info("Validate successfully!");
        return true;
    }
}
