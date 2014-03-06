package com.fms.services.impl;

import com.fms.dao.FacilityDao;
import com.fms.models.Facility;
import com.fms.services.FacilitySvc;

/**
 * Created by e7006722 on 6/03/14.
 */
public class FacilitySvcImpl implements FacilitySvc {
    private FacilityDao facilityDao;

    @Override
    public Integer save(Facility obj) {
        return facilityDao.save(obj);
    }

    @Override
    public void update(Facility obj) {
        facilityDao.update(obj);
    }

    @Override
    public void delete(Facility obj) {
        facilityDao.delete(obj);
    }

    @Override
    public Facility findById(int id) {
        return facilityDao.findById(id);
    }

    public void setFacilityDao(FacilityDao facilityDao) {
        this.facilityDao = facilityDao;
    }

    public FacilityDao getFacilityDao() {
        return facilityDao;
    }
}
