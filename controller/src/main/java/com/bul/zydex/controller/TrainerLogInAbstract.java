/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.Training.TrainerService;
import java.io.File;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.validation.Validator;

/**
 *
 * @author DELL3
 */
public abstract class TrainerLogInAbstract extends CustomAbstract{
    
    protected TrainerService<Trainer> trainerService;

    public TrainerService<Trainer> getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService<Trainer> trainerService) {
        this.trainerService = trainerService;
    }

//    public Validator getForgotPwdValidator() {
//        return forgotPwdValidator;
//    }
//
//    public void setForgotPwdValidator(Validator forgotPwdValidator) {
//        this.forgotPwdValidator = forgotPwdValidator;
//    }
//    protected static final Logger logger = Logger
//            .getLogger(LogInAbstract.class);
//    protected Validator loginValidator;
//    protected Validator userInitPwdValidator;
//    protected Validator forgotPwdValidator;
//    protected static final String PATH = "User" + File.separator;
//    protected static final String LOGIN_PAGE = PATH + "Login";
//
//    public Validator getLoginValidator() {
//        return loginValidator;
//    }
//
//    public void setLoginValidator(Validator loginValidator) {
//        this.loginValidator = loginValidator;
//    }
//
//    public Validator getUserInitPwdValidator() {
//        return userInitPwdValidator;
//    }
//
//    public void setUserInitPwdValidator(Validator userInitPwdValidator) {
//        this.userInitPwdValidator = userInitPwdValidator;
//    }
//
//    protected void addUser(HttpServletRequest request, UserMaster user) {
//        HttpSession session = request.getSession();
//        session.setAttribute("user", userMasterService.readById(user.getId()));
//    }
//
//    protected void setCookies(HttpServletRequest request, HttpServletResponse response)throws Exception {
//
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String rememberMe = request.getParameter("rememberMe");
//        System.out.println("rememberMe : " + rememberMe);
//        Cookie userNameCookie = new Cookie("userNameCookie", userName.trim());
//        Cookie passwordCookie = new Cookie("passwordCookie", password.trim());
//        Cookie rememberMeCookie = new Cookie("rememberMeCookie", rememberMe.trim());
//        userNameCookie.setMaxAge(60 * 60 * 24 * 15);//15 days
//        passwordCookie.setMaxAge(60 * 60 * 24 * 15);
//        rememberMeCookie.setMaxAge(60 * 60 * 24 * 15);
//        response.addCookie(userNameCookie);
//        response.addCookie(passwordCookie);
//        response.addCookie(rememberMeCookie);
//         //        HttpSession session = request.getSession();
//        //        session.setAttribute("user", userMasterService.readById(user.getId()));
//    }
}
