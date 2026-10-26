/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CanopyVarient;

import com.bul.zydex.dao.CanopyVarient.CanopyVarientDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class CanopyVarientServiceImpl<T> extends GenericsServiceImpl<T> implements CanopyVarientService<T>  {
  
    private CanopyVarientDao<T> canopyVarientDao;

    public CanopyVarientDao<T> getCanopyVarientDao() {
        return canopyVarientDao;
    }

    public void setCanopyVarientDao(CanopyVarientDao<T> canopyVarientDao) {
        this.canopyVarientDao = canopyVarientDao;
        setGenericsDAO(canopyVarientDao);
        
    }

    @Override
    public int getTotalCanopyCount() {
        return canopyVarientDao.getTotalCanopyCount();
    }

    @Override
    public int getFilteredCanopyCount(String search) {
        return canopyVarientDao.getFilteredCanopyCount(search);
    }

    @Override
    public List getCanopyPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return canopyVarientDao.getCanopyPagination(start, length, searchValue, orderColumn, orderDir);
    }
    
    
}
