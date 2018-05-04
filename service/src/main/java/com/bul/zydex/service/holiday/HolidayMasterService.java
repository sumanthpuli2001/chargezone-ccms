/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.holiday;

import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Irfan
 */
public interface HolidayMasterService<T> extends GenericsService<T> {

    public List<?> readWithLocation();

    public boolean isExist(T object);

    public List<?> checkHoliday(String date, String locationId);

    public int searchMonthWiseHoliday(T object);

    public List<?> readHolidaysLocationWise(String locationId);
    
    public List<?> readHolidaysDateLocationWise(String holidayFrom, String holidayTo, int locationId);
}
