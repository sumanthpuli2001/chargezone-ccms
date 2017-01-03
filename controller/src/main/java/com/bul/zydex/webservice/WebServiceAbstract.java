/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.ItServiceRequest;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emprequest.HrServiceRequestService;
import com.bul.zydex.service.emprequest.ItServiceRequestService;
import com.bul.zydex.service.expense.ExpenseMasterService;
import com.bul.zydex.service.holiday.HolidayMasterService;
import com.bul.zydex.service.leave.COffLeaveMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveEmployeeDetailService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import com.bul.zydex.service.travel.TravelRequestMasterService;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Nishant
 */
public abstract class WebServiceAbstract extends CustomAbstract {

    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected LeaveEmployeeDetailService<LeaveEmployeeDetail> leaveEmployeeDetailService;
    protected LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService;
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;
    protected HolidayMasterService<HolidayMaster> holidayMasterService;
    protected COffLeaveMasterService<COffLeaveMaster> cOffLeaveMasterService;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService;
    protected ExpenseMasterService<ExpenseMaster> expenseMasterService;
    protected ItServiceRequestService<ItServiceRequest> itServiceRequestService;
    protected HrServiceRequestService<HrServiceRequest> hrServiceRequestService;
    protected EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService;

    public EmployeeShiftDataService<EmployeeShiftData> getEmployeeShiftDataService() {
        return employeeShiftDataService;
    }

    public void setEmployeeShiftDataService(EmployeeShiftDataService<EmployeeShiftData> employeeShiftDataService) {
        this.employeeShiftDataService = employeeShiftDataService;
    }
    

    public ItServiceRequestService<ItServiceRequest> getItServiceRequestService() {
        return itServiceRequestService;
    }

    public void setItServiceRequestService(ItServiceRequestService<ItServiceRequest> itServiceRequestService) {
        this.itServiceRequestService = itServiceRequestService;
    }

    public HrServiceRequestService<HrServiceRequest> getHrServiceRequestService() {
        return hrServiceRequestService;
    }

    public void setHrServiceRequestService(HrServiceRequestService<HrServiceRequest> hrServiceRequestService) {
        this.hrServiceRequestService = hrServiceRequestService;
    }
    public TravelRequestMasterService<TravelRequestMaster> getTravelRequestMasterService() {
        return travelRequestMasterService;
    }

    public void setTravelRequestMasterService(TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService) {
        this.travelRequestMasterService = travelRequestMasterService;
    }

    public ExpenseMasterService<ExpenseMaster> getExpenseMasterService() {
        return expenseMasterService;
    }

    public void setExpenseMasterService(ExpenseMasterService<ExpenseMaster> expenseMasterService) {
        this.expenseMasterService = expenseMasterService;
    }
    
    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public COffLeaveMasterService<COffLeaveMaster> getcOffLeaveMasterService() {
        return cOffLeaveMasterService;
    }

    public void setcOffLeaveMasterService(COffLeaveMasterService<COffLeaveMaster> cOffLeaveMasterService) {
        this.cOffLeaveMasterService = cOffLeaveMasterService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public LeaveEmployeeDetailService<LeaveEmployeeDetail> getLeaveEmployeeDetailService() {
        return leaveEmployeeDetailService;
    }

    public void setLeaveEmployeeDetailService(LeaveEmployeeDetailService<LeaveEmployeeDetail> leaveEmployeeDetailService) {
        this.leaveEmployeeDetailService = leaveEmployeeDetailService;
    }

    public LeaveTypeMasterService<LeaveTypeMaster> getLeaveTypeMasterService() {
        return leaveTypeMasterService;
    }

    public void setLeaveTypeMasterService(LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService) {
        this.leaveTypeMasterService = leaveTypeMasterService;
    }

    public HolidayMasterService<HolidayMaster> getHolidayMasterService() {
        return holidayMasterService;
    }

    public void setHolidayMasterService(HolidayMasterService<HolidayMaster> holidayMasterService) {
        this.holidayMasterService = holidayMasterService;
    }

    public JSONObject doPost(HttpServletRequest request)
            throws ServletException, IOException, JSONException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            /*report an error*/ }
        JSONObject jsonObject = new JSONObject(jb.toString());

        return jsonObject;

    }

}
