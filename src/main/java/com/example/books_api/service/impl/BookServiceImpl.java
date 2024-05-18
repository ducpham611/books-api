package com.example.books_api.service.impl;

import com.example.books_api.DTO.BookDTO;
import com.example.books_api.bean.BaseResponse;
import com.example.books_api.bean.book.BookCreateRequest;
import com.example.books_api.bean.book.BookUpdateRequest;
import com.example.books_api.constant.BaseResponseCode;
import com.example.books_api.entity.Book;
import com.example.books_api.mapper.BookMapper;
import com.example.books_api.repository.AuthorRepository;
import com.example.books_api.repository.BookRepository;
import com.example.books_api.repository.CategoryRepository;
import com.example.books_api.service.BookService;
import com.example.books_api.validation.BookValidate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;

    @Override
    public BaseResponse createBook(BookCreateRequest createRequest) {
        log.info("Begin create book with data: {}", createRequest);
        if (!BookValidate.validateCreateRequest(createRequest)) {
            log.info("Invalid book create request");
            return BaseResponse.of(BaseResponseCode.INVALID_REQUEST);
        }
        if (null != bookRepository.findByBookNameAndAuthorIdAndCategoryId(
                createRequest.getName(), createRequest.getAuthorId(), createRequest.getCategoryId())) {
            log.info("Book data existed in database");
            return BaseResponse.of(BaseResponseCode.BOOK_EXIST);
        }
        if (authorRepository.findById(createRequest.getAuthorId()).isEmpty()) {
            log.info("Author not exist in database");
            return BaseResponse.of(BaseResponseCode.AUTHOR_NOT_EXIST);
        }
        if (categoryRepository.findById(createRequest.getCategoryId()).isEmpty()) {
            log.info("Category not exist in database");
            return BaseResponse.of(BaseResponseCode.CATEGORY_NOT_EXIST);
        }
        Book newBook = Book.builder()
                .bookName(createRequest.getName())
                .authorId(createRequest.getAuthorId())
                .categoryId(createRequest.getCategoryId())
                .publishedDate(createRequest.getPublishedDate())
                .pageCount(createRequest.getPageCount())
                .build();
        bookRepository.save(newBook);
        log.info("Create new book successfully");
        return BaseResponse.ok();
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOList = bookList.stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
        log.info("List book found with :{} results", bookDTOList.size());
        return bookDTOList;
    }

    @Override
    public BookDTO findBookById(Integer id) {
        log.info("Begin find book data with id: {}", id);
        Optional<Book> bookData = bookRepository.findById(id);
        if (bookData.isEmpty()) {
            log.info("Book not exist");
            return null;
        }
        BookDTO bookDTOData = bookMapper.toBookDTO(bookData.get());
        log.info("Book data found: {}", bookDTOData);
        return bookDTOData;
    }

    @Override
    public boolean deleteBookById(Integer id) {
        Optional<Book> bookData = bookRepository.findById(id);
        if (bookData.isEmpty()) {
            log.info("Book not exist, failed to delete book data");
            return false;
        }
        bookRepository.delete(bookData.get());
        log.info("Delete book data successfully");
        return true;
    }

    @Override
    @Transactional
    public BaseResponse updateBook(BookUpdateRequest updateRequest) {
        if (!BookValidate.validateUpdateRequest(updateRequest)) {
            log.info("Invalid update book request");
            return BaseResponse.of(BaseResponseCode.INVALID_REQUEST);
        }
        Optional<Book> bookData = bookRepository.findById(updateRequest.getId());
        if (bookData.isEmpty()) {
            log.info("Book data not exist");
            return BaseResponse.of(BaseResponseCode.BOOK_NOT_EXIST);
        }
        if (authorRepository.findById(updateRequest.getAuthorId()).isEmpty()) {
            log.info("Author not exist in database");
            return BaseResponse.of(BaseResponseCode.AUTHOR_NOT_EXIST);
        }
        if (categoryRepository.findById(updateRequest.getCategoryId()).isEmpty()) {
            log.info("Category not exist in database");
            return BaseResponse.of(BaseResponseCode.CATEGORY_NOT_EXIST);
        }
        Book bookDataUpdate = bookData.get();
        log.info("Book data found: {}", bookDataUpdate);
        bookDataUpdate.setBookName(updateRequest.getName());
        bookDataUpdate.setAuthorId(updateRequest.getAuthorId());
        bookDataUpdate.setCategoryId(updateRequest.getCategoryId());
        bookDataUpdate.setPublishedDate(updateRequest.getPublishedDate());
        bookDataUpdate.setPageCount(updateRequest.getPageCount());
        bookRepository.save(bookDataUpdate);
        log.info("Update book data successfully");
        return BaseResponse.ok();
    }
}
