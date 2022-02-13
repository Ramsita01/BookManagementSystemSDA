package com.sda.ramona.bookManagement.repository;

import com.sda.ramona.bookManagement.repository.BaseRepository;
import com.sda.ramona.bookManagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseRepositoryImpl<T, ID> implements BaseRepository<T, ID> {

    private final Class<T> clazz;

    public BaseRepositoryImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void createEntity(T entity) {
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public T findById(ID id) {
        Session session = SessionManager.getSessionFactory().openSession();
        T entity = session.find(clazz, id);
        session.close();
        return entity;
    }

    @Override
    public void update(T entity) {
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();

    }

    @Override
    public void delete(T entity) {
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();

    }


}