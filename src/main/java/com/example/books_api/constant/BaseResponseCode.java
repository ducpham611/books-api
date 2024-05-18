package com.example.books_api.constant;

public enum BaseResponseCode {
    SUCCESS("00", "Success!"),
    INVALID_REQUEST("01", "Invalid request!"),
    AUTHOR_NOT_EXIST("02", "Author not exist!"),
    AUTHOR_EXIST("03", "Author existed"),
    CATEGORY_NOT_EXIST("10", "Category not exist!"),
    CATEGORY_EXIST("11", "Category existed"),
    BOOK_NOT_EXIST("20", "Book not exist!"),
    BOOK_EXIST("21", "Book existed");

    private final String code;
    private final String message;

    BaseResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
