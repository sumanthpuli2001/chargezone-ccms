/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Kaizen;

import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.KaizenApproval;
import com.bul.zydex.model.KaizenApprovalHistory;
import com.bul.zydex.model.KaizenMaster;
import com.bul.zydex.model.UserMaster;
import java.io.File;
import static java.lang.Math.E;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeSet;
import java.util.Vector;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman
 */
public class KaizenMasterController extends KaizenMasterAbstract {

    public ModelAndView myKaizen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Kaizen/myKaizen");
        return mv;
    }

    public ModelAndView kaizenMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> km = kaizenMasterService.readKaizenMasterList(employeeMaster.getId());
//        List<?> km1 = kaizenMasterService.readKaizenMasterapprovalList(employeeMaster.getId());
        mv.getModelMap().put("list", km);
        mv.setViewName("Kaizen/kaizenMasterList");
        return mv;
    }

    public ModelAndView pastKaizenMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> km = kaizenMasterService.readPastKaizenMaster();
//        List<?> km1 = kaizenMasterService.readKaizenMasterapprovalList(employeeMaster.getId());
        mv.getModelMap().put("list", km);
        mv.setViewName("Kaizen/pastKaizenList");

//        Vector v = new Vector();
//        Enumeration e = v.elements();//1.0 v
//        while (e.hasMoreElements()) {
//            Integer i = (Integer) e.nextElement();
//        }
//methodds
//        e.hasMoreElements();
//        e.nextElement();
//        Iterator it2=km.iterator();//
//        it2.hasNext();//methods
//        it2.next();
//        it2.remove();
//        TreeSet t = new TreeSet();
//        t.add("A");
//        t.add("C");
//        t.add("B");
//        
        return mv;
    }
    
     public ModelAndView exportToExcelpastKaizenMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        KaizenMaster kaizenMaster = new KaizenMaster();
         List<?> list = kaizenMasterService.readPastKaizenMaster();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=KaizenList.xls");
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("kaizenMaster", kaizenMaster);
         mv.setViewName("Kaizen/ExportPastKaizen");
//        mv.setViewName("AttendanceRegularization/attendanceRegularizationViewResultExport");
        return mv;
    }

    public ModelAndView kaizenList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> km = kaizenMasterService.readKaizenMaster(employeeMaster.getId());
//        List<?> km1 = kaizenMasterService.readKaizenMasterapprovalList(employeeMaster.getId());
        mv.getModelMap().put("list", km);
        mv.setViewName("Kaizen/kaizenList");
        return mv;
    }

    public ModelAndView kaizenApproverList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        KaizenMaster kaizenMaster = new KaizenMaster();
        List kaizenMaster = new ArrayList();
        List<?> dynCycleList = dynamicApprovalSettingApproverService.getByApproverId(employeeMaster.getId());
        Iterator itr = dynCycleList.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            int dId = (int) next[0];
            int eId = (int) next[1];
            int mId = (int) next[2];
            int da = (int) next[3];
            int dmId = (int) next[4];

            Object flag = request.getAttribute("flag");

            String flag1 = "";
            if (flag != null) {
                flag1 = flag.toString();
            }
            if (!flag1.equals("1")) {
                kaizenMaster = kaizenMasterService.readByDeptIdCompanyNameDesId(dmId);
            } else {
//               leaveDetail1 = (List<?>) request.getAttribute("list1");
            }
        }

