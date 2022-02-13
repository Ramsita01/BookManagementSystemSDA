package com.sda.ramona.bookManagement.repository;

import com.sda.ramona.bookManagement.model.Author;
import com.sda.ramona.bookManagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

//public class BaseRepository<T, ID> {



   //public void createEntity(T entity) {
   //    // Session e legaura cu care ne conectam la baza de date
   //    // Session manager

   //    Session session = SessionManager.getSessionFactory().openSession();

   //    //sessionfactory ...poate genera alte sesiuni
   //    // open sesion deschide sesiunea
   //    // session este obiectul in aceasta situatie

   //    Transaction transaction = null;// = session.beginTransaction(); // asa incepe tranzactia pe baza de date
   //    try {
   //        transaction = session.beginTransaction();
   //        session.save(entity);
   //        transaction.commit();         // se face comiterea p=operatiunii de save

   //    } catch (Exception ex) {
   //        ex.fillInStackTrace();

   //        if (transaction != null) {
   //            transaction.rollback();
   //        }
   //    }

   //    session.close();
   //}

  //  public T findById(ID id) {
  //      Session session = SessionManager.getSessionFactory().openSession();
  //      T entity = session.find(Author.class, id);
  //      session.close();
  //      return entity;
  //  }


//}
public interface BaseRepository<T, ID> {

    void createEntity(T entity);

    T findById(ID id);

    void update(T Entity);

    void delete(T entity);
}
