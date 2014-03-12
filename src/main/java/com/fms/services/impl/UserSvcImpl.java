package com.fms.services.impl;

import com.fms.dao.UserDao;
import com.fms.models.User;
import com.fms.services.UserSvc;

/**
 * Created by e7006722 on 6/03/14.
 */
public class UserSvcImpl implements UserSvc {
    private UserDao userDao;

    @Override
    public Integer save(User obj) {
        return userDao.save(obj);
    }

    @Override
    public void update(User obj) {
        userDao.update(obj);
    }

    @Override
    public void delete(User obj) {
        userDao.delete(obj);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
