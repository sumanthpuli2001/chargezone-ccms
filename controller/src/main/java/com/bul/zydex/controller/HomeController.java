/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
public class HomeController extends HomeAbstract {

    public ModelAndView openHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();

        DepartmentMaster departmentMaster = new DepartmentMaster();
        LevelMaster levelMaster = new LevelMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LocationMaster locationMaster = new LocationMaster();
        employeeMaster.setUserMaster(user);

        List<?> employeeList = employeeMasterService.readByUserName(employeeMaster);
        if (!employeeList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) employeeList.get(0);
            departmentMaster = departmentMasterService.readById(employeeMaster1.getDepartmentMaster().getId());
            employeeMaster1.setDepartmentMaster(departmentMaster);
            levelMaster = levelMasterService.readById(employeeMaster1.getLevelMaster().getId());
            employeeMaster1.setLevelMaster(levelMaster);
            designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
            employeeMaster1.setDesignationMaster(designationMaster);
            locationMaster = locationMasterService.readById(employeeMaster1.getLocationMaster().getId());
            employeeMaster1.setLocationMaster(locationMaster);

        }

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String CurrentDate = sdf.format(d);
        List<?> TodaysBirthdays = employeeMasterService.readEmployeeByBirthday(CurrentDate);
        request.setAttribute("employeeMaster", employeeMaster1);
        request.setAttribute("TodaysBirthdays", TodaysBirthdays);
        mv.setViewName("Common/Home");
        return mv;
    }
}
