/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.IntervalMaster;

/**
 *
 * @author BlackBull
 */
public class IntervalMasterDAOImpl<T> extends GenericsDAOImpl<T> implements IntervalMasterDAO<T>{

    public Class getDomainClass() {
        return IntervalMaster.class;
    }

   
    
    
}
