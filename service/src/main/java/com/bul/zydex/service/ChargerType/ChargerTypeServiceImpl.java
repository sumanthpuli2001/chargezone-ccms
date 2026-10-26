/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ChargerType;

import com.bul.zydex.dao.ChargerType.ChargerTypeDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ChargerTypeServiceImpl<T> extends GenericsServiceImpl<T> implements ChargerTypeService<T> {

    private ChargerTypeDao<T> chargerTypeDao;

    public ChargerTypeDao<T> getChargerTypeDao() {
        return chargerTypeDao;
    }

    public void setChargerTypeDao(ChargerTypeDao<T> chargerTypeDao) {
        this.chargerTypeDao = chargerTypeDao;
        setGenericsDAO(chargerTypeDao);
    }

    @Override
    public List getChargerPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return chargerTypeDao.getChargerPagination(start, length, searchValue, orderColumn, orderDir);

    }

    @Override
    public int getTotalChargerCount() {

        return chargerTypeDao.getTotalChargerCount();

    }

    @Override
    public int getFilteredChargerCount(String searchValue) {
        return chargerTypeDao.getFilteredChargerCount(searchValue); 
        
    }

}
