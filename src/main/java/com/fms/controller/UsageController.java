package com.fms.controller;

import com.fms.models.Usage;
import com.fms.services.UsageSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by e7006722 on 12/03/14.
 */
public class UsageController extends MultiActionController {

    private UsageSvc usageSvc;

    public ModelAndView home(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        return new ModelAndView("usage");
    }

    public ModelAndView deleteOrUpdate(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.valueOf(request.getParameter("id"));
            usageSvc.delete(new Usage(id));
            return new ModelAndView("usage", "msg", "Usage(" + id + ") deleted!");
        } else {
            Usage usage = new Usage();
            usage.setId(Integer.valueOf(request.getParameter("id")));
            usage.setStartDate(request.getParameter("startDt"));
            usage.setFacilityId(Integer.valueOf(request.getParameter("facilityId")));
            usage.setEndDate(request.getParameter("endDt"));

            usageSvc.update(usage);
            return new ModelAndView("usage", "msg", "Usage(" + usage.getId() + ") updated!");
        }
    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        List<Usage> usages = usageSvc.findAll();
        if (usages != null)
            return new ModelAndView("usage", "list", usages);
        else
            return new ModelAndView("usage", "error", "Not records found.");
    }

    public ModelAndView get(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        int id = Integer.valueOf(request.getParameter("searchId"));
        Usage usage = usageSvc.findById(id);
        if (usage != null)
            return new ModelAndView("usage", "usage", usage);
        else
            return new ModelAndView("usage", "error", "Usage(" + id + ") not found.");

    }

    public void setUsageSvc(UsageSvc usageSvc) {
        this.usageSvc = usageSvc;
    }

    public UsageSvc getUsageSvc() {
        return usageSvc;
    }
}