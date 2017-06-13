/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.DeviceMasterNotificationDAO;
import java.util.List;

/**
 *
 * @author Dell
 */
public class DeviceMasterNotificationServiceImpl<T> extends GenericsServiceImpl<T> implements DeviceMasterNotificationService<T> {

    protected DeviceMasterNotificationDAO<T> deviceMasterNotificationDAO;

    public DeviceMasterNotificationDAO<T> getDeviceMasterNotificationDAO() {
        return deviceMasterNotificationDAO;
    }

    public void setDeviceMasterNotificationDAO(DeviceMasterNotificationDAO<T> deviceMasterNotificationDAO) {
        this.deviceMasterNotificationDAO = deviceMasterNotificationDAO;
        setGenericsDAO(deviceMasterNotificationDAO);
    }

    @Override
    public List<?> readByIpAddress(T object) {
        return deviceMasterNotificationDAO.readByIpAddress(object);
    }

}
