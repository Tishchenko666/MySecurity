package com.tish.dbconnectors;


import com.tish.models.*;
import com.tish.utils.CurrentDataUtils;
import com.tish.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

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
                tableRecordList.add(new TableRecord(b.getDataType(), b.getSource(), b.getCreationDate()))
        );

        return tableRecordList;
    }

    public static List<TableRecord> getSearchRecords(String searchPart) {
        List<TableRecord> tableRecordList = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();

        String sql = "select * from records where user_id=:user_id and (data_type like :search_type or source like :search_source)";
        NativeQuery nativeQuery = session.createSQLQuery(sql);
        nativeQuery.addEntity(BaseData.class);
        nativeQuery.setParameter("user_id", CurrentDataUtils.getCurrentUser().getId());
        nativeQuery.setParameter("search_type", searchPart + "%");
        nativeQuery.setParameter("search_source", "%" + searchPart + "%");

        session.beginTransaction();
        List<BaseData> bases = nativeQuery.getResultList();
        session.getTransaction().commit();

        bases.forEach(b ->
                tableRecordList.add(new TableRecord(b.getDataType(), b.getSource(), b.getCreationDate()))
        );

        return tableRecordList;
    }

    public static PasswordData getPasswordData(BaseData data) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Long id = (Long) session.getIdentifier(data);
        PasswordData passwordData = session.get(PasswordData.class, id);
        session.getTransaction().commit();
        return passwordData;
    }

    public static PinData getPinData(BaseData data) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Long id = (Long) session.getIdentifier(data);
        PinData pinData = session.get(PinData.class, id);
        session.getTransaction().commit();
        return pinData;
    }

    public static void savePassword(PasswordData password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        saveBaseData(session, password.getData());
        session.saveOrUpdate(password);
        session.getTransaction().commit();
    }

    public static void savePin(PinData pin) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        saveBaseData(session, pin.getData());
        session.saveOrUpdate(pin);
        session.getTransaction().commit();
    }

    private static void saveBaseData(Session session, BaseData baseData) {
        session.saveOrUpdate(baseData);
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

    public static boolean deletePassword(PasswordData password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(password);
        session.getTransaction().commit();
        return true;
    }

    public static boolean deletePin(PinData pin) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(pin);
        session.getTransaction().commit();
        return true;
    }

}
