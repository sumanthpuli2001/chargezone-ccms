/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.pip;

import com.bul.zydex.model.ActivityGoals;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.GoalResourceManagement;
import com.bul.zydex.model.ImprovementGoal;
import com.bul.zydex.model.ImprovementGoalsHistory;
import com.bul.zydex.model.PerformanceImprovementPlanMaster;
import com.bul.zydex.model.PipMeeting;
import com.bul.zydex.model.PipNextScheduledDate;
import com.bul.zydex.model.UserMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class PerformanceImprovementPlanMasterController extends PerformanceImprovementPlanMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();

        PerformanceImprovementPlanMaster performanceImprovementPlanMaster = new PerformanceImprovementPlanMaster();
        ImprovementGoal improvementGoal = new ImprovementGoal();
        ActivityGoals activityGoals = new ActivityGoals();
        GoalResourceManagement goalResourceManagement = new GoalResourceManagement();
        PipMeeting pipMeeting = new PipMeeting();
        PipNextScheduledDate pipNextScheduledDate = new PipNextScheduledDate();

        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        user.getId();
        employeeMaster.setUserMaster(user);
        int reportingId = 0;
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            Object[] obj = (Object[]) empDetailList.get(0);
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }
            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
        }
        List<?> improvementGoalList = null;
        List<?> activityGoalList = null;
        List<?> goalResourceManagementList = null;
        List<?> pipMeetingList = null;
        List<?> pipNextScheduledDateList = null;
        EmployeeMaster employeeMaster2 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        performanceImprovementPlanMaster.setEmployeeMasterByPipEmployeeId(employeeMaster2);
        List<?> pipMasterList = performanceImprovementPlanMasterService.readPipByEmployeeMaster(performanceImprovementPlanMaster);
        if (!pipMasterList.isEmpty()) {
            performanceImprovementPlanMaster = (PerformanceImprovementPlanMaster) pipMasterList.get(0);

            improvementGoal.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            improvementGoalList = improvementGoalService.readImprovementGoalByPipMaster(improvementGoal);

            activityGoals.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            activityGoalList = activityGoalsService.readActivityGoalByPipMaster(activityGoals);

            goalResourceManagement.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            goalResourceManagementList = goalResourceManagementService.readGoalResourceByPipMaster(goalResourceManagement);

            pipMeeting.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            pipMeetingList = pipMeetingService.readPipMeetingByPipMaster(pipMeeting);

            pipNextScheduledDate.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            pipNextScheduledDateList = pipNextScheduledDateService.readPipNextScheduledDateByPipMaster(pipNextScheduledDate);
        }
        request.setAttribute("improvementGoalList", improvementGoalList);
        request.setAttribute("activityGoalList", activityGoalList);
        request.setAttribute("goalResourceManagementList", goalResourceManagementList);
        request.setAttribute("pipMeetingList", pipMeetingList);
        request.setAttribute("pipNextScheduledDateList", pipNextScheduledDateList);
        request.setAttribute("performanceImprovementPlanMaster", performanceImprovementPlanMaster);
        mv.setViewName("Appraisal/PerformanceImprovementPlanCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PerformanceImprovementPlanMaster performanceImprovementPlanMaster = new PerformanceImprovementPlanMaster();
        ImprovementGoal improvementGoal = new ImprovementGoal();
        ImprovementGoal improvementGoal1 = new ImprovementGoal();
        ActivityGoals activityGoals = new ActivityGoals();
        GoalResourceManagement goalResourceManagement = new GoalResourceManagement();
        PipMeeting pipMeeting = new PipMeeting();
        PipNextScheduledDate pipNextScheduledDate = new PipNextScheduledDate();
        ImprovementGoalsHistory improvementGoalsHistory = new ImprovementGoalsHistory();

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        String firstStepCount = request.getParameter("firstStepCount");
        String secondStepCount = request.getParameter("secondStepCount");
        String thirdStepCount = request.getParameter("thirdStepCount");
        String forthStepCount = request.getParameter("forthStepCount");
        String pip_id = request.getParameter("pip_id");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String requestdate = sdf.format(new Date());
        performanceImprovementPlanMaster.setEmployeeMasterByPipEmployeeId(employeeMaster);
        performanceImprovementPlanMaster.setDateOfSubmit(requestdate);
        performanceImprovementPlanMaster.setStatus(1);
        if (null == pip_id || "".equals(pip_id)) {
            performanceImprovementPlanMasterService.create(performanceImprovementPlanMaster);
        } else {
            performanceImprovementPlanMaster.setId(Integer.parseInt(pip_id));
            performanceImprovementPlanMasterService.update(performanceImprovementPlanMaster);
        }

        for (int i = 1; i <= Integer.parseInt(firstStepCount); i++) {

            String improvementGoal_id = request.getParameter("improvementGoal_id" + i);
            String pipGoal = request.getParameter("pipGoal" + i);
            improvementGoal.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            improvementGoal.setGoals(pipGoal);
            if (null == improvementGoal_id || "".equals(improvementGoal_id)) {
                improvementGoalService.create(improvementGoal);
            } else {
                improvementGoal.setId(Integer.parseInt(improvementGoal_id));
                improvementGoal1 = improvementGoalService.readById(Integer.parseInt(improvementGoal_id));
                if (improvementGoal1.getGoals().equals(pipGoal)) {
                    improvementGoalService.update(improvementGoal);
                } else {
                    improvementGoalService.update(improvementGoal);
                    improvementGoalsHistory.setEditedGoals(improvementGoal1.getGoals());
                    improvementGoalsHistory.setEmployeeMaster(employeeMaster);
                    improvementGoalsHistory.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
                    improvementGoalsHistory.setImprovementGoal(improvementGoal);
                    improvementGoalsHistory.setHistoryDate(requestdate);
                    improvementGoalsHistoryService.create(improvementGoalsHistory);
                }
            }

        }
        for (int j = 1; j <= Integer.parseInt(secondStepCount); j++) {
            String activityGoal_id = request.getParameter("activityGoal_id" + j);
            String activityGoal = request.getParameter("activityGoal" + j);
            String activityName = request.getParameter("activityName" + j);
            String howToAccomplish = request.getParameter("howToAccomplish" + j);
            String startDate = request.getParameter("startDate" + j);
            String completionDate = request.getParameter("completionDate" + j);

            activityGoals.setImprovementGoal(activityGoal);
            activityGoals.setActivity(activityName);
            activityGoals.setHowToCcomplish(howToAccomplish);
            activityGoals.setActivityStartDate(startDate);
            activityGoals.setProjectedCompletionDate(completionDate);
            activityGoals.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            if (null == activityGoal_id || "".equals(activityGoal_id)) {
                activityGoalsService.create(activityGoals);

            } else {
                activityGoals.setId(Integer.parseInt(activityGoal_id));
                activityGoalsService.update(activityGoals);
            }

        }
        for (int k = 1; k <= Integer.parseInt(thirdStepCount); k++) {
            String goalResource_id = request.getParameter("goalResource_id" + k);
            String resourceGoal = request.getParameter("resourceGoal" + k);
            String resourceName = request.getParameter("resourceName" + k);
            goalResourceManagement.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            goalResourceManagement.setImprovementGoal(resourceGoal);
            goalResourceManagement.setResources(resourceName);
            if (null == goalResource_id || "".equals(goalResource_id)) {
                goalResourceManagementService.create(goalResourceManagement);
            } else {
                goalResourceManagement.setId(Integer.parseInt(goalResource_id));
                goalResourceManagementService.update(goalResourceManagement);
            }

        }
        for (int m = 1; m <= Integer.parseInt(forthStepCount); m++) {
            String pipMeeting_id = request.getParameter("pipMeeting_id" + m);
            String scheduledDate = request.getParameter("scheduledDate" + m);
            String meeting = request.getParameter("meeting" + m);
            String managerRemark = request.getParameter("managerRemark" + m);
            pipMeeting.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            pipMeeting.setDateScheduled(scheduledDate);
            pipMeeting.setMeeting(meeting);
            pipMeeting.setRemarks(managerRemark);
            if (null == pipMeeting_id || "".equals(pipMeeting_id)) {
                pipMeetingService.create(pipMeeting);

            } else {
                pipMeeting.setId(Integer.parseInt(pipMeeting_id));
                pipMeetingService.update(pipMeeting);

            }

        }
        String pipNextScheduledDate_id = request.getParameter("pipNextScheduledDate_id");
        String nextScheduleDate = request.getParameter("nextScheduleDate");
        pipNextScheduledDate.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
        pipNextScheduledDate.setNextScheduleDateTime(nextScheduleDate);
        if (null == pipNextScheduledDate_id || "".equals(pipNextScheduledDate_id)) {
            pipNextScheduledDateService.create(pipNextScheduledDate);
        } else {
            pipNextScheduledDate.setId(Integer.parseInt(pipNextScheduledDate_id));
            pipNextScheduledDateService.update(pipNextScheduledDate);
        }

        // For Emailtemplate
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMasterHr = new EmployeeMaster();
            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            // id 24 is apply status
            emailTemplate = emailTemplateService.readById(131);
            String To = employeeMasterHr.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }

        request.setAttribute("successMessage",
                "Information : The Information is Saved Successfully.");

        mv = createClick(request, response);

        return mv;
    }

    public ModelAndView viewPipListByManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        List<?> pipList = performanceImprovementPlanMasterService.viewPipListByManager("" + employeeMaster.getId());
        request.setAttribute("pipList", pipList);
        mv.setViewName("Appraisal/PerformanceImprovementPlanList");
        return mv;
    }

    public ModelAndView editPipFormByManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PerformanceImprovementPlanMaster performanceImprovementPlanMaster = new PerformanceImprovementPlanMaster();
        ImprovementGoal improvementGoal = new ImprovementGoal();
        ActivityGoals activityGoals = new ActivityGoals();
        GoalResourceManagement goalResourceManagement = new GoalResourceManagement();
        PipMeeting pipMeeting = new PipMeeting();
        PipNextScheduledDate pipNextScheduledDate = new PipNextScheduledDate();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String pip_Id = request.getParameter("pip_Id");
        String emp_Id = request.getParameter("emp_Id");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(emp_Id));
        int reportingId = 0;
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }
            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
        }
        performanceImprovementPlanMaster = performanceImprovementPlanMasterService.readById(Integer.parseInt(pip_Id));
        List<?> improvementGoalList = null;
        List<?> activityGoalList = null;
        List<?> goalResourceManagementList = null;
        List<?> pipMeetingList = null;
        List<?> pipNextScheduledDateList = null;

        List<?> pipMasterList = performanceImprovementPlanMasterService.readPipByEmployeeMaster(performanceImprovementPlanMaster);
        if (!pipMasterList.isEmpty()) {
            performanceImprovementPlanMaster = (PerformanceImprovementPlanMaster) pipMasterList.get(0);

            improvementGoal.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            improvementGoalList = improvementGoalService.readImprovementGoalByPipMaster(improvementGoal);

            activityGoals.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            activityGoalList = activityGoalsService.readActivityGoalByPipMaster(activityGoals);

            goalResourceManagement.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            goalResourceManagementList = goalResourceManagementService.readGoalResourceByPipMaster(goalResourceManagement);

            pipMeeting.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            pipMeetingList = pipMeetingService.readPipMeetingByPipMaster(pipMeeting);

            pipNextScheduledDate.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            pipNextScheduledDateList = pipNextScheduledDateService.readPipNextScheduledDateByPipMaster(pipNextScheduledDate);
        }
        request.setAttribute("improvementGoalList", improvementGoalList);
        request.setAttribute("activityGoalList", activityGoalList);
        request.setAttribute("goalResourceManagementList", goalResourceManagementList);
        request.setAttribute("pipMeetingList", pipMeetingList);
        request.setAttribute("pipNextScheduledDateList", pipNextScheduledDateList);
        request.setAttribute("performanceImprovementPlanMaster", performanceImprovementPlanMaster);
        request.setAttribute("emp_Id", emp_Id);
        mv.setViewName("Appraisal/PerformanceImprovementPlanViewByManager");
        return mv;
    }

    public ModelAndView editSubmitPipFormByManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PerformanceImprovementPlanMaster performanceImprovementPlanMaster = new PerformanceImprovementPlanMaster();
        ImprovementGoal improvementGoal = new ImprovementGoal();
        ImprovementGoal improvementGoal1 = new ImprovementGoal();
        ActivityGoals activityGoals = new ActivityGoals();
        GoalResourceManagement goalResourceManagement = new GoalResourceManagement();
        PipMeeting pipMeeting = new PipMeeting();
        PipNextScheduledDate pipNextScheduledDate = new PipNextScheduledDate();
        ImprovementGoalsHistory improvementGoalsHistory = new ImprovementGoalsHistory();

        EmployeeMaster employeeMaster1 = new EmployeeMaster();

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        String firstStepCount = request.getParameter("firstStepCount");
        String secondStepCount = request.getParameter("secondStepCount");
        String thirdStepCount = request.getParameter("thirdStepCount");
        String forthStepCount = request.getParameter("forthStepCount");
        String pip_id = request.getParameter("pip_id");
        String emp_Id = request.getParameter("emp_Id");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String requestdate = sdf.format(new Date());
        employeeMaster1.setId(Integer.parseInt(emp_Id));
        performanceImprovementPlanMaster.setEmployeeMasterByPipEmployeeId(employeeMaster1);
        performanceImprovementPlanMaster.setEmployeeMasterByPipManagerId(employeeMaster);
        performanceImprovementPlanMaster.setDateOfSubmit(requestdate);
        performanceImprovementPlanMaster.setStatus(2);
        if (null == pip_id || "".equals(pip_id)) {
            performanceImprovementPlanMasterService.create(performanceImprovementPlanMaster);
        } else {
            performanceImprovementPlanMaster.setId(Integer.parseInt(pip_id));
            performanceImprovementPlanMasterService.update(performanceImprovementPlanMaster);
        }

        for (int i = 1; i <= Integer.parseInt(firstStepCount); i++) {

            String improvementGoal_id = request.getParameter("improvementGoal_id" + i);
            String pipGoal = request.getParameter("pipGoal" + i);
            improvementGoal.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            improvementGoal.setGoals(pipGoal);
            if (null == improvementGoal_id || "".equals(improvementGoal_id)) {
                improvementGoalService.create(improvementGoal);
            } else {
                improvementGoal.setId(Integer.parseInt(improvementGoal_id));
                improvementGoal1 = improvementGoalService.readById(Integer.parseInt(improvementGoal_id));
                if (improvementGoal1.getGoals().equals(pipGoal)) {
                    improvementGoalService.update(improvementGoal);
                } else {
                    improvementGoalService.update(improvementGoal);
                    improvementGoalsHistory.setEditedGoals(improvementGoal1.getGoals());
                    improvementGoalsHistory.setEmployeeMaster(employeeMaster);
                    improvementGoalsHistory.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
                    improvementGoalsHistory.setImprovementGoal(improvementGoal);
                    improvementGoalsHistory.setHistoryDate(requestdate);
                    improvementGoalsHistoryService.create(improvementGoalsHistory);
                }
            }

        }
        for (int j = 1; j <= Integer.parseInt(secondStepCount); j++) {
            String activityGoal_id = request.getParameter("activityGoal_id" + j);
            String activityGoal = request.getParameter("activityGoal" + j);
            String activityName = request.getParameter("activityName" + j);
            String howToAccomplish = request.getParameter("howToAccomplish" + j);
            String startDate = request.getParameter("startDate" + j);
            String completionDate = request.getParameter("completionDate" + j);

            activityGoals.setImprovementGoal(activityGoal);
            activityGoals.setActivity(activityName);
            activityGoals.setHowToCcomplish(howToAccomplish);
            activityGoals.setActivityStartDate(startDate);
            activityGoals.setProjectedCompletionDate(completionDate);
            activityGoals.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            if (null == activityGoal_id || "".equals(activityGoal_id)) {
                activityGoalsService.create(activityGoals);
            } else {
                activityGoals.setId(Integer.parseInt(activityGoal_id));
                activityGoalsService.update(activityGoals);
            }

        }
        for (int k = 1; k <= Integer.parseInt(thirdStepCount); k++) {
            String goalResource_id = request.getParameter("goalResource_id" + k);
            String resourceGoal = request.getParameter("resourceGoal" + k);
            String resourceName = request.getParameter("resourceName" + k);
            goalResourceManagement.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            goalResourceManagement.setImprovementGoal(resourceGoal);
            goalResourceManagement.setResources(resourceName);
            if (null == goalResource_id || "".equals(goalResource_id)) {
                goalResourceManagementService.create(goalResourceManagement);
            } else {
                goalResourceManagement.setId(Integer.parseInt(goalResource_id));
                goalResourceManagementService.update(goalResourceManagement);
            }

        }
        for (int m = 1; m <= Integer.parseInt(forthStepCount); m++) {
            String pipMeeting_id = request.getParameter("pipMeeting_id" + m);
            String scheduledDate = request.getParameter("scheduledDate" + m);
            String meeting = request.getParameter("meeting" + m);
            String managerRemark = request.getParameter("managerRemark" + m);
            pipMeeting.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            pipMeeting.setDateScheduled(scheduledDate);
            pipMeeting.setMeeting(meeting);
            pipMeeting.setRemarks(managerRemark);
            if (null == pipMeeting_id || "".equals(pipMeeting_id)) {
                pipMeetingService.create(pipMeeting);
            } else {
                pipMeeting.setId(Integer.parseInt(pipMeeting_id));
                pipMeetingService.update(pipMeeting);
            }

        }
        String pipNextScheduledDate_id = request.getParameter("pipNextScheduledDate_id");
        String nextScheduleDate = request.getParameter("nextScheduleDate");
        pipNextScheduledDate.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
        pipNextScheduledDate.setNextScheduleDateTime(nextScheduleDate);
        if (null == pipNextScheduledDate_id || "".equals(pipNextScheduledDate_id)) {
            pipNextScheduledDateService.create(pipNextScheduledDate);
        } else {
            pipNextScheduledDate.setId(Integer.parseInt(pipNextScheduledDate_id));
            pipNextScheduledDateService.update(pipNextScheduledDate);
        }

        try {

            EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeemastermodel.getDesignationMaster().getId());
