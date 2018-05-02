/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.LeaveEmployeeDetailsApprovalHistory;
import com.bul.zydex.service.leave.LeaveEmployeeDetailsApprovalHistoryService;

/**
 *
 * @author Admin
 */
public class LeaveEmployeeDetailsApprovalHistoryAbstract extends CustomAbstract{

    protected LeaveEmployeeDetailsApprovalHistoryService<LeaveEmployeeDetailsApprovalHistory> leaveEmployeeDetailsApprovalHistoryService;

    public LeaveEmployeeDetailsApprovalHistoryService<LeaveEmployeeDetailsApprovalHistory> getLeaveEmployeeDetailsApprovalHistoryService() {
        return leaveEmployeeDetailsApprovalHistoryService;
    }

    public void setLeaveEmployeeDetailsApprovalHistoryService(LeaveEmployeeDetailsApprovalHistoryService<LeaveEmployeeDetailsApprovalHistory> leaveEmployeeDetailsApprovalHistoryService) {
        this.leaveEmployeeDetailsApprovalHistoryService = leaveEmployeeDetailsApprovalHistoryService;
    }

   

}
