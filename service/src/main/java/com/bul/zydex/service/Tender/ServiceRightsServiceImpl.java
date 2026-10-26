/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceRightsDao;
import com.bul.zydex.model.ServiceRights;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class ServiceRightsServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceRightsService<T> {
    
    private ServiceRightsDao<T> serviceRightsDao;

    public ServiceRightsDao<T> getServiceRightsDao() {
        return serviceRightsDao;
    }

    public void setServiceRightsDao(ServiceRightsDao<T> serviceRightsDao) {
        this.serviceRightsDao = serviceRightsDao;
        setGenericsDAO(serviceRightsDao);
    }

    @Override
    public ServiceRights ReadDepartmentLocation(String department, String location) {
        return serviceRightsDao.ReadDepartmentLocation(department,location);
    }
}
