package com.sda.ramona.bookManagement;



import com.sda.ramona.bookManagement.controller.*;
import com.sda.ramona.bookManagement.service.AuthorServiceImpl;
import com.sda.ramona.bookManagement.service.BookService;
import com.sda.ramona.bookManagement.service.BookServiceImpl;
import com.sda.ramona.bookManagement.utils.SessionManager;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        SessionManager.getSessionFactory();

//        AuthorService authorService = new AuthorServiceImpl();
//        authorService.importAuthorsFromFile();
//
//        BookService bookService = new BookServiceImpl();
//        bookService.importBooksFromFile();

        BookController bookController = new BookControllerImpl();
        AuthorController authorController = new AuthorControllerImpl();
    //    ReviewController reviewController = new ReviewControllerImpl();

        System.out.println("Booking Management is Running! Starting !!!");

        String option = null;
        do {
            printMenu();
            System.out.println("Please insert your option:");
            option = SCANNER.nextLine();
            MenuOption menuOption = findByOption(option);
//            if (menuOption == null) {
//                System.out.println("Option is not valid");
//            } else {
//
//            }

            switch (menuOption) {
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case CREATE_BOOK_WITH_AUTHOR:
                    bookController.createBookWithAuthor();
                    break;
                case VIEW_ALL_AUTHOR:
                    authorController.viewAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;
           //     case ADD_REVIEW:
          //          reviewController.addReview();
          //          break;
         //       case VIEW_REVIEWS_FOR_BOOK:
         //           reviewController.getReviewForBook();
         //           break;
                case EXIT:
                    System.out.println("Finish, bye, bye");
                    break;
                default:
                    System.out.println("Option is not valid!");
            }
        } while (option == null || !option.equals("EXIT"));

        SessionManager.shutDown();

    }

    private static void printMenu() {
        System.out.println("Menu:");
        // MenuOption menuOption = MenuOption.CREATE_BOOK;
        for (MenuOption menuOption : MenuOption.values()) {
            if (!menuOption.equals(MenuOption.UNDEFINED)) {
                System.out.println(menuOption.getOption() + " -> " + menuOption.getDescription());
            }
        }

        //System.out.println("1: CREATE BOOK");
        //System.out.println("2: Create author");
        //System.out.println("EXIT: EXIT");
    }

    public static MenuOption findByOption(String option) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.getOption().equals(option)) {
                return menuOption;
            }
        }
        return MenuOption.UNDEFINED;
    }
}