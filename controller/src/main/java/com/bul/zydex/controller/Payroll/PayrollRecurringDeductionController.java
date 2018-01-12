/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollRecurringDeduction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishant
 */
public class PayrollRecurringDeductionController extends PayrollRecurringDeductionAbstract {
    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response)throws Exception{
        ModelAndView mv=new ModelAndView();
        PayrollRecurringDeduction payrollRecurringDeduction=new PayrollRecurringDeduction();
        EmployeeMaster  employeeMaster =new EmployeeMaster(); 
        List<?>RecurringList=payrollRecurringDeductionService.read();
        for (Object obj : RecurringList) {
            payrollRecurringDeduction= (PayrollRecurringDeduction) obj;
            employeeMaster = employeeMasterService.readById(payrollRecurringDeduction.getEmployeeMaster().getId());
            payrollRecurringDeduction.setEmployeeMaster(employeeMaster);
        }
        request.setAttribute("RecurringList",RecurringList);
        mv.setViewName("Payroll/PayrollRecurringDeductionshow");
        return mv;
    }
    
    public  ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response)throws Exception{
    
       ModelAndView mv= new ModelAndView();
       PayrollRecurringDeduction payrollRecurringDeduction=new PayrollRecurringDeduction();
       EmployeeMaster employeeMaster= new EmployeeMaster();
       selectedEmployeeFor360Feedback(request, employeeMaster);
       selectEmployee(request, response);
       mv.getModelMap().put("payrollRecurringDeduction",payrollRecurringDeduction);
       mv.setViewName("Payroll/PayrollRecurringDeductionCreate");
       return mv;
    }
    
    
    public ModelAndView createSubmit(HttpServletRequest request,
             HttpServletResponse response)throws Exception{
    ModelAndView mv=new ModelAndView();
    PayrollRecurringDeduction payrollRecurringDeduction=new PayrollRecurringDeduction();
    EmployeeMaster employeeMaster=new EmployeeMaster();
    BindException errors = new BindException(payrollRecurringDeduction,"payrollRecurringDeduction");
    bind(request,payrollRecurringDeduction);
    String empId = request.getParameter("empId");
    if(null != empId && !"".equals(empId)){
            employeeMaster.setId(Integer.parseInt(empId));
            payrollRecurringDeduction.setEmployeeMaster(employeeMaster);
        }else{
            payrollRecurringDeduction.setEmployeeMaster(new EmployeeMaster());
        }
    selectedEmployeeFor360Feedback(request, employeeMaster); 
    selectEmployee(request,response);
     PayrollRecurringDeductionValidator.validate(payrollRecurringDeduction, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollRecurringDeductionCreate");
        } else {
            payrollRecurringDeductionService.create(payrollRecurringDeduction);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);
        }
        return mv; 
      }
    
      public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollRecurringDeduction payrollRecurringDeduction=new PayrollRecurringDeduction();
        EmployeeMaster employeeMaster= new EmployeeMaster();
        String id = request.getParameter("id");
        
      
        payrollRecurringDeduction = payrollRecurringDeductionService.readById(Integer.parseInt(id));
        employeeMaster = employeeMasterService.readById( payrollRecurringDeduction.getEmployeeMaster().getId());
        payrollRecurringDeduction.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("payrollRecurringDeduction",payrollRecurringDeduction);
        mv.setViewName("Payroll/PayrollRecurringDeductionEdit");
        return mv;
    }
      
       public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollRecurringDeduction payrollRecurringDeduction=new PayrollRecurringDeduction();
        BindException errors = new BindException(payrollRecurringDeduction, "payrollRecurringDeduction");
        bind(request, payrollRecurringDeduction);
        
        PayrollRecurringDeductionValidator.validate(payrollRecurringDeduction, errors);
        
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Deduction is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap()
                    .put("payrollRecurringDeduction",payrollRecurringDeduction);
            mv.setViewName("Payroll/PayrollRecurringDeductionEdit");
        } 
        else {
            payrollRecurringDeductionService.update(payrollRecurringDeduction);
            request.setAttribute("successMessage",
                    "Information: The Recurring Deduction  is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }
    
        public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                payrollRecurringDeductionService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showResult(request, response);
        return mv;
    }
 
            
    
}
