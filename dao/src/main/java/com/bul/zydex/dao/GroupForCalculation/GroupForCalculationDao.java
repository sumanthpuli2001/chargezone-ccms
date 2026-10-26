/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.GroupForCalculation;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface GroupForCalculationDao <T> extends GenericsDAO<T>{

    public List getGroupCalculationPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalGroupCalculationCount();

    public int getFilteredGroupCalculationCount(String searchValue);
    
}
