/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ESICMaster;
import com.bul.zydex.service.PayrollESIC.ESICMasterService;

/**
 *
 * @author Rishi
 */
public class PayrollESICAbstract extends CustomAbstract {

    protected ESICMasterService<ESICMaster> eSICMasterService;

    public ESICMasterService<ESICMaster> geteSICMasterService() {
        return eSICMasterService;
    }

    public void seteSICMasterService(ESICMasterService<ESICMaster> eSICMasterService) {
        this.eSICMasterService = eSICMasterService;
    }

}
