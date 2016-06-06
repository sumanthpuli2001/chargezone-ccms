/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.attendanceRegularization;

import com.bul.zydex.controller.*;
import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import com.bul.zydex.service.attendanceRegularization.AttendanceRegularizationMasterService;
import com.bul.zydex.service.attendanceRegularization.TimeAttandanceFlaxibleMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.overTime.OverTimeMasterService;
import com.bul.zydex.service.shift.EmployeeDatetimeDataService;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
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

    
}
