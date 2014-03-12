package com.fms.controller;

import com.fms.models.User;
import com.fms.services.UserSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by e7006722 on 12/03/14.
 */
public class UserController extends MultiActionController {

    private UserSvc userSvc;

    public ModelAndView home(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        return new ModelAndView("user");
    }

    public ModelAndView deleteOrUpdate(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.valueOf(request.getParameter("id"));
            userSvc.delete(new User(id));
            return new ModelAndView("user", "msg", "User(" + id + ") deleted!");
        } else {
            User user = new User();
            user.setId(Integer.valueOf(request.getParameter("id")));
            user.setName(request.getParameter("name"));
            user.setFacilityId(Integer.valueOf(request.getParameter("facilityId")));

            userSvc.update(user);
            return new ModelAndView("user", "msg", "User(" + user.getId() + ") updated!");
        }
    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        List<User> users = userSvc.findAll();
        if (users != null)
            return new ModelAndView("user", "list", users);
        else
            return new ModelAndView("user", "error", "Not records found.");


    }

    public ModelAndView get(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        int id = Integer.valueOf(request.getParameter("searchId"));
        User user = userSvc.findById(id);
        if (user != null)
            return new ModelAndView("user", "user", user);
        else
            return new ModelAndView("user", "error", "User(" + id + ") not found.");
    }

    public void setUserSvc(UserSvc userSvc) {
        this.userSvc = userSvc;
    }

    public UserSvc getUserSvc() {
        return userSvc;
    }
}