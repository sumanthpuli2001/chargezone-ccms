/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.pip;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ActivityGoals;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.GoalResourceManagement;
import com.bul.zydex.model.ImprovementGoal;
import com.bul.zydex.model.ImprovementGoalsHistory;
import com.bul.zydex.model.PerformanceImprovementPlanMaster;
import com.bul.zydex.model.PipMeeting;
import com.bul.zydex.model.PipNextScheduledDate;
import com.bul.zydex.service.pip.ActivityGoalsService;
import com.bul.zydex.service.pip.GoalResourceManagementService;
import com.bul.zydex.service.pip.ImprovementGoalService;
import com.bul.zydex.service.pip.ImprovementGoalsHistoryService;
import com.bul.zydex.service.pip.PerformanceImprovementPlanMasterService;
import com.bul.zydex.service.pip.PipMeetingService;
import com.bul.zydex.service.pip.PipNextScheduledDateService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author AJAY
 */
public abstract class PerformanceImprovementPlanMasterAbstract extends CustomAbstract {

    protected PerformanceImprovementPlanMasterService<PerformanceImprovementPlanMaster> performanceImprovementPlanMasterService;
    protected ImprovementGoalService<ImprovementGoal> improvementGoalService;
    protected ActivityGoalsService<ActivityGoals> activityGoalsService;
    protected GoalResourceManagementService<GoalResourceManagement> goalResourceManagementService;
    protected PipMeetingService<PipMeeting> pipMeetingService;
    protected PipNextScheduledDateService<PipNextScheduledDate> pipNextScheduledDateService;
    protected ImprovementGoalsHistoryService<ImprovementGoalsHistory> improvementGoalsHistoryService;

    public PerformanceImprovementPlanMasterService<PerformanceImprovementPlanMaster> getPerformanceImprovementPlanMasterService() {
        return performanceImprovementPlanMasterService;
    }

    public void setPerformanceImprovementPlanMasterService(PerformanceImprovementPlanMasterService<PerformanceImprovementPlanMaster> performanceImprovementPlanMasterService) {
        this.performanceImprovementPlanMasterService = performanceImprovementPlanMasterService;
    }

    public ImprovementGoalService<ImprovementGoal> getImprovementGoalService() {
        return improvementGoalService;
    }

    public void setImprovementGoalService(ImprovementGoalService<ImprovementGoal> improvementGoalService) {
        this.improvementGoalService = improvementGoalService;
    }

    public ActivityGoalsService<ActivityGoals> getActivityGoalsService() {
        return activityGoalsService;
    }

    public void setActivityGoalsService(ActivityGoalsService<ActivityGoals> activityGoalsService) {
        this.activityGoalsService = activityGoalsService;
    }

    public GoalResourceManagementService<GoalResourceManagement> getGoalResourceManagementService() {
        return goalResourceManagementService;
    }

    public void setGoalResourceManagementService(GoalResourceManagementService<GoalResourceManagement> goalResourceManagementService) {
        this.goalResourceManagementService = goalResourceManagementService;
    }

    public PipMeetingService<PipMeeting> getPipMeetingService() {
        return pipMeetingService;
    }

    public void setPipMeetingService(PipMeetingService<PipMeeting> pipMeetingService) {
        this.pipMeetingService = pipMeetingService;
    }

    public PipNextScheduledDateService<PipNextScheduledDate> getPipNextScheduledDateService() {
        return pipNextScheduledDateService;
    }

    public void setPipNextScheduledDateService(PipNextScheduledDateService<PipNextScheduledDate> pipNextScheduledDateService) {
        this.pipNextScheduledDateService = pipNextScheduledDateService;
    }

    public ImprovementGoalsHistoryService<ImprovementGoalsHistory> getImprovementGoalsHistoryService() {
        return improvementGoalsHistoryService;
    }

    public void setImprovementGoalsHistoryService(ImprovementGoalsHistoryService<ImprovementGoalsHistory> improvementGoalsHistoryService) {
        this.improvementGoalsHistoryService = improvementGoalsHistoryService;
    }
  public void mailSendPipApply(HttpServletRequest request) throws Exception {

        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmailTemplate emailTemplate1 = new EmailTemplate();
            // id =7 for approve leave request...
            emailTemplate1 = emailTemplateService.readById(131);
            int empID = employeeMasterModel.getId();
            employeeMaster2 = employeeMasterService.readById(empID);

            String name = "PIP";
            EmailAddMaster emailAddMaster = new EmailAddMaster();
            emailAddMaster.setModuleName(name);
            emailAddMaster.setDepartmentMaster(employeeMaster2.getDepartmentMaster());
            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
            if (!emailSendList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
            List<?> allDeptmailList = emailAddMasterService.readAllDept(name);
            if (!allDeptmailList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) allDeptmailList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }   

}
