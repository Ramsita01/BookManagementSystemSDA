package com.sda.ramona.bookManagement.service;

import com.sda.ramona.bookManagement.model.Author;
import com.sda.ramona.bookManagement.model.Book;
import com.sda.ramona.bookManagement.model.Review;
import com.sda.ramona.bookManagement.repository.AuthorRepository;
import com.sda.ramona.bookManagement.repository.AuthorRepositoryImpl;
import com.sda.ramona.bookManagement.repository.BookRepository;

import com.sda.ramona.bookManagement.repository.BookRepositoryImpl;
import com.sda.ramona.bookManagement.service.exceptions.AuthorNotFoundException;
import com.sda.ramona.bookManagement.service.exceptions.BookNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
        authorRepository = new AuthorRepositoryImpl();

    }

    @Override
    public void createBook(String isbn, String title, String description) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setDescription(description);
        bookRepository.createBook(book);
    }

    @Override
    public void createBook(String isbn, String title, String description, Integer authorId) throws AuthorNotFoundException {
        Author author = authorRepository.findById(authorId);
        if (author != null) {
            Book book = new Book();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setDescription(description);
            book.setAuthor(author);
            bookRepository.createBook(book);
        } else {
            throw new AuthorNotFoundException("Author not found", authorId);
        }
    }

    @Override
    public void importBooksFromFile() {
        Path bookFileAbsolutePath = Paths.get("C:\\Users\\Rosu\\Documents\\book-management-system-sda\\data\\books.txt");
        try {
            Files.lines(bookFileAbsolutePath)
                    .filter(line -> line != null)
                    .filter(line -> !line.isEmpty())
                    .skip(1)
                    .forEach(line -> {
                        try {
                            String[] elements = line.split("\\|");
                            createBook(elements[0], elements[1], elements[2], Integer.parseInt(elements[3]));

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Review> getReviewsForBook(Integer bookId) throws BookNotFoundException {
        Book book = bookRepository.findByIdAndLoadReviews(bookId);
        if (book != null) {
            return book.getReviews();
        } else {
            throw new BookNotFoundException("not found book", bookId);
        }

    }
}