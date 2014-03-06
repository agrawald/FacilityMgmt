package com.fms.services.impl;

import com.fms.GenericTest;
import com.fms.models.Usage;
import com.fms.services.UsageSvc;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by e7006722 on 6/03/14.
 */
public class UsageSvcImplTest extends GenericTest {
    UsageSvc usageSvc;
    Usage usage;

    public void setUp() throws Exception {
        super.setUp();
        usageSvc = (UsageSvc) appContext.getBean("usageSvc");

        usage = new Usage();
        usage.setStartDate("12/12/2012");
        usage.setFacilityId(2);
        usage.setEndDate("12/12/2014");
    }

    public void testSave() throws Exception {
        usage.setId(usageSvc.save(usage));
        Assert.assertNotNull("Usage Id is null", usage.getId());
    }

    public void testUpdate() throws Exception {
        usage.setId(1);
        usage.setStartDate("01/01/2012");
        usageSvc.update(usage);
        Usage updUsage = usageSvc.findById(usage.getId());
        Assert.assertNotNull("Usage not found",updUsage);
        Assert.assertEquals("Not updated", "01/01/2012", updUsage.getStartDate());
    }

    public void testDelete() throws Exception {
        usage.setId(1);
        usageSvc.delete(usage);
        Usage delUsage = usageSvc.findById(usage.getId());
        Assert.assertNull("Usage still exists", delUsage);
    }

    public void testFindById() throws Exception {
        Usage foundUsage = usageSvc.findById(usage.getId());
        Assert.assertNotNull("Usage not found", foundUsage);
    }
}
