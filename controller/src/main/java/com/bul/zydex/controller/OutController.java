/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.support.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import com.bul.zydex.model.VendorInvitation;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.model.VendorInfo;
import com.bul.zydex.util.SendMail;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;

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

    public ModelAndView out(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        User userModel = new User();
        mv.getModelMap().put("userModel", userModel);

        UserMaster user = new UserMaster();
        request.setAttribute("userMaster", user);
        HttpSession session = request.getSession(false);
        //    request.setAttribute("loginName", "");
        //    request.setAttribute("password", "");
        if (session != null) {

            Object success = session.getAttribute("successMessage");
            Object failure = session.getAttribute("failureMessage");

            if (success != null) {
                mv.addObject("successMessage", success);
                session.removeAttribute("successMessage");
            }

            if (failure != null) {
                mv.addObject("failureMessage", failure);
                session.removeAttribute("failureMessage");
            }
        }
        mv.setViewName("User/ForgotPass");
        return mv;
    }

    public ModelAndView forgotuser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        User userModel = new User();
        mv.getModelMap().put("userModel", userModel);

        UserMaster user = new UserMaster();
        request.setAttribute("userMaster", user);
        mv.setViewName("User/ForgotUser");
        return mv;
    }

    public ModelAndView unlockuser(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        User userModel = new User();
        mv.getModelMap().put("userModel", userModel);

        UserMaster user = new UserMaster();
        request.setAttribute("userMaster", user);
        mv.setViewName("User/UnlockUser");
        return mv;
    }

    public ModelAndView contactus(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        User userModel = new User();
        mv.getModelMap().put("userModel", userModel);

        UserMaster user = new UserMaster();
        request.setAttribute("userMaster", user);
        mv.setViewName("User/contactus");
        return mv;
    }

