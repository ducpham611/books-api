package com.example.books_api.mapper;

import com.example.books_api.DTO.BookDTO;
import com.example.books_api.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "authorData.authorName", target = "authorName")
    @Mapping(source = "categoryData.categoryName", target = "categoryName")
    BookDTO toBookDTO(Book book);
}
