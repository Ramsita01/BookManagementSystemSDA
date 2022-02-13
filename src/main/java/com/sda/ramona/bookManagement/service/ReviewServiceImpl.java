package com.sda.ramona.bookManagement.service;


import com.sda.ramona.bookManagement.model.Book;
import com.sda.ramona.bookManagement.model.Review;
import com.sda.ramona.bookManagement.repository.BookRepository;
import com.sda.ramona.bookManagement.repository.BookRepositoryImpl;
import com.sda.ramona.bookManagement.repository.ReviewRepository;
import com.sda.ramona.bookManagement.repository.ReviewRepositoryImpl;
import com.sda.ramona.bookManagement.service.exceptions.BookNotFoundException;

public class ReviewServiceImpl implements ReviewService {

        private BookRepository bookRepository;
        private ReviewRepository reviewRepository;

        public ReviewServiceImpl() {
            bookRepository = new BookRepositoryImpl();
            reviewRepository = new ReviewRepositoryImpl();
        }

        @Override
        public void createReview(String score, String comment, Integer bookId) throws BookNotFoundException{

            Book book = bookRepository.findById(bookId);
            if (book != null) {
                Review review = new Review();
                review.setScore(score);
                review.setComment(comment);
                review.setBook(book);
                reviewRepository.createEntity(review);
            } else {
                throw new BookNotFoundException("Book not found", bookId);
            }
        }
    }

