/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CanopyVarient;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface CanopyVarientDao<T> extends GenericsDAO<T> {

    public int getTotalCanopyCount();

    public int getFilteredCanopyCount(String search);

    public List getCanopyPagination(int start, int length, String searchValue, String orderColumn, String orderDir);
    
}
