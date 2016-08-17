/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.UserMaster;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author
 */
public class DepartmentMasterController extends DepartmentMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, DepartmentMaster departmentMaster) throws Exception {
        if (departmentMaster.getId() != null) {
            departmentMaster = departmentMasterService.readById(departmentMaster.getId());
        }
        return new ModelAndView("Department/DepartmentCreate", "departmentMaster", departmentMaster);
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, DepartmentMaster departmentMaster) throws Exception {
        BindException errors = new BindException(departmentMaster, "departmentMaster");
        ModelAndView mv = new ModelAndView();
        bind(request, departmentMaster);
        departmentMasterValidator.validate(departmentMaster, errors);
        if (errors.hasErrors()) {
            mv.addObject("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Department/DepartmentCreate");
        } else {
            String abc = departmentMaster.getDepartmentName().replaceAll("'", "");
            departmentMaster.setDepartmentName(abc);

            if (departmentMasterService.isExist(departmentMaster)) {
                departmentMasterService.createOrUpdate(departmentMaster);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                List<?> departmentList = departmentMasterService.read();
                mv.addObject("departmentList", departmentList);
                mv.setViewName("Department/DepartmentList");
            } else {
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
                mv.setViewName("Department/DepartmentCreate");
            }
        }
        mv.getModelMap().put("departmentMaster", departmentMaster);
        return mv;
    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, DepartmentMaster departmentMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> departmentList = departmentMasterService.read();
        mv.addObject("departmentList", departmentList);
        mv.setViewName("Department/DepartmentList");
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, DepartmentMaster departmentMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                departmentMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    departmentMaster = departmentMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += departmentMaster.getDepartmentName();
                    } else {
                        checkStr += "," + departmentMaster.getDepartmentName();
                    }
                    count++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            mv.addObject("failureMessage", "Error : In Use, Can't Be Deleted.....  " + "<b>" + checkStr + "</b>");
        } else {
            mv.addObject("successMessage", "Information Is Deleted Successfully.");
        }
        List<?> departmentList = departmentMasterService.read();
        mv.addObject("departmentList", departmentList);
        mv.setViewName("Department/DepartmentList");
        return mv;
    }

//this method is for display department wise employee on Hr Deshboard
    public ModelAndView hrDashboard(HttpServletRequest request, HttpServletResponse response, DepartmentMaster departmentMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> departmentWiseEmpCountList = departmentMasterService.countEmpByDepartmentList();
        if (!departmentWiseEmpCountList.isEmpty()) {

            try {
                mv.addObject("departmentWiseEmp", iterateList(departmentWiseEmpCountList));
            } catch (Exception e) {
            }
        }
        mv.setViewName("forward:employeeMaster.htm?act=hrDashboard");
        return mv;
    }

    public String iterateList(List list) {
        StringBuilder sb = new StringBuilder();
        for (Object objList : list) {
            Object[] asd = (Object[]) objList;
            sb.append("['").append(asd[0]).append("',").append(asd[1]).append("],");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

//this method is for display department wise employee Resignation on Hr Deshboard
    public ModelAndView hrDashboardResignation(HttpServletRequest request, HttpServletResponse response, DepartmentMaster departmentMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> resignedEmpOfDeptList = departmentMasterService.countResignedEmpOfDept();
        if (!resignedEmpOfDeptList.isEmpty()) {
            try {
                mv.addObject("departmentWiseResignedEmployee", iterateList(resignedEmpOfDeptList));
            } catch (Exception e) {
            }
        }
        mv.setViewName("forward:expenseMaster.htm?act=hrDashboard");
        return mv;
    }
}
