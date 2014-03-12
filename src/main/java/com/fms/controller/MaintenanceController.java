package com.fms.controller;

import com.fms.services.MaintenanceSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by e7006722 on 12/03/14.
 */
public class MaintenanceController extends MultiActionController {

    private MaintenanceSvc maintenanceSvc;

    protected ModelAndView add(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        return new ModelAndView("maintenance", "msg", "add() method");
    }

    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("maintenance", "msg", "delete() method");

    }

    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("maintenance", "msg", "update() method");

    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        return new ModelAndView("maintenance", "msg", "list() method");

    }

    public void setMaintenanceSvc(MaintenanceSvc maintenanceSvc) {
        this.maintenanceSvc = maintenanceSvc;
    }

    public MaintenanceSvc getMaintenanceSvc() {
        return maintenanceSvc;
    }
}