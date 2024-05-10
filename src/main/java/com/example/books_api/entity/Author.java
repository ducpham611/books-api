package com.example.books_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "author", uniqueConstraints = {@UniqueConstraint(columnNames = {"author_id"})})
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "born_address")
    private String bornAddress;
    @Column(name = "age")
    private Integer age;
}
