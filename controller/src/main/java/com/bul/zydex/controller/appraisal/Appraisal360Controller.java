/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisal;

import com.bul.zydex.model.AppraisalFeedback360;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserMaster;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhruv
 */
public class Appraisal360Controller extends Appraisal360Abstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        selectEmployee1(request, response);
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        selectedEmployeeFor360Feedback(request, employeeMaster);
//        List<Object> list = new ArrayList<Object>();
//        selectedEmployeeFor360Feedback1(request, list);
        yearList(request);
        mv.getModelMap().put("appraisal360", appraisal360);
        mv.setViewName("Appraisal/Appraisal360FeedbackFormCreate");

        return mv;
    }

    public void employeeAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int empId = Integer.parseInt(request.getParameter("empId"));
        List<?> list = employeeMasterService.readEmployeeAjax(empId);
        String listString = "";

        String tempStr = "";
        Object[] arrayOfObject;

        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "" + arrayOfObject[0]
                    + "/" + arrayOfObject[1]
                    + "/" + arrayOfObject[2]
                    + "/" + arrayOfObject[3]
                    + "/" + arrayOfObject[4]
                    + "/" + arrayOfObject[5] + "";
        }

        PrintWriter out = response.getWriter();
        out.write(tempStr);

    }

    public ModelAndView submitAppraisal360HR(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        BindException errors = new BindException(appraisal360, "appraisal360");
        bind(request, appraisal360);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        EmployeeMaster employeeMaster3 = new EmployeeMaster();
        String[] doneId = request.getParameterValues("employeeMasterByRefDoneEmpId");
        String forId = request.getParameter("employeeMasterByRefForEmpId");
        String feedBackYear = request.getParameter("cycleYear");
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        user.getId();
        employeeMaster2.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster2);
        if (!empId.isEmpty()) {
            employeeMaster2 = (EmployeeMaster) empId.get(0);
            employeeMaster2.getId();
        }

        String[] doneId1 = doneId[0].split(",");
        int len = 0;
        boolean flag = false;
        if (null != doneId1[0] && !"".equals(doneId1[0])) {
            len = doneId1.length;
            flag = true;
        }
        if (flag) {
            for (int i = 0; i < len; i++) {
                if (!"".equals(forId)) {
                    employeeMaster2.setId(employeeMaster2.getId());
                    employeeMaster1.setId(Integer.parseInt(forId));
                    employeeMaster.setId(Integer.parseInt(doneId1[i]));
                    appraisal360.setEmployeeMasterByRefForEmpId(employeeMaster1);
                    appraisal360.setEmployeeMasterByRefDoneEmpId(employeeMaster);
                    appraisal360.setEmployeeMasterByHrCreatorId(employeeMaster2);

                    if (appraisal360.getRemarkEmp() == null || appraisal360.getRemarkHr() == null || appraisal360.getId() == null) {
                        appraisal360.setRemarkEmp(" ");
                        appraisal360.setRemarkHr(" ");
                        appraisal360.setId(0);
                    }
                }
                appraisal360Validator.validate(appraisal360, errors);
                if (errors.hasErrors()) {
                    request.setAttribute("failureMessage",
                            "Error : The Entered Information is not valid.");
                    mv.addAllObjects(errors.getModel());
                    selectEmployee1(request, response);
                    mv.setViewName("Appraisal/Appraisal360FeedbackFormCreate");
                    break;
                } else if (appraisal360.getEmployeeMasterByRefForEmpId().getId() == appraisal360.getEmployeeMasterByRefDoneEmpId().getId()) {
                    request.setAttribute("failureMessage",
                            "Error : The Entered Information is not valid.");
                    mv = createClick(request, response);
                    break;
                } else {
                    appraisal360.setFeedbackYear(feedBackYear);
                    appraisal360Service.create(appraisal360);

                    request.setAttribute("successMessage",
                            "Information : The Information is saved Successfully.");
                    try {
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmailTemplate emailTemplate = new EmailTemplate();
                        //id=108 for Appraisal feedback apply.....
                        emailTemplate = emailTemplateService.readById(108);
                        EmployeeMaster employeeMaster11 = new EmployeeMaster();
                        employeeMaster3 = employeeMasterService.readById(Integer.parseInt(forId));
                        String employeeFDname = employeeMaster3.getEmployeeName();

                        String aaa = "" + appraisal360.getEmployeeMasterByRefDoneEmpId().getId();
                        String StrDate = appraisal360.getPerformedDateStr();
                        String EndDate = appraisal360.getCompleteDateStr();
                        String[] zz = aaa.split(",");
                        for (String oo : zz) {
                            String idd = oo;
                            employeeMaster11 = employeeMasterService.readById(Integer.parseInt(idd));
                            String To = employeeMaster11.getOfficeEmailId();
                            String From = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeFDname);
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster11.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_Str_date\\}", StrDate);
                            msg = msg.replaceAll("\\{from_End_date\\}", EndDate);
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(From, To, Subject, msg);
                        }

                    } catch (Exception e) {
                    }

                    mv = createClick(request, response);
                }
            }
        } else {
            if (!"".equals(forId)) {
                employeeMaster1.setId(Integer.parseInt(forId));
                appraisal360.setEmployeeMasterByRefForEmpId(employeeMaster);
//                employeeMasterByRefForEmpId
            }

            appraisal360Validator.validate(appraisal360, errors);
            if (errors.hasErrors()) {
                request.setAttribute("failureMessage",
                        "Error : The Entered Information is not valid.");
                mv.addAllObjects(errors.getModel());
                selectEmployee1(request, response);
                mv.setViewName("Appraisal/Appraisal360FeedbackFormCreate");
            } else {

                request.setAttribute("failureMessage",
                        "Error : The Entered Information is not valid.");
                mv = createClick(request, response);
            }
        }

        return mv;
    }

    public ModelAndView createEmployeeClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        int forId = Integer.parseInt(request.getParameter("forId"));
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        LocationMaster locationMaster1 = new LocationMaster();
        LocationMaster locationMaster2 = new LocationMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        DesignationMaster designationMaster1;
        LevelMaster levelMaster1;
        DepartmentMaster departmentMaster1;

        employeeMaster2.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster2);
        if (!empId.isEmpty()) {
            employeeMaster2 = (EmployeeMaster) empId.get(0);
            employeeMaster2.getId();
        }
        int id = employeeMaster2.getId();
        List<?> list = appraisal360Service.readHRAppraisalData(id, forId);
        levelMaster = levelMasterService.readById(employeeMaster2.getLevelMaster().getId());
        designationMaster = designationMasterService.readById(employeeMaster2.getDesignationMaster().getId());
        departmentMaster = departmentMasterService.readById(employeeMaster2.getDepartmentMaster().getId());
        employeeMaster = employeeMasterService.readById(Integer.parseInt(employeeMaster2.getReportingManagerLevel1()));
        employeeMaster2.setChild1(employeeMaster.getEmployeeName());
        employeeMaster2.setLevelMaster(levelMaster);
        employeeMaster2.setDepartmentMaster(departmentMaster);
        employeeMaster2.setDesignationMaster(designationMaster);
        locationMaster2 = locationMasterService.readById(employeeMaster2.getLocationMaster().getId());
        employeeMaster2.setLocationMaster(locationMaster2);
        employeeMaster1 = employeeMasterService.readById(forId);
        levelMaster1 = levelMasterService.readById(employeeMaster1.getLevelMaster().getId());
        designationMaster1 = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
        departmentMaster1 = departmentMasterService.readById(employeeMaster1.getDepartmentMaster().getId());
        employeeMaster = employeeMasterService.readById(Integer.parseInt(employeeMaster1.getReportingManagerLevel1()));
        employeeMaster1.setChild2(employeeMaster.getEmployeeName());
        employeeMaster1.setLevelMaster(levelMaster1);
        employeeMaster1.setDepartmentMaster(departmentMaster1);
        employeeMaster1.setDesignationMaster(designationMaster1);
        locationMaster1 = locationMasterService.readById(employeeMaster1.getLocationMaster().getId());
        employeeMaster1.setLocationMaster(locationMaster1);
        request.setAttribute("list1", list);
        request.setAttribute("employeeMaster2", employeeMaster2);
        request.setAttribute("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("appraisal360", appraisal360);
        mv.setViewName("Appraisal/Appraisal360FeedbackFormEmployeeCreate");

        return mv;
    }

    public ModelAndView submitAppraisal360Employee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        BindException errors = new BindException(appraisal360, "appraisal360");
        bind(request, appraisal360);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        int id = Integer.parseInt(request.getParameter("appId"));
        int forid = Integer.parseInt(request.getParameter("forId"));
        int doneid = Integer.parseInt(request.getParameter("doneId"));
        int hrid = Integer.parseInt(request.getParameter("hrId"));
        
        AppraisalFeedback360 af=appraisal360Service.readById(id);
        appraisal360.setId(id);
        employeeMaster.setId(forid);
        employeeMaster1.setId(doneid);
        employeeMaster2.setId(hrid);
        appraisal360.setEmployeeMasterByRefForEmpId(employeeMaster);
        appraisal360.setEmployeeMasterByRefDoneEmpId(employeeMaster1);
        appraisal360.setEmployeeMasterByHrCreatorId(employeeMaster2);
        if (appraisal360.getRemarkHr() == null && appraisal360.getRemarkEmp() == null) {
            appraisal360.setRemarkHr("");
            appraisal360.setRemarkEmp("");
        } else {
            appraisal360.setRemarkHr("");
        }
        appraisal360.setStatus(1);
        appraisal360.setFeedbackYear(af.getFeedbackYear());
        appraisal360Service.update(appraisal360);
        request.setAttribute("successMessage",
                "Information : The Information is saved Successfully.");
        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());

            EmailTemplate emailTemplate = new EmailTemplate();
            //id=112 for Appraisal feedback approval.....
            emailTemplate = emailTemplateService.readById(112);
