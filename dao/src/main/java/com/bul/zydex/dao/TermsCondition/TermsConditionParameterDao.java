/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.TermsCondition;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TermsConditionParameter;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TermsConditionParameterDao<T> extends GenericsDAO<T> {

    public List readAll();

    public List readByIds(int id);

    public List readAllTerms(int termsParameterId);

    public List getTermsConditionParameterPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTermsConditionParameterCount();

    public int getFilteredTermsConditionParameterCount(String search);

}
