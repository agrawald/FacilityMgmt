package com.fms.services.impl;

import com.fms.GenericTest;
import com.fms.models.Inspection;
import com.fms.services.InspectionSvc;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by e7006722 on 6/03/14.
 */
public class InspectionSvcImplTest extends GenericTest {
    InspectionSvc inspectionSvc;
    Inspection inspection;

    public void setUp() throws Exception {
        super.setUp();
        inspectionSvc = (InspectionSvc) appContext.getBean("inspectionSvc");

        inspection = new Inspection();
        inspection.setUsageId(2);
        inspection.setDetails("New Inspection");
    }

    public void testSave() throws Exception {
        inspection.setId(inspectionSvc.save(inspection));
        Assert.assertNotNull("Inspection Id is null", inspection.getId());
    }

    public void testUpdate() throws Exception {
        inspection.setId(1);
        inspection.setDetails("Updated details");
        inspectionSvc.update(inspection);
        Inspection updInspection = inspectionSvc.findById(inspection.getId());
        Assert.assertNotNull("Inspection not found",updInspection);
        Assert.assertEquals("Not updated", "Updated details", updInspection.getDetails());
    }

    public void testDelete() throws Exception {
        inspection.setId(1);
        inspectionSvc.delete(inspection);
        Inspection delInspection = inspectionSvc.findById(inspection.getId());
        Assert.assertNull("Inspection still exists", delInspection);
    }

    public void testFindById() throws Exception {
        Inspection foundInspection = inspectionSvc.findById(inspection.getId());
        Assert.assertNotNull("Inspection not found", foundInspection);
    }
}
