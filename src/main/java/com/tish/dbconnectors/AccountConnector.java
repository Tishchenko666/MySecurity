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
        session.beginTransaction();
        if (query.getResultList().isEmpty()) {
            if (update)
                user.setId(CurrentDataUtils.getCurrentUser().getId());
            session.saveOrUpdate(user);
            saved = true;
        } else {
            User tempUser = (User) query.getSingleResult();
            if (!tempUser.getPassword().equals(user.getPassword())) {
                user.setId(CurrentDataUtils.getCurrentUser().getId());
                session.update(user);
            }
        }
        session.getTransaction().commit();
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