//        List<?> km1 = kaizenMasterService.readKaizenMasterapprovalList(employeeMaster.getId());
//        mv.getModelMap().put("list", km1);
        request.setAttribute("list", kaizenMaster);
        mv.setViewName("Kaizen/KaizenApproval");
        return mv;
    }

    public ModelAndView kaizenSubmit(HttpServletRequest request, HttpServletResponse response, KaizenMaster kaizenMaster) throws Exception {
        ModelAndView mv = new ModelAndView();

//        KaizenMaster kaizenMaster = new KaizenMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(4);
        BindException errors = new BindException(kaizenMaster, "kaizenMaster");
        bind(request, kaizenMaster);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDate localDate = LocalDate.now();
        String btnType = request.getParameter("btnType");
        String comment = request.getParameter("comment");
        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(3);
        if (btnType.equals("SUBMIT")) {

            String srNo = request.getParameter("srNo");
            String teamLeader = request.getParameter("teamLeader");
            String teamName = request.getParameter("teamName");
            String ideaGenerator = request.getParameter("ideaGenerator");
            String department = request.getParameter("department");
            String teamMember = request.getParameter("teamMember");
            String problemDescription = request.getParameter("problemDescription");
//        String beforePhoto = request.getParameter("beforePhoto");
            //Storeing Images
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date cDate = new Date();
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("beforePhoto");
            MultipartFile multipartFile1 = multipartRequest.getFile("afterPhoto");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "Kaizen" + File.separator + "beforePhoto" + File.separator;
            File Folder1 = new File(fileLocationURL);
            if (!Folder1.exists()) {
                Folder1.mkdirs();
            }
            String fileLocationURL1 = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "Kaizen" + File.separator + "afterPhoto" + File.separator;

            File Folder2 = new File(fileLocationURL1);
            if (!Folder2.exists()) {
                Folder2.mkdirs();
            }
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile.transferTo(file2);
                    kaizenMaster.setBeforePhoto(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                } catch (Exception e) {

                }
            }
            if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                try {
                    File file2 = new File(fileLocationURL1 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile1.transferTo(file2);
                    kaizenMaster.setAfterPhoto(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                } catch (Exception e) {

                }
            }

            String startDate = request.getParameter("startDate");
            String compiletionDate = request.getParameter("compiletionDate");
            String budgetRequirement = request.getParameter("budgetRequirement");

            String tangibleBenefit = request.getParameter("tangibleBenefit");
            String intangibleBenefit = request.getParameter("intangibleBenefit");
            String horizontalDeployment = request.getParameter("horizontalDeployment");
            String productivity = request.getParameter("productivity");
            String quality = request.getParameter("quality");
            String delivery = request.getParameter("delivery");
            String safety = request.getParameter("safety");
            String cost = request.getParameter("cost");
            String morale = request.getParameter("morale");

            kaizenMaster.setSrNo(srNo);
            kaizenMaster.setTeamLeader(teamLeader);
            kaizenMaster.setTeamName(teamName);
            kaizenMaster.setIdeaGenerator(ideaGenerator);
            kaizenMaster.setDepartment(department);
            kaizenMaster.setTeamMember(teamMember);
            kaizenMaster.setProblemDescription(problemDescription);
            kaizenMaster.setStartDate(startDate);
            kaizenMaster.setCompiletionDate(compiletionDate);
            kaizenMaster.setBudgetRequirement(budgetRequirement);
            kaizenMaster.setTangibleBenefit(tangibleBenefit);
            kaizenMaster.setIntangibleBenefit(intangibleBenefit);
            kaizenMaster.setHorizontalDeployment(horizontalDeployment);
            if (productivity == null) {
                kaizenMaster.setProductivity(0);
            } else {
                kaizenMaster.setProductivity(1);
            }
            if (quality == null) {
                kaizenMaster.setQuality(0);
            } else {
                kaizenMaster.setQuality(1);
            }
            if (delivery == null) {
                kaizenMaster.setDelivery(0);
            } else {
                kaizenMaster.setDelivery(1);
            }
            if (safety == null) {
                kaizenMaster.setSafety(0);
            } else {
                kaizenMaster.setSafety(1);
            }
            if (cost == null) {
                kaizenMaster.setCost(0);
            } else {
                kaizenMaster.setCost(1);
            }
            if (morale == null) {
                kaizenMaster.setMorale(0);
            } else {
                kaizenMaster.setMorale(1);
            }
            kaizenMaster.setCreatedBy(employeeMaster.getId());
            kaizenMaster.setCreatedDate(sdf.format(cDate));
            kaizenMaster.setStatus(0);
//            if ("" != employeeMaster.getReportingManagerLevel1()) {
//                kaizenMaster.setReportingId(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//            }
            EmployeeMaster em = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            String module = "kaizen";
            List<?> cycleCheck = dynamicApprovalSettingApproverService.readByzyLocIdCompnameAndDesId(em.getDepartmentMaster().getId(), module);
            if (!cycleCheck.isEmpty()) {
                int sizeOfLevel = cycleCheck.size();
//                attendanceRegularization.setTotalLevel(sizeOfLevel);
//                attendanceRegularization.setCurrentLevel(1);
                kaizenMaster.setTotalLevel(sizeOfLevel);
                kaizenMaster.setCurrentLevel(1);
                for (Object cycleCheck1 : cycleCheck) {
                    Object[] o = (Object[]) cycleCheck1;
                    int emplid = 0;
                    int dymaicApprover = 0;
                    emplid += (Integer) o[1];
                    dymaicApprover += (Integer) o[0];
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMaster1 = employeeMasterService.readById(emplid);
                        DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                        // id ( Not created id 138) is for Approved User....
                        emailTemplate = emailTemplateService.readById(161);
                        String To = employeeMaster.getEmailAddress();
                        String from = "";
                        String Subject = emailTemplate.getSubject();
                        String msg = emailTemplate.getBodytext();
                        Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                        msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                        sendMail.sendMail(from, To, Subject, msg);
                    } catch (Exception e) {
                    }

                    List<?> cycleCheckEmail = dynamicApprovalSettingEmailService.readByApproverCycleId(dymaicApprover);
                    if (!cycleCheckEmail.isEmpty()) {
                        for (Object cycleCheckEmail1 : cycleCheckEmail) {
                            Object[] o1 = (Object[]) cycleCheckEmail1;
                            int emplid2 = 0;
                            emplid2 += (Integer) o1[0];
//                            EmployeeMaster employeeMaster23 = employeeMasterService.readById(emplid2);
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMaster1 = employeeMasterService.readById(emplid2);
                                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                                // id ( Not created id 138) is for Approved User....
                                emailTemplate = emailTemplateService.readById(161);
                                String To = employeeMaster1.getEmailAddress();
                                String from = "";
                                String Subject = emailTemplate.getSubject();
                                String msg = emailTemplate.getBodytext();
                                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                                sendMail.sendMail(from, To, Subject, msg);
                            } catch (Exception e) {
                            }

                        }
                    }

                }

            }

            kaizenMaster.setComment(comment);
            kaizenMasterService.create(kaizenMaster);

            for (ApprovalUser au : approvalList) {
                KaizenApproval ma = new KaizenApproval();
                ma.setEmployeeMaster(au.getEmployeeMaster());
                ma.setKaizenMaster(kaizenMaster);
                ma.setLevel(au.getLevel());
                ma.setStatus(0);
                kaizenApprovalService.create(ma);

            }

            KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatus(0);
            kaizenApprovalHistory.setStatusMessage("Kaizen Created");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully And Publish This Kizen.");

            mv.setViewName("forward:homeController.htm?act=openHomePage");
            return mv;

//          ---------------------  OnHold Code By Vikas -----------------
        }
