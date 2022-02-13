package com.sda.ramona.bookManagement.repository;


import com.sda.ramona.bookManagement.model.Book;
import com.sda.ramona.bookManagement.utils.SessionManager;
import org.hibernate.Session;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {
        public BookRepositoryImpl() {
            super(Book.class);
        }

        @Override
        public void createBook(Book book) {
//        Session session = SessionManager.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            session.save(book);
//            transaction.commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        session.close();
            createEntity(book);
        }

        @Override
        public Book findByIdAndLoadReviews(Integer id) {
            Session session = SessionManager.getSessionFactory().openSession();

            Book book = session.find(Book.class, id);
            System.out.println(book.getReviews().size()); // incarcarea datelor in interiorul sesiunii

            session.close();
            return book;

        }


    }

