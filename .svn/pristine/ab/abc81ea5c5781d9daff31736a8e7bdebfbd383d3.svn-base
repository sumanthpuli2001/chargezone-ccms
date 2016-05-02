/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.HoursBasisDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class HoursBasisServiceImpl<T> extends GenericsServiceImpl<T> implements HoursBasisService<T> {

    protected HoursBasisDAO<T> hoursBasisDAO;

    public HoursBasisDAO<T> getHoursBasisDAO() {
        return hoursBasisDAO;
    }

    public void setHoursBasisDAO(HoursBasisDAO<T> hoursBasisDAO) {
        this.hoursBasisDAO = hoursBasisDAO;
        setGenericsDAO(hoursBasisDAO);
    }

    @Override
    public List<?> checkByTitleOfHourBasis(final String title) {
        return hoursBasisDAO.checkByTitleOfHourBasis(title);
    }
    
}
