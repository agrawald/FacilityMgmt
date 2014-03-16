package com.fms.common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by poope on 3/16/14.
 */
public class DbUtils {
    public static final SessionFactory sessionFactory = getSessionFactory();

    private static SessionFactory getSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
