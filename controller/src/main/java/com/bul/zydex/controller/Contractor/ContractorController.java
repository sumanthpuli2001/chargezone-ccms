/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Contractor;

import com.bul.zydex.model.ContractorMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class ContractorController extends ContractorAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ContractorMaster contractorMaster = new ContractorMaster();
        List list = contractorService.readByDrow();
        request.setAttribute("list", list);
        mv.getModelMap().put("contractorMaster", contractorMaster);
        mv.setViewName("Contractor/ContractorList");
        return mv;
    }

    public ModelAndView showBackupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ContractorMaster contractorMaster = new ContractorMaster();
        List list = contractorService.readByDrowDisable();
        request.setAttribute("list", list);
        mv.getModelMap().put("contractorMaster", contractorMaster);
        mv.setViewName("Contractor/ContractorDisableList");
        return mv;
    }

    public ModelAndView createContractorMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ContractorMaster contractorMaster = new ContractorMaster();
        mv.getModelMap().put("contractorMaster", contractorMaster);
        mv.setViewName("Contractor/ContractorCreate");
        return mv;
    }

    public ModelAndView submitContractorMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ContractorMaster cm = new ContractorMaster();
        bind(request, cm);
        Boolean contractoraCode = contractorService.readByContractorCode(cm.getContractorCode());
        if (!contractoraCode) {
            String RF_id = "";
            int st = cm.getContractorCode().substring(1, 2).charAt(0) - 64;
            String u = cm.getContractorCode().substring(2);
            int temp = cm.getContractorCode().substring(2).length();
            String p = "" + st;
            if (temp == 4) {
                if (p.length() == 2) {
                    RF_id = RF_id + p + "30" + u;
                } else {
                    RF_id = RF_id + "0" + p + "30" + u;
                }
            } else if (temp == 3) {
                if (p.length() == 2) {
                    RF_id = RF_id + p + "300" + u;
                } else {
                    RF_id = RF_id + "0" + p + "300" + u;
                }

            } else if (temp == 2) {
                if (p.length() == 2) {
                    RF_id = RF_id + p + "3000" + u;
                } else {
                    RF_id = RF_id + "0" + p + "3000" + u;
                }

            } else if (temp == 1) {
                if (p.length() == 2) {
                    RF_id = RF_id + p + "10000" + u;
                } else {
                    RF_id = RF_id + "0" + p + "10000" + u;
                }

            }
            cm.setRfId(RF_id).setDuration("0").setdRow("N").setApproved("Y");
            contractorService.create(cm);
            UserMaster um = new UserMaster();
        //    um.setLoginName(cm.getContractorCode()).setPassword(encription(cm.getContractorCode())).setUserFullName(cm.getName()).setRights("Contractor").setDepartment(cm.getDepartment()).setDesignation(" ").setEmailId(" ").setdRow("N");
        //    userMasterService.create(um);
            request.setAttribute("successMessage",
                    "Information: Employee Created successfully");

            //------for Log entry---------
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Contractor Created").setDrow("Y");
            logService.create(lm);
        } else {
            request.setAttribute("failureMessage",
                    "Information: Employee code duplicated found.");
            request.setAttribute("contractorMaster", cm);
            mv.setViewName("Contractor/ContractorCreate");
        }
        mv = showList(request, response);
        return mv;

    }

    public ModelAndView editContractorMasterSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ContractorMaster contractorMaster = new ContractorMaster();
        bind(request, contractorMaster);
        contractorService.update(contractorMaster);
        UserMaster um = userMasterService.read(contractorMaster.getContractorCode());
    //    um.setUserFullName(contractorMaster.getName()).setDepartment(contractorMaster.getDepartment());
    //    userMasterService.update(um);
        request.setAttribute("successMessage",
                "Information: Employee Updated successfully");
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Edit Contractor").setDrow("Y");
        logService.create(lm);
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ccCode = request.getParameter("id");
        ContractorMaster contractorMaster = contractorService.read(ccCode);
        mv.getModelMap().put("contractorMaster", contractorMaster);
        mv.setViewName("Contractor/ContractorEdit");
        return mv;
    }

 public ModelAndView disableContractor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            ContractorMaster contractorMaster = contractorService.read(checkedValues);
            contractorMaster.setdRow("Y");
            contractorService.update(contractorMaster);
            UserMaster um = userMasterService.read(contractorMaster.getContractorCode());
        //    um.setdRow("Y");
            userMasterService.update(um);

        }
        request.setAttribute("successMessage",
                "Information: One or more Employee deleted successfully");
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Delete Contractor").setDrow("Y");
        logService.create(lm);
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView deleteContractorMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String value = request.getParameter("delete");
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        if (value.equals("D")) {
            for (String checkedValues : checkId) {
                contractorService.deleteByContractorCode(checkedValues);
                userMasterService.deleteByLoginName(checkedValues);
            }
            request.setAttribute("successMessage",
                    "Information: One or more Employee deleted successfully");
            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Delete Contractor permanent").setDrow("Y");
            logService.create(lm);
        } else if (value.equals("R")) {
            for (String checkedValues : checkId) {
                ContractorMaster contractorMaster = contractorService.read(checkedValues);
                contractorMaster.setdRow("N");
                contractorService.update(contractorMaster);
                UserMaster um = userMasterService.read(contractorMaster.getContractorCode());
            //    um.setdRow("N");
                userMasterService.update(um);

            }
            request.setAttribute("successMessage",
                    "Information: One or more Employee deleted successfully");
            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Restore Contractor").setDrow("Y");
            logService.create(lm);
        }

        mv = showBackupList(request, response);
        return mv;
    }
}
