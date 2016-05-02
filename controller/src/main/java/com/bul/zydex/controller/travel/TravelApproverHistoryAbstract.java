/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.travel;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.TravelApproverHistory;
import com.bul.zydex.service.travel.TravelApproverHistoryService;

/**
 *
 * @author Irfan
 */
public class TravelApproverHistoryAbstract extends CustomAbstract {

    protected TravelApproverHistoryService<TravelApproverHistory> travelApproverHistoryService;

    public TravelApproverHistoryService<TravelApproverHistory> getTravelApproverHistoryService() {
        return travelApproverHistoryService;
    }

    public void setTravelApproverHistoryService(TravelApproverHistoryService<TravelApproverHistory> travelApproverHistoryService) {
        this.travelApproverHistoryService = travelApproverHistoryService;
    }

}
