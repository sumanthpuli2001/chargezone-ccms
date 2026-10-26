/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProductTypeMaster;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface ProductTypeMasterDao<T> extends GenericsDAO<T> {

    public List getTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalTypeCount();

    public int getFilteredTypeCount(String search);
    
}
