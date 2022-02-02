package com.sda.ramona.bookManagement.model;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="isbn")
    private String isbn;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="author_id")
     private Author author;

    public Book() {

    }


    public Book(Integer id, String isbn, String title, String description) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
