package com.fms.dao.impl;

import com.fms.common.DbUtils;
import org.hibernate.Session;

/**
 * Created by poope on 3/16/14.
 */
public abstract class GenericDaoImpl {
    private Session session;

    public Session openSession() {
        session = DbUtils.sessionFactory.openSession();
        return session;
    }

    public void closeSession() {
        session.close();
    }
}
