/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TermsConditon;

import com.bul.zydex.dao.TermsCondition.TermsConditionParameterDao;
import com.bul.zydex.model.TermsConditionParameter;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TermsConditionParameterServiceImpl<T> extends GenericsServiceImpl<T> implements TermsConditionParameterService<T> {

    private TermsConditionParameterDao<T> TermsConditionParameterDao;

    public TermsConditionParameterDao<T> getTermsConditionParameterDao() {
        return TermsConditionParameterDao;
    }

    public void setTermsConditionParameterDao(TermsConditionParameterDao<T> TermsConditionParameterDao) {
        this.TermsConditionParameterDao = TermsConditionParameterDao;
        setGenericsDAO(TermsConditionParameterDao);
    }

    @Override
    public List readAll() {
        return TermsConditionParameterDao.readAll();
    }

    @Override
    public List readByIds(int id) {
        return TermsConditionParameterDao.readByIds(id);
    }

    @Override
    public List readAllTerms(int termsParameterId) {
        return TermsConditionParameterDao.readAllTerms(termsParameterId);
    }

    @Override
    public List getTermsConditionParameterPagination(int start, int length, String search, String orderColumn, String orderDir) {
        return TermsConditionParameterDao.getTermsConditionParameterPagination(start, length, search, orderColumn, orderDir);
    }

    @Override
    public int getTermsConditionParameterCount() {
        return TermsConditionParameterDao.getTermsConditionParameterCount();
    }

    @Override
    public int getFilteredTermsConditionParameterCount(String search) {
        return TermsConditionParameterDao.getFilteredTermsConditionParameterCount(search);
    }

}
