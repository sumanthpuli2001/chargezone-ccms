/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

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
public class EmployeeTypeController extends EmployeeTypeAbstract {

    public ModelAndView showResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<?> list1 = employeeTypeService.read();
        request.setAttribute("list", list1);
        mv.setViewName("Employee/EmployeeTypeShow");

        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.setViewName("Employee/EmployeeTypeCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        BindException errors = new BindException(employeeTypeMaster, "employeeTypeMaster");
        bind(request, employeeTypeMaster);
        employeeTypeValidator.validate(employeeTypeMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
            mv.setViewName("Employee/EmployeeTypeCreate");

        } else {if (!employeeTypeService.isExist(employeeTypeMaster)) {
            employeeTypeService.create(employeeTypeMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showResult(request, response);

        }
        else {
                request.setAttribute("failureMessage",
                        "Error : The Employee Type  is already there.");
                mv.setViewName("Employee/EmployeeTypeCreate");
                 mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
            }
        
//        return mv;
    }
        return mv;
    }

//    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
//        String id = request.getParameter("id");
//        employeeTypeMaster = employeeTypeService.readById(Integer.parseInt(id));
//        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
//        mv.setViewName("Employee/EmployeeTypeEdit");
//        return mv;
//    }

//    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
//        BindException errors = new BindException(employeeTypeMaster, "employeeTypeMaster");
////        payrollSavingType.setId(Integer.parseInt(request.getParameter("id")));
//        bind(request, employeeTypeMaster);
//        employeeTypeValidator.validate(employeeTypeMaster, errors);
//        if (errors.hasErrors()) {
//            request.setAttribute("failureMessage",
//                    "Error : The Entered Information is not valid.");
//            mv = viewClick(request, response);
//        } else {if (!employeeTypeService.isExist(employeeTypeMaster)) {
//            employeeTypeService.update(employeeTypeMaster);
//            request.setAttribute("successMessage",
//                    "Information : The Information is Updated Successfully.");
//            mv = showResult(request, response);
//        }
//            else {
//                request.setAttribute("failureMessage",
//                        "Error : The EmployeeType is already there.");
//                mv.setViewName("Employee/EmployeeTypeEdit");
//                 mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
//            }
//        
////        return mv;
//    }
//        return mv;
//    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                employeeTypeService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showResult(request, response);
        return mv;
    }

}
