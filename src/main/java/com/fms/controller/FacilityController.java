package com.fms.controller;

import com.fms.models.Facility;
import com.fms.services.FacilitySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

/**
 * Created by e7006722 on 11/03/14.
 */
@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    FacilitySvc facilitySvc;

    @RequestMapping(value="/get/{id}")
    protected ModelAndView getById(@PathVariable int id, HttpServletResponse httpServletResponse) throws Exception {
        Facility facility = facilitySvc.findById(id);

        return null;
    }
}
