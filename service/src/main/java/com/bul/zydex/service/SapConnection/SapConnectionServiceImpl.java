/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SapConnection;

import com.bul.zydex.dao.SapConnection.SapConnectionDao;
import com.bul.zydex.service.GenericsServiceImpl;
import com.bul.zydex.service.Sap.SapDeliSchService;
import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public class SapConnectionServiceImpl<T> extends GenericsServiceImpl<T> implements SapConnectionService<T> {
   private SapConnectionDao<T> sapConnectionDao;

    public SapConnectionDao<T> getSapConnectionDao() {
        return sapConnectionDao;
    }

    public void setSapConnectionDao(SapConnectionDao<T> sapConnectionDao) {
        this.sapConnectionDao = sapConnectionDao;
        setGenericsDAO(sapConnectionDao);
    }

    @Override
    public List getSapPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return sapConnectionDao.getSapPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getSapPlantCount() {
        return sapConnectionDao.getSapPlantCount();
    }

    @Override
    public int getFilteredPlantCount(String search) {
        return sapConnectionDao.getFilteredPlantCount(search);
    }


    

   
}
