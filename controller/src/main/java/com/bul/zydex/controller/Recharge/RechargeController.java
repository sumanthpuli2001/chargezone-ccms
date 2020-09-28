/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recharge;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ContractorMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.RechargeInfoMaster;
import com.bul.zydex.model.RechargeMaster;
import com.bul.zydex.model.UserMaster;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class RechargeController extends CustomAbstract {

    public ModelAndView CretaeRecharge(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RechargeMaster rechargeMaster = new RechargeMaster();
        mv.getModelMap().put("rechargeMaster", rechargeMaster);
        mv.setViewName("Recharge/CreateRecharge");

        return mv;
    }

    public ModelAndView submitRecharge(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RechargeMaster rechargeMaster = new RechargeMaster();
        bind(request, rechargeMaster);
        rechargeMaster.setdRow("N");
        rechargeService.create(rechargeMaster);

        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Recharge").setDrow("Y");
        logService.create(lm);

        request.setAttribute("successMessage",
                "Information: Recharge done successfully");
        mv = CretaeRecharge(request, response);
        return mv;
    }

    public ModelAndView rechargeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List list = rechargeInfoService.readDistinctEmp();
        List finalList = new LinkedList();
        for (Object o : list) {
            String rfId = (String) o;
            List empLatestRecharge = rechargeInfoService.readEmpLatestRecharge(rfId);
            if (!empLatestRecharge.isEmpty()) {
                try {
                    RechargeInfoMaster rim = new RechargeInfoMaster();
                    rim = (RechargeInfoMaster) empLatestRecharge.get(0);

                    List listOfEmp = new LinkedList();

                    listOfEmp.add(rim.getId());
                    listOfEmp.add(rfId);
                    listOfEmp.add(Math.abs(Double.parseDouble(rim.getAmount())));
                    listOfEmp.add(rim.getDate());

                    List empList = employeeMasterService.readByRfId(rfId);
                    if (!empList.isEmpty()) {
                        EmployeeMaster employeeMaster = (EmployeeMaster) empList.get(0);
                        listOfEmp.add(employeeMaster.getName());

                    } else {
                        empList = contractorService.readByRfId(rfId);
                        if (!empList.isEmpty()) {
                            ContractorMaster contractorMaster = (ContractorMaster) empList.get(0);
                            listOfEmp.add(contractorMaster.getName());
                        }
                    }
                    if (!empList.isEmpty()) {
                        finalList.add(listOfEmp);
                    }
                } catch (Exception e) {
                }
            }

        }
        request.setAttribute("finalList", finalList);
        mv.setViewName("Recharge/RechargeViewList");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        RechargeInfoMaster rechargeInfoMaster = rechargeInfoService.readById(Integer.parseInt(id));
        Date date = new Date();
        String name = "";
        List empList = employeeMasterService.readByRfId(rechargeInfoMaster.getRfId());
        if (!empList.isEmpty()) {
            EmployeeMaster employeeMaster = (EmployeeMaster) empList.get(0);
            name = employeeMaster.getName();

        } else {
            empList = contractorService.readByRfId(rechargeInfoMaster.getRfId());
            if (!empList.isEmpty()) {
                ContractorMaster contractorMaster = (ContractorMaster) empList.get(0);
                name = contractorMaster.getName();
            }
        }
        if (name == "") {
            request.setAttribute("failureMessage", "No User found with this RFID.");
            mv = rechargeView(request, response);
        } else {
            request.setAttribute("name", name);
            request.setAttribute("date", dateFormat.format(date));
            request.setAttribute("rechargeInfoMaster", rechargeInfoMaster);
            mv.setViewName("Recharge/RechargeCard");
        }
        return mv;
    }

    public ModelAndView searchRecharge(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Recharge/searchRecharge");
        return mv;
    }

    public ModelAndView searchRechargeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String rfID = request.getParameter("code");
        Date date = new Date();
        String name = "";
        List list = rechargeInfoService.readEmpLatestRecharge(rfID);
        if (!list.isEmpty()) {
            RechargeInfoMaster rechargeInfoMaster = (RechargeInfoMaster) list.get(0);
            List empList = employeeMasterService.readByRfId(rechargeInfoMaster.getRfId());
            if (!empList.isEmpty()) {
                EmployeeMaster employeeMaster = (EmployeeMaster) empList.get(0);
                name = employeeMaster.getName();

            } else {
                empList = contractorService.readByRfId(rechargeInfoMaster.getRfId());
                if (!empList.isEmpty()) {
                    ContractorMaster contractorMaster = (ContractorMaster) empList.get(0);
                    name = contractorMaster.getName();
                }
            }
            if (name == "") {
                request.setAttribute("failureMessage", "No User found with this RFID.");
                mv = searchRecharge(request, response);
            } else {
                request.setAttribute("name", name);
                request.setAttribute("date", dateFormat.format(date));
                request.setAttribute("rechargeInfoMaster", rechargeInfoMaster);
                mv.setViewName("Recharge/RechargeCard");
            }
        } else {
            request.setAttribute("failureMessage", "No User found with this RFID.");
            mv = searchRecharge(request, response);
        }
        return mv;
    }

    public ModelAndView submitRechargeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("rechargeOption");
        String rAmount = request.getParameter("rAmount");
        RechargeInfoMaster rechargeInfoMaster = new RechargeInfoMaster();
        bind(request, rechargeInfoMaster);
        Date date = new Date();
        if (id.equals("N")) {
            rechargeInfoMaster.setDate(dateFormat.format(date)).setAmount(rAmount).setrAmount(rAmount);
            rechargeInfoService.create(rechargeInfoMaster);
        } else if (id.equals("A")) {
            List list = rechargeInfoService.readByRfidAndDate(dateFormat.format(date), rechargeInfoMaster.getRfId());
            if (!list.isEmpty()) {
                RechargeInfoMaster rim = (RechargeInfoMaster) list.get(0);
                Double amount = Double.parseDouble(rim.getAmount());
                rim.setAmount("" + (amount + Double.parseDouble(rAmount))).setrAmount("" + (amount + Double.parseDouble(rAmount)));
                rechargeInfoService.update(rim);

            } else {
                rechargeInfoMaster.setDate(dateFormat.format(date)).setAmount("" + Double.parseDouble(rechargeInfoMaster.getAmount()) + Double.parseDouble(rAmount)).setrAmount("" + Double.parseDouble(rechargeInfoMaster.getAmount()) + Double.parseDouble(rAmount));
                rechargeInfoService.create(rechargeInfoMaster);
            }

        }
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Recharge Created").setDrow("Y");
        logService.create(lm);
        request.setAttribute("successMessage", "Recharge Sucessfully.");
        mv = rechargeView(request, response);
        return mv;
    }

}
