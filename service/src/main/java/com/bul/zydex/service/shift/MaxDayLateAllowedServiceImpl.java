/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.MaxDayLateAllowedDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author AJAY
 */
public class MaxDayLateAllowedServiceImpl<T> extends GenericsServiceImpl<T> implements MaxDayLateAllowedService<T> {

    protected MaxDayLateAllowedDAO<T> maxDayLateAllowedDAO;

    public MaxDayLateAllowedDAO<T> getMaxDayLateAllowedDAO() {
        return maxDayLateAllowedDAO;
    }

    public void setMaxDayLateAllowedDAO(MaxDayLateAllowedDAO<T> maxDayLateAllowedDAO) {
        this.maxDayLateAllowedDAO = maxDayLateAllowedDAO;
        setGenericsDAO(maxDayLateAllowedDAO);
    }

}
