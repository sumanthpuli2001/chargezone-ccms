/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.service.leave.COffLeaveMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author Khurshid Khokhar <Khokharkhurshid123@gmail.com>
 */
public class CoffMasterAbstract extends CustomAbstract {

  protected COffLeaveMasterService<COffLeaveMaster> cOffLeaveMasterService;
  protected  Validator CoffMasterValidator;

    public COffLeaveMasterService<COffLeaveMaster> getcOffLeaveMasterService() {
        return cOffLeaveMasterService;
    }

    public void setcOffLeaveMasterService(COffLeaveMasterService<COffLeaveMaster> cOffLeaveMasterService) {
        this.cOffLeaveMasterService = cOffLeaveMasterService;
    }

    public Validator getCoffMasterValidator() {
        return CoffMasterValidator;
    }

    public void setCoffMasterValidator(Validator CoffMasterValidator) {
        this.CoffMasterValidator = CoffMasterValidator;
    }
  
  


}
