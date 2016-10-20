/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.PmpFormStatusMaster;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.service.PmpFormStatusMaster.PmpFormStatusMasterService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceService;

/**
 *
 * @author BlackBull
 */
public class PmpFormStatusMasterAbstract  extends CustomAbstract{
     protected PmpFormStatusMasterService<PmpFormStatusMaster> pmpFormStatusMasterService;
     protected AppraisalPerformanceService<AppraisalPerformanceMaster> appraisalPerformanceService;

    public PmpFormStatusMasterService<PmpFormStatusMaster> getPmpFormStatusMasterService() {
        return pmpFormStatusMasterService;
    }

    public void setPmpFormStatusMasterService(PmpFormStatusMasterService<PmpFormStatusMaster> pmpFormStatusMasterService) {
        this.pmpFormStatusMasterService = pmpFormStatusMasterService;
    }

    public AppraisalPerformanceService<AppraisalPerformanceMaster> getAppraisalPerformanceService() {
        return appraisalPerformanceService;
    }

    public void setAppraisalPerformanceService(AppraisalPerformanceService<AppraisalPerformanceMaster> appraisalPerformanceService) {
        this.appraisalPerformanceService = appraisalPerformanceService;
    }
}
