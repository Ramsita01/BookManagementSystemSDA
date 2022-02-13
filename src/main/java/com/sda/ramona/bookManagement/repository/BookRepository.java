package com.sda.ramona.bookManagement.repository;

import com.sda.ramona.bookManagement.model.Book;

public interface BookRepository extends BaseRepository<Book, Integer> {

    void createBook(Book book);

    Book findByIdAndLoadReviews(Integer id);


}