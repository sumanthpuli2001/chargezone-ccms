/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public abstract class LogOutAbstract extends CustomAbstract {

    protected static final Logger logger = Logger
            .getLogger(LogOutAbstract.class);

    protected void setInOut(HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession(false);
        String userLoginLogStart = (String) session
                .getAttribute("userLoginLogStart");
        String userLoginLogEnd = (String) session
                .getAttribute("userLoginLogEnd");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date loginStartDate = sdf.parse(userLoginLogStart);
        Date loginEndDate = sdf.parse(userLoginLogEnd);
        long diff = loginEndDate.getTime() - loginStartDate.getTime();
        long diffMinutes = diff / (60 * 1000);
        int minute = (int) (diffMinutes % 60);
        int hour = (int) (diffMinutes / 60);
//         long diffHours = diff / (60 * 60 * 1000) % 24;
        request.setAttribute("userLoginLogStart", userLoginLogStart);
        request.setAttribute("userLoginLogEnd", userLoginLogEnd);
        request.setAttribute("Logindurationmin", diffMinutes);
        session.invalidate();
    }

    protected void invalidateCookies(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie userNameCookie = new Cookie("userNameCookie", "");
        Cookie passwordCookie = new Cookie("passwordCookie", "");
        Cookie rememberMeCookie = new Cookie("rememberMeCookie", "");
        userNameCookie.setMaxAge(0);//15 days
        passwordCookie.setMaxAge(0);
        passwordCookie.setMaxAge(0);
        response.addCookie(userNameCookie);
        response.addCookie(passwordCookie);
        response.addCookie(passwordCookie);
    }
}
