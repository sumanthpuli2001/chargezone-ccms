/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.travel;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeLeaveBalance;
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

}
