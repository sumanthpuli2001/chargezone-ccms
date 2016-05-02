/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.location;

import com.bul.zydex.dao.location.LocationMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author admin
 */
public class LocationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements LocationMasterService<T> {

    private LocationMasterDAO<T> locationMasterDAO;

    public LocationMasterDAO<T> getLocationMasterDAO() {
        return locationMasterDAO;
    }

    @Override
    public boolean isExist(T object) {
        return locationMasterDAO.isExist(object);
    }

    @Override
    public List<?> readEmpByLocation() {
        return locationMasterDAO.readEmpByLocation();

    }

    public void setLocationMasterDAO(LocationMasterDAO<T> locationMasterDAO) {
        this.locationMasterDAO = locationMasterDAO;
        setGenericsDAO(locationMasterDAO);
    }

    @Override
    public List<?> readByName(String workLocation) {
        return locationMasterDAO.readByName(workLocation);

    }
}
