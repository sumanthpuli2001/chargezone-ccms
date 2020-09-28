/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.UserMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class LogInController extends LogInAbstract {

    public ModelAndView firstStep(HttpServletRequest request,
                HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv = loginClick(request, response);
//        mv.setViewName("Common/BrowserDetail");
        return mv;
    }

    public ModelAndView browserDetail(HttpServletRequest request,
                HttpServletResponse response) throws Exception {
        ModelAndView mv = loginClick(request, response);
        return mv;
    }

    public ModelAndView loginClick(HttpServletRequest request,
                HttpServletResponse response) throws Exception {
        ModelAndView mv;
        HttpSession session = request.getSession(false);
        if (null == session) {
            mv = redirectToLogin(request, response);
        } else {
            mv = dashboard(request, response);
        }
        return mv;
    }

    private ModelAndView redirectToLogin(HttpServletRequest request,
                HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        UserMaster user = new UserMaster();
        mv.getModelMap().put("userMaster", user);
//        request.setAttribute("lockCounter", 0);
        mv.setViewName(LOGIN_PAGE);
//         mv.setViewName("User/Login");
        return mv;
    }

    public ModelAndView dashboard(HttpServletRequest request,
                HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        if (null == user) {
            mv = redirectToLogin(request, response);
        } else {
            addUser(request, user);
//            mv.setViewName("forward:userMaster.htm?act=goToDashboard");
            mv.setViewName("forward:userMaster.htm?act=goToHomePage");
        }
        return mv;
    }

    public ModelAndView home(HttpServletRequest request,
                HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        ModelAndView mv;
        if (null != session) {
            session.invalidate();
        }
        session = request.getSession(true);
        UserMaster user = (UserMaster) request.getAttribute("user");
        session.setAttribute("user", user);
//        if (request.getParameter("rememberMe") != null) {
//            setCookies(request, response);
//        }
        mv = dashboard(request, response);

//        log(request, ActionType.LOGIN.toString(),
//                "The user is log in to system.");
        return mv;
    }

    public ModelAndView loginSubmit(HttpServletRequest request,
                HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster user = new UserMaster();
        BindException errors = new BindException(user, "userMaster");
        bind(request, user);
        user.setPassword(encription(user.getPassword()));
        UserMaster user3;
        if (user.getLoginName().equals("") & user.getPassword().equals("")) {
            request.setAttribute("faliureMessage",
                        "Username or Password is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("user", user);
            mv = redirectToLogin(request, response);
        } else {
            List<?> tempList = userMasterService.read(user);

            if (null == tempList || tempList.isEmpty()) {
                request.setAttribute("faliureMessage",
                            "Error : Username or Password is not valid or exist.");
                mv = redirectToLogin(request, response);
            } else {
                user3 = (UserMaster) tempList.get(0);
                request.setAttribute("user", user3);
                mv = home(request, response);
            }
        }
        return mv;
    }

}
