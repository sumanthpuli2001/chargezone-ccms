/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.service.attendanceRegularization.AttendanceRegularizationMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.overTime.OverTimeMasterService;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class AttendanceRegularizationMasterwebAbstract extends CustomAbstract {
    
     protected AttendanceRegularizationMasterService<AttendanceRegularization> attendanceRegularizationMasterService;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService;
    protected OverTimeMasterService<OverTimeMaster> overTimeMasterService;

    public OverTimeMasterService<OverTimeMaster> getOverTimeMasterService() {
        return overTimeMasterService;
    }

    public void setOverTimeMasterService(OverTimeMasterService<OverTimeMaster> overTimeMasterService) {
        this.overTimeMasterService = overTimeMasterService;
    }

    public EmployeeShiftDataService<EmployeeShiftData> getEmployeeShiftDataService() {
        return employeeShiftDataService;
    }

    public void setEmployeeShiftDataService(EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService) {
        this.employeeShiftDataService = employeeShiftDataService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;

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
    protected LocationMasterService<LocationMaster> locationMasterService;

    public AttendanceRegularizationMasterService<AttendanceRegularization> getAttendanceRegularizationMasterService() {
        return attendanceRegularizationMasterService;
    }

    public void setAttendanceRegularizationMasterService(AttendanceRegularizationMasterService<AttendanceRegularization> attendanceRegularizationMasterService) {
        this.attendanceRegularizationMasterService = attendanceRegularizationMasterService;
    }

    public JSONObject doConvert(HttpServletRequest request) throws IOException, JSONException {

        StringBuffer buffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader bufferedReader = request.getReader();
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
        }
        JSONObject jSONObject = new JSONObject(buffer.toString());

        return jSONObject;
    }

}
