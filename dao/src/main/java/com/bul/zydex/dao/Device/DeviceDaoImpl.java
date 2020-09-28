/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Device;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DeviceDetails;

/**
 *
 * @author Aman Bahukhandi
 */
public class DeviceDaoImpl<T> extends GenericsDAOImpl<T> implements DeviceDao<T> {

    @Override
    protected Class getDomainClass() {
        return DeviceDetails.class;
    }

}
