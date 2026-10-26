/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.MaterialTypeMaster;

import com.bul.zydex.dao.Approval.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.MaterialTypeMaster;

import java.util.List;


/**
 *
 * @author admin
 */
public interface MaterialTypeMasterDao<T> extends GenericsDAO<T> {
    

    public MaterialTypeMaster readByMaterialtype(String material_type_id);

 public List getmaterialTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalmaterialTypeCount();

    public int getFilteredmaterialTypeCount(String search);
    }
