/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.TermsConditon;

import com.bul.zydex.model.TermsCondition;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TermsConditionService<T> extends GenericsService<T> {

    public TermsCondition readByName(String termsParameter);

    public List getTermsConditionPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalTermsConditionCount();

    public int getFilteredTermsConditionCount(String searchValue);

   

    
}
