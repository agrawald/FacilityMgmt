package com.fms.dao.impl;

import com.fms.dao.ProblemDao;
import com.fms.entity.ProblemEntity;
import com.fms.models.Problem;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class ProblemDaoImpl extends GenericDaoImpl implements ProblemDao {
    @Override
    public Integer save(Problem entity) {
        Integer res = (Integer) openSession().save(new ProblemEntity(entity));
        closeSession();
        return res;
    }

    @Override
    public void saveOrUpdate(Problem entity) {
        Session session = openSession();
        Transaction tx = session.beginTransaction();
        if (findById(entity.getId()) != null)
            session.update(new ProblemEntity(entity));
        else
            session.save(new ProblemEntity(entity));
        session.flush();
        tx.commit();
        closeSession();
    }

    @Override
    public void delete(Problem entity) {
        if (findById(entity.getId()) != null) {
            Session session = openSession();
            Transaction tx = session.beginTransaction();
            session.delete(new ProblemEntity(entity));
            session.flush();
            tx.commit();
            closeSession();
        }
    }

    @Override
    public Problem findById(int id) {
        ProblemEntity list = (ProblemEntity) openSession().get(ProblemEntity.class, id);
        closeSession();
        if (list != null)
            return list.toProblem();
        return null;
    }

    @Override
    public List<Problem> findAll() {
        List<Problem> problems;
        List<ProblemEntity> list = openSession().createQuery("from ProblemEntity").list();
        closeSession();
        if (!CollectionUtils.isEmpty(list)) {
            problems = new ArrayList<Problem>(list.size());
            for (ProblemEntity problemEntity : list)
                problems.add(problemEntity.toProblem());
            return problems;
        }
        return null;
    }
}
