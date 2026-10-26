/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Right;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.RightMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.ServiceRights;
import com.bul.zydex.model.UserRights;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class RightController extends CustomAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        mv.setViewName("Right/RightList");
        return mv;
    }

    public ModelAndView showRightMasterlist(HttpServletRequest request, HttpServletResponse response, RightMaster rightMaster) throws Exception {
        ModelAndView mv = new ModelAndView("Right/RightCreate");

        mv.addObject("RightMaster", rightMaster);
        return mv;
    }

    public ModelAndView showBackupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RightMaster rightMaster = new RightMaster();
        List list = rightService.readByDrowDisable();
        request.setAttribute("list", list);
        mv.getModelMap().put("rightMaster", rightMaster);
        mv.setViewName("Right/RightDisableList");
        return mv;
    }

    public ModelAndView createRightMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RightMaster rightMaster = new RightMaster();
        mv.getModelMap().put("rightMaster", rightMaster);
        mv.setViewName("Right/RightCreate");
        return mv;
    }

    public ModelAndView submitRightMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RightMaster rightMaster = new RightMaster();
        bind(request, rightMaster);
        HttpSession session = request.getSession(false);
        String emp_mgt = request.getParameter("emp_mgt");
        if (emp_mgt == null) {
            emp_mgt = "0";
        }
        String right_mgt = "0";
        if (emp_mgt.equals("1")) {
            right_mgt = "1";
        }

        String vendor_mgt = request.getParameter("vendor_mgt");
        if (vendor_mgt == null) {
            vendor_mgt = "0";
        }
        String create_tender = request.getParameter("create_tender");
        if (create_tender == null) {
            create_tender = "0";
        }
        String authorize_tender = request.getParameter("authorize_tender");
        if (authorize_tender == null) {
            authorize_tender = "0";
        }
        String tender_bid_open = request.getParameter("tender_bid_open");
        if (tender_bid_open == null) {
            tender_bid_open = "0";
        }
        String user_report = request.getParameter("user_report");
        if (user_report == null) {
            user_report = "0";
        }
        String tender_report = request.getParameter("tender_report");
        if (tender_report == null) {
            tender_report = "0";
        }

        String oap_creater = request.getParameter("oap_creater");
        if (oap_creater == null) {
            oap_creater = "0";
        }
        String oap_Approval = request.getParameter("oap_Approval");
        if (oap_Approval == null) {
            oap_Approval = "0";
        }
        String aoc_creater = request.getParameter("aoc_creater");
        if (aoc_creater == null) {
            aoc_creater = "0";
        }
        String aoc_Approval = request.getParameter("aoc_Approval");
        if (aoc_Approval == null) {
            aoc_Approval = "0";
        }
        String oap_approval_creater = request.getParameter("oap_approval_creater");
        if (oap_approval_creater == null) {
            oap_approval_creater = "0";
        }
        String aoc_approval_creater = request.getParameter("aoc_approval_creater");
        if (aoc_approval_creater == null) {
            aoc_approval_creater = "0";
        }
        String project_manager = request.getParameter("project_manager");
        if (project_manager == null) {
            project_manager = "0";
        }
        String network_team = request.getParameter("network_team");
        if (network_team == null) {
            network_team = "0";
        }
        String finance_team = request.getParameter("finance_team");
        if (finance_team == null) {
            finance_team = "0";
        }
        String oap_aoc_report = request.getParameter("oap_aoc_report");
        if (oap_aoc_report == null) {
            oap_aoc_report = "0";
        }
        String execitive_head = request.getParameter("execitive_head");
        if (execitive_head == null) {
            execitive_head = "0";
        }
        String project_Cordinator = request.getParameter("project_Cordinator");
        if (project_Cordinator == null) {
            project_Cordinator = "0";
        }

        String vendor_request = request.getParameter("vendor_request");
        if (vendor_request == null) {
            vendor_request = "0";
        }

        String vendor_invite = request.getParameter("vendor_invite");
        if (vendor_invite == null) {
            vendor_invite = "0";
        }

        String vendor_information = request.getParameter("vendor_information");
        if (vendor_information == null) {
            vendor_information = "0";
        }

        String buyer_approval = request.getParameter("buyer_approval");
        if (buyer_approval == null) {
            buyer_approval = "0";
        }
        String financial_approval = request.getParameter("financial_approval");
        if (financial_approval == null) {
            financial_approval = "0";
        }
        String technical_approval = request.getParameter("technical_approval");
        if (technical_approval == null) {
            technical_approval = "0";
        }
        String hr_approval = request.getParameter("hr_approval");
        if (hr_approval == null) {
            hr_approval = "0";
        }
        String it_approval = request.getParameter("it_approval");
        if (it_approval == null) {
            it_approval = "0";
        }
        String safety_approval = request.getParameter("safety_approval");
        if (safety_approval == null) {
            safety_approval = "0";
        }
        String active_vender = request.getParameter("active_vender");
        if (active_vender == null) {
            active_vender = "0";
        }
        String all_vender = request.getParameter("all_vender");
        if (all_vender == null) {
            all_vender = "0";
        }
        String vendor_technical_criteria_master = request.getParameter("vendor_technical_criteria_master");
        if (vendor_technical_criteria_master == null) {
            vendor_technical_criteria_master = "0";
        }
        String hr_criteria_master = request.getParameter("hr_criteria_master");
        if (hr_criteria_master == null) {
            hr_criteria_master = "0";
        }
        String safety_criteria_master = request.getParameter("safety_criteria_master");
        if (safety_criteria_master == null) {
            safety_criteria_master = "0";
        }
        String site_survey = request.getParameter("site_survey");
        if (site_survey == null) {
            site_survey = "0";
        }
        String procurementHead = request.getParameter("procurementHead");
        if (procurementHead == null) {
            procurementHead = "0";
        }
        String complianceOfficer = request.getParameter("complianceOfficer");
        if (complianceOfficer == null) {
            complianceOfficer = "0";
        }
        String prManagement = request.getParameter("prManagement");
        if (prManagement == null) {
            prManagement = "0";
        }
        String omsCreator = request.getParameter("omsCreator");
        if (omsCreator == null) {
            omsCreator = "0";
        }
        String grnExecutive = request.getParameter("grnExecutive");
        if (grnExecutive == null) {
            grnExecutive = "0";
        }

        StringJoiner sj = new StringJoiner("");
        rightMaster.setdRow("N");

        String[] SelectedEntry = {"u", "e", "cn", "a", "co", "ca", "w", "rp", "l", "rc"};
        String a;
        String str1 = "";
        for (int i = 0; i < SelectedEntry.length; i++) {
            a = SelectedEntry[i];
            String s = request.getParameter(a);
            if (s != null) {
                String WrightsEntry[] = request.getParameterValues(a);
                for (int j = 0; j < WrightsEntry.length; j++) {
                    str1 = str1 + WrightsEntry[j];
                }
                str1 = str1 + " ";
            } else {
                str1 = str1 + "N ";
            }

        }

        rightMaster.setEmpMgt(Integer.parseInt(emp_mgt));
        rightMaster.setRightMgt(Integer.parseInt(right_mgt));
        rightMaster.setVendorMgt(Integer.parseInt(vendor_mgt));
        rightMaster.setCreateTender(Integer.parseInt(create_tender));
        rightMaster.setAuthorizeTender(Integer.parseInt(authorize_tender));
        rightMaster.setTenderBidOpen(Integer.parseInt(tender_bid_open));
        rightMaster.setUserReport(Integer.parseInt(user_report));
        rightMaster.setTenderReport(Integer.parseInt(tender_report));

        rightMaster.setOapCreater(Integer.parseInt(oap_creater));
        rightMaster.setOapApproval(Integer.parseInt(oap_Approval));
        rightMaster.setAocCreater(Integer.parseInt(aoc_creater));
        rightMaster.setAocApproval(Integer.parseInt(aoc_Approval));

        rightMaster.setOapApprovalCreater(Integer.parseInt(oap_approval_creater));
        rightMaster.setAocApprovalCreater(Integer.parseInt(aoc_approval_creater));
        rightMaster.setProjectManager(Integer.parseInt(project_manager));

        rightMaster.setNetworkTeam(Integer.parseInt(network_team));
        rightMaster.setFinanceTeam(Integer.parseInt(finance_team));
        rightMaster.setOapaocReport(Integer.parseInt(oap_aoc_report));
        rightMaster.setExecutiveHead(Integer.parseInt(execitive_head));
        rightMaster.setProjectCordinator(Integer.parseInt(project_Cordinator));

        rightMaster.setVenderRequest(Integer.parseInt(vendor_request));
        rightMaster.setVenderInvite(Integer.parseInt(vendor_invite));
        rightMaster.setVenderInformation(Integer.parseInt(vendor_information));

        rightMaster.setBuyerApproval(Integer.parseInt(buyer_approval));
        rightMaster.setFinancialApproval(Integer.parseInt(financial_approval));
        rightMaster.setTechnicalApproval(Integer.parseInt(technical_approval));
        rightMaster.setHrApproval(Integer.parseInt(hr_approval));
        rightMaster.setItApproval(Integer.parseInt(it_approval));
        rightMaster.setSafetyApproval(Integer.parseInt(safety_approval));
        rightMaster.setActiveVendor(Integer.parseInt(active_vender));
        rightMaster.setAllVendor(Integer.parseInt(all_vender));
        rightMaster.setProcurementHead(Integer.parseInt(procurementHead));
        rightMaster.setComplianceOfficer(Integer.parseInt(complianceOfficer));
        rightMaster.setPrManagement(Integer.parseInt(prManagement));
        rightMaster.setVendorTechnicalCriteriaMaster(Integer.parseInt(vendor_technical_criteria_master));
        rightMaster.setHrCriteriaMaster(Integer.parseInt(hr_criteria_master));
        rightMaster.setSafetyCriteriaMaster(Integer.parseInt(safety_criteria_master));
        rightMaster.setSiteSurvey(Integer.parseInt(site_survey));
        rightMaster.setOmsCreator(Integer.parseInt(omsCreator));
        rightMaster.setGrnExecutive(Integer.parseInt(grnExecutive));

        rightMaster.setRight(str1);
        if (!rightService.isExist(rightMaster)) {
            rightService.create(rightMaster);
            session.setAttribute("successMessage", "Right Created successfully");
            mv.setViewName("redirect:right.htm?act=showList");
        } else {
            mv.setViewName("forward:right.htm?act=showRightMasterlist");
            mv.addObject("failureMessage", "Right Already Exist. Please enter new Data");
        }

        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right created").setDrow("Y");
        logService.create(lm);
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String rigName = request.getParameter("rigName");
        RightMaster rightMaster = rightService.read(rigName);
        rightMaster.setdRow("N");

        String emp_mgt = request.getParameter("emp_mgt");
        if (emp_mgt == null) {
            emp_mgt = "0";
        }

        String right_mgt = "0";
        if (emp_mgt.equals("1")) {
            right_mgt = "1";
        }

        String vendor_mgt = request.getParameter("vendor_mgt");
        if (vendor_mgt == null) {
            vendor_mgt = "0";
        }
        String create_tender = request.getParameter("create_tender");
        if (create_tender == null) {
            create_tender = "0";
        }
        String authorize_tender = request.getParameter("authorize_tender");
        if (authorize_tender == null) {
            authorize_tender = "0";
        }
        String tender_bid_open = request.getParameter("tender_bid_open");
        if (tender_bid_open == null) {
            tender_bid_open = "0";
        }
        String user_report = request.getParameter("user_report");
        if (user_report == null) {
            user_report = "0";
        }
        String tender_report = request.getParameter("tender_report");
        if (tender_report == null) {
            tender_report = "0";
        }

        String oap_creater = request.getParameter("oap_creater");
        if (oap_creater == null) {
            oap_creater = "0";
        }
        String oap_Approval = request.getParameter("oap_Approval");
        if (oap_Approval == null) {
            oap_Approval = "0";
        }
        String aoc_creater = request.getParameter("aoc_creater");
        if (aoc_creater == null) {
            aoc_creater = "0";
        }
        String aoc_Approval = request.getParameter("aoc_Approval");
        if (aoc_Approval == null) {
            aoc_Approval = "0";
        }
        String oap_approval_creater = request.getParameter("oap_approval_creater");
        if (oap_approval_creater == null) {
            oap_approval_creater = "0";
        }
        String aoc_approval_creater = request.getParameter("aoc_approval_creater");
        if (aoc_approval_creater == null) {
            aoc_approval_creater = "0";
        }
        String project_manager = request.getParameter("project_manager");
        if (project_manager == null) {
            project_manager = "0";
        }
        String network_team = request.getParameter("network_team");
        if (network_team == null) {
            network_team = "0";
        }
        String finance_team = request.getParameter("finance_team");
        if (finance_team == null) {
            finance_team = "0";
        }
        String oap_aoc_report = request.getParameter("oap_aoc_report");
        if (oap_aoc_report == null) {
            oap_aoc_report = "0";
        }
        String execitive_head = request.getParameter("execitive_head");
        if (execitive_head == null) {
            execitive_head = "0";
        }
        String project_Cordinator = request.getParameter("project_Cordinator");
        if (project_Cordinator == null) {
            project_Cordinator = "0";
        }

        String vendor_request = request.getParameter("vendor_request");
        if (vendor_request == null) {
            vendor_request = "0";
        }

        String vendor_invite = request.getParameter("vendor_invite");
        if (vendor_invite == null) {
            vendor_invite = "0";
        }

        String vendor_information = request.getParameter("vendor_information");
        if (vendor_information == null) {
            vendor_information = "0";
        }
        String buyer_approval = request.getParameter("buyer_approval");
        if (buyer_approval == null) {
            buyer_approval = "0";
        }
        String financial_approval = request.getParameter("financial_approval");
        if (financial_approval == null) {
            financial_approval = "0";
        }
        String technical_approval = request.getParameter("technical_approval");
        if (technical_approval == null) {
            technical_approval = "0";
        }
        String hr_approval = request.getParameter("hr_approval");
        if (hr_approval == null) {
            hr_approval = "0";
        }
        String safety_approval = request.getParameter("safety_approval");
        if (safety_approval == null) {
            safety_approval = "0";
        }
        String it_approval = request.getParameter("it_approval");
        if (it_approval == null) {
            it_approval = "0";
        }
        String active_vender = request.getParameter("active_vender");
        if (active_vender == null) {
            active_vender = "0";
        }
        String all_vender = request.getParameter("all_vender");
        if (all_vender == null) {
            all_vender = "0";
        }
        String procurementHead = request.getParameter("procurementHead");
        if (procurementHead == null) {
            procurementHead = "0";
        }
        String complianceOfficer = request.getParameter("complianceOfficer");
        if (complianceOfficer == null) {
            complianceOfficer = "0";
        }
        String vendor_technical_criteria_master = request.getParameter("vendor_technical_criteria_master");
        if (vendor_technical_criteria_master == null) {
            vendor_technical_criteria_master = "0";
        }
        String hr_criteria_master = request.getParameter("hr_criteria_master");
        if (hr_criteria_master == null) {
            hr_criteria_master = "0";
        }
        String safety_criteria_master = request.getParameter("safety_criteria_master");
        if (safety_criteria_master == null) {
            safety_criteria_master = "0";
        }
        String site_survey = request.getParameter("site_survey");
        if (site_survey == null) {
            site_survey = "0";
        }
        String prManagement = request.getParameter("prManagement");
        if (prManagement == null) {
            prManagement = "0";
        }
        String omsCreator = request.getParameter("omsCreator");
        if (omsCreator == null) {
            omsCreator = "0";
        }
        String grnExecutive = request.getParameter("grnExecutive");
        if (grnExecutive == null) {
            grnExecutive = "0";
        }

        String[] SelectedEntry = {"u", "e", "cn", "a", "co", "ca", "w", "rp", "l", "rc"};
        String a;
        String str1 = "";
        for (int i = 0; i < SelectedEntry.length; i++) {
            a = SelectedEntry[i];
            String s = request.getParameter(a);
            if (s != null) {
                String WrightsEntry[] = request.getParameterValues(a);
                for (int j = 0; j < WrightsEntry.length; j++) {
                    str1 = str1 + WrightsEntry[j];
                }
                str1 = str1 + " ";
            } else {
                str1 = str1 + "N ";
            }

        }

        rightMaster.setRight(str1);

        rightMaster.setEmpMgt(Integer.parseInt(emp_mgt));
        rightMaster.setRightMgt(Integer.parseInt(right_mgt));
        rightMaster.setVendorMgt(Integer.parseInt(vendor_mgt));
        rightMaster.setCreateTender(Integer.parseInt(create_tender));
        rightMaster.setAuthorizeTender(Integer.parseInt(authorize_tender));
        rightMaster.setTenderBidOpen(Integer.parseInt(tender_bid_open));
        rightMaster.setUserReport(Integer.parseInt(user_report));
        rightMaster.setTenderReport(Integer.parseInt(tender_report));

        rightMaster.setOapCreater(Integer.parseInt(oap_creater));
        rightMaster.setOapApproval(Integer.parseInt(oap_Approval));
        rightMaster.setAocCreater(Integer.parseInt(aoc_creater));
        rightMaster.setAocApproval(Integer.parseInt(aoc_Approval));

        rightMaster.setOapApprovalCreater(Integer.parseInt(oap_approval_creater));
        rightMaster.setAocApprovalCreater(Integer.parseInt(aoc_approval_creater));
        rightMaster.setProjectManager(Integer.parseInt(project_manager));
        rightMaster.setNetworkTeam(Integer.parseInt(network_team));
        rightMaster.setFinanceTeam(Integer.parseInt(finance_team));
        rightMaster.setOapaocReport(Integer.parseInt(oap_aoc_report));
        rightMaster.setExecutiveHead(Integer.parseInt(execitive_head));
        rightMaster.setProjectCordinator(Integer.parseInt(project_Cordinator));

        rightMaster.setVenderRequest(Integer.parseInt(vendor_request));
        rightMaster.setVenderInvite(Integer.parseInt(vendor_invite));
        rightMaster.setVenderInformation(Integer.parseInt(vendor_information));

        rightMaster.setBuyerApproval(Integer.parseInt(buyer_approval));
        rightMaster.setFinancialApproval(Integer.parseInt(financial_approval));
        rightMaster.setTechnicalApproval(Integer.parseInt(technical_approval));
        rightMaster.setHrApproval(Integer.parseInt(hr_approval));
        rightMaster.setItApproval(Integer.parseInt(it_approval));
        rightMaster.setSafetyApproval(Integer.parseInt(safety_approval));
        rightMaster.setActiveVendor(Integer.parseInt(active_vender));
        rightMaster.setAllVendor(Integer.parseInt(all_vender));
        rightMaster.setVendorTechnicalCriteriaMaster(Integer.parseInt(vendor_technical_criteria_master));
        rightMaster.setHrCriteriaMaster(Integer.parseInt(hr_criteria_master));
        rightMaster.setSafetyCriteriaMaster(Integer.parseInt(safety_criteria_master));
        rightMaster.setSiteSurvey(Integer.parseInt(site_survey));
        rightMaster.setProcurementHead(Integer.parseInt(procurementHead));
        rightMaster.setPrManagement(Integer.parseInt(prManagement));
        rightMaster.setComplianceOfficer(Integer.parseInt(complianceOfficer));
        rightMaster.setOmsCreator(Integer.parseInt(omsCreator));
        rightMaster.setGrnExecutive(Integer.parseInt(grnExecutive));

        rightService.update(rightMaster);

        RightMaster rightMaster1 = rightService.read(rigName);

        List employeeList = employeeMasterService.readByRightsName(rigName);

        for (Object o : employeeList) {
            EmployeeMaster employeeMaster = (EmployeeMaster) o;

            int empMgt = rightMaster1.getEmpMgt();
            int vendorMgt = rightMaster1.getVendorMgt();
            int rightMgt = rightMaster1.getRightMgt();
            int createTender = rightMaster1.getCreateTender();
            int authorizeTender = rightMaster1.getAuthorizeTender();
            int tenderBidOpen = rightMaster1.getTenderBidOpen();
            int userReport = rightMaster1.getUserReport();
            int tenderReport = rightMaster1.getTenderReport();

            int oapCreater = rightMaster1.getOapCreater();
            int oapApproval = rightMaster1.getOapApproval();
            int aocCreater = rightMaster1.getAocCreater();
            int aocApproval = rightMaster1.getAocApproval();

            int oapApprovalCreater = rightMaster1.getOapApprovalCreater();
            int aocApprovalCreater = rightMaster1.getAocApprovalCreater();
            int projectManager = rightMaster1.getProjectManager();

            int networkTeam = rightMaster1.getNetworkTeam();
            int financeTeam = rightMaster1.getFinanceTeam();
            int oapaocReport = rightMaster1.getOapaocReport();
            int executiveHead = rightMaster1.getExecutiveHead();
            int projectcordinator = rightMaster1.getProjectCordinator();
            int sitesurvey = rightMaster1.getSiteSurvey();

            int vendorRequest = rightMaster1.getVenderRequest();
            int vendorInvite = rightMaster1.getVenderInvite();
            int vendorInformation = rightMaster1.getVenderInformation();
            int buyerApproval = rightMaster1.getBuyerApproval();
            int financialApproval = rightMaster1.getFinancialApproval();
            int technicalApproval = rightMaster1.getTechnicalApproval();
            int hrApproval = rightMaster1.getHrApproval();
            int safetyApproval = rightMaster1.getSafetyApproval();
            int activeVendor = rightMaster1.getActiveVendor();
            int allVendor = rightMaster1.getAllVendor();
            int vendorTechnicalCriteriaMaster = rightMaster1.getAllVendor();
            int hrCriteriaMaster = rightMaster1.getHrCriteriaMaster();
            int safetyCriteriaMaster = rightMaster1.getSafetyApproval();

            int prManagement1 = rightMaster1.getPrManagement();
            int itApproval = rightMaster1.getItApproval();
            int procurementHead1 = rightMaster1.getProcurementHead();
            int complianceOfficer1 = rightMaster1.getComplianceOfficer();
            int omsCreator1 = rightMaster1.getOmsCreator();
            int grnExecutive1 = rightMaster1.getGrnExecutive();

            userRightsService.updateRight(employeeMaster.getEmployeeCode(), empMgt, vendorMgt, rightMgt, createTender, authorizeTender, tenderBidOpen, userReport, tenderReport, oapCreater, oapApproval, aocCreater, aocApproval, oapApprovalCreater, aocApprovalCreater, projectManager, networkTeam, financeTeam, oapaocReport, executiveHead, projectcordinator, vendorRequest, vendorInvite, vendorInformation, buyerApproval, financialApproval, technicalApproval, hrApproval, safetyApproval, activeVendor, allVendor, vendorTechnicalCriteriaMaster, hrCriteriaMaster, safetyCriteriaMaster, sitesurvey, procurementHead1, complianceOfficer1, itApproval, prManagement1, omsCreator1,grnExecutive1);
        }

        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right edited").setDrow("Y");
        logService.create(lm);

        session.setAttribute("successMessage", "Information: Right Edited successfully");
        mv.setViewName("redirect:right.htm?act=showList");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String rightName = request.getParameter("id");
        RightMaster rightMaster = rightService.read(rightName);

        int empMgt = rightMaster.getEmpMgt();
        int rightMgt = rightMaster.getRightMgt();
        int vendorMgt = rightMaster.getVendorMgt();
        int createTender = rightMaster.getCreateTender();
        int authorizeTender = rightMaster.getAuthorizeTender();
        int tenderBidOpen = rightMaster.getTenderBidOpen();
        int userReport = rightMaster.getUserReport();
        int tenderReport = rightMaster.getTenderReport();
        int procurementHead = rightMaster.getProcurementHead();
        int complianceOfficer = rightMaster.getComplianceOfficer();

        int count = 0;
        ArrayList arr = new ArrayList();
        StringTokenizer st = new StringTokenizer(rightMaster.getRight(), "  ");
        while (st.hasMoreTokens()) {
            arr.add(count, st.nextToken());
            count++;
        }

        request.setAttribute("empMgt", empMgt);
        request.setAttribute("rightMgt", rightMgt);
        request.setAttribute("vendorMgt", vendorMgt);
        request.setAttribute("createTender", createTender);
        request.setAttribute("authorizeTender", authorizeTender);
        request.setAttribute("tenderBidOpen", tenderBidOpen);
        request.setAttribute("userReport", userReport);
        request.setAttribute("tenderReport", tenderReport);
        request.setAttribute("complianceOfficer", complianceOfficer);
        request.setAttribute("procurementHead", procurementHead);

        //    rightMaster.
        request.setAttribute("wright", arr);
        mv.getModelMap().put("rightMaster", rightMaster);
        // mv.getModelMap().put("empMgt", empMgt);
        mv.setViewName("Right/RightEdit");
        return mv;
    }

    public ModelAndView disableRight(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            RightMaster rightMaster = rightService.read(checkedValues);
            rightMaster.setdRow("Y");
            rightService.update(rightMaster);
        }
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right Delete").setDrow("Y");
        logService.create(lm);
        session.setAttribute("successMessage", "Information: One or more Right deleted successfully");
        mv.setViewName("redirect:right.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteRightMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String value = request.getParameter("delete");
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        if (value.equals("D")) {
            for (String checkedValues : checkId) {
                rightService.deleteByRightName(checkedValues);
            }
            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right Delete permanantely").setDrow("Y");
            logService.create(lm);
            session.setAttribute("successMessage",
                    "Information: One or more Right deleted successfully");
        } else if (value.equals("R")) {
            for (String checkedValues : checkId) {
                RightMaster rightMaster = rightService.read(checkedValues);
                rightMaster.setdRow("N");
                rightService.update(rightMaster);
            }
            //------for Log entry---------

            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right Restore").setDrow("Y");
            logService.create(lm);
            session.setAttribute("successMessage", "Information: One or more Right Restore successfully");
        }
        mv.setViewName("redirect:right.htm?act=showList");
        return mv;
    }

    public ModelAndView showServiceRightsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ServiceRights serviceRights = new ServiceRights();

        List list = serviceRightsService.read();
        request.setAttribute("list", list);
        mv.getModelMap().put("serviceRights", serviceRights);
        mv.getModelMap().put("list", list);
        mv.setViewName("Right/ServiceRightsList");
        return mv;
    }

    public ModelAndView createServiceRights(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ServiceRights serviceRights = new ServiceRights();
        mv.getModelMap().put("serviceRights", serviceRights);
        mv.setViewName("Right/ServiceRightsCreate");
        return mv;
    }

    public ModelAndView submitServicetRights(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        ServiceRights serviceRights = new ServiceRights();

        String department = request.getParameter("department");
        if (department == null) {
            department = "";
        }
        String location = request.getParameter("location");
        if (location == null) {
            location = "";
        }
        String sap = request.getParameter("sap");
        if (sap == null) {
            sap = "0";
        }
        String service1 = request.getParameter("service1");
        if (service1 == null) {
            service1 = "0";
        }
        String service2 = request.getParameter("service2");
        if (service2 == null) {
            service2 = "0";
        }
        String service3 = request.getParameter("service3");
        if (service3 == null) {
            service3 = "0";
        }
        String service4 = request.getParameter("service4");
        if (service4 == null) {
            service4 = "0";
        }
        String service5 = request.getParameter("service5");
        if (service5 == null) {
            service5 = "0";
        }
        String service6 = request.getParameter("service6");
        if (service6 == null) {
            service6 = "0";
        }

        serviceRights.setDepartment(department);
        serviceRights.setLocation(location);
        serviceRights.setSap(Integer.parseInt(sap));
        serviceRights.setService1(Integer.parseInt(service1));
        serviceRights.setService2(Integer.parseInt(service2));
        serviceRights.setService3(Integer.parseInt(service3));
        serviceRights.setService4(Integer.parseInt(service4));
        serviceRights.setService5(Integer.parseInt(service5));
        serviceRights.setService6(Integer.parseInt(service6));

        serviceRightsService.create(serviceRights);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Service Right created").setDrow("Y");
        logService.create(lm);
        request.setAttribute("successMessage",
                "Information: Service Right Created successfully");

        List list = serviceRightsService.read();
        request.setAttribute("list", list);

        mv.getModelMap().put("list", list);
        mv.setViewName("Right/ServiceRightsList");

        return mv;
    }

    public ModelAndView deleteServiceRight(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            serviceRightsService.delete(Integer.parseInt(checkedValues));

        }
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right Delete").setDrow("Y");
        logService.create(lm);
        request.setAttribute("successMessage",
                "Information: One or more Right deleted successfully");

        List list = serviceRightsService.read();
        request.setAttribute("list", list);

        mv.getModelMap().put("list", list);
        mv.setViewName("Right/ServiceRightsList");
        return mv;
    }

    public ModelAndView viewServiceRightsClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        ServiceRights serviceRights = serviceRightsService.readById(Integer.parseInt(id));

        String department = serviceRights.getDepartment();
        String location = serviceRights.getLocation();
        int sap = serviceRights.getSap();
        int service1 = serviceRights.getService1();
        int service2 = serviceRights.getService2();
        int service3 = serviceRights.getService3();
        int service4 = serviceRights.getService4();
        int service5 = serviceRights.getService5();
        int service6 = serviceRights.getService6();

        mv.getModelMap().put("id", id);
        mv.getModelMap().put("serviceRights", serviceRights);
        mv.getModelMap().put("department", department);
        mv.getModelMap().put("location", location);
        mv.getModelMap().put("sap", sap);
        mv.getModelMap().put("service1", service1);
        mv.getModelMap().put("service2", service2);
        mv.getModelMap().put("service3", service3);
        mv.getModelMap().put("service4", service4);
        mv.getModelMap().put("service5", service5);
        mv.getModelMap().put("service6", service6);

        request.setAttribute("serviceRights", serviceRights);
        // mv.getModelMap().put("empMgt", empMgt);
        mv.setViewName("Right/ServiceRightEdit");
        return mv;
    }

    public ModelAndView editServiceRightsSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        ServiceRights serviceRights = new ServiceRights();
        bind(request, serviceRights);

        String id = request.getParameter("id");
        if (id == null) {
            id = "";
        }
        String department = request.getParameter("department");
        if (department == null) {
            department = "";
        }
        String location = request.getParameter("location");
        if (location == null) {
            location = "";
        }
        String sap = request.getParameter("sap");
        if (sap == null) {
            sap = "0";
        }
        String service1 = request.getParameter("service1");
        if (service1 == null) {
            service1 = "0";
        }
        String service2 = request.getParameter("service2");
        if (service2 == null) {
            service2 = "0";
        }
        String service3 = request.getParameter("service3");
        if (service3 == null) {
            service3 = "0";
        }
        String service4 = request.getParameter("service4");
        if (service4 == null) {
            service4 = "0";
        }
        String service5 = request.getParameter("service5");
        if (service5 == null) {
            service5 = "0";
        }
        String service6 = request.getParameter("service6");
        if (service6 == null) {
            service6 = "0";
        }

        serviceRights.setId(Integer.parseInt(id));
        serviceRights.setDepartment(department);
        serviceRights.setLocation(location);
        serviceRights.setSap(Integer.parseInt(sap));
        serviceRights.setService1(Integer.parseInt(service1));
        serviceRights.setService2(Integer.parseInt(service2));
        serviceRights.setService3(Integer.parseInt(service3));
        serviceRights.setService4(Integer.parseInt(service4));
        serviceRights.setService5(Integer.parseInt(service5));
        serviceRights.setService6(Integer.parseInt(service6));

        serviceRightsService.update(serviceRights);

        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Service Right edited").setDrow("Y");
        logService.create(lm);

        request.setAttribute("successMessage",
                "Information: Right Updated successfully");
        List list = serviceRightsService.read();
        request.setAttribute("list", list);

        mv.getModelMap().put("list", list);
        mv.setViewName("Right/ServiceRightsList");
        return mv;
    }

    public ModelAndView deleteRightId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String id = request.getParameter("id");
        try {
            RightMaster rightMaster = rightService.read(id);
            rightMaster.setdRow("Y");
            rightService.update(rightMaster);
        } catch (Exception e) {
            session.setAttribute("successMessage", "Information: One or more data deleted successfully");
        }

        mv.setViewName("redirect:right.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteRightAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            RightMaster RightMaster = rightService.read(checkedValues);
            RightMaster.setdRow("Y");
            rightService.update(RightMaster);
        }

        mv.setViewName("redirect:right.htm?act=showList");
        return mv;
    }

    public ModelAndView rightMasterAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "rightName";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "2":
                    orderColumn = "rightName";
                    break;
                default:
                    orderColumn = "rightName";
                    break;
            }
        }

        List list = rightService.getrightMasterPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = rightService.getTotalrightMasterCount();
        int filteredRecords = rightService.getFilteredrightMasterCount(searchValue);
        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            RightMaster rightMaster = (RightMaster) obj;
            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + rightMaster.getRightName() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("rightName", rightMaster.getRightName());
            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='right.htm?act=viewClick&id="
                    + rightMaster.getRightName()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + rightMaster.getRightName() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );
            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

}
