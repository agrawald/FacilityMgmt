package com.fms.dao.impl;

import com.fms.dao.UsageDao;
import com.fms.entity.UsageEntity;
import com.fms.models.Usage;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class UsageDaoImpl extends GenericDaoImpl implements UsageDao {
    @Override
    public Integer save(Usage entity) {
        Integer res = (Integer) openSession().save(new UsageEntity(entity));
        closeSession();
        return res;
    }

    @Override
    public void update(Usage entity) {
        Session session = openSession();
        Transaction tx = session.beginTransaction();
        session.update(new UsageEntity(entity));
        session.flush();
        tx.commit();
        closeSession();
    }

    @Override
    public void delete(Usage entity) {
        if (findById(entity.getId()) != null) {
            Session session = openSession();
            Transaction tx = session.beginTransaction();
            session.delete(new UsageEntity(entity));
            session.flush();
            tx.commit();
            closeSession();
        }
    }

    @Override
    public Usage findById(int id) {
        UsageEntity list = (UsageEntity) openSession().get(UsageEntity.class, id);
        closeSession();
        if (list != null)
            return list.toUsage();
        return null;
    }

    @Override
    public List<Usage> findAll() {
        List<Usage> usages;
        List<UsageEntity> list = openSession().createQuery("from UsageEntity").list();
        closeSession();
        if (!CollectionUtils.isEmpty(list)) {
            usages = new ArrayList<Usage>(list.size());
            for (UsageEntity usageEntity : list)
                usages.add(usageEntity.toUsage());
            return usages;
        }
        return null;
    }
}
