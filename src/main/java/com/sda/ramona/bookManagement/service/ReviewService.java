package com.sda.ramona.bookManagement.service;

import com.sda.ramona.bookManagement.service.exceptions.BookNotFoundException;

public interface ReviewService {
        void createReview(String score, String comment, Integer bookId) throws BookNotFoundException;

    }

