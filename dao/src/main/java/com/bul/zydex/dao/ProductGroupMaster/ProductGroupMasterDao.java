/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProductGroupMaster;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface ProductGroupMasterDao<T> extends GenericsDAO<T> {

    public List readAll();

    public List getProGroupPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalProGroupCount();

    public int getFilteredProGroupCount(String search);
    
}
