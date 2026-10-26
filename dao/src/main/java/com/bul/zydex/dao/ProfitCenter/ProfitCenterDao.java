/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProfitCenter;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface ProfitCenterDao<T> extends GenericsDAO<T> {

    public List getProfitPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalProfitCount();

    public int getFilteredProfitCount(String search);
    
}
