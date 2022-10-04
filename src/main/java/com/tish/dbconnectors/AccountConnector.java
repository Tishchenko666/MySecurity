package com.tish.dbconnectors;

import com.tish.models.User;
import com.tish.utils.CurrentDataUtils;
import com.tish.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.TransientObjectException;

import javax.persistence.Query;


public class AccountConnector {

    public static boolean saveAccount(User user, boolean update) {
        boolean saved = false;
        Session session = HibernateUtils.getSessionFactory().openSession();

        Query query = session.createQuery("from User where login = :user_login");
        query.setParameter("user_login", user.getLogin());
        if (query.getResultList().isEmpty()) {
            session.beginTransaction();
            if (update)
                user.setId(CurrentDataUtils.getCurrentUser().getId());
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            saved = true;
        }
        return saved;
    }

    public static Long checkAccount(User user) {
        Long id = 0L;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            id = (Long) session.getIdentifier(user);
        } catch (TransientObjectException e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
        }
        return id;
    }
}
