package com.fms.controller;

import com.fms.services.InspectionSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by e7006722 on 12/03/14.
 */
public class InspectionController extends MultiActionController {

    private InspectionSvc inspectionSvc;

    protected ModelAndView add(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        return new ModelAndView("inspection", "msg", "add() method");
    }

    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("inspection", "msg", "delete() method");

    }

    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("inspection", "msg", "update() method");

    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        return new ModelAndView("inspection", "msg", "list() method");

    }

    public void setInspectionSvc(InspectionSvc inspectionSvc) {
        this.inspectionSvc = inspectionSvc;
    }

    public InspectionSvc getInspectionSvc() {
        return inspectionSvc;
    }
}