/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.MaterialGroupMaster;

import com.bul.zydex.service.Apprentices.*;
import com.bul.zydex.model.ApprenticesMaster;
import com.bul.zydex.model.MaterialGroupMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface MaterialGroupMasterService<T> extends GenericsService<T> {

    public MaterialGroupMaster readBymaterialgroup(String material_group_id);

    public List getmaterialGroupMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalmaterialGroupMasterCount();

    public int getFilteredmaterialGroupMasterCount(String searchValue);

}
