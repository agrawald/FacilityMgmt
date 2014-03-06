package com.fms.services.impl;

import com.fms.GenericTest;
import com.fms.models.Facility;
import com.fms.services.FacilitySvc;
import junit.framework.Assert;

/**
 * Created by e7006722 on 6/03/14.
 */
public class FacilitySvcImplTest extends GenericTest {

    FacilitySvc facilitySvc;
    Facility facility;

    public void setUp() throws Exception {
        super.setUp();
        facilitySvc = (FacilitySvc) appContext.getBean("facilitySvc");

        facility = new Facility();
        facility.setAvailableCapacity(120);
        facility.setDetails("New Facility");
        facility.setDownTime("10 hrs");
        facility.setInUse("true");
        facility.setName("Facility 1");
    }

    public void testSave() throws Exception {
        facility.setId(facilitySvc.save(facility));
        Assert.assertNotNull("Facility Id is null", facility.getId());
    }

    public void testUpdate() throws Exception {
        facility.setId(1);
        facility.setDetails("Updated details");
        facilitySvc.update(facility);
        Facility updFacility = facilitySvc.findById(facility.getId());
        Assert.assertNotNull("Facility not found",updFacility);
        Assert.assertEquals("Not updated", "Updated details", updFacility.getDetails());
    }

    public void testDelete() throws Exception {
        facility.setId(1);
        facilitySvc.delete(facility);
        Facility delFacility = facilitySvc.findById(facility.getId());
        Assert.assertNull("Facility still exists", delFacility);
    }

    public void testFindById() throws Exception {
        Facility foundFacility = facilitySvc.findById(facility.getId());
        Assert.assertNotNull("Facility not found", foundFacility);
    }
}
