/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.ESICMaster;
import com.bul.zydex.model.EmployeeMaster;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rishi
 */
public class PayrollESICController extends PayrollESICAbstract{
    
     public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ESICMaster eSICMaster = new ESICMaster();
        List<?> esicList = eSICMasterService.readEsic();
        mv.addObject("list", esicList);
        mv.addObject("eSICMaster", eSICMaster);
        mv.setViewName("PayrollESIC/ESICList");
        return mv;

    }

    public ModelAndView createNewESIC(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ESICMaster eSICMaster = new ESICMaster();
        mv.addObject("eSICMaster", eSICMaster);
        mv.setViewName("PayrollESIC/ESICcreate");
        return mv;
    }

    public ModelAndView SubmitESIC(HttpServletRequest request, HttpServletResponse response, ESICMaster eSICMaster) throws Exception {
        BindException errors = new BindException(eSICMaster, "eSICMaster");
        bind(request, eSICMaster);
        ModelAndView mv = new ModelAndView();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("eSICMaster", eSICMaster);
            mv.setViewName("PayrollESIC/ESICcreate");
        } else {
            if (eSICMasterService.isExist(eSICMaster)) {
                eSICMasterService.createOrUpdate(eSICMaster);
                List<?> esicList = eSICMasterService.read();
                mv.addObject("list", eSICMaster);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv = showList(request, response);
            } else {
                mv.addObject("failureMessage", "Error : The Bank Name Is Already Exist. ");
                mv.addObject("eSICMaster", eSICMaster);
                mv.setViewName("PayrollESIC/ESICcreate");
            }
        }
        mv.getModelMap().put("eSICMaster", eSICMaster);
        return mv;
    }

    public ModelAndView deleteESIC(HttpServletRequest request, HttpServletResponse response, ESICMaster eSICMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            try {
                eSICMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
            }
        }
        mv.addObject("successMessage", "Information : Information Delete Successfully.");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView esicChalan(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("PayrollESIC/ESICchalanDetail");
        return mv;

    }

    public ModelAndView searchEsicSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        Double totalgrossAmount = 0.00;
        Double totalEmpContrubtionAmount = 0.00;
        Double totalCompContrubtionAmount = 0.00;
        List finalList = new ArrayList();
        List listForMonthAndYear = new ArrayList();
        String month = request.getParameter("month");
        String year = request.getParameter("year11");

        HttpSession session = request.getSession();

        if (!"".equals(month)) {
            employeeMaster.setBankAccountNo(month);
        }

        if (!"".equals(year)) {
            employeeMaster.setPanCard(year);
        }

        List<?> readEmployeeEsicStatementlist = eSICMasterService.esicChalanSearch(employeeMaster);
        List<?> readEmployeeCountlist = eSICMasterService.esicChalanemCount(employeeMaster);

        Iterator itr = readEmployeeEsicStatementlist.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalgrossAmount += (Double) next[2];
        }

        Iterator itr1 = readEmployeeEsicStatementlist.iterator();
        while (itr1.hasNext()) {
            Object[] next = (Object[]) itr1.next();
            totalEmpContrubtionAmount += (Double) next[3];
        }

        Iterator itr2 = readEmployeeEsicStatementlist.iterator();
        while (itr2.hasNext()) {
            Object[] next = (Object[]) itr2.next();
            totalCompContrubtionAmount += (Double) next[4];
        }
        Double total = 0.00;
        total = totalEmpContrubtionAmount + totalCompContrubtionAmount;

        List<?> esicList = eSICMasterService.read();
        request.setAttribute("list", esicList);
        request.setAttribute("employeelist", readEmployeeEsicStatementlist);
        request.setAttribute("totalgrossAmount", totalgrossAmount);
        request.setAttribute("totalEmpContrubtionAmount", totalEmpContrubtionAmount);
        request.setAttribute("totalCompContrubtionAmount", totalCompContrubtionAmount);
        request.setAttribute("readEmployeeCountlist", readEmployeeCountlist);
        request.setAttribute("total", total);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = esicChalan(request, response);
        return mv;
    }

}
