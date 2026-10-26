/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.LocationMasters;

import com.bul.zydex.dao.LocationMasters.LocationMastersDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class LocationMastersServiceImpl<T> extends GenericsServiceImpl<T> implements LocationMastersService<T> {

    private LocationMastersDao<T> locationMastersDao;

    public LocationMastersDao<T> getLocationMastersDao() {
        return locationMastersDao;
    }

    public void setLocationMastersDao(LocationMastersDao<T> locationMastersDao) {
        this.locationMastersDao = locationMastersDao;
        setGenericsDAO(locationMastersDao);

    }

    @Override
    public List readByPlantCode(String plantCode) {
        return locationMastersDao.readByPlantCode(plantCode);
    }

    @Override
    public List getLocationMastersPagination(int start, int length, String search, String orderColumn, String orderDir) {
        return locationMastersDao.getLocationMastersPagination(start, length, search, orderColumn, orderDir);
    }

    @Override
    public int getTotalLocationMastersCount() {
        return locationMastersDao.getTotalLocationMastersCount();
    }

    @Override
    public int getFilteredLocationMastersCount(String search) {
        return locationMastersDao.getFilteredLocationMastersCount(search);
    }

}
