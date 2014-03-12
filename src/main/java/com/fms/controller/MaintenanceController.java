package com.fms.controller;

import com.fms.models.Maintenance;
import com.fms.services.MaintenanceSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by e7006722 on 12/03/14.
 */
public class MaintenanceController extends MultiActionController {

    private MaintenanceSvc maintenanceSvc;

    public ModelAndView home(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        return new ModelAndView("maintenance");
    }

    public ModelAndView deleteOrUpdate(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.valueOf(request.getParameter("id"));
            maintenanceSvc.delete(new Maintenance(id));
            return new ModelAndView("maintenance", "msg", "Maintenance(" + id + ") deleted!");
        } else {
            Maintenance maintenance = new Maintenance();
            maintenance.setId(Integer.valueOf(request.getParameter("id")));
            maintenance.setCost(Integer.valueOf(request.getParameter("cost")));
            maintenance.setStartDate(request.getParameter("startDt"));
            maintenance.setEndDate(request.getParameter("endDt"));
            maintenance.setFacilityId(Integer.valueOf(request.getParameter("facilityId")));

            maintenanceSvc.update(maintenance);
            return new ModelAndView("maintenance", "msg", "Maintenance(" + maintenance.getId() + ") updated!");
        }
    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        List<Maintenance> maintenances = maintenanceSvc.findAll();
        if (maintenances != null)
            return new ModelAndView("maintenance", "list", maintenances);
        else
            return new ModelAndView("maintenance", "error", "Not records found.");
    }

    public ModelAndView get(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        int id = Integer.valueOf(request.getParameter("searchId"));
        Maintenance maintenance = maintenanceSvc.findById(Integer.valueOf(request.getParameter("searchId")));
        if (maintenance != null)
            return new ModelAndView("maintenance", "maintenance", maintenance);
        else
            return new ModelAndView("maintenance", "error", "Maintenance(" + id + ") not found.");

    }

    public void setMaintenanceSvc(MaintenanceSvc maintenanceSvc) {
        this.maintenanceSvc = maintenanceSvc;
    }

    public MaintenanceSvc getMaintenanceSvc() {
        return maintenanceSvc;
    }
}