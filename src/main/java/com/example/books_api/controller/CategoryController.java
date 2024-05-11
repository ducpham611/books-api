package com.example.books_api.controller;

import com.example.books_api.bean.BaseResponse;
import com.example.books_api.bean.CategoryCreateRequest;
import com.example.books_api.bean.CategorySearchRequest;
import com.example.books_api.bean.CategoryUpdateRequest;
import com.example.books_api.constant.BaseResponseCode;
import com.example.books_api.entity.Category;
import com.example.books_api.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Slf4j
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping(value = "/get-all")
    public BaseResponse getAllCategory() {
        log.info("List of category found: {}", categoryService.getAllCategory());
        return BaseResponse.of(BaseResponseCode.SUCCESS, categoryService.getAllCategory());
    }

    @PostMapping(value = "/create")
    public BaseResponse createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest) {
        log.info("Category data received: {}", categoryCreateRequest);
        return categoryService.createCategory(categoryCreateRequest);
    }

    @PostMapping(value = "/find-by-id")
    public BaseResponse findCategoryById(@RequestBody CategorySearchRequest categorySearchRequest) {
        log.info("Begin find category by id: {}", categorySearchRequest.getId());
        Category categoryData = categoryService.findCategoryById(categorySearchRequest.getId());
        if (null == categoryData) {
            return BaseResponse.of(BaseResponseCode.CATEGORY_NOT_EXIST);
        }
        return BaseResponse.of(BaseResponseCode.SUCCESS, categoryData);
    }

    @PostMapping(value = "delete-by-id")
    public BaseResponse deleteCategoryById(@RequestBody CategorySearchRequest categorySearchRequest) {
        log.info("Begin delete category data by id: {}", categorySearchRequest.getId());
        if (!categoryService.deleteCategoryById(categorySearchRequest.getId())) {
            return BaseResponse.of(BaseResponseCode.CATEGORY_NOT_EXIST);
        }
        return BaseResponse.ok();
    }

    @PostMapping(value = "update")
    public BaseResponse updateCategory(@RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        log.info("Begin update category with data: {}", categoryUpdateRequest);
        return categoryService.updateCategory(categoryUpdateRequest);
    }
}
