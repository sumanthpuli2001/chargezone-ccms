/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Approval;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ApprovalMaster;
import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.service.Approval.ApprovalMasterService;
import com.bul.zydex.service.Approval.ApprovalUserService;

/**
 *
 * @author Vikas
 */
public class ApprovalAbstract extends CustomAbstract{
    
    protected ApprovalMasterService<ApprovalMaster> approvalMasterService;
    protected ApprovalUserService<ApprovalUser> approvalUserService;

    public ApprovalMasterService<ApprovalMaster> getApprovalMasterService() {
        return approvalMasterService;
    }

    public void setApprovalMasterService(ApprovalMasterService<ApprovalMaster> approvalMasterService) {
        this.approvalMasterService = approvalMasterService;
    }

    public ApprovalUserService<ApprovalUser> getApprovalUserService() {
        return approvalUserService;
    }

    public void setApprovalUserService(ApprovalUserService<ApprovalUser> approvalUserService) {
        this.approvalUserService = approvalUserService;
    }
    
    
    
}
