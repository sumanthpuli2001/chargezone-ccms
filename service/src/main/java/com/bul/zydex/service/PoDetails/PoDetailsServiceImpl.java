/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PoDetails;

import com.bul.zydex.dao.PoDetails.PoDetailsDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class PoDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements PoDetailsService<T> {

    private PoDetailsDao<T> poDetailsDao;

    public PoDetailsDao<T> getPoDetailsDao() {
        return poDetailsDao;
    }

    public void setPoDetailsDao(PoDetailsDao<T> poDetailsDao) {
        this.poDetailsDao = poDetailsDao;
        setGenericsDAO(poDetailsDao);

    }

    @Override
    public List readByRefNo(String refNo) {
        return poDetailsDao.readByRefNo(refNo);
    }

    @Override
    public List getPoDetailsPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username) {
        return poDetailsDao.getPoDetailsPagination(start, length, searchValue, orderColumn, orderDir, username);
    }

    @Override
    public int getTotalPoDetailsCount(String username) {
        return poDetailsDao.getTotalPoDetailsCount(username);
    }

    @Override
    public int getFilteredPoDetailsCount(String searchValue, String username) {
        return poDetailsDao.getFilteredPoDetailsCount(searchValue, username);
    }

    @Override
    public List readByGrnExecutive(String username) {
        return poDetailsDao.readByGrnExecutive(username);
    }

    @Override
    public List readByfinancailExecutive(String username) {
        return poDetailsDao.readByfinancailExecutive(username);
    }

}
