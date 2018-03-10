/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.support.User;
import com.bul.zydex.util.ActionType;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        request.setAttribute("lockCounter", 0);
        mv.setViewName(LOGIN_PAGE);
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
        //remember me feature for next login using cookies
        // and remove that cookies when logs out and use this cookies on (User/Login.jsp).
        if (request.getParameter("rememberMe") != null) {
            setCookies(request, response);
        }

        mv = dashboard(request, response);

        log(request, ActionType.LOGIN.toString(),
                "The user is log in to system.");

        return mv;
    }

    public ModelAndView loginSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        int lockCounter = Integer.parseInt(request.getParameter("lockCounter"));

        UserMaster user = new UserMaster();
        BindException errors = new BindException(user, "userMaster");
        bind(request, user);
        loginValidator.validate(user, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : Username or Password is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("user", user);
            mv.setViewName("User/Login");
        } else {
            List<?> tempList = userMasterService.read(user);
            if (null == tempList || tempList.isEmpty()) {

                List<?> tempList2 = userMasterService.readByUserName(user);
                if (!tempList2.isEmpty()) {
                    lockCounter += 1;
                    request.setAttribute("lockCounter", lockCounter);
                    if (5 == lockCounter) {
                        UserMaster user2;
                        user2 = (UserMaster) tempList2.get(0);
                        user2.setBlockStatus(true);
                        userMasterService.update(user2);
                        request.setAttribute("faliureMessage",
                                "Error : Your account is locked as You have attemped five times.");
                    } else {
                        request.setAttribute("faliureMessage",
                                "Error : Username or Password is not valid or exist.");
                    }
                } else {
                    request.setAttribute("faliureMessage",
                            "Error : Username or Password is not valid or exist.");
                }
                mv.addAllObjects(errors.getModel());
                mv.getModelMap().put("user", user);
                mv.setViewName("User/Login");
            } else {
                UserMaster user3;
                user3 = (UserMaster) tempList.get(0);
                int userId = 0;
                boolean DateOfLeavingflag = false;
                userId = user3.getId();
                if (userId != 0) {
                    List list = employeeMasterService.readDateOfLeaving(userId);
                    if (!list.isEmpty()) {
                        if (!"".equals(list.get(0)) && null != list.get(0)) {
                            String date = (String) list.get(0);
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                            Date doldate = sdf.parse(date);
                            String today = sdf.format(new Date());
                            Date tDate = sdf.parse(today);
                            if (doldate.before(tDate)) {
                                DateOfLeavingflag = true;
                            }
                        }
                    }
                }
                if (user3.isBlockStatus()) {
                    request.setAttribute("faliureMessage",
                            "Error : Your account is locked.");
                    mv.addAllObjects(errors.getModel());
                    mv.getModelMap().put("user", user3);
                    mv.setViewName("User/Login");
                } else if (user3.isFirstTime()) {
                    request.setAttribute("userName",
                            user3.getUserName());
                    mv.setViewName("forward:out.html?act=changePwd");
                } else if (DateOfLeavingflag == true) {
                    request.setAttribute("faliureMessage",
                            "Error : Sorry,Your Account is Deactivated.");
                    mv.addAllObjects(errors.getModel());
                    mv.getModelMap().put("user", user3);
                    mv.setViewName("User/Login");
                } else {
                    request.setAttribute("user", user3);
                    mv = home(request, response);
                }
            }
        }
        request.setAttribute("lockCounter", lockCounter);
        return mv;
    }

    public ModelAndView newPwdSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        User userModel = new User();

        BindException errors = new BindException(userModel, "userModel");
        bind(request, userModel);
        userInitPwdValidator.validate(userModel, errors);
        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : There are some errors.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("userModel", userModel);
            mv.setViewName("User/UserInitPwdChange");
        } else {
            UserMaster user = new UserMaster();
            user.setUserName(userModel.getUsername());
            user.setPassword(userModel.getPassword());
            List<?> tempList = userMasterService.read(user);
            if (null == tempList || tempList.isEmpty()) {
                request.setAttribute("faliureMessage",
                        "Error : Current Username or Password is not valid.");
                mv.addAllObjects(errors.getModel());
                mv.getModelMap().put("userModel", userModel);
                mv.setViewName("User/UserInitPwdChange");
            } else {
                user = (UserMaster) tempList.get(0);
                user.setPassword(userModel.getNewPassword());
                user.setFirstTime(false);
                userMasterService.update(user);
                request.setAttribute("user", user);
                mv = home(request, response);
            }
        }
        return mv;
    }

}
