/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

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
 * @author Administrator
 */
public class UserMasterController extends UserMasterAbstract {

    public ModelAndView goToHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        getRights(request, session, user);
        getCurrentIp(request, session);

//         EmployeeMaster em = employeeMasterService.read(user.getLoginName());
//        ContractorMaster cm = contractorService.read(user.getLoginName());
//        ApprenticesMaster am = apprenticesService.read(user.getLoginName());
//
//        if (em.getEmployeeCode() != null) {
//            session.setAttribute("valueOfAll", "1");
//            session.setAttribute("type", "E");
//        } else if (cm.getContractorCode() != null) {
//            session.setAttribute("valueOfAll", "1");
//            session.setAttribute("type", "C");
//        } else if (am.getApprenticeCode() != null) {
//            session.setAttribute("valueOfAll", "1");
//            session.setAttribute("type", "A");
//        } else {
//            session.setAttribute("valueOfAll", "0");
//        }
        // this will use 
        mv.setViewName("forward:homeController.htm?act=openHomePage");
        return mv;
    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster um = new UserMaster();
        List list = userMasterService.readByDrow();
        request.setAttribute("list", list);
        mv.getModelMap().put("userMaster", um);
        mv.setViewName("User/UserList");
        return mv;
    }

    public ModelAndView showBackupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster um = new UserMaster();
        List list = userMasterService.readByDrowDisable();
        request.setAttribute("list", list);
        mv.getModelMap().put("userMaster", um);
        mv.setViewName("User/UserDisableList");
        return mv;
    }

    public ModelAndView createUserMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster um = new UserMaster();
        readRights(request, response);
        mv.getModelMap().put("userMaster", um);
        mv.setViewName("User/CreateUser");
        return mv;
    }

    public ModelAndView submitUserMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster userMaster = new UserMaster();
        bind(request, userMaster);
        userMaster.setPassword(encription(userMaster.getPassword()));
        userMaster.setdRow("N");
        userMasterService.create(userMaster);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("User Created").setDrow("N");
        logService.create(lm);

        request.setAttribute("successMessage",
                "Information: User Created successfully");
        mv = showList(request, response);
        return mv;

    }

    public ModelAndView editUserMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster userMaster = new UserMaster();
        bind(request, userMaster);
        userMasterService.update(userMaster);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Edited User").setDrow("Y");
        logService.create(lm);

        request.setAttribute("successMessage",
                "Information: User Updated successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String loginname = request.getParameter("id");
        UserMaster userMaster = userMasterService.read(loginname);
        readRights(request, response);
        mv.getModelMap().put("userMaster", userMaster);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("View User").setDrow("Y");
        logService.create(lm);

        mv.setViewName("User/EditUser");
        return mv;
    }

    public ModelAndView passwordReset(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String loginname = request.getParameter("id");
        UserMaster userMaster = userMasterService.read(loginname);
        userMaster.setPassword("");
        mv.getModelMap().put("userMaster", userMaster);
        mv.setViewName("User/ForgotPassword");
        return mv;
    }

    public ModelAndView submitPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster userMaster = new UserMaster();
        bind(request, userMaster);
        userMaster.setPassword(encription(userMaster.getPassword()));
        userMasterService.update(userMaster);
        mv= showList(request, response);
        return mv;

    }

    public ModelAndView disableUserMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            UserMaster userMaster = userMasterService.read(checkedValues);
            userMaster.setdRow("Y");
            userMasterService.update(userMaster);
        }
        request.setAttribute("successMessage",
                "Information: One or more User deleted successfully");
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Deletd User ").setDrow("Y");
        logService.create(lm);
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView deleteUserMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String value = request.getParameter("delete");
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        if (value.equals("D")) {
            for (String checkedValues : checkId) {
                userMasterService.deleteByLoginName(checkedValues);
            }
            request.setAttribute("successMessage",
                    "Information: One or more User deleted successfully");
            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Deletd User permanent").setDrow("Y");
            logService.create(lm);
        } else if (value.equals("R")) {
            for (String checkedValues : checkId) {
                UserMaster userMaster = userMasterService.read(checkedValues);
                userMaster.setdRow("N");
                userMasterService.update(userMaster);
            }
            request.setAttribute("successMessage",
                    "Information: One or more User enabled successfully");
            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Enable User ").setDrow("Y");
            logService.create(lm);
        }

        mv = showBackupList(request, response);
        return mv;
    }

}
