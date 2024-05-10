package com.example.books_api.repository;

import com.example.books_api.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findByAuthorNameAndGenderAndBornAddressAndAge(String authorName, String gender, String bornAddress, int age);
}
