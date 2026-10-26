/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AnchorCustomer;

import com.bul.zydex.dao.AnchorCustomer.AnchorCustomerDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AnchorCustomerServiceImpl<T> extends GenericsServiceImpl<T> implements AnchorCustomerService<T> {

        private AnchorCustomerDao<T> anchorCustomerDao;

    public AnchorCustomerDao<T> getAnchorCustomerDao() {
        return anchorCustomerDao;
    }

    public void setAnchorCustomerDao(AnchorCustomerDao<T> anchorCustomerDao) {
        this.anchorCustomerDao = anchorCustomerDao;
        setGenericsDAO(anchorCustomerDao);
    }

    @Override
    public List getAnchorPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return anchorCustomerDao.getAnchorPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalAnchorCount() {
        return anchorCustomerDao.getTotalAnchorCount();
    }

    @Override
    public int getFilteredAnchorCount(String search) {
        return anchorCustomerDao.getFilteredAnchorCount(search);
    }

    
    
}
