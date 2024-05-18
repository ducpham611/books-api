package com.example.books_api.repository;

import com.example.books_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByBookNameAndAuthorIdAndCategoryId(String bookName, Integer authorId, Integer categoryId);
}
