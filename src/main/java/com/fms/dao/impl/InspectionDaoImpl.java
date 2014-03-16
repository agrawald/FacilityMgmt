package com.fms.dao.impl;

import com.fms.dao.InspectionDao;
import com.fms.entity.InspectionEntity;
import com.fms.models.Inspection;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class InspectionDaoImpl extends GenericDaoImpl implements InspectionDao {
    @Override
    public Integer save(Inspection entity) {
        Integer result = (Integer) openSession().save(new InspectionEntity(entity));
        closeSession();
        return result;
    }

    @Override
    public void saveOrUpdate(Inspection entity) {
        Session session = openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(new InspectionEntity(entity));
        session.flush();
        tx.commit();
        closeSession();
    }

    @Override
    public void delete(Inspection entity) {
        if (findById(entity.getId()) != null) {
            Session session = openSession();
            Transaction tx = session.beginTransaction();
            session.delete(new InspectionEntity(entity));
            session.flush();
            tx.commit();
            closeSession();
        }
    }

    @Override
    public Inspection findById(int id) {
        InspectionEntity inspectionEntity = (InspectionEntity) openSession().get(InspectionEntity.class, id);
        closeSession();
        if (inspectionEntity != null)
            return inspectionEntity.toInspection();
        return null;
    }

    @Override
    public List<Inspection> findAll() {
        List<Inspection> inspections;
        List<InspectionEntity> list = openSession().createQuery("from InspectionEntity").list();
        closeSession();
        if (!CollectionUtils.isEmpty(list)) {
            inspections = new ArrayList<Inspection>(list.size());
            for (InspectionEntity inspectionEntity : list)
                inspections.add(inspectionEntity.toInspection());
            return inspections;
        }
        return null;
    }
}
