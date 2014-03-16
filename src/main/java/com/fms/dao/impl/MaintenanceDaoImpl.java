package com.fms.dao.impl;

import com.fms.dao.MaintenanceDao;
import com.fms.entity.MaintenanceEntity;
import com.fms.models.Maintenance;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class MaintenanceDaoImpl extends GenericDaoImpl implements MaintenanceDao {
    @Override
    public Integer save(Maintenance entity) {
        Integer result = (Integer) openSession().save(new MaintenanceEntity(entity));
        closeSession();
        return result;
    }

    @Override
    public void saveOrUpdate(Maintenance entity) {
        Session session = openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(new MaintenanceEntity(entity));
        session.flush();
        tx.commit();
        closeSession();
    }

    @Override
    public void delete(Maintenance entity) {
        if (findById(entity.getId()) != null) {
            Session session = openSession();
            Transaction tx = session.beginTransaction();
            session.delete(new MaintenanceEntity(entity));
            session.flush();
            tx.commit();
            closeSession();
        }
    }

    @Override
    public Maintenance findById(int id) {
        List<MaintenanceEntity> list = openSession().createQuery("from MaintenanceEntity where id=" + id).list();
        closeSession();
        if (!CollectionUtils.isEmpty(list))
            return list.get(0).toMaintenance();
        return null;
    }

    @Override
    public List<Maintenance> findAll() {
        List<Maintenance> maintenances;
        List<MaintenanceEntity> list = openSession().createQuery("from MaintenanceEntity").list();
        closeSession();
        if (!CollectionUtils.isEmpty(list)) {
            maintenances = new ArrayList<Maintenance>(list.size());
            for (MaintenanceEntity maintenanceEntity : list)
                maintenances.add(maintenanceEntity.toMaintenance());
            return maintenances;
        }
        return null;
    }

}