//        if (btnType.equals("OnHold")) {
//
//            String srNo = request.getParameter("srNo");
//            String teamLeader = request.getParameter("teamLeader");
//            String teamName = request.getParameter("teamName");
//            String ideaGenerator = request.getParameter("ideaGenerator");
//            String department = request.getParameter("department");
//            String teamMember = request.getParameter("teamMember");
//            String problemDescription = request.getParameter("problemDescription");
////        String beforePhoto = request.getParameter("beforePhoto");
//            //Storeing Images
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            Date cDate = new Date();
//            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//            MultipartFile multipartFile = multipartRequest.getFile("beforePhoto");
//            MultipartFile multipartFile1 = multipartRequest.getFile("afterPhoto");
//            String fileLocationURL = getServletContext().getRealPath("/")
//                    + File.separator + "StorageYard"
//                    + File.separator + "Kaizen" + File.separator + "beforePhoto" + File.separator;
//            File Folder1 = new File(fileLocationURL);
//            if (!Folder1.exists()) {
//                Folder1.mkdirs();
//            }
//            String fileLocationURL1 = getServletContext().getRealPath("/")
//                    + File.separator + "StorageYard"
//                    + File.separator + "Kaizen" + File.separator + "afterPhoto" + File.separator;
//
//            File Folder2 = new File(fileLocationURL1);
//            if (!Folder2.exists()) {
//                Folder2.mkdirs();
//            }
//            if (multipartFile != null && multipartFile.getSize() > 0) {
//                try {
//                    File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
//                    multipartFile.transferTo(file2);
//                    kaizenMaster.setBeforePhoto(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
//                } catch (Exception e) {
//
//                }
//            }
//            if (multipartFile1 != null && multipartFile1.getSize() > 0) {
//                try {
//                    File file2 = new File(fileLocationURL1 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
//                    multipartFile1.transferTo(file2);
//                    kaizenMaster.setAfterPhoto(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
//                } catch (Exception e) {
//
//                }
//            }
//
//            String startDate = request.getParameter("startDate");
//            String compiletionDate = request.getParameter("compiletionDate");
//            String budgetRequirement = request.getParameter("budgetRequirement");
//
//            String tangibleBenefit = request.getParameter("tangibleBenefit");
//            String intangibleBenefit = request.getParameter("intangibleBenefit");
//            String horizontalDeployment = request.getParameter("horizontalDeployment");
//            String productivity = request.getParameter("productivity");
//            String quality = request.getParameter("quality");
//            String delivery = request.getParameter("delivery");
//            String safety = request.getParameter("safety");
//            String cost = request.getParameter("cost");
//            String morale = request.getParameter("morale");
//
//            kaizenMaster.setSrNo(srNo);
//            kaizenMaster.setTeamLeader(teamLeader);
//            kaizenMaster.setTeamName(teamName);
//            kaizenMaster.setIdeaGenerator(ideaGenerator);
//            kaizenMaster.setDepartment(department);
//            kaizenMaster.setTeamMember(teamMember);
//            kaizenMaster.setProblemDescription(problemDescription);
//            kaizenMaster.setStartDate(startDate);
//            kaizenMaster.setCompiletionDate(compiletionDate);
//            kaizenMaster.setBudgetRequirement(budgetRequirement);
//            kaizenMaster.setTangibleBenefit(tangibleBenefit);
//            kaizenMaster.setIntangibleBenefit(intangibleBenefit);
//            kaizenMaster.setHorizontalDeployment(horizontalDeployment);
//            if (productivity == null) {
//                kaizenMaster.setProductivity(0);
//            } else {
//                kaizenMaster.setProductivity(1);
//            }
//            if (quality == null) {
//                kaizenMaster.setQuality(0);
//            } else {
//                kaizenMaster.setQuality(1);
//            }
//            if (delivery == null) {
//                kaizenMaster.setDelivery(0);
//            } else {
//                kaizenMaster.setDelivery(1);
//            }
//            if (safety == null) {
//                kaizenMaster.setSafety(0);
//            } else {
//                kaizenMaster.setSafety(1);
//            }
//            if (cost == null) {
//                kaizenMaster.setCost(0);
//            } else {
//                kaizenMaster.setCost(1);
//            }
//            if (morale == null) {
//                kaizenMaster.setMorale(0);
//            } else {
//                kaizenMaster.setMorale(1);
//            }
//            kaizenMaster.setCreatedBy(employeeMaster.getId());
//            kaizenMaster.setCreatedDate(sdf.format(cDate));
//            kaizenMaster.setStatus(11);
//            if ("" != employeeMaster.getReportingManagerLevel1()) {
//                kaizenMaster.setReportingId(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//            }
//            kaizenMaster.setTotalLevel(0);
//            kaizenMaster.setCurrentLevel(0);
//            kaizenMaster.setComment(comment);
//            kaizenMasterService.create(kaizenMaster);
//
//            KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
//            kaizenApprovalHistory.setComment(comment);
//            kaizenApprovalHistory.setStatus(11);
//            kaizenApprovalHistory.setStatusMessage("Kaizen Created");
//            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
//            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
//            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
//            kaizenApprovalHistoryService.create(kaizenApprovalHistory);
//
//            request.setAttribute("successMessage",
//                    "Information : The Information is saved Successfully.");
//
//        }
        mv.setViewName("forward:homeController.htm?act=openHomePage");
        return mv;
    }

    public ModelAndView editKaizenSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        BindException errors = new BindException(kaizenMaster, "kaizenMaster");
        bind(request, kaizenMaster);

        String srNo = request.getParameter("srNo");
        String teamLeader = request.getParameter("teamLeader");
        String teamName = request.getParameter("teamName");
        String ideaGenerator = request.getParameter("ideaGenerator");
        String department = request.getParameter("department");
        String teamMember = request.getParameter("teamMember");
        String problemDescription = request.getParameter("problemDescription");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date cDate = new Date();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("beforePhoto");
        MultipartFile multipartFile1 = multipartRequest.getFile("afterPhoto");
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "Kaizen" + File.separator + "beforePhoto" + File.separator;
        File Folder1 = new File(fileLocationURL);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        String fileLocationURL1 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "Kaizen" + File.separator + "afterPhoto" + File.separator;

        File Folder2 = new File(fileLocationURL1);
        if (!Folder2.exists()) {
            Folder2.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                kaizenMaster.setBeforePhoto(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
        if (multipartFile1 != null && multipartFile1.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL1 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile1.transferTo(file2);
                kaizenMaster.setAfterPhoto(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }

        String startDate = request.getParameter("startDate");
        String compiletionDate = request.getParameter("compiletionDate");
        String budgetRequirement = request.getParameter("budgetRequirement");

        String tangibleBenefit = request.getParameter("tangibleBenefit");
        String intangibleBenefit = request.getParameter("intangibleBenefit");
        String horizontalDeployment = request.getParameter("horizontalDeployment");
        String productivity = request.getParameter("productivity");
        String quality = request.getParameter("quality");
        String delivery = request.getParameter("delivery");
        String safety = request.getParameter("safety");
        String cost = request.getParameter("cost");
        String morale = request.getParameter("morale");

        kaizenMaster.setSrNo(srNo);
        kaizenMaster.setTeamLeader(teamLeader);
        kaizenMaster.setTeamName(teamName);
        kaizenMaster.setIdeaGenerator(ideaGenerator);
        kaizenMaster.setDepartment(department);
        kaizenMaster.setTeamMember(teamMember);
        kaizenMaster.setProblemDescription(problemDescription);
        kaizenMaster.setStartDate(startDate);
        kaizenMaster.setCompiletionDate(compiletionDate);
        kaizenMaster.setBudgetRequirement(budgetRequirement);
        kaizenMaster.setTangibleBenefit(tangibleBenefit);
        kaizenMaster.setIntangibleBenefit(intangibleBenefit);
        kaizenMaster.setHorizontalDeployment(horizontalDeployment);
        if (productivity == null) {
            kaizenMaster.setProductivity(0);
        } else {
            kaizenMaster.setProductivity(1);
        }
        if (quality == null) {
            kaizenMaster.setQuality(0);
        } else {
            kaizenMaster.setQuality(1);
        }
        if (delivery == null) {
            kaizenMaster.setDelivery(0);
        } else {
            kaizenMaster.setDelivery(1);
        }
        if (safety == null) {
            kaizenMaster.setSafety(0);
        } else {
            kaizenMaster.setSafety(1);
        }
        if (cost == null) {
            kaizenMaster.setCost(0);
        } else {
            kaizenMaster.setCost(1);
        }
        if (morale == null) {
            kaizenMaster.setMorale(0);
        } else {
            kaizenMaster.setMorale(1);
        }
        kaizenMaster.setStatus(0);
        kaizenMaster.setReportingId(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        kaizenMaster.setTotalLevel(0);
        kaizenMaster.setCurrentLevel(0);
        kaizenMasterService.update(kaizenMaster);

        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
        kaizenApprovalHistory.setComment("Kaizen Edit");
        kaizenApprovalHistory.setStatus(0);
        kaizenApprovalHistory.setStatusMessage("Kaizen Edit");
        kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
        kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
        kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
        kaizenApprovalHistoryService.create(kaizenApprovalHistory);

        request.setAttribute("successMessage",
                "Information : The Information is Updated Successfully.");
        mv = kaizenMasterList(request, response);
//        mv.setViewName("forward:homeController.htm?act=kaizenMasterList");

        return mv;
    }

    public ModelAndView viewKaizen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = new KaizenMaster();
        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
        List<?> KaizenHistory = kaizenApprovalHistoryService.readByKaizenId(Integer.parseInt(id));
        kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
//        List<?> approvalUser = approvalUserService.readByapprovalId(3);
//        mv.getModelMap().put("listAu", approvalUser);
        mv.getModelMap().put("list", kaizenMaster);
        mv.getModelMap().put("listKh", KaizenHistory);
        mv.setViewName("Kaizen/ViewKaizen");
        return mv;
    }

    public ModelAndView reportingViewKaizen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = new KaizenMaster();
        kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        List<?> KaizenHistory = kaizenApprovalHistoryService.readByKaizenId(Integer.parseInt(id));
        List<?> approvalUser = approvalUserService.readByapprovalId(3);
        mv.getModelMap().put("listAu", approvalUser);
        mv.getModelMap().put("list", kaizenMaster);
        mv.getModelMap().put("listKh", KaizenHistory);
        mv.setViewName("Kaizen/ReportingKaizenViewAndSubmit");
        return mv;
    }

    public ModelAndView editKaizen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = new KaizenMaster();
        kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("list", kaizenMaster);
        mv.setViewName("Kaizen/EditKaizen");
        return mv;
    }

    public ModelAndView editKaizenafterApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = new KaizenMaster();
        kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("list", kaizenMaster);
        mv.setViewName("Kaizen/Editkaizenafterapproval");
        return mv;
    }

    public ModelAndView viewKaizenApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = new KaizenMaster();
        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
