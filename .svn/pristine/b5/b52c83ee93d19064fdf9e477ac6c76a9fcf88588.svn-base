/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.LeaveEncashment;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.leave.LeaveEncashmentService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class LeaveEncashmentAbstract extends CustomAbstract {

    protected LeaveEncashmentService<LeaveEncashment> leaveEncashmentService;
    protected LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService;
    protected EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService;
    protected Validator leaveEncashmentValidator;

    public LeaveEncashmentService<LeaveEncashment> getLeaveEncashmentService() {
        return leaveEncashmentService;
    }

    public void setLeaveEncashmentService(LeaveEncashmentService<LeaveEncashment> leaveEncashmentService) {
        this.leaveEncashmentService = leaveEncashmentService;
    }

    public Validator getLeaveEncashmentValidator() {
        return leaveEncashmentValidator;
    }

    public void setLeaveEncashmentValidator(Validator leaveEncashmentValidator) {
        this.leaveEncashmentValidator = leaveEncashmentValidator;
    }

    public LeaveTypeMasterService<LeaveTypeMaster> getLeaveTypeMasterService() {
        return leaveTypeMasterService;
    }

    public void setLeaveTypeMasterService(LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService) {
        this.leaveTypeMasterService = leaveTypeMasterService;
    }

    public EmployeeLeaveBalanceService<EmployeeLeaveBalance> getEmployeeLeaveBalanceService() {
        return employeeLeaveBalanceService;
    }

    public void setEmployeeLeaveBalanceService(EmployeeLeaveBalanceService<EmployeeLeaveBalance> employeeLeaveBalanceService) {
        this.employeeLeaveBalanceService = employeeLeaveBalanceService;
    }

    protected void readleaveType(HttpServletRequest request) {
        List list = leaveTypeMasterService.read();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        Map<Integer, String> leaveTypemap = new HashMap();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            leaveTypeMaster = (LeaveTypeMaster) iterator.next();
            if (leaveTypeMaster.isCarriedForwardStatus()) {
                leaveTypemap.put(leaveTypeMaster.getId(), leaveTypeMaster.getLeaveType());
            }
        }
        request.setAttribute("leaveTypemap11", leaveTypemap);
    }

}
