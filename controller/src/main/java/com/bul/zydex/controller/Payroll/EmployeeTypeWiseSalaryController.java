/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMultipleSalary;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.EmployeeTypeWiseSalary;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeTypeWiseSalaryController extends EmployeeTypeWiseSalaryAbstract {

    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeWiseSalary employeeTypeWiseSalary = new EmployeeTypeWiseSalary();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        List<?> EmpTypeWiseList = employeeTypeWiseSalaryService.read();
        for (Object obj : EmpTypeWiseList) {
            employeeTypeWiseSalary = (EmployeeTypeWiseSalary) obj;
            employeeTypeMaster = employeeTypeService.readById(employeeTypeWiseSalary.getEmployeeTypeMaster().getId());
            employeeTypeWiseSalary.setEmployeeTypeMaster(employeeTypeMaster);
            employeeSubType = employeeSubTypeService.readById(employeeTypeWiseSalary.getEmployeeSubType().getId());
            employeeTypeWiseSalary.setEmployeeSubType(employeeSubType);
            zydexLocationMaster = zydexLocationMasterService.readById(employeeTypeWiseSalary.getZydexLocationMaster().getId());
            employeeTypeWiseSalary.setZydexLocationMaster(zydexLocationMaster);
        }
        request.setAttribute("EmpTypeWiseList", EmpTypeWiseList);
        mv.setViewName("Payroll/EmployeeTypeWiseSalaryShow");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeWiseSalary employeeTypeWiseSalary = new EmployeeTypeWiseSalary();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        zydexLocationList(request);
        PayrollSalaryTypeList(request);
        employeeTypeWiseSalary.setEmployeeTypeMaster(employeeTypeMaster);
        employeeTypeWiseSalary.setEmployeeSubType(employeeSubType);
        employeeTypeWiseSalary.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("employeeTypeWiseSalary", employeeTypeWiseSalary);
        mv.setViewName("Payroll/EmployeeTypeWiseSalaryCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeWiseSalary employeeTypeWiseSalary = new EmployeeTypeWiseSalary();
        BindException errors = new BindException(employeeTypeWiseSalary, "employeeTypeWiseSalary");
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        String subTypeId = request.getParameter("subTypeId");
         if (null != subTypeId && !subTypeId.equals("")) {
                    employeeSubType.setId(Integer.parseInt(subTypeId));
                }
//        employeeSubType.setId(Integer.parseInt(subTypeId));
        employeeTypeWiseSalary.setEmployeeSubType(employeeSubType);
        bind(request, employeeTypeWiseSalary);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        zydexLocationList(request);
        PayrollSalaryTypeList(request);
        String[] a = request.getParameterValues("payrollSalaryType");
       
//           employeeTypeWiseSalary.setEmployeeTypeMaster(employeeTypeMaster);
//           employeeTypeWiseSalary.setZydexLocationMaster(zydexLocationMaster);
          employeeTypeWiseSalaryValidator.validate(employeeTypeWiseSalary, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeTypeWiseSalary", employeeTypeWiseSalary);
            mv.setViewName("Payroll/EmployeeTypeWiseSalaryCreate");
            
        } else {if (!employeeTypeWiseSalaryService.isExist(employeeTypeWiseSalary)) {
            employeeTypeWiseSalaryService.create(employeeTypeWiseSalary);

//            for
            for (String s : a) {
                EmployeeMultipleSalary employeeMultipleSalary = new EmployeeMultipleSalary();
                employeeMultipleSalary.setEmployeeTypeWiseSalary(employeeTypeWiseSalary);
                payrollSalaryType.setId(Integer.parseInt(s));
                employeeMultipleSalary.setPayrollSalaryType(payrollSalaryType);
                employeeMultipleSalaryService.create(employeeMultipleSalary);
            }

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }else {
                request.setAttribute("failureMessage",
                        "Error : The Employee Type Wise Salary is already there.");
                 mv.getModelMap().put("employeeTypeWiseSalary", employeeTypeWiseSalary);
                mv.setViewName("Payroll/EmployeeTypeWiseSalaryCreate");
            }
        
//        return mv;
    }
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeWiseSalary employeeTypeWiseSalary = new EmployeeTypeWiseSalary();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        PayrollSalaryType payrollSalaryType = new PayrollSalaryType();

        EmployeeSubType employeeSubType = new EmployeeSubType();
        String id = request.getParameter("id");
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        zydexLocationList(request);
        PayrollSalaryTypeList(request);

        employeeTypeWiseSalary = employeeTypeWiseSalaryService.readById(Integer.parseInt(id));
        employeeTypeMaster = employeeTypeService.readById(employeeTypeWiseSalary.getEmployeeTypeMaster().getId());
        employeeTypeWiseSalary.setEmployeeTypeMaster(employeeTypeMaster);
        employeeSubType = employeeSubTypeService.readById(employeeTypeWiseSalary.getEmployeeSubType().getId());
        employeeTypeWiseSalary.setEmployeeSubType(employeeSubType);
        zydexLocationMaster = zydexLocationMasterService.readById(employeeTypeWiseSalary.getZydexLocationMaster().getId());
        employeeTypeWiseSalary.setZydexLocationMaster(zydexLocationMaster);
        String addId = "";
        List<?> list = employeeMultipleSalaryService.readBytypeWiseSalary(Integer.parseInt(id));
        for (Object o : list) {
            EmployeeMultipleSalary employeeMultipleSalary = (EmployeeMultipleSalary) o;
            addId += "" + employeeMultipleSalary.getPayrollSalaryType().getId() + ",";
        }
         request.setAttribute("list", addId);

        mv.getModelMap().put("employeeTypeWiseSalary", employeeTypeWiseSalary);
        mv.setViewName("Payroll/EmployeeTypeWiseSalaryEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeWiseSalary employeeTypeWiseSalary = new EmployeeTypeWiseSalary();
       
        PayrollSalaryType payrollSalaryType = new PayrollSalaryType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        String[] a = request.getParameterValues("payrollSalaryType");
        String subTypeId = request.getParameter("subTypeId");
        employeeSubType.setId(Integer.parseInt(subTypeId));
        employeeTypeWiseSalary.setEmployeeSubType(employeeSubType);
        BindException errors = new BindException(employeeTypeWiseSalary,"employeeTypeWiseSalary");

        bind(request,employeeTypeWiseSalary);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        zydexLocationList(request);
        PayrollSalaryTypeList(request);
            
            
        employeeTypeWiseSalaryValidator.validate(employeeTypeWiseSalary, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Assign Salary is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeTypeWiseSalary", employeeTypeWiseSalary);
            mv.setViewName("Payroll/EmployeeTypeWiseSalaryEdit");
        } else {
            
             List<?> list = employeeMultipleSalaryService.readBytypeWiseSalary(employeeTypeWiseSalary.getId());
        for (Object o : list) { 
            EmployeeMultipleSalary employeeMultipleSalary = (EmployeeMultipleSalary) o;
            employeeMultipleSalaryService.delete(employeeMultipleSalary.getId());
        }
            for (String s : a) {
                EmployeeMultipleSalary employeeMultipleSalary = new EmployeeMultipleSalary();
                employeeMultipleSalary.setEmployeeTypeWiseSalary(employeeTypeWiseSalary);
                payrollSalaryType.setId(Integer.parseInt(s));
                employeeMultipleSalary.setPayrollSalaryType(payrollSalaryType);
                employeeMultipleSalaryService.create(employeeMultipleSalary);
            } 
            
            employeeTypeWiseSalaryService.update(employeeTypeWiseSalary);
              
            request.setAttribute("successMessage",
                    "Information: The Assign Salary is Updated successfully");
            mv = showResult(request, response);
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                
                employeeTypeWiseSalaryService.delete(Integer.parseInt(z));
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
        EmployeeTypeWiseSalary employeeTypeWiseSalary = new EmployeeTypeWiseSalary();
        String typeId = request.getParameter("typeId");
        String employeeId = request.getParameter("employeeId");

        String empSubTypeId = request.getParameter("empSubTypeId");

        if (null == employeeId) {
        } else {
            employeeTypeWiseSalary = employeeTypeWiseSalaryService.readById(Integer.parseInt(employeeId));
            request.setAttribute("employeeSubTypeId", employeeTypeWiseSalary.getEmployeeSubType().getId());
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
