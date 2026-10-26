/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Employee;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.DesignationMaster;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public interface DesignationMasterDao<T> extends GenericsDAO<T> {
    
    
     public List getDesignationPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalDesignationCount();

    public int getFilteredDesignationCount(String search);
    
    
    
}



 