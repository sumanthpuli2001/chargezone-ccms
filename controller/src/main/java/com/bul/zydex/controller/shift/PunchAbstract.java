/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.Punch;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.TimeAttendanceMaster;
import com.bul.zydex.service.emp.EmployeeMasterService;
import com.bul.zydex.service.shift.PunchService;
import com.bul.zydex.service.shift.ShiftMasterService;
import com.bul.zydex.service.shift.TimeAttendanceMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public abstract class PunchAbstract extends CustomAbstract {

    protected PunchService<Punch> punchService;
    protected Validator punchValidator;
    protected TimeAttendanceMasterService<TimeAttendanceMaster> timeAttendanceMasterService;
    protected ShiftMasterService<ShiftMaster> shiftMasterService;

    public PunchService<Punch> getPunchService() {
        return punchService;
    }

    public void setPunchService(PunchService<Punch> punchService) {
        this.punchService = punchService;
    }

    public Validator getPunchValidator() {
        return punchValidator;
    }

    public void setPunchValidator(Validator punchValidator) {
        this.punchValidator = punchValidator;
    }

    public TimeAttendanceMasterService<TimeAttendanceMaster> getTimeAttendanceMasterService() {
        return timeAttendanceMasterService;
    }

    public void setTimeAttendanceMasterService(TimeAttendanceMasterService<TimeAttendanceMaster> timeAttendanceMasterService) {
        this.timeAttendanceMasterService = timeAttendanceMasterService;
    }

    public ShiftMasterService<ShiftMaster> getShiftMasterService() {
        return shiftMasterService;
    }

    public void setShiftMasterService(ShiftMasterService<ShiftMaster> shiftMasterService) {
        this.shiftMasterService = shiftMasterService;
    }

}
