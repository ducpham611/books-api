package com.example.books_api.service;

import com.example.books_api.bean.BaseResponse;
import com.example.books_api.bean.CategoryCreateRequest;
import com.example.books_api.bean.CategoryUpdateRequest;
import com.example.books_api.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    BaseResponse createCategory(CategoryCreateRequest categoryCreateRequest);
    Category findCategoryById(Integer id);
    boolean deleteCategoryById(Integer id);
    BaseResponse updateCategory(CategoryUpdateRequest categoryUpdateRequest);
}
