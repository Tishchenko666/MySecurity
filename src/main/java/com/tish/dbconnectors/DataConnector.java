package com.tish.dbconnectors;


import com.tish.models.*;
import com.tish.utils.CurrentDataUtils;
import com.tish.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DataConnector {

    public static List<TableRecord> getUserRecords() {
        List<TableRecord> tableRecordList = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();

        Query query = session.createQuery("from BaseData where user.id=:user_id");
        query.setParameter("user_id", CurrentDataUtils.getCurrentUser().getId());

        session.beginTransaction();
        List<BaseData> bases = query.getResultList();
        session.getTransaction().commit();

        bases.forEach(b ->
                tableRecordList.add(new TableRecord(b.getType(), b.getSource(), b.getCreationDate()))
        );

        return tableRecordList;
    }

    public static void savePassword(PasswordData password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        saveBaseData(session, password.getData());
        session.save(password);
        session.getTransaction().commit();
    }

    public static void savePin(PinData pin) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        saveBaseData(session, pin.getData());
        session.save(pin);
        session.getTransaction().commit();
    }

    private static void saveBaseData(Session session, BaseData baseData) {
        session.save(baseData);
    }

    public static void deleteAllRecords() {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Query query = session.createQuery("delete from BaseData where user.id=:user_id");
        query.setParameter("user_id", CurrentDataUtils.getCurrentUser().getId());

        session.beginTransaction();
        int deleted = query.executeUpdate();

        if (deleted > 0) {
            session.createQuery("delete from PasswordData where data.id is null").executeUpdate();
            session.createQuery("delete from PinData where data.id is null").executeUpdate();
        }

        session.getTransaction().commit();
    }

}
