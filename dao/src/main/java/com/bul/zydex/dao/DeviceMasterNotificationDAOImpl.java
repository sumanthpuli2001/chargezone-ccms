/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.DeviceMasterNotification;
import java.util.List;

/**
 *
 * @author Dell
 */
public class DeviceMasterNotificationDAOImpl<T> extends GenericsDAOImpl<T> implements DeviceMasterNotificationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return DeviceMasterNotification.class;
    }

    @Override
    public List<?> readByIpAddress(T object) {
        DeviceMasterNotification deviceMasterNotification = (DeviceMasterNotification) object;
        String query = "";

        query += " FROM DeviceMasterNotification a"
                + " WHERE a.ipAddress ='" + deviceMasterNotification.getIpAddress() + "'";

        return getHibernateTemplate().find(query);
    }

}
