/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.BpGroup;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.BpGroup;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface BpGroupDao <T> extends GenericsDAO<T>{

    public BpGroup readByBpCode(String extractedBpGroup);

    public List getbpGroupPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalbpGroupCount();

    public int getFilteredbpGroupCount(String searchValue);
    
}
