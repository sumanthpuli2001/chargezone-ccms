/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.attendanceRegularization;

import com.bul.zydex.controller.*;
import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePunchForMobileApp;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OTRegularization;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.attendanceRegularization.AttendanceRegularizationMasterService;
import com.bul.zydex.service.attendanceRegularization.OTRegularizationService;
import com.bul.zydex.service.attendanceRegularization.TimeAttandanceFlaxibleMasterService;
import com.bul.zydex.service.holiday.HolidayMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveEmployeeDetailService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.mobileapp.EmployeePunchForMobileAppService;
import com.bul.zydex.service.overTime.OverTimeMasterService;
import com.bul.zydex.service.shift.EmployeeDatetimeDataService;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import com.bul.zydex.service.shift.ShiftMasterService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Dhaval Patel
 */
public class AttendanceRegularizationMasterAbstract extends CustomAbstract {

    protected AttendanceRegularizationMasterService<AttendanceRegularization> attendanceRegularizationMasterService;
    protected EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService;
    protected EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService;
    protected TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> timeAttandanceFlaxibleMasterService;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;
    protected OverTimeMasterService<OverTimeMaster> overTimeMasterService;
    protected Validator attendanceRegularizationValidator;
    protected EmployeePunchForMobileAppService<EmployeePunchForMobileApp> employeePunchForMobileAppService;
    protected LeaveEmployeeDetailService<LeaveEmployeeDetail> leaveEmployeeDetailService;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected OTRegularizationService<OTRegularization> oTRegularizationService;
    protected ShiftMasterService<ShiftMaster> shiftMasterService;
    protected HolidayMasterService<HolidayMaster> holidayMasterService;
    
    
    public TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> getTimeAttandanceFlaxibleMasterService() {
        return timeAttandanceFlaxibleMasterService;
    }

    public void setTimeAttandanceFlaxibleMasterService(TimeAttandanceFlaxibleMasterService<TimeAttandanceFlaxibleMaster> timeAttandanceFlaxibleMasterService) {
        this.timeAttandanceFlaxibleMasterService = timeAttandanceFlaxibleMasterService;
    }

    public Validator getAttendanceRegularizationValidator() {
        return attendanceRegularizationValidator;
    }

    public void setAttendanceRegularizationValidator(Validator attendanceRegularizationValidator) {
        this.attendanceRegularizationValidator = attendanceRegularizationValidator;
    }

    public EmployeeShiftDataService<EmployeeShiftData> getEmployeeShiftDataService() {
        return employeeShiftDataService;
    }

    public void setEmployeeShiftDataService(EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService) {
        this.employeeShiftDataService = employeeShiftDataService;
    }

    public EmployeeDatetimeDataService<EmployeeDatetimeData> getEmployeeDatetimeDataService() {
        return employeeDatetimeDataService;
    }

    public void setEmployeeDatetimeDataService(EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService) {
        this.employeeDatetimeDataService = employeeDatetimeDataService;
    }

    public AttendanceRegularizationMasterService<AttendanceRegularization> getAttendanceRegularizationMasterService() {
        return attendanceRegularizationMasterService;
    }

    public void setAttendanceRegularizationMasterService(AttendanceRegularizationMasterService<AttendanceRegularization> attendanceRegularizationMasterService) {
        this.attendanceRegularizationMasterService = attendanceRegularizationMasterService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    public OverTimeMasterService<OverTimeMaster> getOverTimeMasterService() {
        return overTimeMasterService;
    }

    public void setOverTimeMasterService(OverTimeMasterService<OverTimeMaster> overTimeMasterService) {
        this.overTimeMasterService = overTimeMasterService;
    }

    public EmployeePunchForMobileAppService<EmployeePunchForMobileApp> getEmployeePunchForMobileAppService() {
        return employeePunchForMobileAppService;
    }

    public void setEmployeePunchForMobileAppService(EmployeePunchForMobileAppService<EmployeePunchForMobileApp> employeePunchForMobileAppService) {
        this.employeePunchForMobileAppService = employeePunchForMobileAppService;
    }

    public LeaveEmployeeDetailService<LeaveEmployeeDetail> getLeaveEmployeeDetailService() {
        return leaveEmployeeDetailService;
    }

    public void setLeaveEmployeeDetailService(LeaveEmployeeDetailService<LeaveEmployeeDetail> leaveEmployeeDetailService) {
        this.leaveEmployeeDetailService = leaveEmployeeDetailService;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public OTRegularizationService<OTRegularization> getoTRegularizationService() {
        return oTRegularizationService;
    }

    public void setoTRegularizationService(OTRegularizationService<OTRegularization> oTRegularizationService) {
        this.oTRegularizationService = oTRegularizationService;
    }

    public ShiftMasterService<ShiftMaster> getShiftMasterService() {
        return shiftMasterService;
    }

    public void setShiftMasterService(ShiftMasterService<ShiftMaster> shiftMasterService) {
        this.shiftMasterService = shiftMasterService;
    }

    public HolidayMasterService<HolidayMaster> getHolidayMasterService() {
        return holidayMasterService;
    }

    public void setHolidayMasterService(HolidayMasterService<HolidayMaster> holidayMasterService) {
        this.holidayMasterService = holidayMasterService;
    }
    
    

    
    public void mailSendArApply(HttpServletRequest request) throws Exception {

        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmailTemplate emailTemplate1 = new EmailTemplate();
            // id =7 for approve leave request...
            emailTemplate1 = emailTemplateService.readById(14);
            int empID = employeeMasterModel.getId();
            employeeMaster2 = employeeMasterService.readById(empID);

            String name = "Attendance";
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
