package com.fms.services.impl;

import com.fms.GenericTest;
import com.fms.models.Problem;
import com.fms.services.ProblemSvc;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by e7006722 on 6/03/14.
 */
public class ProblemSvcImplTest extends GenericTest {
    ProblemSvc problemSvc;
    Problem problem;

    public void setUp() throws Exception {
        super.setUp();
        problemSvc = (ProblemSvc) appContext.getBean("problemSvc");

        problem = new Problem();
        problem.setResolvedOn("12/12/2012");
        problem.setMaintenanceId(2);
        problem.setIsResolved("true");
        problem.setFoundOn("11/12/2012");
        problem.setDetails("new details");
    }

    public void testSave() throws Exception {
        problem.setId(problemSvc.save(problem));
        Assert.assertNotNull("Problem Id is null", problem.getId());
    }

    public void testUpdate() throws Exception {
        problem.setId(1);
        problem.setDetails("udpated details");
        problemSvc.update(problem);
        Problem updProblem = problemSvc.findById(problem.getId());
        Assert.assertNotNull("Problem not found",updProblem);
        Assert.assertEquals("Not updated", "udpated details", updProblem.getDetails());
    }

    public void testDelete() throws Exception {
        problem.setId(1);
        problemSvc.delete(problem);
        Problem delProblem = problemSvc.findById(problem.getId());
        Assert.assertNull("Problem still exists", delProblem);
    }

    public void testFindById() throws Exception {
        Problem foundProblem = problemSvc.findById(problem.getId());
        Assert.assertNotNull("Problem not found", foundProblem);
    }
}
