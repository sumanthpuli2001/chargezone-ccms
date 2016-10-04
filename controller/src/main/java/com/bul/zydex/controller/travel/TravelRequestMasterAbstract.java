/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.travel;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.HotelAccommodation;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.TravelApproverHistory;
import com.bul.zydex.model.TravelDetail;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.EmailTemplateService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.overTime.OverTimeMasterService;
import com.bul.zydex.service.travel.HotelAccommodationService;
import com.bul.zydex.service.travel.TravelApproverHistoryService;
import com.bul.zydex.service.travel.TravelDetailService;
import com.bul.zydex.service.travel.TravelRequestMasterService;
import com.bul.zydex.util.SendMail;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class TravelRequestMasterAbstract extends CustomAbstract {

    protected TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService;
    protected Validator travelRequestMasterValidator;
    protected TravelDetailService<TravelDetail> travelDetailService;
    protected TravelApproverHistoryService<TravelApproverHistory> travelApproverHistoryService;
    protected HotelAccommodationService<HotelAccommodation> hotelAccommodationService;
    protected EmailTemplateService<EmailTemplate> emailTemplateService;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected SendMail sendMail;
    protected OverTimeMasterService<OverTimeMaster> overTimeMasterService;
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;

    public TravelRequestMasterService<TravelRequestMaster> getTravelRequestMasterService() {
        return travelRequestMasterService;
    }

    public void setTravelRequestMasterService(TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService) {
        this.travelRequestMasterService = travelRequestMasterService;
    }

    public Validator getTravelRequestMasterValidator() {
        return travelRequestMasterValidator;
    }

    public void setTravelRequestMasterValidator(Validator travelRequestMasterValidator) {
        this.travelRequestMasterValidator = travelRequestMasterValidator;
    }

    public TravelDetailService<TravelDetail> getTravelDetailService() {
        return travelDetailService;
    }

    public void setTravelDetailService(TravelDetailService<TravelDetail> travelDetailService) {
        this.travelDetailService = travelDetailService;
    }

    public HotelAccommodationService<HotelAccommodation> getHotelAccommodationService() {
        return hotelAccommodationService;
    }

    public void setHotelAccommodationService(HotelAccommodationService<HotelAccommodation> hotelAccommodationService) {
        this.hotelAccommodationService = hotelAccommodationService;
    }

    public TravelApproverHistoryService<TravelApproverHistory> getTravelApproverHistoryService() {
        return travelApproverHistoryService;
    }

    public void setTravelApproverHistoryService(TravelApproverHistoryService<TravelApproverHistory> travelApproverHistoryService) {
        this.travelApproverHistoryService = travelApproverHistoryService;
    }

    public EmailTemplateService<EmailTemplate> getEmailTemplateService() {
        return emailTemplateService;
    }

    public void setEmailTemplateService(EmailTemplateService<EmailTemplate> emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    public SendMail getSendMail() {
        return sendMail;
    }

    public void setSendMail(SendMail sendMail) {
        this.sendMail = sendMail;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public OverTimeMasterService<OverTimeMaster> getOverTimeMasterService() {
        return overTimeMasterService;
    }

    public void setOverTimeMasterService(OverTimeMasterService<OverTimeMaster> overTimeMasterService) {
        this.overTimeMasterService = overTimeMasterService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    public void mailSendtTravelapply(HttpServletRequest request) throws Exception {

        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmailTemplate emailTemplate1 = new EmailTemplate();
            // id =7 for approve leave request...
            emailTemplate1 = emailTemplateService.readById(24);
            int empID = employeeMasterModel.getId();
            employeeMaster2 = employeeMasterService.readById(empID);

            String name = "Travel";
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
