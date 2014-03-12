package com.fms.controller;

import com.fms.models.Facility;
import com.fms.services.FacilitySvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by e7006722 on 11/03/14.
 */
public class FacilityController extends MultiActionController {

    private FacilitySvc facilitySvc;

    public ModelAndView home(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        return new ModelAndView("facility");
    }

    public ModelAndView deleteOrUpdate(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.valueOf(request.getParameter("id"));
            facilitySvc.delete(new Facility(id));
            return new ModelAndView("facility", "msg", "Facility(" + id + ") deleted!");
        } else {
            Facility facility = new Facility();
            facility.setId(Integer.valueOf(request.getParameter("id")));
            facility.setName(request.getParameter("name"));
            facility.setDetails(request.getParameter("details"));
            facility.setDownTime(request.getParameter("downTime"));
            facility.setAvailableCapacity(Integer.valueOf(request.getParameter("availableCapacity")));
            facility.setInUse(request.getParameter("inUse"));
            facilitySvc.update(facility);
            return new ModelAndView("facility", "msg", "Facility(" + facility.getId() + ") updated!");
        }
    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        List<Facility> facilities = facilitySvc.findAll();
        if (facilities != null)
            return new ModelAndView("facility", "list", facilities);
        else
            return new ModelAndView("facility", "error", "Not records found.");
    }

    public ModelAndView get(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        int id = Integer.valueOf(request.getParameter("searchId"));
        Facility facility = facilitySvc.findById(id);
        if (facility != null)
            return new ModelAndView("facility", "facility", facility);
        else
            return new ModelAndView("facility", "error", "Not Facility(" + id + ") found!");
    }


    public void setFacilitySvc(FacilitySvc facilitySvc) {
        this.facilitySvc = facilitySvc;
    }

    public FacilitySvc getFacilitySvc() {
        return facilitySvc;
    }
}
