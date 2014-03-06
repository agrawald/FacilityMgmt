package com.fms.services.impl;

import com.fms.GenericTest;
import com.fms.models.Maintenance;
import com.fms.services.MaintenanceSvc;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by e7006722 on 6/03/14.
 */
public class MaintenanceSvcImplTest extends GenericTest {
    MaintenanceSvc maintenanceSvc;
    Maintenance maintenance;

    public void setUp() throws Exception {
        super.setUp();
        maintenanceSvc = (MaintenanceSvc) appContext.getBean("maintenanceSvc");

        maintenance = new Maintenance();
        maintenance.setStartDate("12/12/2012");
        maintenance.setFacilityId(2);
        maintenance.setEndDate("12/12/2014");
        maintenance.setCost(123);
    }

    public void testSave() throws Exception {
        maintenance.setId(maintenanceSvc.save(maintenance));
        Assert.assertNotNull("Maintenance Id is null", maintenance.getId());
    }

    public void testUpdate() throws Exception {
        maintenance.setId(1);
        maintenance.setCost(234);
        maintenanceSvc.update(maintenance);
        Maintenance updMaintenance = maintenanceSvc.findById(maintenance.getId());
        Assert.assertNotNull("Maintenance not found",updMaintenance);
        Assert.assertEquals("Not updated", "234", updMaintenance.getCost());
    }

    public void testDelete() throws Exception {
        maintenance.setId(1);
        maintenanceSvc.delete(maintenance);
        Maintenance delMaintenance = maintenanceSvc.findById(maintenance.getId());
        Assert.assertNull("Maintenance still exists", delMaintenance);
    }

    public void testFindById() throws Exception {
        Maintenance foundMaintenance = maintenanceSvc.findById(maintenance.getId());
        Assert.assertNotNull("Maintenance not found", foundMaintenance);
    }
}