//        List<?> approvalUser = approvalUserService.readByapprovalId(3);
        List<?> KaizenHistory = kaizenApprovalHistoryService.readByKaizenId(Integer.parseInt(id));
        kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("list", kaizenMaster);
        mv.getModelMap().put("listKh", KaizenHistory);
//        mv.getModelMap().put("listAu", approvalUser);
        mv.setViewName("Kaizen/ViewKaizenApproval");
        return mv;
    }

    public ModelAndView viewApproveKaizenSumbit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = new KaizenMaster();
        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
//        List<?> approvalUser = approvalUserService.readByapprovalId(3);
        List<?> KaizenHistory = kaizenApprovalHistoryService.readByKaizenId(Integer.parseInt(id));
        kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("list", kaizenMaster);
        mv.getModelMap().put("listKh", KaizenHistory);
//        mv.getModelMap().put("listAu", approvalUser);
        mv.setViewName("Kaizen/viewApproveKaizenSumbit");
        return mv;
    }

    public ModelAndView kaizenApprovalReporting(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String id = request.getParameter("id");
        String btnType = request.getParameter("btnType");
        String comment = request.getParameter("comment");
        KaizenMaster kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
//        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(3);

//        KaizenApproval kaizenApproval = kaizenApprovalService.readByIdAndEmp(kaizenMaster.getId(), employeeMaster.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date cDate = new Date();

        if (btnType.equals("Approve")) {

//            kaizenMaster.setTotalLevel(approvalList.size());
//            kaizenMaster.setCurrentLevel(1);
            kaizenMaster.setStatus(1);
            kaizenMaster.setUpdatedBy(employeeMaster.getId());
            kaizenMaster.setUpdatedDate(sdf.format(cDate));
            kaizenMaster.setCompiletionDate(sdf.format(cDate));

            kaizenMasterService.update(kaizenMaster);

//            for (ApprovalUser au : approvalList) {
//                KaizenApproval kaizenApproval = new KaizenApproval();
//                kaizenApproval.setEmployeeMaster(au.getEmployeeMaster());
//                kaizenApproval.setComment(comment);
//                kaizenApproval.setKaizenMaster(kaizenMaster);
//                kaizenApproval.setLevel(au.getLevel());
//                kaizenApprovalService.create(kaizenApproval);
            KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatus(1);
            kaizenApprovalHistory.setStatusMessage("Kaizen Approve");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);
//            }
            request.setAttribute("successMessage",
                    "Information : The request is Approved Successfully.");

            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
// id ( Not created id 138) is for Approved User....
                emailTemplate = emailTemplateService.readById(144);
                String To = employeeMaster.getEmailAddress();
                String from = "";
                String Subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
        }
        if (btnType.equals("Recycle")) {

            kaizenMaster.setStatus(2);
            kaizenMaster.setUpdatedBy(employeeMaster.getId());
            kaizenMaster.setUpdatedDate(sdf.format(cDate));
            kaizenMasterService.update(kaizenMaster);

            KaizenApproval kaizenApproval = new KaizenApproval();
            kaizenApproval.setKaizenMaster(kaizenMaster);
            kaizenApproval.setComment(comment);
            kaizenApproval.setCreatedBy(employeeMaster.getId());
            kaizenApproval.setCreatedDate(sdf.format(cDate));
            kaizenApprovalService.create(kaizenApproval);

            KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatus(2);
            kaizenApprovalHistory.setStatusMessage("Kaizen Recycled");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The request is Recycled Successfully.");

            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                // id ( Not created id 138) is for Approved User....
                emailTemplate = emailTemplateService.readById(145);
                String To = employeeMaster.getEmailAddress();
                String from = "";
                String Subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }

        }
        if (btnType.equals("Reject")) {

            kaizenMaster.setStatus(3);
            kaizenMaster.setUpdatedBy(employeeMaster.getId());
            kaizenMaster.setUpdatedDate(sdf.format(cDate));
            kaizenMasterService.update(kaizenMaster);

            KaizenApproval kaizenApproval = new KaizenApproval();
            kaizenApproval.setKaizenMaster(kaizenMaster);
            kaizenApproval.setComment(comment);
            kaizenApproval.setCreatedBy(employeeMaster.getId());
            kaizenApproval.setCreatedDate(sdf.format(cDate));
            kaizenApprovalService.create(kaizenApproval);

            KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatus(3);
            kaizenApprovalHistory.setStatusMessage("Kaizen Rejected");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The request is Reject Successfully.");

            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                // id ( Not created id 138) is for Approved User....
                emailTemplate = emailTemplateService.readById(146);
                String To = employeeMaster.getEmailAddress();
                String from = "";
                String Subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
        }
