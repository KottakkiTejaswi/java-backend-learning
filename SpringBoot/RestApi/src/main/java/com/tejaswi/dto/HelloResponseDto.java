package com.tejaswi.dto;

public class HelloResponseDto {

    private String message;
    private String author;

    // No-args constructor (important for Spring/Jackson)
    public HelloResponseDto() {
    }

    public HelloResponseDto(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
