/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.DeviceMasterDAO;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class DeviceMasterServiceImpl<T> extends GenericsServiceImpl<T> implements DeviceMasterService<T> {
    protected DeviceMasterDAO<T> deviceMasterDAO;   

    public DeviceMasterDAO<T> getDeviceMasterDAO() {
        return deviceMasterDAO;
    }

    public void setDeviceMasterDAO(DeviceMasterDAO<T> deviceMasterDAO) {
        this.deviceMasterDAO = deviceMasterDAO;
        setGenericsDAO(deviceMasterDAO);
    }
    
}
