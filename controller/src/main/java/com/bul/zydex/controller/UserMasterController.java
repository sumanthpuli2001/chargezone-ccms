/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import static com.bul.zydex.controller.CustomAbstract.dateFormat;
import static com.bul.zydex.controller.CustomAbstract.myIp;
import static com.bul.zydex.controller.CustomAbstract.timeFOrmat;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.model.VendorInvitation;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.util.SendMail;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

        List list = userRightsService.readByUserRight(user.getLoginName());
        if (!list.isEmpty()) {
            session.setAttribute("userRights", list.get(0));
        }

        //      addUserRight(request, user);
        //    getRights(request, session, user);
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
        if (!list.isEmpty()) {
            UserRights rights = (UserRights) list.get(0);
            String PR_REDIRECT_NO = (String) request.getAttribute("PR_REDIRECT_NO");

            if (PR_REDIRECT_NO == null) {
                PR_REDIRECT_NO = request.getParameter("PR_REDIRECT_NO");
            }

            if (PR_REDIRECT_NO != null
                    && !PR_REDIRECT_NO.trim().isEmpty()
                    && rights.getOmsCreator() == 1) {
                mv.setViewName("forward:prMaster.htm?act=searchViewForOms&id=" + PR_REDIRECT_NO);
                return mv;
            }
        }
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

    public ModelAndView passwordChange(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");

        String username = user.getLoginName();
        //     UserMaster um = new UserMaster();
        //    List list = userMasterService.readByDrow();
        //    request.setAttribute("list", list);
        //mv.getModelMap().put("userMaster", um);
        UserMaster userMaster = userMasterService.read(username);
        userMaster.setPassword("");
        mv.getModelMap().put("userMaster", userMaster);
        mv.setViewName("User/PasswardChange");
        return mv;
    }

    public ModelAndView passwordChangeA(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");

        String username = user.getLoginName();
        //     UserMaster um = new UserMaster();
        //    List list = userMasterService.readByDrow();
        //    request.setAttribute("list", list);
        //mv.getModelMap().put("userMaster", um);
        UserMaster userMaster = userMasterService.read(username);
        userMaster.setPassword("");
        mv.getModelMap().put("userMaster", userMaster);
        mv.setViewName("User/PasswordChangeA");
        return mv;
    }

    public ModelAndView passwordChangeV(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");

        String username = user.getLoginName();
        //     UserMaster um = new UserMaster();
        //    List list = userMasterService.readByDrow();
        //    request.setAttribute("list", list);
        //mv.getModelMap().put("userMaster", um);
        UserMaster userMaster = userMasterService.read(username);
        userMaster.setPassword("");
        mv.getModelMap().put("userMaster", userMaster);
        mv.setViewName("User/PasswordChangeV");
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
        userMaster.setPassword(userMaster.getPassword());
        //  userMaster.setdRow("N");
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

    public ModelAndView checkPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String loginname = request.getParameter("loginName");
        String emailid = request.getParameter("emailId");

        UserMaster userMaster = userMasterService.read(loginname);
        String email = "";
        String password = userMaster.getPassword();

        if (emailid.equals(email)) {
            String mail_from = "vendor.portal@gfl.co.in";
            String mail_to = email;
            String subject = "Password";
            String msg = "Dear Sir,<br> Your Password : " + password + "";
            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);

        }

        request.setAttribute("successMessage",
                "Information: Password Send to your email ID");

        mv.setViewName("User/ForgotPass");
        return mv;
    }

    public ModelAndView submitPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster userMaster = new UserMaster();
        bind(request, userMaster);
        userMaster.setPassword(userMaster.getPassword());
        //userMasterService.update(userMaster);

        HttpSession session = request.getSession();

        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        String password = request.getParameter("password");

        userMasterService.updatepass(user11, password);

        UserMaster userMaster1 = userMasterService.read(user11);
        userMaster1.setPassword("");
        mv.getModelMap().put("userMaster", userMaster1);
        mv.setViewName("User/PasswardChange");

