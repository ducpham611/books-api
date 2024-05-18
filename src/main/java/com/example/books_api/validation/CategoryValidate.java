package com.example.books_api.validation;

import com.example.books_api.bean.CategoryCreateRequest;
import com.example.books_api.bean.CategoryUpdateRequest;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CategoryValidate {
    public static boolean validateCreateRequest(CategoryCreateRequest categoryCreateRequest) {
        if (StringUtils.isBlank(categoryCreateRequest.getCategoryName())) {
            log.info("CategoryName cannot be null or empty or blank");
            return false;
        }
        log.info("Validate successfully");
        return true;
    }

    public static boolean validateUpdateRequest(CategoryUpdateRequest categoryUpdateRequest) {
        if (null == categoryUpdateRequest.getCategoryId()) {
            log.info("CategoryId cannot be null or empty or blank");
            return false;
        }
        if (StringUtils.isBlank(categoryUpdateRequest.getCategoryName())) {
            log.info("CategoryName cannot be null or empty or blank");
            return false;
        }
        log.info("Validate successfully");
        return true;
    }
}