//        if (btnType.equals("OnHold")) {
//
//            kaizenMaster.setStatus(10);
//            kaizenMaster.setUpdatedBy(employeeMaster.getId());
//            kaizenMaster.setUpdatedDate(sdf.format(cDate));
//            kaizenMasterService.update(kaizenMaster);
//
//            KaizenApproval kaizenApproval = new KaizenApproval();
//            kaizenApproval.setKaizenMaster(kaizenMaster);
//            kaizenApproval.setComment(comment);
//            kaizenApproval.setCreatedBy(employeeMaster.getId());
//            kaizenApproval.setCreatedDate(sdf.format(cDate));
//            kaizenApprovalService.create(kaizenApproval);
//
//            KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
//            kaizenApprovalHistory.setComment(btnType);
//            kaizenApprovalHistory.setStatus(10);
//            kaizenApprovalHistory.setStatusMessage("Kaizen OnHold");
//            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
//            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
//            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
//            kaizenApprovalHistoryService.create(kaizenApprovalHistory);
//
//            request.setAttribute("successMessage",
//                    "Information : The request is OnHold Successfully.");
//
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
//                // id ( Not created id 138) is for Approved User....
//                emailTemplate = emailTemplateService.readById(160);
//                String To = employeeMaster.getEmailAddress();
//                String from = "";
//                String Subject = emailTemplate.getSubject();
//                String msg = emailTemplate.getBodytext();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//            }
//        }

        mv = kaizenList(request, response);

        return mv;
    }

    public ModelAndView kaizenApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String id = request.getParameter("id");
        String btnType = request.getParameter("btnType");
        String comment = request.getParameter("comment");
        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(3);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        KaizenMaster kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
//        KaizenApproval kaizenApproval = kaizenApprovalService.readByIdAndEmp(kaizenMaster.getId(), employeeMaster.getId());

