/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProductGroupMaster;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface ProductGroupMasterService<T> extends GenericsService<T>  {

    public List readAll();

    public List getProGroupPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalProGroupCount();

    public int getFilteredProGroupCount(String searchValue);
    
}
