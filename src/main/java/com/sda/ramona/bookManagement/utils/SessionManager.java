package com.sda.ramona.bookManagement.utils;


import com.sda.ramona.bookManagement.model.Author;
import com.sda.ramona.bookManagement.model.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager{

    private static final SessionManager INSTANCE =new SessionManager();// singletone pattern
    // static -am o singura clasa / final- nu se poate schimba

    private SessionManager() {

    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("bms");
    }

    public static void shutDown() {
        INSTANCE.shutdownSessionManager();
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
      configuration.addAnnotatedClass(Author.class);
      configuration.addAnnotatedClass(Book.class);
    }
}