//            EmployeeMaster employeeMaster11 = new EmployeeMaster();

            EmployeeMaster employeeMaster3 = new EmployeeMaster();
            employeeMaster3 = employeeMasterService.readById(forid);
            String EmployeeFDname = employeeMaster3.getEmployeeName();

            List list = userRightMasterService.readApparaisal360Rights();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object[] next = (Object[]) it.next();
                String umId = "" + next[0];
                String EmailId = "" + next[1];
                String name = "" + next[2];
                String EmployeeName = name;
                String To = EmailId;
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", EmployeeFDname);
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", EmployeeName);
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

            }
//            
//            //            }

        } catch (Exception e) {
        }

        mv.setViewName("forward:userMaster.htm?act=goToDashboard");
//        mv = createClick(request, response);
        return mv;
    }

    public ModelAndView createAppraisalResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        EmployeeMaster employeeMaster;
        List<?> list = appraisal360Service.readAppraisalList();
        for (Object o : list) {
            appraisal360 = (AppraisalFeedback360) o;
            employeeMaster = employeeMasterService.readById(appraisal360.getEmployeeMasterByRefForEmpId().getId());
            appraisal360.setEmployeeMasterByRefForEmpId(employeeMaster);
        }

        request.setAttribute("list", list);
        mv.setViewName("Appraisal/Appraisal360Result");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        EmployeeMaster employeeMaster;
        EmployeeMaster employeeMaster1;
        int ForId = Integer.parseInt(request.getParameter("ForID"));
        String PerfDate = request.getParameter("perDate");
        String CompDate = request.getParameter("compDate");

        List<?> list = appraisal360Service.readAppraisalFeedbackView(ForId, PerfDate, CompDate);

        request.setAttribute("list", list);
        mv.setViewName("Appraisal/Appraisal360View");
        return mv;
    }

    public ModelAndView deleteAppraisal360(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String tabId[] = request.getParameterValues("checkId");
        for (String z : tabId) {
            try {
                appraisal360Service.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = createAppraisalResult(request, response);

        return mv;
    }

    public ModelAndView searchEmpAppraisal360(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Appraisal/Appraisal360EmployeeDetailSearch");
        return mv;
    }

    public ModelAndView searchSubmitEmpAppraisal360(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        bind(request, employeeMaster);
        String endDate = request.getParameter("endDate");
        String strDate = request.getParameter("startDate");
        int forId = 0;
        if ((employeeMaster.getEmployeeName()).equals("")) {

        } else {
            forId = Integer.parseInt(employeeMaster.getEmployeeName());
        }
        List<?> list = appraisal360Service.searchAppraisalFeedback(forId, strDate, endDate);
        request.setAttribute("list1", list);
//        mv.setViewName("Appraisal/Appraisal360EmployeeDetailSearch");
        mv = searchEmpAppraisal360(request, response);
//        mv.setViewName("Appraisal/Appraisal360SearchResult");
        return mv;
    }

    public ModelAndView dashboardResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        int empId = employeeMaster.getId();
        List<?> list = appraisal360Service.readEmployeeAppraisalFeedback(empId);
        request.setAttribute("list", list);
        mv.getModelMap().put("appraisal360", appraisal360);
        mv.setViewName("Appraisal/AppraisaldashboardResult");
        return mv;
    }

    public ModelAndView searchAppraisalPerformance360Reoprt(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisalFeedback360 = new AppraisalFeedback360();

//        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        selectEmployee(request, response);
        department(request, response);
        level(request, response);

        mv.getModelMap().put("appraisal360", appraisalFeedback360);
        mv.setViewName("Appraisal/Appraisal360Reoprt");
        return mv;
    }

    public ModelAndView searchAppraisalPerformance360ReoprtSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisalFeedback360 = new AppraisalFeedback360();
        String employeeMasterId = request.getParameter("employeeMasterId");
        String departmentId = request.getParameter("departmentId");
        String levelId = request.getParameter("levelId");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();

        if (null != employeeMasterId && !"".equals(employeeMasterId)) {
            employeeMaster.setId(Integer.parseInt(employeeMasterId));
        }
        appraisalFeedback360.setEmployeeMasterByRefForEmpId(employeeMaster);
        appraisalFeedback360.setPerformedDateStr(departmentId);
        appraisalFeedback360.setCompleteDateStr(levelId);
        List<?> empFilled = appraisal360Service.read360SearchByFillingEmployee(appraisalFeedback360);
//        mv.getModelMap().put("list", emp360list);
        List<List<String>> fianlList = new ArrayList();
        Map<Object[], List<?>> mapList = new HashMap();
//        if (!emp360list.isEmpty()) {
//            Object[] ss = (Object[]) emp360list.get(0);
        Iterator itr = empFilled.iterator();
        while (itr.hasNext()) {
//        List<String> list12 = new ArrayList();
            Object[] next = (Object[]) itr.next();
            int forByEmpId = (Integer) next[1];
//            list12.add(""+forByEmpId);

            employeeMaster1.setId(forByEmpId);
            appraisalFeedback360.setEmployeeMasterByRefForEmpId(employeeMaster1);
            List<?> emp360list = appraisal360Service.read360SearchByEmployee(appraisalFeedback360);
            mapList.put(next, emp360list);
        }
//            mv.getModelMap().put("list1", empFilled);
        request.setAttribute("mapList", mapList);
//        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeePMPRating.xls");
        mv.getModelMap().put("appraisalFeedback360", appraisalFeedback360);
        mv.setViewName("Appraisal/Appraisal360ReoprtResult");
        return mv;
    }

    public ModelAndView exportToPDF(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFeedback360 appraisal360 = new AppraisalFeedback360();
        EmployeeMaster employeeMaster;
        EmployeeMaster employeeMaster1;
        int ForId = Integer.parseInt(request.getParameter("ForID"));
        String PerfDate = request.getParameter("perDate");
        String CompDate = request.getParameter("compDate");

        List<?> list = appraisal360Service.readAppraisalFeedbackView(ForId, PerfDate, CompDate);

        request.setAttribute("list", list);
        mv.setViewName("Appraisal/Appraisal360PDF");
        return mv;
    }

}
