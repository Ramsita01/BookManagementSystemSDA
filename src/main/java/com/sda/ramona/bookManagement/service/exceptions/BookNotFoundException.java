package com.sda.ramona.bookManagement.service.exceptions;

public class BookNotFoundException extends Exception{
        private Integer bookId;

        public BookNotFoundException(String message, Integer bookId) {
            super(message);
            this.bookId = bookId;
        }

        public Integer getBookId() {
            return bookId;
        }
    }
