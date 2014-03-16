package com.fms.dao.impl;

import com.fms.dao.UserDao;
import com.fms.entity.OwnerEntity;
import com.fms.models.User;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class UserDaoImpl extends GenericDaoImpl implements UserDao {
    @Override
    public Integer save(User entity) {
        Integer res = (Integer) openSession().save(new OwnerEntity(entity));
        closeSession();
        return res;
    }

    @Override
    public void update(User entity) {
        openSession().update(new OwnerEntity(entity));
        closeSession();
    }

    @Override
    public void delete(User entity) {
        if (findById(entity.getId()) != null) {
            openSession().delete(new OwnerEntity(entity));
            closeSession();
        }
    }

    @Override
    public User findById(int id) {
        OwnerEntity list = (OwnerEntity) openSession().get(OwnerEntity.class, id);
        closeSession();
        if (list != null)
            return list.toUser();
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users;
        List<OwnerEntity> list = openSession().createQuery("from OwnerEntity").list();
        closeSession();
        if (!CollectionUtils.isEmpty(list)) {
            users = new ArrayList<User>(list.size());
            for (OwnerEntity ownerEntity : list)
                users.add(ownerEntity.toUser());
            return users;
        }
        return null;
    }
}
