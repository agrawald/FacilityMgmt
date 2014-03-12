package com.fms.controller;

import com.fms.services.UsageSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by e7006722 on 12/03/14.
 */
public class UsageController extends MultiActionController {

    private UsageSvc usageSvc;

    protected ModelAndView add(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        return new ModelAndView("usage", "msg", "add() method");
    }

    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("usage", "msg", "delete() method");

    }

    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("usage", "msg", "update() method");

    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        return new ModelAndView("usage", "msg", "list() method");

    }

    public void setUsageSvc(UsageSvc usageSvc) {
        this.usageSvc = usageSvc;
    }

    public UsageSvc getUsageSvc() {
        return usageSvc;
    }
}