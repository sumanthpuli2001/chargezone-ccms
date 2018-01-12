/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollBonus;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollBonusController extends PayrollBonusAbstract{
    
    
    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollBonus  payrollBonus = new PayrollBonus();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        List<?> BonusList = payrollBonusService.read();
        for (Object obj : BonusList) {
             payrollBonus=(PayrollBonus) obj;
            employeeMaster = employeeMasterService.readById(payrollBonus.getEmployeeMaster().getId());
             payrollBonus.setEmployeeMaster(employeeMaster);
        }
        request.setAttribute("BonusList", BonusList);
        mv.setViewName("Payroll/PayrollBonusShow");
        return mv;
    }
    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollBonus  payrollBonus = new PayrollBonus();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        selectedEmployeeFor360Feedback(request, employeeMaster); 
        selectEmployee(request,response);
        
        payrollBonus.setEmployeeMaster(new EmployeeMaster());
     
       
        mv.getModelMap().put("payrollBonus",payrollBonus);
        mv.setViewName("Payroll/PayrollBonusCreate");
        return mv;
    }
     
      public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
         PayrollBonus  payrollBonus = new PayrollBonus();
        EmployeeMaster employeemaster= new EmployeeMaster();
        BindException errors = new BindException(payrollBonus,"payrollBonus");
        bind(request, payrollBonus);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("empId");
        if(null != empId && !"".equals(empId)){
            employeeMaster.setId(Integer.parseInt(empId));
            payrollBonus.setEmployeeMaster(employeeMaster);
        }else{
            payrollBonus.setEmployeeMaster(new EmployeeMaster());
        }
            selectedEmployeeFor360Feedback(request, employeeMaster); 
        selectEmployee(request,response);
        payrollBonusValidator.validate(payrollBonus, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollBonusCreate");
        } else {
            payrollBonusService.create(payrollBonus);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }

        return mv;
    }
        public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       PayrollBonus  payrollBonus = new PayrollBonus();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        String id = request.getParameter("id");
        
      
         payrollBonus = payrollBonusService.readById(Integer.parseInt(id));
        employeeMaster = employeeMasterService.readById(payrollBonus.getEmployeeMaster().getId());
         payrollBonus.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("payrollBonus", payrollBonus);
        mv.setViewName("Payroll/PayrollBonusEdit");
        return mv;
    }
      
       public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
           PayrollBonus  payrollBonus = new PayrollBonus();
        BindException errors = new BindException(payrollBonus, "payrollBonus");
        bind(request, payrollBonus);
        
        payrollBonusValidator.validate(payrollBonus, errors);
        
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Bonus is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollBonus",payrollBonus);
            mv.setViewName("Payroll/PayrollBonusEdit");
        } 
        else {
            payrollBonusService.update(payrollBonus);
            request.setAttribute("successMessage",
                    "Information: The Bonus  is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }
      public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollBonusService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }
      
    
}
