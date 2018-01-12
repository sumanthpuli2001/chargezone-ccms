/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

public class PayrollDeductionController extends PayrollDeductionAbstract{
    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response)throws Exception{
        ModelAndView mv =new ModelAndView();
        PayrollDeduction payrollDeduction=new PayrollDeduction();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        List<?> Deductionlist = payrollDeductionService.read();
        for (Object obj : Deductionlist) {
            payrollDeduction= (PayrollDeduction) obj;
            employeeMaster = employeeMasterService.readById(payrollDeduction.getEmployeeMaster().getId());
            payrollDeduction.setEmployeeMaster(employeeMaster);
        }
        request.setAttribute("Deductionlist", Deductionlist);
        mv.setViewName("Payroll/PayrollDeductionshow");
      
        return mv;
        
    }
    
     public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollDeduction payrollDeduction=new PayrollDeduction();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        selectedEmployeeFor360Feedback(request, employeeMaster); 
        selectEmployee(request,response);
        
        payrollDeduction.setEmployeeMaster(new EmployeeMaster());
     
       
        mv.getModelMap().put("payrollDeduction",payrollDeduction);
        mv.setViewName("Payroll/PayrollDeductionCreate");
        return mv;
    }
     
      public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollDeduction payrollDeduction=new PayrollDeduction();
    
        BindException errors = new BindException(payrollDeduction,"payrollDeduction");
        bind(request, payrollDeduction);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("empId");
        if(null != empId && !"".equals(empId)){
            employeeMaster.setId(Integer.parseInt(empId));
            payrollDeduction.setEmployeeMaster(employeeMaster);
        }else{
            payrollDeduction.setEmployeeMaster(new EmployeeMaster());
        }
            selectedEmployeeFor360Feedback(request, employeeMaster); 
        selectEmployee(request,response);
        PayrollDeductionValidator.validate(payrollDeduction, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollDeductionCreate");
        } else {
            payrollDeductionService.create(payrollDeduction);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }

        return mv;
    }
        public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollDeduction payrollDeduction=new PayrollDeduction();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        String id = request.getParameter("id");
        
      
        payrollDeduction = payrollDeductionService.readById(Integer.parseInt(id));
        employeeMaster = employeeMasterService.readById( payrollDeduction.getEmployeeMaster().getId());
        payrollDeduction.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("payrollDeduction",payrollDeduction);
        mv.setViewName("Payroll/PayrollDeductionEdit");
        return mv;
    }
      
       public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollDeduction payrollDeduction=new PayrollDeduction();
        BindException errors = new BindException(payrollDeduction, "payrollDeduction");
        bind(request, payrollDeduction);
        
        PayrollDeductionValidator.validate(payrollDeduction, errors);
        
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Deduction is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollDeduction",payrollDeduction);
            mv.setViewName("Payroll/PayrollDeductionEdit");
        } 
        else {
            payrollDeductionService.update(payrollDeduction);
            request.setAttribute("successMessage",
                    "Information: The Deduction  is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }
    
        public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                payrollDeductionService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showResult(request, response);
        return mv;
    }
 

}
    

