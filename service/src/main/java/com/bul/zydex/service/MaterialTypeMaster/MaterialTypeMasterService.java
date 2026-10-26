/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.MaterialTypeMaster;

import com.bul.zydex.model.MaterialTypeMaster;
import com.bul.zydex.service.Apprentices.*;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface MaterialTypeMasterService<T> extends GenericsService<T> {


    public MaterialTypeMaster readByMaterialtype(String material_type_id);

    public List getmaterialTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalmaterialTypeCount();

    public int getFilteredmaterialTypeCount(String searchValue);
   
}
