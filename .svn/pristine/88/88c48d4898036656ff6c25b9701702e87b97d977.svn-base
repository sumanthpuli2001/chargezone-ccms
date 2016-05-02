/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.holiday;

import com.bul.zydex.dao.holiday.HolidayMasterDAO;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan
 */
public class HolidayMasterServiceImpl<T> extends GenericsServiceImpl<T> implements HolidayMasterService<T> {

    private HolidayMasterDAO<T> holidayMasterDAO;

    public HolidayMasterDAO<T> getHolidayMasterDAO() {
        return holidayMasterDAO;
    }

    public void setHolidayMasterDAO(HolidayMasterDAO<T> holidayMasterDAO) {
        this.holidayMasterDAO = holidayMasterDAO;
        setGenericsDAO(holidayMasterDAO);

    }

    @Override
    public List<?> readWithLocation() {
        return holidayMasterDAO.readWithLocation();
    }

    @Override
    public boolean isExist(T object) {
        return holidayMasterDAO.isExist(object);
    }
    @Override
    public List<?> checkHoliday(String date,String locationId) {
        return holidayMasterDAO.checkHoliday(date,locationId);
    }
    @Override
  public int searchMonthWiseHoliday(T object) {
        return holidayMasterDAO.searchMonthWiseHoliday(object);
    }
  
    @Override
    public List<?> readHolidaysLocationWise(String locationId){
        return holidayMasterDAO.readHolidaysLocationWise(locationId);
    }

}
