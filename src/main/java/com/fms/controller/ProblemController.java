package com.fms.controller;

import com.fms.models.Problem;
import com.fms.services.ProblemSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by e7006722 on 12/03/14.
 */
public class ProblemController extends MultiActionController {

    private ProblemSvc problemSvc;

    public ModelAndView home(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        return new ModelAndView("problem");
    }

    public ModelAndView deleteOrUpdate(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.valueOf(request.getParameter("id"));
            problemSvc.delete(new Problem(id));
            return new ModelAndView("problem", "msg", "Problem(" + id + ") deleted!");
        } else {
            Problem problem = new Problem();
            problem.setId(Integer.valueOf(request.getParameter("id")));
            problem.setDetails(request.getParameter("details"));
            problem.setFoundOn(request.getParameter("foundOn"));
            problem.setIsResolved(request.getParameter("isResolved"));
            problem.setMaintenanceId(Integer.valueOf(request.getParameter("maintenanceId")));
            problem.setResolvedOn(request.getParameter("resolvedOn"));

            problemSvc.update(problem);
            return new ModelAndView("problem", "msg", "Problem(" + problem.getId() + ") updated!");
        }
    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        List<Problem> problems = problemSvc.findAll();
        if (problems != null)
            return new ModelAndView("problem", "list", problems);
        else
            return new ModelAndView("problem", "error", "Not records found.");
    }

    public ModelAndView get(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        int id = Integer.valueOf(request.getParameter("searchId"));
        Problem problem = problemSvc.findById(id);
        if (problem != null)
            return new ModelAndView("problem", "problem", problem);
        else
            return new ModelAndView("problem", "error", "Problem(" + id + ") not found.");
    }

    public void setProblemSvc(ProblemSvc problemSvc) {
        this.problemSvc = problemSvc;
    }

    public ProblemSvc getProblemSvc() {
        return problemSvc;
    }
}