//                    EmployeeMaster employeemasterHr = new EmployeeMaster();
//                    employeemasterHr = employeeMasterService.readById(Integer.parseInt(employeemastermodel.getReportingManagerLevel1()));
            EmailTemplate emailTemplate1 = new EmailTemplate();
            emailTemplate1 = emailTemplateService.readById(132);
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmployeeMaster employeeMaster3 = new EmployeeMaster();
            employeeMaster3 = employeeMasterService.readById(Integer.parseInt(emp_Id));

            if (null != employeeMaster3.getEmployeeId() && !"".equals(employeeMaster3.getEmployeeId())) {

                int empID = Integer.parseInt(employeeMaster3.getEmployeeId());
                List list = employeeMasterService.readByEmployeeNo(empID);
                if (!list.isEmpty()) {
                    employeeMaster2 = (EmployeeMaster) list.get(0);
                    String To = employeeMaster2.getOfficeEmailId();
                    String from = employeemastermodel.getOfficeEmailId();
                    String subject = emailTemplate1.getSubject();
                    subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                    String msg = emailTemplate1.getBodytext();
                    msg = msg.replaceAll("\\{date\\}", nextScheduleDate);
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, subject, msg);
                }
            }

        } catch (Exception e) {
        }

        request.setAttribute("successMessage",
                "Information : The Information is Saved Successfully.");
        mv = viewPipListByManager(request, response);
        return mv;
    }

    public ModelAndView readHistoryAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String pip_id = request.getParameter("pip_id");
        String improvementGoal_id = request.getParameter("improvementGoal_id");

        List<?> historyList = improvementGoalsHistoryService.readGoalHistory(pip_id, improvementGoal_id);
        request.setAttribute("historyList", historyList);
        mv.setViewName("Appraisal/ImprovementGoalHistory");

        return mv;
    }

    public ModelAndView viewPipListByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> pipAdminList = performanceImprovementPlanMasterService.viewPipListByAdmin();
        request.setAttribute("pipAdminList", pipAdminList);
        mv.setViewName("Appraisal/PerformanceImprovementPlanListForAdmin");
        return mv;
    }

    public ModelAndView viewPipFormByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PerformanceImprovementPlanMaster performanceImprovementPlanMaster = new PerformanceImprovementPlanMaster();
        ImprovementGoal improvementGoal = new ImprovementGoal();
        ActivityGoals activityGoals = new ActivityGoals();
        GoalResourceManagement goalResourceManagement = new GoalResourceManagement();
        PipMeeting pipMeeting = new PipMeeting();
        PipNextScheduledDate pipNextScheduledDate = new PipNextScheduledDate();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String pip_Id = request.getParameter("pip_Id");
        String emp_Id = request.getParameter("emp_Id");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(emp_Id));
        int reportingId = 0;
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }
            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
        }
        performanceImprovementPlanMaster = performanceImprovementPlanMasterService.readById(Integer.parseInt(pip_Id));
        List<?> improvementGoalList = null;
        List<?> activityGoalList = null;
        List<?> goalResourceManagementList = null;
        List<?> pipMeetingList = null;
        List<?> pipNextScheduledDateList = null;

        List<?> pipMasterList = performanceImprovementPlanMasterService.readPipByEmployeeMaster(performanceImprovementPlanMaster);
        if (!pipMasterList.isEmpty()) {
            performanceImprovementPlanMaster = (PerformanceImprovementPlanMaster) pipMasterList.get(0);

            improvementGoal.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            improvementGoalList = improvementGoalService.readImprovementGoalByPipMaster(improvementGoal);

            activityGoals.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            activityGoalList = activityGoalsService.readActivityGoalByPipMaster(activityGoals);

            goalResourceManagement.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            goalResourceManagementList = goalResourceManagementService.readGoalResourceByPipMaster(goalResourceManagement);

            pipMeeting.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            pipMeetingList = pipMeetingService.readPipMeetingByPipMaster(pipMeeting);

            pipNextScheduledDate.setPerformanceImprovementPlanMaster(performanceImprovementPlanMaster);
            pipNextScheduledDateList = pipNextScheduledDateService.readPipNextScheduledDateByPipMaster(pipNextScheduledDate);
        }
        request.setAttribute("improvementGoalList", improvementGoalList);
        request.setAttribute("activityGoalList", activityGoalList);
        request.setAttribute("goalResourceManagementList", goalResourceManagementList);
        request.setAttribute("pipMeetingList", pipMeetingList);
        request.setAttribute("pipNextScheduledDateList", pipNextScheduledDateList);
        request.setAttribute("performanceImprovementPlanMaster", performanceImprovementPlanMaster);
        request.setAttribute("emp_Id", emp_Id);
        mv.setViewName("Appraisal/PerformanceImprovementPlanViewByAdmin");
        return mv;
    }

    public ModelAndView userDashBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PerformanceImprovementPlanMaster performanceImprovementPlanMaster = new PerformanceImprovementPlanMaster();
        performanceImprovementPlanMaster.setEmployeeMasterByPipEmployeeId(employeemastermodel);
        List ownPipPendingList = performanceImprovementPlanMasterService.readOwnPipPending(performanceImprovementPlanMaster);

        List empPendingPip = performanceImprovementPlanMasterService.readEmployeePipPending("" + employeemastermodel.getId());

//        For Employee
        request.setAttribute("ownPipPendingList", ownPipPendingList.size());
//        For Manager
        request.setAttribute("empPendingPip", empPendingPip.size());
        mv.setViewName("forward:poolCarRequest.htm?act=userDashboardPoolCarPendingRequest");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String pipId[] = request.getParameterValues("checkId");
        for (String z : pipId) {
            try {
                performanceImprovementPlanMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv.setViewName("forward:performanceImprovementPlanMaster.htm?act=viewPipListByAdmin");
//        mv = viewPipListByAdmin(request, response);
        return mv;
    }
}
