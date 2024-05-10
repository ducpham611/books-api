package com.example.books_api.bean;

public enum BaseResponseCode {
    SUCCESS("00", "Success!"),
    INVALID_REQUEST("01", "Invalid request!"),
    AUTHOR_NOT_EXIST("02", "Author not exist!"),
    AUTHOR_EXIST("03", "Author existed");
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
