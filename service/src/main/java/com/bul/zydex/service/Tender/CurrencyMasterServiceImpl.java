/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.CurrencyMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CurrencyMasterServiceImpl<T> extends GenericsServiceImpl<T> implements CurrencyMasterService<T> {
    
    private CurrencyMasterDao<T> currencyMasterDao;

    public CurrencyMasterDao<T> getCurrencyMasterDao() {
        return currencyMasterDao;
    }

    public void setCurrencyMasterDao(CurrencyMasterDao<T> currencyMasterDao) {
        this.currencyMasterDao = currencyMasterDao;
        setGenericsDAO(currencyMasterDao);
    }

    @Override
    public List getCurrencyPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return currencyMasterDao.getCurrencyPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalCurrencyCount() {
        return currencyMasterDao.getTotalCurrencyCount();
    }

    @Override
    public int getFilteredCurrencyCount(String search) {
        return currencyMasterDao.getFilteredCurrencyCount(search);
    }
    
    
}
