package com.sda.ramona.bookManagement.service;

import com.sda.ramona.bookManagement.model.Review;
import com.sda.ramona.bookManagement.service.exceptions.AuthorNotFoundException;
import com.sda.ramona.bookManagement.service.exceptions.BookNotFoundException;

import java.util.List;

public interface BookService {

    void createBook(String isbn, String title, String description);

    void createBook(String isbn, String title, String description, Integer authorId) throws AuthorNotFoundException;

    void importBooksFromFile();

    List<Review> getReviewsForBook(Integer bookId) throws BookNotFoundException;

}
