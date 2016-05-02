/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class LeaveTypeMasterAbstract extends CustomAbstract {

    protected LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService;
    protected Validator leaveTypeMasterValidator;
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

    public Validator getLeaveTypeMasterValidator() {
        return leaveTypeMasterValidator;
    }

    public void setLeaveTypeMasterValidator(Validator leaveTypeMasterValidator) {
        this.leaveTypeMasterValidator = leaveTypeMasterValidator;
    }
    protected void leaveTypeList(HttpServletRequest request) {
        LeaveTypeMaster leaveTypeMaster=new LeaveTypeMaster();
        List<?> leaveType = leaveTypeMasterService.read();

        Map<Integer, String> leaveType1 = new HashMap<>();
        for (Object o : leaveType) {
            leaveTypeMaster = (LeaveTypeMaster) o;
            leaveType1.put(leaveTypeMaster.getId(), leaveTypeMaster.getLeaveType()); 
        }
        request.setAttribute("leaveType", leaveType1); 
    }

}
