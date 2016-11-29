/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.PmpFormStatusMaster;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AppraisalPerformanceActivities;
import com.bul.zydex.model.AppraisalPerformanceKra;
import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.service.PmpFormStatusMaster.PmpFormStatusMasterService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceActivitiesService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceKraService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceService;

/**
 *
 * @author BlackBull
 */
public class PmpFormStatusMasterAbstract  extends CustomAbstract{
     protected PmpFormStatusMasterService<PmpFormStatusMaster> pmpFormStatusMasterService;
     protected AppraisalPerformanceService<AppraisalPerformanceMaster> appraisalPerformanceService;
     protected AppraisalPerformanceKraService<AppraisalPerformanceKra> appraisalPerformanceKraService;
     protected AppraisalPerformanceActivitiesService<AppraisalPerformanceActivities> appraisalPerformanceActivitiesService;

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

    public AppraisalPerformanceKraService<AppraisalPerformanceKra> getAppraisalPerformanceKraService() {
        return appraisalPerformanceKraService;
    }

    public void setAppraisalPerformanceKraService(AppraisalPerformanceKraService<AppraisalPerformanceKra> appraisalPerformanceKraService) {
        this.appraisalPerformanceKraService = appraisalPerformanceKraService;
    }

    public AppraisalPerformanceActivitiesService<AppraisalPerformanceActivities> getAppraisalPerformanceActivitiesService() {
        return appraisalPerformanceActivitiesService;
    }

    public void setAppraisalPerformanceActivitiesService(AppraisalPerformanceActivitiesService<AppraisalPerformanceActivities> appraisalPerformanceActivitiesService) {
        this.appraisalPerformanceActivitiesService = appraisalPerformanceActivitiesService;
    }
    
}