//    public ModelAndView checkPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        String loginname = request.getParameter("loginName");
//        String emailid = request.getParameter("emailId");
//        String mobileNo = request.getParameter("mobileNo");
//        
//        UserMaster userMaster = userMasterService.read(loginname);
//        int usertype = userMaster.getUserType();
//        
//        String email = "";
//        String mobile="";
//        
//        if(usertype == 0)
//        {
//            EmployeeMaster employeeMaster = employeeMasterService.read(loginname);
//            email = employeeMaster.getEmailId();
//            mobile = employeeMaster.getMobileNo();
//        }
//        else
//        {
//            VendorMaster vendorMaster = vendorMasterService.read(loginname);
//            email = vendorMaster.getVendorEmailID();
//            mobile = vendorMaster.getVendorMobNo();
//        }
//        
//        String password = userMaster.getPassword();
//        
//        if(email.contains(emailid))
//        {
//            String[] email1 = email.split(",");
//            for (int j=0; j < email1.length; j++)
//            {
//                String mail_from="samir@bulwarks.com";
//                String mail_to=email1[j];
//                String subject = "Password";
//                String msg="Dear Sir,<br> Your Password : "+password+"";
//                SendMail s = new SendMail();
//                s.sendMail(mail_from, mail_to, subject, msg);
//            }
//             request.setAttribute("successMessage",
//                "Information: Password Send to your email ID");
//        }else{
//             request.setAttribute("faliureMessage",
//                "Information: Please Provide proper email or username");
//        }
//        
//       
//        
//        User userModel = new User();
//        mv.getModelMap().put("userModel", userModel);
//        
//        UserMaster user = new UserMaster();
//        request.setAttribute("userMaster", user);
//        
//        mv.setViewName("forward:logIn.html?act=firstStep");
//        //mv.setViewName("User/ForgotPass");
//        return mv;
//    }
    public ModelAndView checkPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String loginname = request.getParameter("loginName");
        String emailid = request.getParameter("emailId");

        UserMaster userMaster = userMasterService.read(loginname);

        if (userMaster == null) {
            session.setAttribute("failureMessage", "Invalid username.");
            mv.setViewName("forward:out.html?act=out");
            return mv;
        }

        int usertype = userMaster.getUserType();

        String email = "";
        String mobile = "";

        if (usertype == 0) {

            EmployeeMaster employeeMaster = employeeMasterService.read(loginname);

            email = employeeMaster.getEmailId();
            mobile = employeeMaster.getMobileNo();

        } else {

            VendorMaster vendorMaster = vendorMasterService.read(loginname);

            email = vendorMaster.getVendorEmailID();
            mobile = vendorMaster.getVendorMobNo();
        }

        String password = userMaster.getPassword();

        if (email != null && email.contains(emailid)) {

            String[] emails = email.split(",");

            for (String mail_to : emails) {

                String mail_from = "samir@bulwarks.com";
                String subject = "Password";
                String msg = "Dear Sir,<br><br>Your Password : <b>" + password + "</b>";

                SendMail s = new SendMail();
                s.sendMail(mail_from, mail_to.trim(), subject, msg);
            }

            String maskedEmail = maskEmail(emailid);

            session.setAttribute("successMessage",
                    "A password has been sent successfully to " + maskedEmail + ". Please check your email.");

        } else {

            session.setAttribute("failureMessage",
                    "Please provide the correct username or email address.");
        }

        User userModel = new User();
        mv.addObject("userModel", userModel);

        session.setAttribute("userMaster", new UserMaster());

        // Forward to out page
        mv.setViewName("redirect:out.html?act=out");

        return mv;
    }

    private String maskEmail(String email) {

        if (email == null || !email.contains("@")) {
            return email;
        }

        String[] parts = email.split("@");

        String username = parts[0];
        String domain = parts[1];

        String maskedUsername;

        if (username.length() <= 3) {
            maskedUsername = username.substring(0, 1) + "***";
        } else {
            maskedUsername = username.substring(0, 3) + "***";
        }

        return maskedUsername + "@" + domain;
    }

    public ModelAndView checkUsername(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String loginname = request.getParameter("loginName");
        String emailid = request.getParameter("emailId");
        String mobileNo = request.getParameter("mobileNo");

        // Retrive User details from employee master
        String email = "";
        String mobile = "";

        List list = employeeMasterService.readByEmailMobile(emailid, mobileNo);
        int i = 0;
        if (list.isEmpty()) {
            List list1 = vendorMasterService.readByEmailMobile(emailid, mobileNo);
            if (list1.isEmpty()) {

                request.setAttribute("successMessage",
                        "Information: Password Send to your email ID");

            } else {
                i = 1;
                for (Object o : list1) {
                    VendorMaster em = (VendorMaster) o;
                    loginname = em.getVendorRegNo();
                    email = em.getVendorEmailID();
                    mobile = em.getVendorMobNo();
                }
            }
        } else {
            i = 1;
            for (Object o : list) {
                EmployeeMaster em = (EmployeeMaster) o;
                loginname = em.getEmployeeCode();
                email = em.getEmailId();
                mobile = em.getMobileNo();
            }

        }

        // Retrive User details from vendor master
        // Retrive User details from user master
        if (i == 1) {
            UserMaster userMaster = userMasterService.read(loginname);
            int usertype = userMaster.getUserType();

            String password = userMaster.getPassword();

            String[] email1 = email.split(",");
            for (int j = 0; j < email1.length; j++) {
                String mail_from = "samir@bulwarks.com";
                String mail_to = email1[j];
                String subject = "Your user details";
                String msg = "Dear Sir,<br> Your Username : " + loginname + " <br> Your Password : " + password + "";
                SendMail s = new SendMail();
                s.sendMail(mail_from, mail_to, subject, msg);
            }

            request.setAttribute("successMessage",
                    "Information: User Details Send to your email ID");
        }
        User userModel = new User();
        mv.getModelMap().put("userModel", userModel);

        UserMaster user = new UserMaster();
        request.setAttribute("userMaster", user);

        mv.setViewName("User/ForgotUser");
        return mv;
    }

    public ModelAndView submitUnlockUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String loginname = request.getParameter("loginName");

        UserMaster userMaster = userMasterService.read(loginname);
        int usertype = userMaster.getUserType();

        String email = "";
        String mobile = "";

        if (usertype == 0) {
            EmployeeMaster employeeMaster = employeeMasterService.read(loginname);
            email = employeeMaster.getEmailId();
            mobile = employeeMaster.getMobileNo();
        } else {
            VendorMaster vendorMaster = vendorMasterService.read(loginname);
            email = vendorMaster.getVendorEmailID();
            mobile = vendorMaster.getVendorMobNo();
        }

        String password = "";

        //Generate password
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        password = sb.toString();

        userMasterService.unlockuser(loginname, password);

        String[] email1 = email.split(",");
        for (int j = 0; j < email1.length; j++) {
            String mail_from = "samir@bulwarks.com";
            String mail_to = email1[j];
            String subject = "Password";
            String msg = "Dear Sir,<br> Your Password : " + password + "";
            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
        }

        request.setAttribute("successMessage",
                "Information: Password Send to your email ID");

        User userModel = new User();
        mv.getModelMap().put("userModel", userModel);

        UserMaster user = new UserMaster();
        request.setAttribute("userMaster", user);

        mv.setViewName("User/UnlockUser");
        return mv;
    }

    public ModelAndView vendorpolicy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Code = request.getParameter("id");

        VendorInvitation vendorInvitation1 = vendorInvitationService.readCode(Code);

        Code = vendorInvitation1.getVendorEmailId();

        VendorInformation vendorInformation5 = vendorInformationService.readEmailId(Code);
        int status = 0;
        status = vendorInformation5.getStatus1();

        if (status != 0) {
            mv.setViewName("Vendor/VendorFinalInformation");
            return mv;
        }

        String date1 = vendorInvitation1.getLinkExpireDateTime();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        d1 = format.parse(date1);
        d2 = format.parse(formattedDate);

        //in milliseconds
        long diff = d2.getTime() - d1.getTime();

        if (diff < 0 || diff > 0) {

            //    Code = "samir@bulwarks.com";
            VendorInvitation vendorInvitation = vendorInvitationService.readEmailId(Code);
            mv.getModelMap().put("vendorInvitation", vendorInvitation);

            VendorInformation vendorInformation3 = vendorInformationService.readEmailId(Code);
            int status1 = 0;
            status1 = vendorInformation3.getStatus1();

            //mv.getModelMap().put("vendorInvitation", vendorInvitation);
            mv.setViewName("Vendor/VendorPolicy");
            return mv;

        } else {
            mv.setViewName("Vendor/VendorInfo");
            return mv;

        }

    }

    public ModelAndView vendorRegistrationValidation(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        User userModel = new User();
        mv.getModelMap().put("userModel", userModel);

        UserMaster user = new UserMaster();
        request.setAttribute("userMaster", user);
        mv.setViewName("Vendor/VendorRegistrationValidation");
        return mv;
    }

    public ModelAndView redirectToSessionExp(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Common/SessionExpired");
        return mv;
    }

}
