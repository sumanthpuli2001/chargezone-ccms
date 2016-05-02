/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.holiday;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.holiday.HolidayMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.validator.holiday.HolidayMasterValidator;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Irfan
 */
public abstract class HolidayMasterAbstract extends CustomAbstract {

    protected HolidayMasterService<HolidayMaster> holidayMasterService;
    protected HolidayMasterValidator holidayMasterValidator;
    protected LocationMasterService<LocationMaster> locationMasterService;
//    protected Validator holidayMasterValidator;

    public HolidayMasterValidator getHolidayMasterValidator() {
        return holidayMasterValidator;
    }

    public void setHolidayMasterValidator(HolidayMasterValidator holidayMasterValidator) {
        this.holidayMasterValidator = holidayMasterValidator;
    }

//    public Validator getHolidayMasterValidator() {
//        return holidayMasterValidator;
//    }
//    public void setHolidayMasterValidator(Validator holidayMasterValidator) {
//        this.holidayMasterValidator = holidayMasterValidator;
//    }
//
//
    public HolidayMasterService<HolidayMaster> getHolidayMasterService() {
        return holidayMasterService;
    }

    public void setHolidayMasterService(HolidayMasterService<HolidayMaster> holidayMasterService) {
        this.holidayMasterService = holidayMasterService;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    protected Map<Integer, String> readLocations() {
        List locationList = locationMasterService.read();
        LocationMaster locationMaster = new LocationMaster();
        Map<Integer, String> locationMap = new HashMap<Integer, String>();
        for (Object o : locationList) {
            locationMaster = (LocationMaster) o;
            locationMap.put(locationMaster.getId(), locationMaster.getLocation());
        }
//        request.setAttribute("locationMap", locationMap);
//        request.getSession().setAttribute("locationMap", locationMap);
        return locationMap;
    }

}
