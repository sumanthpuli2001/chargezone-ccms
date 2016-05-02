/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.resignation;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExitInterviewMaster;
import com.bul.zydex.model.NoDueMaster;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.exitInterview.ExitInterviewMasterService;
import com.bul.zydex.service.nodue.NoDueMasterService;
import com.bul.zydex.service.resignation.ResignationMasterService;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public abstract class ResignationMasterAbstract extends CustomAbstract {

    protected ResignationMasterService<ResignationMaster> resignationMasterService;
    protected ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService;
    protected NoDueMasterService<NoDueMaster> noDueMasterService;
    protected Validator resignationMasterValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }
      
      

    public Validator getResignationMasterValidator() {
        return resignationMasterValidator;
    }

    public void setResignationMasterValidator(Validator resignationMasterValidator) {
        this.resignationMasterValidator = resignationMasterValidator;
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

    public NoDueMasterService<NoDueMaster> getNoDueMasterService() {
        return noDueMasterService;
    }

    public void setNoDueMasterService(NoDueMasterService<NoDueMaster> noDueMasterService) {
        this.noDueMasterService = noDueMasterService;
    }

    public void selectResignedEmployee(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = resignationMasterService.readResignedEmployees();
        String tempStr = "[";
        Object[] arrayOfObject;

        EmployeeMaster employeeMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3]+ "\"}";
//                    + "  /" + arrayOfObject[4]
//                    + "  /" + arrayOfObject[5] 

        }
        tempStr += "]";

        request.setAttribute("resignedEmployeelist", tempStr);
    }
}
