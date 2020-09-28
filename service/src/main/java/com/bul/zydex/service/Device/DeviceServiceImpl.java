/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Device;

import com.bul.zydex.dao.Device.DeviceDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Aman Bahukhandi
 */
public class DeviceServiceImpl <T>extends  GenericsServiceImpl<T> implements DeviceService<T>{
    
    private DeviceDao<T> deviceDao;

    public DeviceDao<T> getDeviceDao() {
        return deviceDao;
    }

    public void setDeviceDao(DeviceDao<T> deviceDao) {
        this.deviceDao = deviceDao;
        setGenericsDAO(deviceDao);
    }
    
    
}
