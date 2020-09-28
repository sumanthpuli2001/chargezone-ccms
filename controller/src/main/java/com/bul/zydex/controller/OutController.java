/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.support.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class OutController extends OutAbstract {

    public ModelAndView changePwd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        User userModel = new User();
        mv.getModelMap().put("userModel", userModel);
        mv.setViewName("User/UserInitPwdChange");
        return mv;
    }


    public ModelAndView redirectToSessionExp(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Common/SessionExpired");
        return mv;
    }

}
