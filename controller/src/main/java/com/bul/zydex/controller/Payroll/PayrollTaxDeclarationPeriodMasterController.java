/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollTaxDeclarationPeriodMaster;
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
public class PayrollTaxDeclarationPeriodMasterController extends PayrollTaxDeclarationPeriodMasterAbstract
{
    public ModelAndView showPeriod(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeclarationPeriodMaster payrollTaxDeclarationPeriodMaster = new PayrollTaxDeclarationPeriodMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        
        List<PayrollTaxDeclarationPeriodMaster> tdpmList = (List<PayrollTaxDeclarationPeriodMaster>) payrollTaxDeclarationPeriodMasterService.readDeclarationPeriod();
        
        mv.getModelMap().put("list",tdpmList);
        mv.getModelMap().put("payrollFinancialYear", payrollFinancialYear);
        mv.getModelMap().put("payrollTaxDeclarationPeriodMaster",payrollTaxDeclarationPeriodMaster);
        mv.setViewName("Payroll/PayrollTaxDeclarationPeriodCreate");
        return mv;
        
    }
    
    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeclarationPeriodMaster payrollTaxDeclarationPeriodMaster = new PayrollTaxDeclarationPeriodMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        
        payrollTaxDeclarationPeriodMaster.setPayrollFinancialYear(new PayrollFinancialYear());
        
        financialYearList(request);
        
        payrollTaxDeclarationPeriodMaster.setPayrollFinancialYear(new PayrollFinancialYear());
        
