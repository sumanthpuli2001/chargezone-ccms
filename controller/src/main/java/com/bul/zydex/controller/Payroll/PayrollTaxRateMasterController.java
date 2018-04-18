/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollTaxRateMaster;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL3
 */
public class PayrollTaxRateMasterController extends PayrollTaxRateMasterAbstract 
{
    public ModelAndView showTaxRateList(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
        
        List<?> list = payrollTaxRateMasterService.read();
        
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("payrollTaxRateMaster", payrollTaxRateMaster);
        mv.setViewName("Payroll/PayrollTaxRateMasterCreate");
        return mv;
    }
    
    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
        
        mv.getModelMap().put("payrollTaxRateMaster", payrollTaxRateMaster);
        mv.setViewName("Payroll/PayrollTaxRateMasterNew");
        return mv;
    }
    
    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        
        BindException errors = new BindException(payrollTaxRateMaster, "payrollTaxRateMaster");
        bind(request, payrollTaxRateMaster);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date createdDate = new Date();
        
        payrollTaxRateMasterValidator.validate(payrollTaxRateMaster, errors);

        if (errors.hasErrors()) {    
            request.setAttribute("failureMessage",
                    "Error : The Tax Rate Creation is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollTaxRateMasterNew");
        } 
        else 
        {      
            Integer incomeFrom = Integer.parseInt(request.getParameter("incomeFrom"));
            Integer incomeTo = Integer.parseInt(request.getParameter("incomeTo"));
            Integer ageFrom = Integer.parseInt(request.getParameter("ageFrom"));
            Integer ageTo = Integer.parseInt(request.getParameter("ageTo"));
            
            List<PayrollTaxRateMaster> list = (List<PayrollTaxRateMaster>) payrollTaxRateMasterService.getAgeValues(ageFrom, ageTo, incomeFrom, incomeTo);
            
            if(list.isEmpty())
            {
                payrollTaxRateMaster.setCreatedBy(employeeMaster.getId());
                payrollTaxRateMaster.setStatus(0);
                payrollTaxRateMaster.setCreatedDate(sdf.format(createdDate));
                payrollTaxRateMasterService.create(payrollTaxRateMaster);

                request.setAttribute("successMessage",
                    "Information: The Tax Rate Created successfully");

                mv.getModelMap().put("payrollTaxRateMaster", payrollTaxRateMaster);
                mv.getModelMap().put("employeeMaster",employeeMaster);
                mv = showTaxRateList(request,response);
            }
            else
            {   
                request.setAttribute("failureMessage",
                    "Error : Income Range is already exist in given Age Limit.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("Payroll/PayrollTaxRateMasterNew");
                
            }
        }
        return mv;
    }
    
    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
        
        String id = request.getParameter("id");
        
        payrollTaxRateMaster = payrollTaxRateMasterService.readById(Integer.parseInt(id));
        
        mv.getModelMap().put("payrollTaxRateMaster", payrollTaxRateMaster);
        mv.setViewName("Payroll/PayrollTaxRateMasterEdit");
        return mv;
    }    
    
    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        
        BindException errors = new BindException(payrollTaxRateMaster, "payrollTaxRateMaster");
        bind(request, payrollTaxRateMaster);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date updatedDate = new Date();
        
        payrollTaxRateMasterValidator.validate(payrollTaxRateMaster, errors);

        if (errors.hasErrors()) {    
            request.setAttribute("failureMessage",
                    "Error : The Tax Rate Updation is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollTaxRateMasterEdit");
        } 
        else 
        {
            Integer incomeFrom = Integer.parseInt(request.getParameter("incomeFrom"));
            Integer incomeTo = Integer.parseInt(request.getParameter("incomeTo"));
            Integer ageFrom = Integer.parseInt(request.getParameter("ageFrom"));
            Integer ageTo = Integer.parseInt(request.getParameter("ageTo"));
            
            List<PayrollTaxRateMaster> list = (List<PayrollTaxRateMaster>) payrollTaxRateMasterService.getAgeValues(ageFrom, ageTo, incomeFrom, incomeTo);
            
            if(list.isEmpty())
            {
                payrollTaxRateMaster.setUpdatedBy(employeeMaster.getId());
                payrollTaxRateMaster.setUpdatedDate(sdf.format(updatedDate));
                payrollTaxRateMasterService.update(payrollTaxRateMaster);

                request.setAttribute("successMessage",
                    "Information: The Tax Rate Updated successfully");

                mv.getModelMap().put("payrollTaxRateMaster", payrollTaxRateMaster);
                mv.getModelMap().put("employeeMaster",employeeMaster);
                mv = showTaxRateList(request,response);
            }
            else
            {   
                request.setAttribute("failureMessage",
                    "Error : Income Range is already exist in given Age Limit.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("Payroll/PayrollTaxRateMasterEdit");
                
            }
            
        }
        return mv;
    }
    
    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                
                payrollTaxRateMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
        mv = showTaxRateList(request, response);
        return mv;
    }
}
