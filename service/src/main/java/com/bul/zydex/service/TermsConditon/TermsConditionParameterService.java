/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TermsConditon;

import com.bul.zydex.model.TermsConditionParameter;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TermsConditionParameterService<T> extends GenericsService<T> {

    public List readAll();

    public List readByIds(int id);

    public List readAllTerms(int termsParameterId);

    public List getTermsConditionParameterPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTermsConditionParameterCount();

    public int getFilteredTermsConditionParameterCount(String search);

}
