package com.fms.dao.impl;

import com.fms.common.DbUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by poope on 3/16/14.
 */
public abstract class GenericDaoImpl<T> {
    private Session session;
    private Transaction transaction;

    public Session openSession() {
        session = DbUtils.sessionFactory.openSession();
        return session;
    }

    public void closeSession() {
        if (session.isOpen())
            session.close();
    }
}
