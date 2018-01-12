/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.PayrollPtCheck;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollPtCheckController extends PayrollPtCheckAbstract{
     public ModelAndView showResult(HttpServletRequest request,
                  HttpServletResponse response)throws Exception{
             ModelAndView mv = new ModelAndView();
             PayrollPtCheck  payrollPtCheck=new PayrollPtCheck();
             EmployeeTypeMaster employeeTypeMaster=new EmployeeTypeMaster();
             EmployeeSubType employeeSubType = new EmployeeSubType();
             List<?> PtCheckList = payrollPtCheckService.read();
             for(Object obj : PtCheckList) {
                 payrollPtCheck=(PayrollPtCheck) obj;
                 employeeTypeMaster = employeeTypeService.readById(payrollPtCheck.getEmployeeTypeMaster().getId());
                 payrollPtCheck.setEmployeeTypeMaster(employeeTypeMaster);
                 employeeSubType=employeeSubTypeService.readById(payrollPtCheck.getEmployeeSubType().getId());
                 payrollPtCheck.setEmployeeSubType(employeeSubType);
                }
             request.setAttribute("PtCheckList", PtCheckList);
             mv.setViewName("Payroll/PayrollPtCheckShow");
             return mv;
    }
     public ModelAndView createClick(HttpServletRequest request,
                 HttpServletResponse  response)throws Exception{
           ModelAndView mv=new ModelAndView();
           PayrollPtCheck  payrollPtCheck=new PayrollPtCheck();
           EmployeeTypeMaster employeeTypeMaster=new EmployeeTypeMaster();
           EmployeeSubType employeeSubType =new EmployeeSubType();
           EmployeeTypeList(request);
           EmployeeSubTypeList(request);
           payrollPtCheck.setEmployeeTypeMaster(employeeTypeMaster);
           payrollPtCheck.setEmployeeSubType(employeeSubType);
           mv.getModelMap().put("payrollPtCheck", payrollPtCheck);
           mv.setViewName("Payroll/PayrollPtCheckCreate");
           return mv;
        }
    
    
    public  ModelAndView createSubmit(HttpServletRequest request,
                 HttpServletResponse response)throws Exception{
           ModelAndView mv=new ModelAndView();
          PayrollPtCheck  payrollPtCheck=new PayrollPtCheck();
           BindException errors = new BindException(payrollPtCheck, "payrollPtCheck");
           EmployeeSubType employeeSubType = new EmployeeSubType();
           EmployeeTypeMaster employeeTypeMaster=new EmployeeTypeMaster();
           bind(request, payrollPtCheck);
           EmployeeTypeList(request);
           EmployeeSubTypeList(request);
           String employeeSubTypeId=request.getParameter("subTypeId");
            if (null != employeeSubTypeId && !employeeSubTypeId.equals("")) {
                    employeeSubType.setId(Integer.parseInt(employeeSubTypeId));
                }
           payrollPtCheck.setEmployeeSubType(employeeSubType);
            payrollPtCheckValidator.validate(payrollPtCheck, errors);
         if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Payroll/PayrollPtCheckCreate");
        } else {if (!payrollPtCheckService.isExist(payrollPtCheck)) {
            payrollPtCheckService.create(payrollPtCheck);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

       }
        else {
                request.setAttribute("failureMessage",
                        "Error : The Pt Check is already there.");
                mv.setViewName("Payroll/PayrollPtCheckCreate");
                 mv.getModelMap().put("payrollPtCheck", payrollPtCheck);
            }
        
//        return mv;
    }
        return mv;
     }
     public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
       PayrollPtCheck  payrollPtCheck=new PayrollPtCheck();
        EmployeeSubType employeeSubType = new EmployeeSubType();
         EmployeeTypeMaster employeeTypeMaster=new EmployeeTypeMaster();
        String id = request.getParameter("id");
        EmployeeTypeList(request);
         EmployeeSubTypeList(request);
        payrollPtCheck = payrollPtCheckService.readById(Integer.parseInt(id));
          employeeTypeMaster = employeeTypeService.readById(payrollPtCheck.getEmployeeTypeMaster().getId());
          payrollPtCheck.setEmployeeTypeMaster(employeeTypeMaster);
          employeeSubType=employeeSubTypeService.readById(payrollPtCheck.getEmployeeSubType().getId());
          payrollPtCheck.setEmployeeSubType(employeeSubType);
        mv.getModelMap().put("payrollPtCheck",payrollPtCheck);
        mv.setViewName("Payroll/PayrollPtCheckEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
      PayrollPtCheck  payrollPtCheck=new PayrollPtCheck();
        BindException errors = new BindException(payrollPtCheck, "payrollPtCheck");
          String subTypeId = request.getParameter("subTypeId");
        EmployeeSubType employeeSubType = new EmployeeSubType();
        if(null !=subTypeId && !subTypeId.equals("")){
            employeeSubType.setId(Integer.parseInt(subTypeId));
            payrollPtCheck.setEmployeeSubType(employeeSubType); 
        }
        bind(request, payrollPtCheck);
         EmployeeTypeList(request);
         EmployeeSubTypeList(request);
        payrollPtCheckValidator.validate(payrollPtCheck, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The payroll PT heck is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollPtCheck", payrollPtCheck);
            mv.setViewName("Payroll/PayrollPtCheckEdit");
        } else {
            payrollPtCheckService.update(payrollPtCheck);
  
            request.setAttribute("successMessage",
                    "Information: The payroll PT check is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }
     public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                payrollPtCheckService.delete(Integer.parseInt(z));
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
         PayrollPtCheck payrollPtCheck=new PayrollPtCheck();
        String typeId = request.getParameter("typeId");
        String employeeId = request.getParameter("employeeId");

        String empSubTypeId = request.getParameter("empSubTypeId");

        if (null == employeeId) {
        } else {
            payrollPtCheck = payrollPtCheckService.readById(Integer.parseInt(employeeId));
            request.setAttribute("employeeSubTypeId", payrollPtCheck.getEmployeeSubType().getId());
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
