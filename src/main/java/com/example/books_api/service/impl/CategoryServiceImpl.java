package com.example.books_api.service.impl;

import com.example.books_api.bean.BaseResponse;
import com.example.books_api.bean.CategoryCreateRequest;
import com.example.books_api.bean.CategoryUpdateRequest;
import com.example.books_api.constant.BaseResponseCode;
import com.example.books_api.entity.Category;
import com.example.books_api.repository.CategoryRepository;
import com.example.books_api.service.CategoryService;
import com.example.books_api.validation.CategoryValidate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public BaseResponse createCategory(CategoryCreateRequest categoryCreateRequest) {
        if (!CategoryValidate.validateCreateRequest(categoryCreateRequest)) {
            log.info("Invalid create author request");
            return BaseResponse.of(BaseResponseCode.INVALID_REQUEST);
        }
        if (null != categoryRepository.findByCategoryName(categoryCreateRequest.getCategoryName())) {
            log.info("Category data existed in database");
            return BaseResponse.of(BaseResponseCode.CATEGORY_EXIST);
        }
        Category newCategory = Category.builder()
                .categoryName(categoryCreateRequest.getCategoryName())
                .build();
        categoryRepository.save(newCategory);
        log.info("Save new category successfully");
        return BaseResponse.ok();
    }

    @Override
    public Category findCategoryById(Integer id) {
        Optional<Category> categoryDataOptional = categoryRepository.findById(id);
        if (categoryDataOptional.isEmpty()) {
            log.info("Category data not found");
            return null;
        }
        log.info("Find category successfully with data: {}", categoryDataOptional.get());
        return categoryDataOptional.get();
    }

    @Override
    public boolean deleteCategoryById(Integer id) {
        Optional<Category> categoryDataOptional = categoryRepository.findById(id);
        if (categoryDataOptional.isEmpty()) {
            log.info("Category data not found, failed to delete category");
            return false;
        }
        categoryRepository.delete(categoryDataOptional.get());
        log.info("Delete category data successfully");
        return true;
    }

    @Override
    public BaseResponse updateCategory(CategoryUpdateRequest categoryUpdateRequest) {
        if (!CategoryValidate.validateUpdateRequest(categoryUpdateRequest)) {
            log.info("Invalid create author request");
            return BaseResponse.of(BaseResponseCode.INVALID_REQUEST);
        }
        Optional<Category> categoryDataOptional = categoryRepository.findById(categoryUpdateRequest.getCategoryId());
        if (categoryDataOptional.isEmpty()) {
            log.info("Category data not found");
            return BaseResponse.of(BaseResponseCode.CATEGORY_NOT_EXIST);
        }
        Category categoryUpdate = categoryDataOptional.get();
        categoryUpdate.setCategoryName(categoryUpdateRequest.getCategoryName());
        categoryRepository.save(categoryUpdate);
        log.info("Update category data successfully");
        return BaseResponse.ok();
    }

}
