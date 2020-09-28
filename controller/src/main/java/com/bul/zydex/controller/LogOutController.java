/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class LogOutController extends LogOutAbstract {

    private static final Logger logger = Logger
            .getLogger(LogOutController.class);

    public ModelAndView checkSession(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag = Boolean.parseBoolean(request.getParameter("flag"));
        if (!flag) {
            HttpSession session = request.getSession();
            session.invalidate();
        }
        return null;
    }

    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        try {
//            log(request, ActionType.LOGOUT.toString(),
//                    "The user is log out of system.");
//            setInOut(request);
            //------for Log entry---------
            UserMaster user = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Logout").setDrow("Y");
            logService.create(lm);

            session.invalidate();
            request.setAttribute("successMessage",
                    "Logout Successfully");
            mv.setViewName("forward:logIn.html?act=loginClick");
//            mv.setViewName("User/Logout");
        } catch (Exception e) {

        }

//        invalidateCookies(request, response); 
        return mv;
    }

    public ModelAndView sessionExp(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        session.invalidate();
        mv.setViewName("Common/SessionExpired");
        return mv;
    }
}
