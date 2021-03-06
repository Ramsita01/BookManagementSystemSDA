package com.sda.ramona.bookManagement.service.exceptions;

public class AuthorNotFoundException extends Exception{

    private final Integer authorId;

    public AuthorNotFoundException(String message, Integer authorId) {
        super(message);
        this.authorId= authorId;
    }

    public Integer getAuthorId() {
        return authorId;
    }
}
