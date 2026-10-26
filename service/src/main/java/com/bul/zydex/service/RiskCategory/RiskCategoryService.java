/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RiskCategory;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RiskCategoryService <T> extends GenericsService<T> {

    public List getRiskCategoryPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalRiskCategoryCount();

    public int getFilteredRiskCategoryCount(String searchValue);

    
}
