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
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.holiday.HolidayMasterService;
import com.bul.zydex.service.leave.COffLeaveMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveEmployeeDetailService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
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
        } catch (Exception e) { /*report an error*/ }
         JSONObject jsonObject = new JSONObject(jb.toString());

//        try {
//            JSONObject jsonObject = new JSONObject(jb.toString());
//        } catch (Exception e) {
//            throw new IOException("Error parsing JSON request string");
//        }
        return jsonObject;
  
    }


    
}
