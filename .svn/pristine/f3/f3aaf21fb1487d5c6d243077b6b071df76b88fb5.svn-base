/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.IntervalMasterDAO;

/**
 *
 * @author BlackBull
 */
public class IntervalMasterServiceImpl<T> extends GenericsServiceImpl<T> implements IntervalMasterService<T>{
    
    protected IntervalMasterDAO<T> intervalMasterDAO;

    public IntervalMasterDAO<T> getIntervalMasterDAO() {
        return intervalMasterDAO;
    }

    public void setIntervalMasterDAO(IntervalMasterDAO<T> intervalMasterDAO) {
        this.intervalMasterDAO = intervalMasterDAO;
        setGenericsDAO(intervalMasterDAO);
    }
    
    
    
}
