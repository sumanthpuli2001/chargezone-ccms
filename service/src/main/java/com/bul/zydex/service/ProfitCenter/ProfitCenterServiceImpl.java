/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProfitCenter;

import com.bul.zydex.dao.ProfitCenter.ProfitCenterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ProfitCenterServiceImpl<T> extends GenericsServiceImpl<T> implements ProfitCenterService<T> {

    private ProfitCenterDao<T> profitCenterDao;

    public ProfitCenterDao<T> getProfitCenterDao() {
        return profitCenterDao;
    }

    public void setProfitCenterDao(ProfitCenterDao<T> profitCenterDao) {
        this.profitCenterDao = profitCenterDao;
        setGenericsDAO(profitCenterDao);
    }

    @Override
    public List getProfitPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return profitCenterDao.getProfitPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalProfitCount() {
        return profitCenterDao.getTotalProfitCount();
    }

    @Override
    public int getFilteredProfitCount(String search) {
        return profitCenterDao.getFilteredProfitCount(search);
    }

}