//        mv= showList(request, response);
        return mv;

    }

    public ModelAndView submitPasswordA(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        String password = request.getParameter("password");

        UserMaster userMaster = new UserMaster();
        bind(request, userMaster);
        // userMaster.setPassword(userMaster.getPassword());
        // userMaster.setPwdChange(1);
        userMasterService.updatepass(user11, password);

        Calendar cal6 = Calendar.getInstance();
        cal6.add(Calendar.DAY_OF_MONTH, -8);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String CurrentDate = sdf.format(d);
        String loginName = user.getLoginName();

        //------for Log entry---------
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Password Change").setDrow("N");
        logService.create(lm);

        request.setAttribute("loginName", loginName);
        request.setAttribute("CurrentDate", CurrentDate);

        mv.setViewName("forward:tenderMaster.htm?act=liveTenderList");
        // mv.setViewName("Common/Home");
//        mv= showList(request, response);
        return mv;

    }

    public ModelAndView submitPasswordV(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        String password = request.getParameter("password");

        UserMaster userMaster = new UserMaster();
        bind(request, userMaster);
        // userMaster.setPassword(userMaster.getPassword());
        // userMaster.setPwdChange(1);
        userMasterService.updatepass(user11, password);

        Calendar cal6 = Calendar.getInstance();
        cal6.add(Calendar.DAY_OF_MONTH, -8);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String CurrentDate = sdf.format(d);
        String loginName = user.getLoginName();

        //------for Log entry---------
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Password Change").setDrow("N");
        logService.create(lm);
        if (user.getUserType() == 2) {
            user11 = user.getVendorCode();
        }
        VendorMaster vendorMaster = vendorMasterService.readByRegNo(user11);
        VendorInformation vendorInformation = vendorInformationService.readEmailId(user11);

        VendorInvitation vendorInvitation = vendorInvitationService.readEmailId(user11);
        int status = 0;
        if (vendorInvitation.getVendorEmailId() == null || vendorInvitation.getVendorEmailId() == "") {
            status = 20;
        } else {
            status = vendorInformation.getStatus1();
        }
        String codString = vendorInvitation.getVendorEmailId();
        int v_flag = vendorMaster.getFlag();
        session.setAttribute("v_flag", v_flag);
        session.setAttribute("status", status);
        session.setAttribute("codString", codString);
        if (v_flag == 1) {

            mv.setViewName("forward:vendor.htm?act=liveTender");
        } else {
            if (status == 1 || status == 2 || status == 10 || status == 101 || status == 100 || status == 6 || status == 7 || status == 102 || status == 500) {
                mv.setViewName("redirect:vendorInformation.htm?act=policyUpdateLevelOneVendorInformation&id=" + codString);
            }
            if (status == 3 || status == 4 || status == 5 || status == 0) {
                mv.setViewName("redirect:vendorInformation.htm?act=vendorpolicy&id=" + codString);
            }
            if (user.getUserType() == 3) {
                mv.setViewName("forward:auditorMaster.htm?act=loginHomePage");
            }

        }

        request.setAttribute("loginName", loginName);
        request.setAttribute("CurrentDate", CurrentDate);

//        mv.setViewName("forward:vendor.htm?act=liveTender");
//        mv.setViewName("Common/Homev");
//        mv= showList(request, response);
        return mv;

    }

    public ModelAndView disableUserMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            UserMaster userMaster = userMasterService.read(checkedValues);
            //    userMaster.setdRow("Y");
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
                //      userMaster.setdRow("N");
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

    public ModelAndView userMasterProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();

        UserMaster user = (UserMaster) session.getAttribute("user");
        String user_name = user.getLoginName();
        VendorMaster vendorMaster = vendorMasterService.readByRegNo(user_name);

        VendorInformation vendorInformation = vendorInformationService.readEmailId(user_name);

        int id = vendorInformation.getId();

        VendorInformation vendorInformation1 = vendorInformationService.readById(id);

        List list4 = electricalContractorService.readByVendorInformationId(id + "");
        List list5 = vendorHrCriteriaCommentService.readByVendorInformationId(id + "");
        List list6 = vendorSafetyCriteriaCommentService.readByVendorInformationId(id + "");

        int venderInvtId = vendorInformation.getVendorInvitationId();

        VendorInvitation vendorInvitation = vendorInvitationService.readById(venderInvtId);
        List list7 = vendorInvitationCategoryService.readIds(venderInvtId);
        mv.getModelMap().put("list7", list7);
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("list5", list5);
        mv.getModelMap().put("list6", list6);
        mv.getModelMap().put("vendorInformation", vendorInformation);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("vendorInvitation", vendorInvitation);
        request.setAttribute("vendorMaster", vendorMaster);
        request.setAttribute("user_name", user_name);
        mv.setViewName("Common/Profile");
        return mv;
    }

    public ModelAndView updateProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int vendor_id = Integer.parseInt(request.getParameter("vendor_id"));
        String emailId = request.getParameter("vendor_email_id");
        String mobileNo = request.getParameter("vendor_mobile_no");
        String cc = request.getParameter("vendor_cc");

        VendorMaster vm = vendorMasterService.readById(vendor_id);

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Vendor"
                + File.separator + vm.getId();
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        String vendor_stamp = request.getParameter("vendor_stamp");
        if (vendor_stamp == null) {
            vendor_stamp = "";
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile multipartFile = multipartRequest.getFile("vendor_stamp");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Vendor"
                        + File.separator + vm.getId() + File.separator;
                File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                vendor_stamp = multipartFile.getOriginalFilename().replaceAll(" ", "");
                multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String vendor_sign = request.getParameter("vendor_sign");
        if (vendor_sign == null) {
            vendor_sign = "";
        }
        multipartRequest = (MultipartHttpServletRequest) request;

        multipartFile = multipartRequest.getFile("vendor_sign");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Vendor"
                        + File.separator + vm.getId() + File.separator;
                File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                vendor_sign = multipartFile.getOriginalFilename().replaceAll(" ", "");
                multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // VendorMaster vm = vendorMasterService.readById(vendor_id);
        vm.setVendorEmailID(emailId);
        vm.setVendorcc(cc);
        vm.setVendorMobNo(mobileNo);
        if (!vendor_stamp.equals("")) {
            vm.setVendorStamp(vendor_stamp);
        }
        if (!vendor_sign.equals("")) {
            vm.setVendorSign(vendor_sign);
        }
        vendorMasterService.update(vm);
        //   mv.setViewName("Common/Home");

        request.setAttribute("successMessage",
                "Information: Vendor information updated successfully");

        mv.setViewName("forward:vendor.htm?act=liveTender");
        return mv;
    }
}
