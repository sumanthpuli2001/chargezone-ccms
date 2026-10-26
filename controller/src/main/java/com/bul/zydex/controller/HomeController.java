/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.model.VendorInvitation;
import com.bul.zydex.model.VendorMaster;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
public class HomeController extends HomeAbstract {

    public ModelAndView openHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
     ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");

        String username = user.getLoginName();
        int usertype = user.getUserType();
        int passchange = user.getPwdChange();

        Calendar cal6 = Calendar.getInstance();
        cal6.add(Calendar.DAY_OF_MONTH, -8);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String CurrentDate = sdf.format(d);
        String loginName = user.getLoginName();

        //------for Log entry---------
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Login").setDrow("Y");
        logService.create(lm);

        request.setAttribute("loginName", loginName);
        request.setAttribute("CurrentDate", CurrentDate);

        if (passchange == 1) {
            if (usertype == 0) {
                List tenderPriceApproval = prPriceApprovalService.approvaList(username);

                if (tenderPriceApproval.size() > 0) {
                    mv.setViewName("forward:prMaster.htm?act=approvePRList");

                } else {
                    UserRights userRights = userRightsService.readByUser(username);

                    if (userRights.getCreateTender() == 0) {
                        mv.setViewName("forward:tenderMaster.htm?act=receiveBidList");
                    } else {
                        if (userRights.getAuthorizeTender() == 0) {
                            List prMaster = prMasterService.pendingPRList1(username);
                            if (prMaster.size() > 0) {
                                mv.setViewName("forward:prMaster.htm?act=assignDashboard");
                            } else {
                                mv.setViewName("forward:tenderMaster.htm?act=liveTenderList");
                            }
                        } else {
                            List prMaster = prMasterService.pendingPRList2();
                            if (prMaster.size() > 0) {
                                mv.setViewName("forward:prMaster.htm?act=pendingPRList");
                            } else {
                                mv.setViewName("forward:tenderMaster.htm?act=liveTenderList");
                            }
                        }
                    }
                }
                //mv.setViewName("Common/Home");
            }else if(usertype == 3){
                
                 mv.setViewName("forward:auditorMaster.htm?act=loginHomePage");
            } 
            
            else {
                if (usertype == 2) {
                    username = user.getVendorCode();

                }
                
                VendorInvitation vendorInvitation = vendorInvitationService.readEmailId(username);
                String codString = vendorInvitation.getVendorEmailId();
                VendorMaster vendorMaster = vendorMasterService.readByRegNo(username);
                VendorInformation vendorInformation = vendorInformationService.readEmailId(username);

                int status = 0;
                if(vendorInvitation.getVendorEmailId()==null || vendorInvitation.getVendorEmailId()=="")
                {
                   status=20; 
                }else{
                 status=   vendorInformation.getStatus1();
                }
                int v_flag = vendorMaster.getFlag();
                session.setAttribute("v_flag", v_flag);
                session.setAttribute("status", status);
                session.setAttribute("codString", codString);
                
                if (v_flag == 1) {

                    mv.setViewName("forward:vendor.htm?act=liveTender");
                } else {                    
                    if (status == 1 || status == 2 || status == 10 || status == 101 || status == 100 || status == 6 || status == 7 || status == 102 || status == 500 || status == 502) {
                        mv.setViewName("redirect:vendorInformation.htm?act=policyUpdateLevelOneVendorInformation&id=" + codString);
                    }
                    if (status == 3 || status == 4 || status == 5 || status == 0) {
                        mv.setViewName("redirect:vendorInformation.htm?act=vendorpolicy&id=" + codString);
                    }

                }
                // mv.setViewName("Common/Homev");
            }
            
            
            
            
            
        } 
        
        
        
        else {

            //     UserMaster um = new UserMaster();
            //    List list = userMasterService.readByDrow();
            //    request.setAttribute("list", list);
            //mv.getModelMap().put("userMaster", um);
            UserMaster userMaster = userMasterService.read(username);
            userMaster.setPassword("");
            mv.getModelMap().put("userMaster", userMaster);

            if (usertype == 0) {
                mv.setViewName("User/PasswordChangeA");
            } else {
                mv.setViewName("User/PasswordChangeV");
            }
        }

        return mv;
    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Log/Loglist");
        return mv;
    }

    public ModelAndView logsSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String dFrom = request.getParameter("startDate");
        String eFrom = request.getParameter("endDate");
        List list = logService.readLogs(dFrom, eFrom);

        request.setAttribute("list", list);
        request.setAttribute("dFrom", dFrom);
        request.setAttribute("eFrom", eFrom);

        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Log Searched").setDrow("Y");
        logService.create(lm);
        mv.setViewName("Log/Loglist");
        return mv;
    } 

}
