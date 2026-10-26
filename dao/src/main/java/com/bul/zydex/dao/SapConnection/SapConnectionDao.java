/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SapConnection;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface SapConnectionDao<T> extends GenericsDAO<T>{

    public List getSapPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getSapPlantCount();

    public int getFilteredPlantCount(String search);
    
    
    
    
    
    
    
    
}