//        int userLevel = kaizenApproval.getLevel();
//        int currentLevel = kaizenMaster.getCurrentLevel();
//        int totalLevel = kaizenMaster.getTotalLevel();
        if (btnType.equals("Approve")) {

            for (ApprovalUser au : approvalList) {
                KaizenApproval ma = new KaizenApproval();
                ma.setEmployeeMaster(au.getEmployeeMaster());
                ma.setKaizenMaster(kaizenMaster);
                ma.setLevel(au.getLevel());
                ma.setStatus(0);
//                kaizenApprovalService.create(ma);
//                try {
//                        EmailTemplate emailTemplate = new EmailTemplate();
//                        EmployeeMaster employeeMaster1 = employeeMasterService.readById(au.getEmployeeMaster().getId());
//                        DesignationMaster designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
//                        // id ( Not created id 138) is for Approved User....
//                        emailTemplate = emailTemplateService.readById(161);
//                        String To = employeeMaster.getOfficeEmailId();
//                        String from = "";
//                        String Subject = emailTemplate.getSubject();
//                        String msg = emailTemplate.getBodytext();
//                        Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                        msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
//                        msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                        sendMail.sendMail(from, To, Subject, msg);
//                    } catch (Exception e) {
//                    }

            }

            kaizenMaster.setStatus(1);
//            kaizenMaster.setCompiletionDate(sdf1.format(cDate));
            kaizenMasterService.update(kaizenMaster);
//            kaizenApprovalService.update(kaizenApproval);

            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatusMessage("Approved");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The request is Approved Successfully.");

//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
//                // id ( Not created id 138) is for Approved User....
//                emailTemplate = emailTemplateService.readById(144);
//                String To = employeeMaster.getOfficeEmailId();
//                String from = "";
//                String Subject = emailTemplate.getSubject();
//                String msg = emailTemplate.getBodytext();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//            }
        }

        if (btnType.equals("Recycle")) {
//            if (userLevel > 1) {
            kaizenMaster.setStatus(2);
//                kaizenApprovalHistory.setStatus(2);
//                kaizenMaster.setCurrentLevel(currentLevel - 1);
//
//            } else {
//                kaizenMaster.setStatus(2);
//                kaizenApprovalHistory.setStatus(2);
//                kaizenMaster.setCurrentLevel(currentLevel - 1);

//            }
//            kaizenApproval.setComment(comment);
            kaizenMasterService.update(kaizenMaster);
//            kaizenApprovalService.update(kaizenApproval);

            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatusMessage("Recycled");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The request is Recycled Successfully.");
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
//                // id ( Not created id 138) is for Approved User....
//                emailTemplate = emailTemplateService.readById(145);
//                String To = employeeMaster.getOfficeEmailId();
//                String from = "";
//                String Subject = emailTemplate.getSubject();
//                String msg = emailTemplate.getBodytext();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//            }
        }

        if (btnType.equals("Reject")) {
            kaizenMaster.setStatus(3);
            kaizenApprovalHistory.setStatus(3);
//            kaizenApproval.setComment(comment);

            kaizenMasterService.update(kaizenMaster);
//            kaizenApprovalService.update(kaizenApproval);

            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatusMessage("Rejected");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The request is Reject Successfully.");

//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
//                // id ( Not created id 138) is for Approved User....
//                emailTemplate = emailTemplateService.readById(146);
//                String To = employeeMaster.getEmailAddress();
//                String from = "";
//                String Subject = emailTemplate.getSubject();
//                String msg = emailTemplate.getBodytext();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//            }
        }
