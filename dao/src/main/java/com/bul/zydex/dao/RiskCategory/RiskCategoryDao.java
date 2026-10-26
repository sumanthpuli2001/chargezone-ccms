/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RiskCategory;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RiskCategoryDao <T> extends GenericsDAO<T> {

    public List getRiskCategoryPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalRiskCategoryCount();

    public int getFilteredRiskCategoryCount(String searchValue);
    
}
