package com.tish.dbconnectors;


import com.tish.models.BaseData;
import com.tish.models.BaseEntity;
import com.tish.models.TableRecord;
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

        Query query = session.createQuery("from BaseData where userId=:user_id");
        query.setParameter("user_id", CurrentDataUtils.getCurrentUser().getId());

        session.beginTransaction();
        List<BaseData> bases = query.getResultList();
        session.getTransaction().commit();

        bases.forEach(b ->
                tableRecordList.add(new TableRecord(b.getpId(), b.getType(), b.getSource(), b.getCreationDate()))
        );

        return tableRecordList;
    }

    public static void saveRecord(BaseData baseData, BaseEntity pData) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();

        baseData.setId((Long) session.save(baseData));
        Long pId = (Long) session.save(pData);
        baseData.setpId(pId);
        session.update(baseData);

        session.getTransaction().commit();
    }

}
