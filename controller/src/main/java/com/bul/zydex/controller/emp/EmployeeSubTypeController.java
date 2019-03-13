/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishant
 */
public class EmployeeSubTypeController extends EmployeeSubTypeAbstract {

    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();

        List<?> list = employeeSubTypeService.read();

        for (Object obj : list) {
            employeeSubType = (EmployeeSubType) obj;

            employeeTypeMaster = employeeTypeService.readById(employeeSubType.getEmployeeTypeMaster().getId());

            employeeSubType.setEmployeeTypeMaster(employeeTypeMaster);
        }
        request.setAttribute("list", list);
        mv.setViewName("Employee/EmployeeSubTypeshow");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        EmployeeTypeList(request);
        employeeSubType.setEmployeeTypeMaster(new EmployeeTypeMaster());
        mv.getModelMap().put("employeeSubType", employeeSubType);
        mv.setViewName("Employee/EmployeeSubTypeCreate");
        return mv;

    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        BindException errors = new BindException(employeeSubType, "employeeSubType");
        bind(request, employeeSubType);
        String formatvalue = employeeSubType.getSubType();
        employeeSubType.setSubType(formatvalue.trim());
        EmployeeTypeList(request);
        
        employeeSubTypeValidator.validate(employeeSubType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeSubType", employeeSubType);
            mv.setViewName("Employee/EmployeeSubTypeCreate");

        } else {if (!employeeSubTypeService.isExist(employeeSubType)) {
            employeeSubTypeService.create(employeeSubType);

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }
         else {
                request.setAttribute("failureMessage",
                        "Error : The Employee SubType  is already there.");
                mv.setViewName("Employee/EmployeeSubTypeCreate");
                 mv.getModelMap().put("employeeSubType", employeeSubType);
            }
        
//        return mv;
    }
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        String id = request.getParameter("id");
        EmployeeTypeList(request);
        employeeSubType = employeeSubTypeService.readById(Integer.parseInt(id));
        employeeTypeMaster = employeeTypeService.readById(employeeSubType.getEmployeeTypeMaster().getId());
        employeeSubType.setEmployeeTypeMaster(employeeTypeMaster);
        mv.getModelMap().put("employeeSubType", employeeSubType);
        mv.setViewName("Employee/EmployeeSubTypeEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        BindException errors = new BindException(employeeSubType, "employeeSubType");
        bind(request, employeeSubType);
        EmployeeTypeList(request);
        employeeSubTypeValidator.validate(employeeSubType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The Employee SubType is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeSubType", employeeSubType);
            mv.setViewName("Employee/EmployeeSubTypeEdit");
        } else {
            employeeSubTypeService.update(employeeSubType);

            request.setAttribute("successMessage",
                    "Information: The Employee SubType is Updated successfully");
            mv = showResult(request, response);
        }
         
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                employeeSubTypeService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }

}
