package com.fms.dao.impl;

import com.fms.dao.FacilityDao;
import com.fms.entity.FacilityEntity;
import com.fms.models.Facility;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class FacilityDaoImpl extends GenericDaoImpl
implements FacilityDao {

    @Override
    public Integer save(Facility entity) {
        Integer result = (Integer) openSession().save(new FacilityEntity(entity));
        closeSession();
        return result;
    }

    @Override
    public void saveOrUpdate(Facility entity) {
        Session session = openSession();
        Transaction tx = session.beginTransaction();
        if (findById(entity.getId()) != null)
            session.update(new FacilityEntity(entity));
        else
            session.save(new FacilityEntity(entity));
        session.flush();
        tx.commit();
        closeSession();
    }

    @Override
    public void delete(Facility entity) {
        if (findById(entity.getId()) != null) {
            Session session = openSession();
            Transaction tx = session.beginTransaction();
            session.delete(new FacilityEntity(entity));
            session.flush();
            tx.commit();
        }
    }

    @Override
    public Facility findById(int id) {
        FacilityEntity facilityEntity = (FacilityEntity) openSession().get(FacilityEntity.class, id);
        closeSession();
        if (facilityEntity != null)
            return facilityEntity.toFacility();
        return null;
    }

    @Override
    public List<Facility> findAll() {
        List<Facility> facilities;
        List<FacilityEntity> list = openSession().createCriteria(FacilityEntity.class).list();
        closeSession();
        if (!CollectionUtils.isEmpty(list)) {
            facilities = new ArrayList<Facility>(list.size());
            for (FacilityEntity facilityEntity : list)
                facilities.add(facilityEntity.toFacility());
            return facilities;
        }
        return null;
    }
}
