/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.StationType;

import com.bul.zydex.dao.StationType.StationTypeDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class StationTypeServiceImpl<T> extends GenericsServiceImpl<T> implements StationTypeService<T> {

    private StationTypeDao<T> stationTypeDao;

    public StationTypeDao<T> getStationTypeDao() {
        return stationTypeDao;
    }

    public void setStationTypeDao(StationTypeDao<T> stationTypeDao) {
        this.stationTypeDao = stationTypeDao;
        setGenericsDAO(stationTypeDao);

    }

    @Override
    public List getstationTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return stationTypeDao.getstationTypePagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getstationTypeCount() {
        return stationTypeDao.getstationTypeCount();
    }

    @Override
    public int getFilteredstationTypeCount(String search) {
        return stationTypeDao.getFilteredstationTypeCount(search);
    }

}
