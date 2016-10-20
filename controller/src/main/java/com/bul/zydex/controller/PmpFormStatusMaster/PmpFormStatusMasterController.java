/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.PmpFormStatusMaster;

import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PmpFormStatusMaster;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BlackBull
 */
public class PmpFormStatusMasterController extends PmpFormStatusMasterAbstract {

    public ModelAndView showpmpStatusMaster(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();

        List<?> pmpFormList = pmpFormStatusMasterService.read();
        for (Object o : pmpFormList) {
            PmpFormStatusMaster pfsm = (PmpFormStatusMaster) o;
            EmployeeMaster employeeMaster = employeeMasterService.readById(pfsm.getEmployeeMaster().getId());
            pfsm.setEmployeeMaster(employeeMaster);
        }

        mv.getModelMap().put("list", pmpFormList);
        mv.setViewName("PmpFormStatus/PmpFormStatusMasterShow");
        return mv;

    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        String id = request.getParameter("id");
        pmpFormStatusMaster = pmpFormStatusMasterService.readById(Integer.parseInt(id));
        EmployeeMaster employeeMaster = employeeMasterService.readById(pmpFormStatusMaster.getEmployeeMaster().getId());
        pmpFormStatusMaster.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("pmpFormStatusMaster", pmpFormStatusMaster);
        mv.setViewName("PmpFormStatus/PmpFormStatusMasterEdit");
        return mv;

    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();

        String id = request.getParameter("id");
        pmpFormStatusMaster = pmpFormStatusMasterService.readById(Integer.parseInt(id));
        bind(request, pmpFormStatusMaster);
        int empid = pmpFormStatusMaster.getEmployeeMaster().getId();
        List<?>empList = appraisalPerformanceService.readByEmpID(empid);
        if (!empList.isEmpty()) {
            for (Object o : empList) {
                appraisalPerformanceMaster = (AppraisalPerformanceMaster) o;
            }
        }
        boolean manside = pmpFormStatusMaster.getManagerSide();
        boolean empside = pmpFormStatusMaster.getEmployeeSide();
        int empstatus = 0;
        int manstatus = 0;
        if (empside == true) {
            empstatus = 1;
        }
        if (manside == true) {
            manstatus = 1;
        }
        if (!manside && !empside) {
            request.setAttribute("failureMessage",
                    "Information : At a Time Only Manager Or Employee Side Unlock The Form.");
            mv = viewClick(request, response);

        } else {
            pmpFormStatusMasterService.update(pmpFormStatusMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            appraisalPerformanceMaster.setEmployeeStatus(empstatus);
            appraisalPerformanceMaster.setManagerkraStatus(manstatus);
            appraisalPerformanceService.update(appraisalPerformanceMaster);
            mv = showpmpStatusMaster(request, response);

        }
        return mv;

    }
}