//        if (btnType.equals("OnHold")) {
//            kaizenMaster.setStatus(10);
//            kaizenApprovalHistory.setStatus(10);
//            kaizenApproval.setComment(comment);
//
//            kaizenMasterService.update(kaizenMaster);
//            kaizenApprovalService.update(kaizenApproval);
//
//            kaizenApprovalHistory.setComment(comment);
//            kaizenApprovalHistory.setStatusMessage(btnType);
//            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
//            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
//            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
//            kaizenApprovalHistoryService.create(kaizenApprovalHistory);
//
//            request.setAttribute("successMessage",
//                    "Information : The request is OnHold Successfully.");
//
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
//                // id ( Not created id 138) is for Approved User....
//                emailTemplate = emailTemplateService.readById(160);
//                String To = employeeMaster.getEmailAddress();
//                String from = "";
//                String Subject = emailTemplate.getSubject();
//                String msg = emailTemplate.getBodytext();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//            }
//        }

        mv = kaizenApproverList(request, response);

        return mv;

    }

    public ModelAndView onholdOpen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = new KaizenMaster();
        kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("list", kaizenMaster);
        mv.setViewName("Kaizen/EditOnholdKaizen");
        return mv;
    }

    public ModelAndView OnHoldKaizenSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        KaizenMaster kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        BindException errors = new BindException(kaizenMaster, "kaizenMaster");
        bind(request, kaizenMaster);

        String srNo = request.getParameter("srNo");
        String teamLeader = request.getParameter("teamLeader");
        String teamName = request.getParameter("teamName");
        String ideaGenerator = request.getParameter("ideaGenerator");
        String department = request.getParameter("department");
        String teamMember = request.getParameter("teamMember");
        String problemDescription = request.getParameter("problemDescription");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date cDate = new Date();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("beforePhoto");
        MultipartFile multipartFile1 = multipartRequest.getFile("afterPhoto");
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "Kaizen" + File.separator + "beforePhoto" + File.separator;
        File Folder1 = new File(fileLocationURL);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        String fileLocationURL1 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "Kaizen" + File.separator + "afterPhoto" + File.separator;

        File Folder2 = new File(fileLocationURL1);
        if (!Folder2.exists()) {
            Folder2.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                kaizenMaster.setBeforePhoto(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
        if (multipartFile1 != null && multipartFile1.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL1 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile1.transferTo(file2);
                kaizenMaster.setAfterPhoto(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }

        String startDate = request.getParameter("startDate");
        String compiletionDate = request.getParameter("compiletionDate");
        String budgetRequirement = request.getParameter("budgetRequirement");

        String tangibleBenefit = request.getParameter("tangibleBenefit");
        String intangibleBenefit = request.getParameter("intangibleBenefit");
        String horizontalDeployment = request.getParameter("horizontalDeployment");
        String productivity = request.getParameter("productivity");
        String quality = request.getParameter("quality");
        String delivery = request.getParameter("delivery");
        String safety = request.getParameter("safety");
        String cost = request.getParameter("cost");
        String morale = request.getParameter("morale");

        kaizenMaster.setSrNo(srNo);
        kaizenMaster.setTeamLeader(teamLeader);
        kaizenMaster.setTeamName(teamName);
        kaizenMaster.setIdeaGenerator(ideaGenerator);
        kaizenMaster.setDepartment(department);
        kaizenMaster.setTeamMember(teamMember);
        kaizenMaster.setProblemDescription(problemDescription);
        kaizenMaster.setStartDate(startDate);
        kaizenMaster.setCompiletionDate(compiletionDate);
        kaizenMaster.setBudgetRequirement(budgetRequirement);
        kaizenMaster.setTangibleBenefit(tangibleBenefit);
        kaizenMaster.setIntangibleBenefit(intangibleBenefit);
        kaizenMaster.setHorizontalDeployment(horizontalDeployment);
        if (productivity == null) {
            kaizenMaster.setProductivity(0);
        } else {
            kaizenMaster.setProductivity(1);
        }
        if (quality == null) {
            kaizenMaster.setQuality(0);
        } else {
            kaizenMaster.setQuality(1);
        }
        if (delivery == null) {
            kaizenMaster.setDelivery(0);
        } else {
            kaizenMaster.setDelivery(1);
        }
        if (safety == null) {
            kaizenMaster.setSafety(0);
        } else {
            kaizenMaster.setSafety(1);
        }
        if (cost == null) {
            kaizenMaster.setCost(0);
        } else {
            kaizenMaster.setCost(1);
        }
        if (morale == null) {
            kaizenMaster.setMorale(0);
        } else {
            kaizenMaster.setMorale(1);
        }
        kaizenMaster.setStatus(0);
        if ("" != employeeMaster.getReportingManagerLevel1()) {
            kaizenMaster.setReportingId(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        }
        kaizenMaster.setTotalLevel(0);
        kaizenMaster.setCurrentLevel(0);
        kaizenMaster.setComment(comment);
        kaizenMasterService.update(kaizenMaster);

        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
        kaizenApprovalHistory.setComment(comment);
        kaizenApprovalHistory.setStatus(0);
        kaizenApprovalHistory.setStatusMessage("Kaizen Onhold After Published");
        kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
        kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
        kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
        kaizenApprovalHistoryService.create(kaizenApprovalHistory);

        request.setAttribute("successMessage",
                "Information : The Information is Updated Successfully.");
        mv = kaizenMasterList(request, response);

        return mv;
    }

    public ModelAndView editKaizenSubmitAfterApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        BindException errors = new BindException(kaizenMaster, "kaizenMaster");
        bind(request, kaizenMaster);

        String srNo = request.getParameter("srNo");
        String teamLeader = request.getParameter("teamLeader");
        String teamName = request.getParameter("teamName");
        String ideaGenerator = request.getParameter("ideaGenerator");
        String department = request.getParameter("department");
        String teamMember = request.getParameter("teamMember");
        String problemDescription = request.getParameter("problemDescription");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date cDate = new Date();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("beforePhoto");
        MultipartFile multipartFile1 = multipartRequest.getFile("afterPhoto");
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "Kaizen" + File.separator + "beforePhoto" + File.separator;
        File Folder1 = new File(fileLocationURL);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        String fileLocationURL1 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "Kaizen" + File.separator + "afterPhoto" + File.separator;

        File Folder2 = new File(fileLocationURL1);
        if (!Folder2.exists()) {
            Folder2.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                kaizenMaster.setBeforePhoto(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
        if (multipartFile1 != null && multipartFile1.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL1 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile1.transferTo(file2);
                kaizenMaster.setAfterPhoto(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }

        String startDate = request.getParameter("startDate");
        String compiletionDate = request.getParameter("compiletionDate");
        String budgetRequirement = request.getParameter("budgetRequirement");

        String tangibleBenefit = request.getParameter("tangibleBenefit");
        String intangibleBenefit = request.getParameter("intangibleBenefit");
        String horizontalDeployment = request.getParameter("horizontalDeployment");
        String productivity = request.getParameter("productivity");
        String quality = request.getParameter("quality");
        String delivery = request.getParameter("delivery");
        String safety = request.getParameter("safety");
        String cost = request.getParameter("cost");
        String morale = request.getParameter("morale");

        kaizenMaster.setSrNo(srNo);
        kaizenMaster.setTeamLeader(teamLeader);
        kaizenMaster.setTeamName(teamName);
        kaizenMaster.setIdeaGenerator(ideaGenerator);
        kaizenMaster.setDepartment(department);
        kaizenMaster.setTeamMember(teamMember);
        kaizenMaster.setProblemDescription(problemDescription);
        kaizenMaster.setStartDate(startDate);
        kaizenMaster.setCompiletionDate(compiletionDate);
        kaizenMaster.setBudgetRequirement(budgetRequirement);
        kaizenMaster.setTangibleBenefit(tangibleBenefit);
        kaizenMaster.setIntangibleBenefit(intangibleBenefit);
        kaizenMaster.setHorizontalDeployment(horizontalDeployment);
        if (productivity == null) {
            kaizenMaster.setProductivity(0);
        } else {
            kaizenMaster.setProductivity(1);
        }
        if (quality == null) {
            kaizenMaster.setQuality(0);
        } else {
            kaizenMaster.setQuality(1);
        }
        if (delivery == null) {
            kaizenMaster.setDelivery(0);
        } else {
            kaizenMaster.setDelivery(1);
        }
        if (safety == null) {
            kaizenMaster.setSafety(0);
        } else {
            kaizenMaster.setSafety(1);
        }
        if (cost == null) {
            kaizenMaster.setCost(0);
        } else {
            kaizenMaster.setCost(1);
        }
        if (morale == null) {
            kaizenMaster.setMorale(0);
        } else {
            kaizenMaster.setMorale(1);
        }
        kaizenMaster.setStatus(1);
        kaizenMaster.setReportingId(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        kaizenMaster.setTotalLevel(0);
        kaizenMaster.setCurrentLevel(0);
        kaizenMasterService.update(kaizenMaster);

        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
        kaizenApprovalHistory.setComment("Kaizen Edit");
        kaizenApprovalHistory.setStatus(1);
        kaizenApprovalHistory.setStatusMessage("Kaizen Edit");
        kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
        kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
        kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
        kaizenApprovalHistoryService.create(kaizenApprovalHistory);

        request.setAttribute("successMessage",
                "Information : The Information is Updated Successfully.");
        mv = kaizenMasterList(request, response);
//        mv.setViewName("forward:homeController.htm?act=kaizenMasterList");

        return mv;
    }

    public ModelAndView kaizenSteeringApproval(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        ModelAndView mv = new ModelAndView();
        KaizenApproval kaizenApproval = new KaizenApproval();
//        List<?> list = mprMasterService.readMprList();

        List<?> list = kaizenApprovalService.readApprovalSteeringCommitteList(employeeMaster.getId());
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("kaizenApproval", kaizenApproval);
//        mv.setViewName("Recruitment/ApprovalRecruitment");
        mv.setViewName("Kaizen/KaizenSteeringCommite");
        return mv;
    }

    public ModelAndView viewSteeringApproveKaizenSumbit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        KaizenMaster kaizenMaster = new KaizenMaster();
        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
//        List<?> approvalUser = approvalUserService.readByapprovalId(3);
        List<?> KaizenHistory = kaizenApprovalHistoryService.readByKaizenId(Integer.parseInt(id));
        kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("list", kaizenMaster);
        mv.getModelMap().put("listKh", KaizenHistory);
//        mv.getModelMap().put("listAu", approvalUser);
        mv.setViewName("Kaizen/ViewSterringKaizenSubmit");

        return mv;
    }

    public ModelAndView kaizenSteeringCommitteApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        KaizenApprovalHistory kaizenApprovalHistory = new KaizenApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String id = request.getParameter("id");
        String btnType = request.getParameter("btnType");
        String comment = request.getParameter("comment");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        KaizenMaster kaizenMaster = kaizenMasterService.readById(Integer.parseInt(id));
//        KaizenApproval kaizenApproval = kaizenApprovalService.readByIdAndEmp(kaizenMaster.getId(), employeeMaster.getId());

//        int userLevel = kaizenApproval.getLevel();
//        int currentLevel = kaizenMaster.getCurrentLevel();
//        int totalLevel = kaizenMaster.getTotalLevel();
        if (btnType.equals("Approve")) {
//            if (userLevel == totalLevel) {
//                kaizenMaster.setStatus(5);
//                kaizenApprovalHistory.setStatus(5);
//            } else {
//                kaizenMaster.setStatus(4);
//                kaizenApprovalHistory.setStatus(4);
//                kaizenMaster.setCurrentLevel(currentLevel + 1);
//            }
//            kaizenApproval.setComment(comment);
            kaizenMaster.setStatus(21);
            kaizenMaster.setCompiletionDate(sdf1.format(cDate));
            kaizenMasterService.update(kaizenMaster);
//            kaizenApprovalService.update(kaizenApproval);

            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatusMessage("Approved");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The request is Approved Successfully.");

            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                // id ( Not created id 138) is for Approved User....
                emailTemplate = emailTemplateService.readById(144);
                String To = employeeMaster.getOfficeEmailId();
                String from = "";
                String Subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
        }

        if (btnType.equals("Recycle")) {
//            if (userLevel > 1) {
            kaizenMaster.setStatus(22);
//                kaizenApprovalHistory.setStatus(2);
//                kaizenMaster.setCurrentLevel(currentLevel - 1);
//
//            } else {
//                kaizenMaster.setStatus(2);
//                kaizenApprovalHistory.setStatus(2);
//                kaizenMaster.setCurrentLevel(currentLevel - 1);

//            }
//            kaizenApproval.setComment(comment);
            kaizenMasterService.update(kaizenMaster);
//            kaizenApprovalService.update(kaizenApproval);

            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatusMessage("Recycled");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The request is Recycled Successfully.");
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                // id ( Not created id 138) is for Approved User....
                emailTemplate = emailTemplateService.readById(145);
                String To = employeeMaster.getOfficeEmailId();
                String from = "";
                String Subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
        }

        if (btnType.equals("Reject")) {
            kaizenMaster.setStatus(23);
//            kaizenApprovalHistory.setStatus(3);
//            kaizenApproval.setComment(comment);

            kaizenMasterService.update(kaizenMaster);
//            kaizenApprovalService.update(kaizenApproval);

            kaizenApprovalHistory.setComment(comment);
            kaizenApprovalHistory.setStatusMessage("Rejected");
            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
            kaizenApprovalHistoryService.create(kaizenApprovalHistory);

            request.setAttribute("successMessage",
                    "Information : The request is Reject Successfully.");

            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                // id ( Not created id 138) is for Approved User....
                emailTemplate = emailTemplateService.readById(146);
                String To = employeeMaster.getOfficeEmailId();
                String from = "";
                String Subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
        }
//        if (btnType.equals("OnHold")) {
//            kaizenMaster.setStatus(10);
//            kaizenApprovalHistory.setStatus(10);
//            kaizenApproval.setComment(comment);
//
//            kaizenMasterService.update(kaizenMaster);
//            kaizenApprovalService.update(kaizenApproval);
//
//            kaizenApprovalHistory.setComment(comment);
//            kaizenApprovalHistory.setStatusMessage(btnType);
//            kaizenApprovalHistory.setKaizenMaster(kaizenMaster);
//            kaizenApprovalHistory.setCreatedBy(employeeMaster.getEmployeeName());
//            kaizenApprovalHistory.setCreatedDate(sdf.format(cDate));
//            kaizenApprovalHistoryService.create(kaizenApprovalHistory);
//
//            request.setAttribute("successMessage",
//                    "Information : The request is OnHold Successfully.");
//
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
//                // id ( Not created id 138) is for Approved User....
//                emailTemplate = emailTemplateService.readById(160);
//                String To = employeeMaster.getEmailAddress();
//                String from = "";
//                String Subject = emailTemplate.getSubject();
//                String msg = emailTemplate.getBodytext();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//            }
//        }

        mv = kaizenSteeringApproval(request, response);

        return mv;

    }

    public ModelAndView exportToExcelLeaveBalance(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        Map<Integer, List<?>> sessionMapOfLeaveBalance = (Map<Integer, List<?>>) request.getSession().getAttribute("sessionMapOfLeaveBalance");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeLeaveBalanceData.xls");
        mv.addObject("sessionMapOfLeaveBalance", sessionMapOfLeaveBalance);
        mv.setViewName("Leave/LeaveBalanceEmployeeWiseExportToExcel");
       
        return mv;
    }
}
