/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Ehmail;

import com.bul.zydex.dao.EhMail.EhMailDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class EhMailServiceImpl<T> extends GenericsServiceImpl<T> implements EhMailService<T> {

    private EhMailDao<T> ehMailDao;

    public EhMailDao<T> getEhMailDao() {
        return ehMailDao;
    }

    public void setEhMailDao(EhMailDao<T> ehMailDao) {
        this.ehMailDao = ehMailDao;
        setGenericsDAO(ehMailDao);

    }

    @Override
    public List getEhMailPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        return ehMailDao.getEhMailPagination(start, length, searchValue, orderColumn, orderDir);

    }

    @Override
    public int getTotalEhMailCount() {
        return ehMailDao.getTotalEhMailCount();
    }

    @Override
    public int getFilteredEhMailCount(String searchValue) {
        return ehMailDao.getEhMailPagination(searchValue);
    }

}
