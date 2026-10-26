/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.LocationMasters;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface LocationMastersService<T> extends GenericsService<T> {

    public List readByPlantCode(String plantCode);

    public List getLocationMastersPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalLocationMastersCount();

    public int getFilteredLocationMastersCount(String search);
}
