/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.IntervalMaster;
import com.bul.zydex.service.IntervalMasterService;

/**
 *
 * @author BlackBull
 */
public class IntervalMasterAbstract extends CustomAbstract{
    
    protected IntervalMasterService<IntervalMaster> intervalMasterService;

    public IntervalMasterService<IntervalMaster> getIntervalMasterService() {
        return intervalMasterService;
    }

    public void setIntervalMasterService(IntervalMasterService<IntervalMaster> intervalMasterService) {
        this.intervalMasterService = intervalMasterService;
    }
    
    
}
