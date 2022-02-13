package com.sda.ramona.bookManagement.service;

import com.sda.ramona.bookManagement.model.Author;
import com.sda.ramona.bookManagement.service.exceptions.AuthorNotFoundException;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName);

    List<Author> findAll();

    void importAuthorsFromFile();

    void update(Integer id, String firstName, String lastName) throws AuthorNotFoundException;

    void delete(Integer id) throws AuthorNotFoundException;
}