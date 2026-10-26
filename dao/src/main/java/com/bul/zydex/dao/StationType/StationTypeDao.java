/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.StationType;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface StationTypeDao<T> extends GenericsDAO<T> {

    public List getstationTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getstationTypeCount();

    public int getFilteredstationTypeCount(String search);
    
}
