/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TermsConditon;

import com.bul.zydex.dao.TermsCondition.TermsConditionDao;
import com.bul.zydex.model.TermsCondition;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TermsConditionServiceImpl<T> extends GenericsServiceImpl<T> implements TermsConditionService<T> {

    private TermsConditionDao<T> termsConditionDao;

    public TermsConditionDao<T> getTermsConditionDao() {
        return termsConditionDao;
    }

    public void setTermsConditionDao(TermsConditionDao<T> termsConditionDao) {
        this.termsConditionDao = termsConditionDao;
        setGenericsDAO(termsConditionDao);
    }

    @Override
    public TermsCondition readByName(String termsParameter) {
        return termsConditionDao.readByName(termsParameter);
          
    }

    @Override
    public List getTermsConditionPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return termsConditionDao.getTermsConditionPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalTermsConditionCount() {
        return termsConditionDao.getTotalTermsConditionCount();
    }

    @Override
    public int getFilteredTermsConditionCount(String search) {
        return termsConditionDao.getFilteredTermsConditionCount(search);
    }

}
