package com.tish.dbconnectors;

import com.tish.models.User;
import com.tish.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.TransientObjectException;
import org.hibernate.query.Query;


public class AccountConnector {

    public static boolean saveAccount(User user) {
        boolean saved = false;
        Session session = HibernateUtils.getSessionFactory().openSession();

        Query query = session.createQuery("from User where login = :user_login");
        query.setParameter("user_login", user.getLogin());
        if (query.list().isEmpty()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            saved = true;
        }
        HibernateUtils.closeSessionFactory();
        return saved;
    }

    public static Long checkAccount(User user) {
        Long id = 0L;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            id = (Long) session.getIdentifier(user);
        } catch (TransientObjectException e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSessionFactory();
        }
        return id;
    }
}
