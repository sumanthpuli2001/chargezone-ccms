/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.travel;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.HotelAccommodation;
import com.bul.zydex.service.travel.HotelAccommodationService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class HotelAccommodationAbstract extends CustomAbstract {

    protected HotelAccommodationService<HotelAccommodation> hotelAccommodationService;
    protected Validator hotelAccommodationValidator;

    public HotelAccommodationService<HotelAccommodation> getHotelAccommodationService() {
        return hotelAccommodationService;
    }

    public void setHotelAccommodationService(HotelAccommodationService<HotelAccommodation> hotelAccommodationService) {
        this.hotelAccommodationService = hotelAccommodationService;
    }

    public Validator getHotelAccommodationValidator() {
        return hotelAccommodationValidator;
    }

    public void setHotelAccommodationValidator(Validator hotelAccommodationValidator) {
        this.hotelAccommodationValidator = hotelAccommodationValidator;
    }

}
