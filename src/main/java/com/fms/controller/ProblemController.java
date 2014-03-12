package com.fms.controller;

import com.fms.services.ProblemSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by e7006722 on 12/03/14.
 */
public class ProblemController extends MultiActionController {

    private ProblemSvc problemSvc;

    protected ModelAndView add(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        return new ModelAndView("problem", "msg", "add() method");
    }

    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("problem", "msg", "delete() method");

    }

    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("problem", "msg", "update() method");

    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        return new ModelAndView("problem", "msg", "list() method");

    }

    public void setProblemSvc(ProblemSvc problemSvc) {
        this.problemSvc = problemSvc;
    }

    public ProblemSvc getProblemSvc() {
        return problemSvc;
    }
}