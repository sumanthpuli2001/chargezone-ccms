/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.travel;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.TravelDetail;
import com.bul.zydex.service.travel.TravelDetailService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class TravelDetailAbstract extends CustomAbstract {

    protected TravelDetailService<TravelDetail> travelDetailService;
    protected Validator travelDetailValidator;

    public TravelDetailService<TravelDetail> getTravelDetailService() {
        return travelDetailService;
    }

    public void setTravelDetailService(TravelDetailService<TravelDetail> travelDetailService) {
        this.travelDetailService = travelDetailService;
    }

    public Validator getTravelDetailValidator() {
        return travelDetailValidator;
    }

    public void setTravelDetailValidator(Validator travelDetailValidator) {
        this.travelDetailValidator = travelDetailValidator;
    }

}
