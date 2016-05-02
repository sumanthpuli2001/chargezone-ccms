/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.MailMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.support.ForgotPwd;
import com.bul.zydex.model.support.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
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

    public ModelAndView forgotPassword(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ForgotPwd forgotPwdModel = new ForgotPwd();
        mv.getModelMap().put("forgotPwdModel", forgotPwdModel);
        mv.setViewName("User/ForgotPassword");
        return mv;
    }

    public ModelAndView forgotPasswordSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ForgotPwd forgotPwdModel = new ForgotPwd();
        BindException errors = new BindException(forgotPwdModel, "forgotPwdModel");
        bind(request, forgotPwdModel);
        ForgotPwdValidator.validate(forgotPwdModel, errors);

        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage", "Error : It is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
//            int level = forgotPwdModel.getLevel();
            String email1 = forgotPwdModel.getEmailL1();

//            if (1 == level) {
                EmployeeMaster employeeMaster = new EmployeeMaster();
                int empCode = 0;
                try {
                    empCode = Integer.parseInt(email1);
                } catch (Exception e) {

                }
                List<?> employeeMasterList = employeeMasterService.readByEmployeeNo(empCode);
                if (employeeMasterList.isEmpty()) {
                    request.setAttribute("faliureMessage",
                            "Error : The Employee Code is not exist.");
                } else {
                    employeeMaster = (EmployeeMaster) employeeMasterList.get(0);
                    UserMaster userMaster = new UserMaster();
                    userMaster.setUserName("" + employeeMaster.getEmployeeId());
                    List list = userMasterService.readByUserName(userMaster);
                    if (!list.isEmpty()) {
                        userMaster = (UserMaster) list.get(0);
                    }
                    String from = "admin@zydexindustries.com";
                    String to = employeeMaster.getOfficeEmailId();
                    String subject = "Account Detail";
                    String message = "" + "<html>" + "<body>"
                            + "<br/>Dear User,"
                            + "<br/>We have a account for you."
                            + "<br/><br/>Your account details are -"
                            + "<br/>Username - " + userMaster.getUserName()
                            + "<br/>Password - " + userMaster.getPassword()
                            + "<br/><br/>Thank you," + "<br/>" + "</body>"
                            + "</html>";
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

//                    mailMasterService.create(new MailMaster(from, to, subject,
//                            message, "", null));
                    try{
                        
                    mailMasterService.create(new MailMaster(from, to, subject, message, sdf.format(date), true));
                    sendMail.sendMail(from, to, subject, message);
                    request.setAttribute("successMessage",
                            "Information : The mail is sent on given email-id with username and password.");
                    }catch(Exception e){
                        request.setAttribute("faliureMessage",
                            "Information : Your Email Address Is Not Register");
                    }finally{
                        
                    }
                }
//            }
        }

        mv.getModelMap().put("forgotPwdModel", forgotPwdModel);
        mv.setViewName("User/ForgotPassword");
        return mv;
    }

    public ModelAndView redirectToSessionExp(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Common/SessionExpired");
        return mv;
    }
}
