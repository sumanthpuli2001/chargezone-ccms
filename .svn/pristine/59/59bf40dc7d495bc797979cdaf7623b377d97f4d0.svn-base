/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PoolCarRequest;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emprequest.PoolCarRequestService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.shift.EmployeeDatetimeDataService;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import com.bul.zydex.service.shift.ShiftGenerateMonthlyScheduleService;
import com.bul.zydex.service.shift.ShiftMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public abstract class PoolCarRequestAbstract extends CustomAbstract {

    public PoolCarRequestService<PoolCarRequest> poolCarRequestService;
    public LevelMasterService<LevelMaster> levelMasterService;
    public Validator poolCarRequestValidator;
    public LocationMasterService<LocationMaster> locationMasterService;
    protected EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService;
    protected EmployeeDatetimeDataService<EmployeeDatetimeData> employeeDatetimeDataService;
    protected ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService;
    protected ShiftMasterService<ShiftMaster> shiftMasterService;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public ShiftMasterService<ShiftMaster> getShiftMasterService() {
        return shiftMasterService;
    }

    public void setShiftMasterService(ShiftMasterService<ShiftMaster> shiftMasterService) {
        this.shiftMasterService = shiftMasterService;
    }

    public ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> getShiftGenerateMonthlyScheduleService() {
        return shiftGenerateMonthlyScheduleService;
    }

    public void setShiftGenerateMonthlyScheduleService(ShiftGenerateMonthlyScheduleService<ShiftGenerateMonthlySchedule> shiftGenerateMonthlyScheduleService) {
        this.shiftGenerateMonthlyScheduleService = shiftGenerateMonthlyScheduleService;
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
    
    

    public PoolCarRequestService<PoolCarRequest> getPoolCarRequestService() {
        return poolCarRequestService;
    }

    public void setPoolCarRequestService(PoolCarRequestService<PoolCarRequest> poolCarRequestService) {
        this.poolCarRequestService = poolCarRequestService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public Validator getPoolCarRequestValidator() {
        return poolCarRequestValidator;
    }

    public void setPoolCarRequestValidator(Validator poolCarRequestValidator) {
        this.poolCarRequestValidator = poolCarRequestValidator;
    }

}
