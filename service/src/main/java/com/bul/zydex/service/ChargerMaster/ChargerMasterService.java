/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ChargerMaster;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface ChargerMasterService<T> extends GenericsService<T> {

    public List getChargerMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalChargerMasterCount();

    public int getFilteredChargerMasterCount(String searchValue);

}
