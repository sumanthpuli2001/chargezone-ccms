/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.nodue;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ExitInterviewMaster;
import com.bul.zydex.model.NoDueMaster;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.exitInterview.ExitInterviewMasterService;
import com.bul.zydex.service.nodue.NoDueMasterService;
import com.bul.zydex.service.resignation.ResignationMasterService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public abstract class NoDueMasterAbstract extends CustomAbstract {

    protected NoDueMasterService<NoDueMaster> noDueMasterService;
    protected ResignationMasterService<ResignationMaster> resignationMasterService;
    protected ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }
      
      

    public ResignationMasterService<ResignationMaster> getResignationMasterService() {
        return resignationMasterService;
    }

    public void setResignationMasterService(ResignationMasterService<ResignationMaster> resignationMasterService) {
        this.resignationMasterService = resignationMasterService;
    }

    public ExitInterviewMasterService<ExitInterviewMaster> getExitInterviewMasterService() {
        return exitInterviewMasterService;
    }

    public void setExitInterviewMasterService(ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService) {
        this.exitInterviewMasterService = exitInterviewMasterService;
    }
    protected Validator noDueMasterValidator;

    public NoDueMasterService<NoDueMaster> getNoDueMasterService() {
        return noDueMasterService;
    }

    public void setNoDueMasterService(NoDueMasterService<NoDueMaster> noDueMasterService) {
        this.noDueMasterService = noDueMasterService;
    }

    public Validator getNoDueMasterValidator() {
        return noDueMasterValidator;
    }

    public void setNoDueMasterValidator(Validator noDueMasterValidator) {
        this.noDueMasterValidator = noDueMasterValidator;
    }

    public void setStatus(HttpServletRequest request) {
        Map<String, String> m1 = new HashMap();
        m1.put("na", "NA");
        m1.put("notIssued", "Not Issued");
        m1.put("cleared", "Cleared");
        m1.put("pending", "Pending");
        request.setAttribute("status2", m1);
    }
}
