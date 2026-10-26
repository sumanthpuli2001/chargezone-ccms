/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DiscomMaster;

import com.bul.zydex.dao.DiscomMaster.DiscomMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DiscomMasterServiceImpl<T> extends GenericsServiceImpl<T> implements DiscomMasterService<T> {

    private DiscomMasterDao<T> discomMasterDao;

    public DiscomMasterDao<T> getDiscomMasterDao() {
        return discomMasterDao;
    }

    public void setDiscomMasterDao(DiscomMasterDao<T> discomMasterDao) {
        this.discomMasterDao = discomMasterDao;
        setGenericsDAO(discomMasterDao);
    }

    @Override
    public boolean isExist(T object) {
        return discomMasterDao.isExist(object);
    }

    @Override
    public List readByStateName(String state) {
        return discomMasterDao.readByStateName(state);

    }

    @Override
    public List getDiscomMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return discomMasterDao.getDiscomMasterPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalDiscomMasterCount() {
        return discomMasterDao.getTotalDiscomMasterCount();
    }

    @Override
    public int getFilteredDiscomMasterCount(String searchValue) {
        return discomMasterDao.getFilteredDiscomMasterCount(searchValue);
    }

}
