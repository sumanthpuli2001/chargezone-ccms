/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DiscomMaster;

import com.bul.zydex.model.DiscomMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DiscomMasterService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List readByStateName(String state);

    public List getDiscomMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalDiscomMasterCount();

    public int getFilteredDiscomMasterCount(String searchValue);

}
