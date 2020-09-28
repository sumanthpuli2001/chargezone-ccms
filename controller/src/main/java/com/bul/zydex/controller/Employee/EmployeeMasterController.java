/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Employee;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class EmployeeMasterController extends EmployeeMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List list = employeeMasterService.readByDrow();
        request.setAttribute("list", list);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeListList");
        return mv;
    }

    public ModelAndView showBackupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List list = employeeMasterService.readByDrowDisable();
        request.setAttribute("list", list);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeDisableList");
        return mv;
    }

    public ModelAndView createEmployeeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        readRights(request, response);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeCreate");
        return mv;
    }

    public ModelAndView submitEmployeeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        bind(request, employeeMaster);
        String emailId = request.getParameter("emailId");
        String issueDept = request.getParameter("issueDept");
        String issueGuest = request.getParameter("issueGuest");
        Boolean rfId = employeeMasterService.readByRifId(employeeMaster.getEmployeeCode().length() == 5 ? "001" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 4 ? "0010" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 3 ? "00100" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 2 ? "001000" + employeeMaster.getEmployeeCode() : "0010000" + employeeMaster.getEmployeeCode());
        if (!rfId) {
            employeeMaster.setRfId("" + (employeeMaster.getEmployeeCode().length() == 5 ? "001" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 4 ? "0010" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 3 ? "00100" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 2 ? "001000" + employeeMaster.getEmployeeCode() : "0010000" + employeeMaster.getEmployeeCode())).setdRow("N");
            if (issueDept.equals("Yes")) {
                employeeMaster.setRfIdDept("" + (employeeMaster.getEmployeeCode().length() == 5 ? "002" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 4 ? "0020" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 3 ? "00200" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 2 ? "002000" + employeeMaster.getEmployeeCode() : "0020000" + employeeMaster.getEmployeeCode()));
            }
            if (issueGuest.equals("Yes")) {
                employeeMaster.setRfIdGuest("" + (employeeMaster.getEmployeeCode().length() == 5 ? "004" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 4 ? "0040" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 3 ? "00400" + employeeMaster.getEmployeeCode() : employeeMaster.getEmployeeCode().length() == 2 ? "004000" + employeeMaster.getEmployeeCode() : "0040000" + employeeMaster.getEmployeeCode()));
            }
            employeeMasterService.create(employeeMaster);
            UserMaster um = new UserMaster();
            um.setLoginName(employeeMaster.getEmployeeCode()).setPassword(encription(employeeMaster.getEmployeeCode())).setUserFullName(employeeMaster.getName()).setRights(employeeMaster.getRightsName()).setDepartment(employeeMaster.getDepartment()).setDesignation(employeeMaster.getDesignation()).setEmailId(emailId).setdRow("N");
            userMasterService.create(um);
            //------for Log entry---------
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee Created").setDrow("Y");
            logService.create(lm);

            request.setAttribute("successMessage",
                    "Information: Employee Created successfully");
        } else {
            request.setAttribute("failureMessage",
                    "Information: Employee code duplicated found.");
            request.setAttribute("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeCreate");
        }
        mv = showList(request, response);
        return mv;

    }

    public ModelAndView editEmployeeMasterSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        bind(request, employeeMaster);
        employeeMasterService.update(employeeMaster);
        UserMaster um = userMasterService.read(employeeMaster.getEmployeeCode());
        um.setLoginName(employeeMaster.getEmployeeCode()).setPassword(encription(employeeMaster.getEmployeeCode())).setUserFullName(employeeMaster.getName()).setRights(employeeMaster.getRightsName()).setDepartment(employeeMaster.getDepartment()).setDesignation(employeeMaster.getDesignation()).setdRow("N");
        userMasterService.update(um);
        request.setAttribute("successMessage",
                "Information: Employee Updated successfully");
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee edited").setDrow("Y");
        logService.create(lm);
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empCode = request.getParameter("id");
        EmployeeMaster employeeMaster = employeeMasterService.read(empCode);
        readRights(request, response);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee view").setDrow("Y");
        logService.create(lm);
        mv.setViewName("Employee/EmployeeEdit");
        return mv;
    }

    public ModelAndView disableEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            EmployeeMaster employeeMaster = employeeMasterService.read(checkedValues);
            employeeMaster.setdRow("Y");
            employeeMasterService.update(employeeMaster);
            UserMaster um = userMasterService.read(employeeMaster.getEmployeeCode());
            um.setdRow("Y");
            userMasterService.update(um);
//            employeeMasterService.deleteByEmpCode(checkedValues);
//            userMasterService.deleteByLoginName(checkedValues);
        }
        request.setAttribute("successMessage",
                "Information: One or more Employee deleted successfully");

        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee Deleted").setDrow("Y");
        logService.create(lm);

        mv = showList(request, response);
        return mv;
    }

    public ModelAndView deleteEmployeeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String value = request.getParameter("delete");
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        if (value.equals("D")) {
            for (String checkedValues : checkId) {
                employeeMasterService.deleteByEmpCode(checkedValues);
                userMasterService.deleteByLoginName(checkedValues);
            }
            request.setAttribute("successMessage",
                    "Information: One or more Employee deleted successfully");

            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee Deleted permanent").setDrow("Y");
            logService.create(lm);
        } else if (value.equals("R")) {
            for (String checkedValues : checkId) {
                EmployeeMaster employeeMaster = employeeMasterService.read(checkedValues);
                employeeMaster.setdRow("N");
                employeeMasterService.update(employeeMaster);
                UserMaster um = userMasterService.read(employeeMaster.getEmployeeCode());
                um.setdRow("N");
                userMasterService.update(um);
            }
            request.setAttribute("successMessage",
                    "Information: One or more Employee deleted successfully");
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee enable").setDrow("Y");
            logService.create(lm);
        }

        mv = showBackupList(request, response);
        return mv;
    }

}
