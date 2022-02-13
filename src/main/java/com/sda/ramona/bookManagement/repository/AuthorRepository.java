package com.sda.ramona.bookManagement.repository;

import com.sda.ramona.bookManagement.model.Author;

import java.util.List;

public interface AuthorRepository extends BaseRepository<Author, Integer>{

    void createAuthor(Author author);

    //Author findById(Integer id);

    List<Author> findAll();


}
