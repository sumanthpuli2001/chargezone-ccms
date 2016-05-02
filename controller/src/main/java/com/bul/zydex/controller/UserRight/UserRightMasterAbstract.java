/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.UserRight;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class UserRightMasterAbstract extends CustomAbstract{
   
    protected Validator userRightMasterValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public Validator getUserRightMasterValidator() {
        return userRightMasterValidator;
    }

    public void setUserRightMasterValidator(Validator userRightMasterValidator) {
        this.userRightMasterValidator = userRightMasterValidator;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }
}
