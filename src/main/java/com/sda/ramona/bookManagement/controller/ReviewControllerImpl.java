package com.sda.ramona.bookManagement.controller;

import com.sda.ramona.bookManagement.service.BookService;
import com.sda.ramona.bookManagement.service.BookServiceImpl;
import com.sda.ramona.bookManagement.service.exceptions.AuthorNotFoundException;

import java.util.Scanner;

public class ReviewControllerImpl {
    public static class BookControllerImpl implements BookController {

        private static final Scanner SCANNER = new Scanner(System.in);

        private BookService bookService;

        public BookControllerImpl() {
            bookService = new BookServiceImpl();
        }

        @Override
        public void createBook() {
            System.out.println("Create book!");
            System.out.println("Please insert ISBN:");
            String isbn = SCANNER.nextLine();
            System.out.println("Please insert title:");
            String title = SCANNER.nextLine();
            System.out.println("Please insert description:");
            String description = SCANNER.nextLine();

            bookService.createBook(isbn, title, description);

        }

        @Override
        public void createBookWithAuthor() {
            System.out.println("Create book!");
            System.out.println("Please insert ISBN:");
            String isbn = SCANNER.nextLine();
            System.out.println("Please insert title:");
            String title = SCANNER.nextLine();
            System.out.println("Please insert description:");
            String description = SCANNER.nextLine();
            System.out.println("Please insert author id");
            Integer authorId = SCANNER.nextInt();

            try {
                bookService.createBook(isbn, title, description, authorId);
            } catch (AuthorNotFoundException e) {
                System.out.println("Author with id " + e.getAuthorId() + " not found!");
            }

        }
    }
}