        mv.getModelMap().put("payrollFinancialYear", payrollFinancialYear);
        mv.getModelMap().put("payrollTaxDeclarationPeriodMaster", payrollTaxDeclarationPeriodMaster);
        mv.setViewName("Payroll/PayrollTaxDeclarationPeriodNew");
        return mv;
    }
    
    public ModelAndView clickSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeclarationPeriodMaster payrollTaxDeclarationPeriodMaster = new PayrollTaxDeclarationPeriodMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
   
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        
        BindException errors = new BindException(payrollTaxDeclarationPeriodMaster, "payrollTaxDeclarationPeriodMaster");
        financialYearList(request);
        bind(request, payrollTaxDeclarationPeriodMaster);
         
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date createdDate = new Date();
        
        
        payrollTaxDeclarationPeriodMasterValidator.validate(payrollTaxDeclarationPeriodMaster, errors);
            if(errors.hasErrors())
            {
                request.setAttribute("faliureMessage",
                            "Error : The Tax Declaration Period  Creation is not valid.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("Payroll/PayrollTaxDeclarationPeriodNew");
            }
            else
            {
                if(null != payrollTaxDeclarationPeriodMaster.getPayrollFinancialYear().getId())
                {
                    String id = request.getParameter("payrollFinancialYear.id");
                    payrollFinancialYear = payrollFinancialYearService.readById(Integer.parseInt(id));
                    
                    Date declareDate = sdf.parse(payrollTaxDeclarationPeriodMaster.getDeclarationThresholdDate());
                    Date proofDate = sdf.parse(payrollTaxDeclarationPeriodMaster.getProofThresholdDate());
                    Date startDate = sdf.parse(payrollFinancialYear.getStartDate());
                    Date endDate = sdf.parse(payrollFinancialYear.getEndDate());
        
                    if(declareDate.compareTo(startDate) <= 0 || proofDate.compareTo(endDate) >= 0)
                    {
                        request.setAttribute("faliureMessage",
                            "Error : Declaration Threshold Date and Proof Threshold Date should be between Financial Year Date.");
                        mv.addAllObjects(errors.getModel());
                        mv.setViewName("Payroll/PayrollTaxDeclarationPeriodNew");
                    }
                    
                    else if (proofDate.compareTo(declareDate) <= 0) 
                    { 
                            request.setAttribute("faliureMessage",
                                    "Error : Proof Threshold Date should not be before Declaration Threshold Date.");
                            mv.addAllObjects(errors.getModel());
                            mv.setViewName("Payroll/PayrollTaxDeclarationPeriodNew");
                    }
                    
                    else
                    {
                        payrollTaxDeclarationPeriodMaster.setTdpStatus(0);
                        payrollTaxDeclarationPeriodMaster.setCreatedBy(employeeMaster.getId());
                        payrollTaxDeclarationPeriodMaster.setCreatedDate(sdf.format(createdDate));
                        payrollTaxDeclarationPeriodMasterService.create(payrollTaxDeclarationPeriodMaster);

                        request.setAttribute("successMessage",
                                "Information: The Tax Declaration Period is Created successfully");
                        mv.getModelMap().put("employeeMaster", employeeMaster);
                        mv.getModelMap().put("payrollTaxDeductionComponentCreate", payrollTaxDeclarationPeriodMaster);

                        mv = showPeriod(request, response);
                    }
                }
                else
                {
                    request.setAttribute("faliureMessage",
                                "Error : You selected black Section.");
                    mv.getModelMap().put("employeeMaster", employeeMaster);
                    mv.getModelMap().put("payrollTaxDeclarationPeriodMaster", payrollTaxDeclarationPeriodMaster);
                    mv.setViewName("Payroll/PayrollTaxDeclarationPeriodNew");
                }
            }
        
        return mv;
    }
          
    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeclarationPeriodMaster payrollTaxDeclarationPeriodMaster = new PayrollTaxDeclarationPeriodMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        
        financialYearList(request);
        
        String id = request.getParameter("id");
        payrollTaxDeclarationPeriodMaster = payrollTaxDeclarationPeriodMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("payrollTaxDeclarationPeriodMaster", payrollTaxDeclarationPeriodMaster);
        mv.setViewName("Payroll/PayrollTaxDeclarationPeriodEdit");
        return mv;
    
    }
    
    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        PayrollTaxDeclarationPeriodMaster payrollTaxDeclarationPeriodMaster = new PayrollTaxDeclarationPeriodMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        
        BindException errors = new BindException(payrollTaxDeclarationPeriodMaster, "payrollTaxDeclarationPeriodMaster");
        financialYearList(request);   
        bind(request, payrollTaxDeclarationPeriodMaster);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date updatedDate = new Date();
        
        payrollTaxDeclarationPeriodMasterValidator.validate(payrollTaxDeclarationPeriodMaster, errors);
        if(errors.hasErrors())
        {
            request.setAttribute("faliureMessage",
                        "Error : The Tax Declaration Period Updation is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollTaxDeclarationPeriodEdit");
        }
        else
        {
            if(null != payrollTaxDeclarationPeriodMaster.getPayrollFinancialYear().getId())
            {
                String id = request.getParameter("payrollFinancialYear.id");
                payrollFinancialYear = payrollFinancialYearService.readById(Integer.parseInt(id));

                Date declareDate = sdf.parse(payrollTaxDeclarationPeriodMaster.getDeclarationThresholdDate());
                Date proofDate = sdf.parse(payrollTaxDeclarationPeriodMaster.getProofThresholdDate());
                Date startDate = sdf.parse(payrollFinancialYear.getStartDate());
                Date endDate = sdf.parse(payrollFinancialYear.getEndDate());

                if(declareDate.compareTo(startDate) <= 0 || proofDate.compareTo(endDate) >= 0)
                {
                    request.setAttribute("faliureMessage",
                        "Error : Declaration Threshold Date and Proof Threshold Date should be between Financial Year Date.");
                    mv.addAllObjects(errors.getModel());
                    mv.setViewName("Payroll/PayrollTaxDeclarationPeriodEdit");
                }

                else if (proofDate.compareTo(declareDate) <= 0) 
                { 
                    request.setAttribute("faliureMessage",
                        "Error : Proof Threshold Date should not be before Declaration Threshold Date.");
                    mv.addAllObjects(errors.getModel());
                    mv.setViewName("Payroll/PayrollTaxDeclarationPeriodEdit");
                }
                
                else
                {
                    payrollTaxDeclarationPeriodMaster.setUpdatedBy(employeeMaster.getId());
                    payrollTaxDeclarationPeriodMaster.setUpdatedDate(sdf.format(updatedDate));
                    payrollTaxDeclarationPeriodMasterService.update(payrollTaxDeclarationPeriodMaster);

                    request.setAttribute("successMessage", "Information: The Tax Declaration Period is Updated successfully");
                    mv.getModelMap().put("employeeMaster", employeeMaster);
                    mv.getModelMap().put("payrollTaxDeclarationPeriodMaster", payrollTaxDeclarationPeriodMaster);

                    mv = showPeriod(request, response);
                }
            }
            else
            {
                request.setAttribute("faliureMessage",
                        "Error : You selected black Section.");
                mv.getModelMap().put("employeeMaster", employeeMaster);
                mv.getModelMap().put("payrollTaxDeclarationPeriodMaster", payrollTaxDeclarationPeriodMaster);
                mv.setViewName("Payroll/PayrollTaxDeclarationPeriodEdit");
            }
        } 
        return mv;
        
    }
    
    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                
                payrollTaxDeclarationPeriodMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
                
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
        mv = showPeriod(request, response);
        return mv;
    }
}
