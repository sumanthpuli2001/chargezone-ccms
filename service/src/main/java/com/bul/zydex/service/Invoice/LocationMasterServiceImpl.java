/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Invoice;

import com.bul.zydex.dao.Invoice.LocationMasterDao;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class LocationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements LocationMasterService<T> {
    
    private LocationMasterDao<T> locationMasterDao;

    public LocationMasterDao<T> getLocationMasterDao() {
        return locationMasterDao;
    }

    public void setLocationMasterDao(LocationMasterDao<T> locationMasterDao) {
        this.locationMasterDao = locationMasterDao;
        setGenericsDAO(locationMasterDao);
    }
}
