/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollCommission;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollCommissionController extends PayrollCommissionAbstract{
    
      public ModelAndView showResult(HttpServletRequest request,
         HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollCommission  payrollCommission = new PayrollCommission();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        List<?> CommissionList = payrollCommissionService.read();
        for (Object obj :  CommissionList) {
             payrollCommission=(PayrollCommission) obj;
            employeeMaster = employeeMasterService.readById(payrollCommission.getEmployeeMaster().getId());
             payrollCommission.setEmployeeMaster(employeeMaster);
        }
        request.setAttribute("CommissionList", CommissionList);
        mv.setViewName("Payroll/PayrollCommissionShow");
        return mv;
    }
    
     public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollCommission  payrollCommission = new PayrollCommission();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        selectedEmployeeFor360Feedback(request, employeeMaster); 
        selectEmployee(request,response);
        
        payrollCommission.setEmployeeMaster(new EmployeeMaster());
     
       
        mv.getModelMap().put("payrollCommission",payrollCommission);
        mv.setViewName("Payroll/PayrollCommissionCreate");
        return mv;
    }
     
      public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollCommission  payrollCommission = new PayrollCommission();
        EmployeeMaster employeemaster= new EmployeeMaster();
        BindException errors = new BindException(payrollCommission,"payrollCommission");
        bind(request, payrollCommission);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("empId");
        if(null != empId && !"".equals(empId)){
            employeeMaster.setId(Integer.parseInt(empId));
            payrollCommission.setEmployeeMaster(employeeMaster);
        }else{
            payrollCommission.setEmployeeMaster(new EmployeeMaster());
        }
            selectedEmployeeFor360Feedback(request, employeeMaster); 
        selectEmployee(request,response);
        payrollCommissionValidator.validate(payrollCommission, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollCommissionCreate");
        } else {
            payrollCommissionService.create(payrollCommission);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }

        return mv;
    }
    
      public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       PayrollCommission  payrollCommission = new PayrollCommission();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        String id = request.getParameter("id");
        
      
         payrollCommission = payrollCommissionService.readById(Integer.parseInt(id));
        employeeMaster = employeeMasterService.readById(payrollCommission.getEmployeeMaster().getId());
         payrollCommission.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("payrollCommission", payrollCommission);
        mv.setViewName("Payroll/PayrollCommissionEdit");
        return mv;
    }
      
       public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
           PayrollCommission  payrollCommission = new PayrollCommission();
        BindException errors = new BindException(payrollCommission, "payrollCommission");
        bind(request, payrollCommission);
        
        payrollCommissionValidator.validate(payrollCommission, errors);
        
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Commission is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollCommission",payrollCommission);
            mv.setViewName("Payroll/PayrollCommissionEdit");
        } 
        else {
            payrollCommissionService.update(payrollCommission);
            request.setAttribute("successMessage",
                    "Information: The Commission  is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }
      public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollCommissionService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }
      
    
    
}
