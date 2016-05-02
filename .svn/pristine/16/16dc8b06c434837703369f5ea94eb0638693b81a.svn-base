/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.TempShiftAssignMaster;
import com.bul.zydex.service.shift.TemporaryShiftAssignService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dhaval Patel
 */
public class TemporaryShiftAssignController extends TemporaryShiftAssignAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TempShiftAssignMaster tempShiftAssignMaster = new TempShiftAssignMaster();
        List<?> list = temporaryShiftAssignService.temporaryShiftAssignResult();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("shiftMaster", tempShiftAssignMaster);
        mv.setViewName("Shift/TemporaryShiftAssignResult");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String shiftId[] = request.getParameterValues("checkId");
        for (String z : shiftId) {
            try {
                temporaryShiftAssignService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TempShiftAssignMaster tempShiftAssignMaster = new TempShiftAssignMaster();
        selectEmployee(request, response);
        selectShift(request, response);
        mv.getModelMap().put("tempShiftAssignMaster", tempShiftAssignMaster);
        mv.setViewName("Shift/TemporaryShiftAssignCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TempShiftAssignMaster tempShiftAssignMaster = new TempShiftAssignMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        ShiftMaster shiftMaster = new ShiftMaster();
        BindException errors = new BindException(tempShiftAssignMaster, "tempShiftAssignMaster");
        bind(request, tempShiftAssignMaster);
        String empid = request.getParameter("employeeMasterId");
        String shiftId = request.getParameter("shiftMasterId");
        temporaryShiftAssignValidator.validate(tempShiftAssignMaster, errors);
        if (errors.hasErrors() || empid.equals("") || shiftId.equals("")) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            selectEmployee(request, response);
            selectShift(request, response);
            mv.setViewName("Shift/TemporaryShiftAssignCreate");
        } else {

            shiftMaster.setId(Integer.parseInt(shiftId));
            String[] eid = empid.split(",");
            for (String st : eid) {
                employeeMaster.setId(Integer.parseInt(st));
                tempShiftAssignMaster.setEmployeeMaster(employeeMaster);
                tempShiftAssignMaster.setShiftMaster(shiftMaster);
                temporaryShiftAssignService.create(tempShiftAssignMaster);
            }
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv.setViewName("redirect:temporaryShiftAssign.htm?act=searchSubmit");
        }
        return mv;
    }
}
