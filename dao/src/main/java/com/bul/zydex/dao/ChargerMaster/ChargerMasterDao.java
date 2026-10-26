/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ChargerMaster;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface ChargerMasterDao <T> extends GenericsDAO<T>  {

    public List getChargerMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalChargerMasterCount();

    public int getFilteredChargerMasterCount(String searchValue);
    
}


