/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.COffLeaveRequest;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.service.leave.COffLeaveRequestService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import com.bul.zydex.service.overTime.OverTimeMasterService;
import com.bul.zydex.validator.leave.COffLeaveRequestValidator;
import org.springframework.validation.Validator;

/**
 *
 * @author Dhaval Patel
 */
public abstract class COffLeaveRequestAbstract extends CustomAbstract {
 
    protected COffLeaveRequestService<COffLeaveRequest>cOffLeaveRequestService;
    protected OverTimeMasterService<OverTimeMaster>overTimeMasterService;
    protected Validator cOffLeaveRequestValidator;
     protected LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService;
      protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

      
    public LeaveTypeMasterService<LeaveTypeMaster> getLeaveTypeMasterService() {
        return leaveTypeMasterService;
    }

    public void setLeaveTypeMasterService(LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService) {
        this.leaveTypeMasterService = leaveTypeMasterService;
    }

     
    public OverTimeMasterService<OverTimeMaster> getOverTimeMasterService() {
        return overTimeMasterService;
    }

    public void setOverTimeMasterService(OverTimeMasterService<OverTimeMaster> overTimeMasterService) {
        this.overTimeMasterService = overTimeMasterService;
    }

    
    public Validator getcOffLeaveRequestValidator() {
        return cOffLeaveRequestValidator;
    }

    public void setcOffLeaveRequestValidator(Validator cOffLeaveRequestValidator) {
        this.cOffLeaveRequestValidator = cOffLeaveRequestValidator;
    }

 

    public COffLeaveRequestService<COffLeaveRequest> getcOffLeaveRequestService() {
        return cOffLeaveRequestService;
    }

    public void setcOffLeaveRequestService(COffLeaveRequestService<COffLeaveRequest> cOffLeaveRequestService) {
        this.cOffLeaveRequestService = cOffLeaveRequestService;
    }
    
   
}
