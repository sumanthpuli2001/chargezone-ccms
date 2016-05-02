/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.DeviceMaster;


/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class DeviceMasterDAOImpl <T> extends GenericsDAOImpl<T> implements DeviceMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
        return DeviceMaster.class;
    }
    
}
