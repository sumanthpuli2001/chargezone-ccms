/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AppraisalFillingData;
import com.bul.zydex.service.appraisalPerformance.AppraisalFillingDataService;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class AppraisalFillingDataAbstract extends CustomAbstract{
     protected Validator appraisalFillingDataValidator;
     protected AppraisalFillingDataService<AppraisalFillingData> appraisalFillingDataService;

    public Validator getAppraisalFillingDataValidator() {
        return appraisalFillingDataValidator;
    }

    public void setAppraisalFillingDataValidator(Validator appraisalFillingDataValidator) {
        this.appraisalFillingDataValidator = appraisalFillingDataValidator;
    }

    public AppraisalFillingDataService<AppraisalFillingData> getAppraisalFillingDataService() {
        return appraisalFillingDataService;
    }

    public void setAppraisalFillingDataService(AppraisalFillingDataService<AppraisalFillingData> appraisalFillingDataService) {
        this.appraisalFillingDataService = appraisalFillingDataService;
    }
    
}
