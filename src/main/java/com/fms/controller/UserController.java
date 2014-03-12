package com.fms.controller;

import com.fms.services.UserSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by e7006722 on 12/03/14.
 */
public class UserController extends MultiActionController {

    private UserSvc userSvc;

    protected ModelAndView add(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        return new ModelAndView("user", "msg", "add() method");
    }

    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("user", "msg", "delete() method");

    }

    public ModelAndView update(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return new ModelAndView("user", "msg", "update() method");

    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        return new ModelAndView("user", "msg", "list() method");

    }

    public void setUserSvc(UserSvc userSvc) {
        this.userSvc = userSvc;
    }

    public UserSvc getUserSvc() {
        return userSvc;
    }
}