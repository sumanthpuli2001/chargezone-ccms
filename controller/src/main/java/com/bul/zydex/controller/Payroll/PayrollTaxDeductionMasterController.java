/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollTaxDeductionComponent;

import com.bul.zydex.model.PayrollTaxDeductionMaster;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeductionMasterController extends PayrollTaxDeductionMasterAbstract {

    public ModelAndView taxDeductionCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        //EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();

        List<?> tdmList = payrollTaxDeductionMasterService.readTaxDeduction();

        mv.getModelMap().put("payrollTaxDeductionMaster", payrollTaxDeductionMaster);
        mv.getModelMap().put("list", tdmList);
     
        mv.setViewName("Payroll/PayrollTaxDeductionCreate");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                
                payrollTaxDeductionMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
        mv = taxDeductionCreate(request, response);
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
       
        mv.getModelMap().put("payrollTaxDeductionMaster", payrollTaxDeductionMaster);
        mv.setViewName("Payroll/PayrollTaxDeductionNewCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,HttpServletResponse response) throws Exception {
        
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
        
        BindException errors = new BindException(payrollTaxDeductionMaster, "payrollTaxDeductionMaster");
        bind(request, payrollTaxDeductionMaster);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date createdDate = new Date();
        
        payrollTaxDeductionMasterValidator.validate(payrollTaxDeductionMaster, errors);

           if (errors.hasErrors()) {
                request.setAttribute("faliureMessage",
                        "Error : The Tax Deduction Creation is not valid.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("Payroll/PayrollTaxDeductionNewCreate");
           } 
           else {
                payrollTaxDeductionMaster.setCreatedBy(employeeMaster.getId());
                payrollTaxDeductionMaster.setTdStatus(0);
                payrollTaxDeductionMaster.setCreatedDate(sdf.format(createdDate));
                payrollTaxDeductionMasterService.create(payrollTaxDeductionMaster);
                
                request.setAttribute("successMessage",
                    "Information: The Tax Deduction is Created successfully");
        }

        mv.getModelMap().put("payrollTaxDeductionMaster", payrollTaxDeductionMaster);
        mv.getModelMap().put("employeeMaster",employeeMaster);
        mv = taxDeductionCreate(request,response);
        return mv;
    }
    
    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();

        String id = request.getParameter("id");

        payrollTaxDeductionMaster = payrollTaxDeductionMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("payrollTaxDeductionMaster",payrollTaxDeductionMaster);
        mv.setViewName("Payroll/PayrollTaxDeductionEdit");
        return mv; 
    
    }
    
    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
        
        BindException errors = new BindException(payrollTaxDeductionMaster, "payrollTaxDeductionMaster");
        bind(request, payrollTaxDeductionMaster);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date updatedDate = new Date();
        
        payrollTaxDeductionMasterValidator.validate(payrollTaxDeductionMaster, errors);

           if (errors.hasErrors()) {
                request.setAttribute("faliureMessage",
                        "Error : The Tax Deduction updation is not valid.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("Payroll/PayrollTaxDeductionEdit");
           } 
           else {
                payrollTaxDeductionMaster.setUpdatedBy(employeeMaster.getId());
                payrollTaxDeductionMaster.setUpdatedDate(sdf.format(updatedDate));
                payrollTaxDeductionMasterService.update(payrollTaxDeductionMaster);
                
                request.setAttribute("successMessage",
                    "Information: The Tax Deduction is Updated successfully");
        }

        mv.getModelMap().put("payrollTaxDeductionMaster", payrollTaxDeductionMaster);
        mv = taxDeductionCreate(request,response);
        return mv;
        
    }
    
    /* ---------------------------- Tax Deduction Component Start From Here ----------------------------- */
    
    public ModelAndView showTaxDeductionComponent(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        
        PayrollTaxDeductionComponent payrollTaxDeductionComponentCreate = new PayrollTaxDeductionComponent();
        
   //     List<?> tdmList = payrollTaxDeductionComponentService.read();
        
        mv.getModelMap().put("payrollTaxDeductionComponentCreate", payrollTaxDeductionComponentCreate);
    //    mv.getModelMap().put("list",tdmList);
        mv.setViewName("Payroll/PayrollTaxDeductionComponentCreate");
        return mv;
    }
    
    public ModelAndView createTaxDeductionComponentClick(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeductionComponent payrollTaxDeductionComponentCreate = new PayrollTaxDeductionComponent();
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
        
        payrollTaxDeductionComponentCreate.setPayrollTaxDeductionMaster(new PayrollTaxDeductionMaster());
        
        sectionList(request);
        
        payrollTaxDeductionComponentCreate.setPayrollTaxDeductionMaster(new PayrollTaxDeductionMaster());
        
        mv.getModelMap().put("payrollTaxDeductionMaster", payrollTaxDeductionMaster);
        mv.getModelMap().put("payrollTaxDeductionComponentCreate", payrollTaxDeductionComponentCreate);
        mv.setViewName("Payroll/PayrollTaxDeductionComponentNew");
        return mv;
    }
    
    public ModelAndView createTaxDeductionComponentSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        
        PayrollTaxDeductionComponent payrollTaxDeductionComponentCreate = new PayrollTaxDeductionComponent();
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        
        BindException errors = new BindException(payrollTaxDeductionComponentCreate, "payrollTaxDeductionComponentCreate");
        bind(request, payrollTaxDeductionComponentCreate);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date createdDate = new Date();
        
        payrollTaxDeductionComponentValidator.validate(payrollTaxDeductionComponentCreate, errors);
        if(errors.hasErrors())
        {
            request.setAttribute("faliureMessage",
                        "Error : The Tax Deduction Component Creation is not valid.");
            mv.addAllObjects(errors.getModel());
            mv = createTaxDeductionComponentClick(request,response);
        }
        else
        {
            payrollTaxDeductionComponentCreate.setTdcStatus(0);
            payrollTaxDeductionComponentCreate.setCreatedBy(employeeMaster.getId());
            payrollTaxDeductionComponentCreate.setCreatedDate(sdf.format(createdDate));
            payrollTaxDeductionComponentService.create(payrollTaxDeductionComponentCreate);

            request.setAttribute("successMessage","Information: The Tax Deduction Component is Created successfully");
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.getModelMap().put("payrollTaxDeductionComponentCreate", payrollTaxDeductionComponentCreate);
            
            mv = showTaxDeductionComponent(request, response);
        }
        
        return mv;
    }
    
    public ModelAndView viewTaxDeductionComponentDetail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        PayrollTaxDeductionComponent payrollTaxDeductionComponent = new PayrollTaxDeductionComponent();
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        
        String id = request.getParameter("id");
        payrollTaxDeductionMaster = payrollTaxDeductionMasterService.readById(Integer.parseInt(id));
        
        List<?> componentList = payrollTaxDeductionComponentService.readByComponentId(Integer.parseInt(id));

        mv.getModelMap().put("payrollTaxDeductionComponent", payrollTaxDeductionComponent);
        mv.getModelMap().put("payrollTaxDeductionMaster", payrollTaxDeductionMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("componentList", componentList);
       
        mv.setViewName("Payroll/PayrollTaxDeductionComponentCreate");
        return mv;
    }
    
    public ModelAndView deleteTaxDeductionComponentSubmit(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeductionComponent payrollTaxDeductionComponentCreate = new PayrollTaxDeductionComponent();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                
                payrollTaxDeductionMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
        
        mv.getModelMap().put("payrollTaxDeductionComponentCreate", payrollTaxDeductionComponentCreate);
        mv.setViewName("Payroll/PayrollTaxDeductionComponentCreate");
        mv = showTaxDeductionComponent(request, response);
        return mv;
        
    }
    
    public ModelAndView editTaxDeductionComponentClick(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeductionComponent payrollTaxDeductionComponentCreate = new PayrollTaxDeductionComponent();
        
        String id = request.getParameter("id");
       
        List<PayrollTaxDeductionComponent> componentList = (List<PayrollTaxDeductionComponent>) payrollTaxDeductionComponentService.readByComponentId(Integer.parseInt(id));

        mv.getModelMap().put("payrollTaxDeductionComponentCreate", payrollTaxDeductionComponentCreate);
        mv.getModelMap().put("componentList", componentList);
        mv.setViewName("Payroll/PayrollTaxDeductionComponentEdit");

        return mv; 
    }
    
    public ModelAndView editTaxDeductionComponentSubmit(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeductionComponent payrollTaxDeductionComponentCreate = new PayrollTaxDeductionComponent();
        mv.getModelMap().put("payrollTaxDeductionComponentCreate", payrollTaxDeductionComponentCreate);
        mv.setViewName("Payroll/PayrollTaxDeductionComponentCreate");
        return mv;
    }
}
