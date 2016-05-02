/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.zydexLocation;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.zydexLocation.ZydexLocationMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan
 */
public class ZydexLocationMasterAbstract extends CustomAbstract {

    protected Validator zydexLocationMasterValidator;
    protected ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService;

    public Validator getZydexLocationMasterValidator() {
        return zydexLocationMasterValidator;
    }

    public void setZydexLocationMasterValidator(Validator zydexLocationMasterValidator) {
        this.zydexLocationMasterValidator = zydexLocationMasterValidator;
    }

    public ZydexLocationMasterService<ZydexLocationMaster> getZydexLocationMasterService() {
        return zydexLocationMasterService;
    }

    public void setZydexLocationMasterService(ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService) {
        this.zydexLocationMasterService = zydexLocationMasterService;
    }

}
