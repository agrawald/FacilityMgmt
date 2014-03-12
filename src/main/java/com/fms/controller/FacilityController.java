package com.fms.controller;

import com.fms.services.FacilitySvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by e7006722 on 11/03/14.
 */
public class FacilityController extends MultiActionController {

    private FacilitySvc facilitySvc;

    public ModelAndView add(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        return new ModelAndView("facility", "msg", "add() method");
    }

    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("facility", "msg", "delete() method");

    }

    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("facility", "msg", "update() method");

    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        return new ModelAndView("facility", "msg", "list() method");

    }

    public void setFacilitySvc(FacilitySvc facilitySvc) {
        this.facilitySvc = facilitySvc;
    }

    public FacilitySvc getFacilitySvc() {
        return facilitySvc;
    }
}
