/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.PayrollPfCheck;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishant
 */
public class PayrollPfCheckController extends PayrollPfCheckAbstract{
    public ModelAndView showResult(HttpServletRequest request,
              HttpServletResponse response)throws Exception{
             ModelAndView mv = new ModelAndView();
             PayrollPfCheck  payrollPfCheck=new PayrollPfCheck();
             EmployeeTypeMaster employeeTypeMaster=new EmployeeTypeMaster();
             EmployeeSubType employeeSubType = new EmployeeSubType();
             List<?> PfCheckList = payrollPfCheckService.read();
             for(Object obj : PfCheckList) {
                 payrollPfCheck=(PayrollPfCheck) obj;
                 employeeTypeMaster = employeeTypeService.readById(payrollPfCheck.getEmployeeTypeMaster().getId());
                 payrollPfCheck.setEmployeeTypeMaster(employeeTypeMaster);
                 employeeSubType=employeeSubTypeService.readById(payrollPfCheck.getEmployeeSubType().getId());
                 payrollPfCheck.setEmployeeSubType(employeeSubType);
                }
             request.setAttribute("PfCheckList", PfCheckList);
             mv.setViewName("Payroll/PayrollPfCheckShow");
             return mv;
        }
    public ModelAndView createClick(HttpServletRequest request,
                 HttpServletResponse  response)throws Exception{
           ModelAndView mv=new ModelAndView();
           PayrollPfCheck payrollPfCheck=new PayrollPfCheck();
           EmployeeTypeMaster employeeTypeMaster=new EmployeeTypeMaster();
           EmployeeSubType employeeSubType =new EmployeeSubType();
           EmployeeTypeList(request);
           EmployeeSubTypeList(request);
           payrollPfCheck.setEmployeeTypeMaster(employeeTypeMaster);
           payrollPfCheck.setEmployeeSubType(employeeSubType);
           mv.getModelMap().put("payrollPfCheck", payrollPfCheck);
           mv.setViewName("Payroll/PayrollPfCheckCreate");
           return mv;
        }
    
    
    public  ModelAndView createSubmit(HttpServletRequest request,
                 HttpServletResponse response)throws Exception{
           ModelAndView mv=new ModelAndView();
           PayrollPfCheck payrollPfCheck=new PayrollPfCheck();
           BindException errors = new BindException(payrollPfCheck, "payrollPfCheck");
           EmployeeSubType employeeSubType = new EmployeeSubType();
           EmployeeTypeMaster employeeTypeMaster=new EmployeeTypeMaster();
           bind(request, payrollPfCheck);
           EmployeeTypeList(request);
           EmployeeSubTypeList(request);
           String employeeSubTypeId=request.getParameter("subTypeId");
            if (null != employeeSubTypeId && !employeeSubTypeId.equals("")) {
                    employeeSubType.setId(Integer.parseInt(employeeSubTypeId));
                }
           payrollPfCheck.setEmployeeSubType(employeeSubType);
            payrollPfCheckValidator.validate(payrollPfCheck, errors);
         if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollPfCheckCreate");
        } else {if (!payrollPfCheckService.isExist(payrollPfCheck)) {
            payrollPfCheckService.create(payrollPfCheck);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

       }else {
                request.setAttribute("failureMessage",
                        "Error : The Pf Check  is already there.");
                mv.setViewName("Payroll/PayrollPfCheckCreate");
                 mv.getModelMap().put("payrollPfCheck", payrollPfCheck);
            }
        
//        return mv;
    }
         
        return mv;
     }
     public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollPfCheck payrollPfCheck=new PayrollPfCheck();
        EmployeeSubType employeeSubType = new EmployeeSubType();
         EmployeeTypeMaster employeeTypeMaster=new EmployeeTypeMaster();
        String id = request.getParameter("id");
        EmployeeTypeList(request);
         EmployeeSubTypeList(request);
        payrollPfCheck = payrollPfCheckService.readById(Integer.parseInt(id));
          employeeTypeMaster = employeeTypeService.readById(payrollPfCheck.getEmployeeTypeMaster().getId());
          payrollPfCheck.setEmployeeTypeMaster(employeeTypeMaster);
          employeeSubType=employeeSubTypeService.readById(payrollPfCheck.getEmployeeSubType().getId());
          payrollPfCheck.setEmployeeSubType(employeeSubType);
        mv.getModelMap().put("payrollPfCheck",payrollPfCheck);
        mv.setViewName("Payroll/PayrollPfCheckEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
         ModelAndView mv = new ModelAndView();
       PayrollPfCheck payrollPfCheck=new PayrollPfCheck();
        BindException errors = new BindException(payrollPfCheck, "payrollPfCheck");
        String subTypeId = request.getParameter("subTypeId");
        EmployeeSubType employeeSubType = new EmployeeSubType();
        if(null !=subTypeId && !subTypeId.equals("")){
            employeeSubType.setId(Integer.parseInt(subTypeId));
            payrollPfCheck.setEmployeeSubType(employeeSubType); 
        }
          
        bind(request, payrollPfCheck);
         EmployeeTypeList(request);
         EmployeeSubTypeList(request);
        payrollPfCheckValidator.validate(payrollPfCheck, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The payroll Pf check is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollPfCheck", payrollPfCheck);
            mv.setViewName("Payroll/PayrollPfCheckEdit");
        } else {
            payrollPfCheckService.update(payrollPfCheck);
  
            request.setAttribute("successMessage",
                    "Information: The payroll Pf check is Updated successfully");
              mv = showResult(request, response);
        }
         
        return mv;
    }
     public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollPfCheckService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }
      public ModelAndView readEmpTypeAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
         PayrollPfCheck payrollPfCheck=new PayrollPfCheck();
        String typeId = request.getParameter("typeId");
        String employeeId = request.getParameter("employeeId");

        String empSubTypeId = request.getParameter("empSubTypeId");

        if (null == employeeId) {
        } else {
            payrollPfCheck = payrollPfCheckService.readById(Integer.parseInt(employeeId));
            request.setAttribute("employeeSubTypeId", payrollPfCheck.getEmployeeSubType().getId());
        }
        if (null == empSubTypeId) {
        } else {
            request.setAttribute("employeeSubTypeId", empSubTypeId);
        }
        List<?> employeeSubTypeList = employeeSubTypeService.readByEmployeeTypeId(typeId);
        request.setAttribute("employeeSubTypeList", employeeSubTypeList);
        mv.setViewName("Payroll/SubTypeAjax");
        return mv;
    }
}
