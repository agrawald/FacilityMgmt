package com.fms.controller;

import com.fms.models.Inspection;
import com.fms.services.InspectionSvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by e7006722 on 12/03/14.
 */
public class InspectionController extends MultiActionController {

    private InspectionSvc inspectionSvc;

    public ModelAndView home(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        return new ModelAndView("inspection");
    }

    public ModelAndView deleteOrUpdate(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.valueOf(request.getParameter("id"));
            inspectionSvc.delete(new Inspection(id));
            return new ModelAndView("inspection", "msg", "Inspection(" + id + ") deleted!");
        } else {
            Inspection inspection = new Inspection();
            inspection.setId(Integer.valueOf(request.getParameter("id")));
            inspection.setUsageId(Integer.parseInt(request.getParameter("usageId")));
            inspection.setDetails(request.getParameter("details"));
            inspectionSvc.update(inspection);
            return new ModelAndView("inspection", "msg", "Inspection(" + inspection.getId() + ") updated!");
        }
    }

    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        List<Inspection> inspections = inspectionSvc.findAll();
        if (inspections != null)
            return new ModelAndView("inspection", "list", inspections);
        else
            return new ModelAndView("inspection", "error", "Not records found.");

    }

    public ModelAndView get(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        int id = Integer.valueOf(request.getParameter("searchId"));
        Inspection inspection = inspectionSvc.findById(Integer.valueOf(request.getParameter("searchId")));
        if (inspection != null)
            return new ModelAndView("inspection", "inspection", inspection);
        else
            return new ModelAndView("inspection", "error", "Inspection(" + id + ") not found.");
    }

    public void setInspectionSvc(InspectionSvc inspectionSvc) {
        this.inspectionSvc = inspectionSvc;
    }

    public InspectionSvc getInspectionSvc() {
        return inspectionSvc;
    }
}