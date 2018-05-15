/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Kaizen;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.KaizenApproval;
import com.bul.zydex.model.KaizenMaster;
import com.bul.zydex.service.Approval.ApprovalUserService;
import com.bul.zydex.service.Kaizen.KaizenApprovalService;
import com.bul.zydex.service.Kaizen.KaizenMasterService;
import com.bul.zydex.service.emp.DesignationMasterService;

/**
 *
 * @author Aman
 */
public class KaizenMasterAbstract extends CustomAbstract {

    protected KaizenMasterService<KaizenMaster> kaizenMasterService;
    protected ApprovalUserService<ApprovalUser> approvalUserService;
    protected KaizenApprovalService<KaizenApproval> kaizenApprovalService;
    protected DesignationMasterService<DesignationMaster> designationMasterService;

    public KaizenMasterService<KaizenMaster> getKaizenMasterService() {
        return kaizenMasterService;
    }

    public void setKaizenMasterService(KaizenMasterService<KaizenMaster> kaizenMasterService) {
        this.kaizenMasterService = kaizenMasterService;
    }

    public ApprovalUserService<ApprovalUser> getApprovalUserService() {
        return approvalUserService;
    }

    public void setApprovalUserService(ApprovalUserService<ApprovalUser> approvalUserService) {
        this.approvalUserService = approvalUserService;
    }

    public KaizenApprovalService<KaizenApproval> getKaizenApprovalService() {
        return kaizenApprovalService;
    }

    public void setKaizenApprovalService(KaizenApprovalService<KaizenApproval> kaizenApprovalService) {
        this.kaizenApprovalService = kaizenApprovalService;
    }

    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }

}
