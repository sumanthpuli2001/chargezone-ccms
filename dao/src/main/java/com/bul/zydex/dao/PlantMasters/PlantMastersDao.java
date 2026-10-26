/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PlantMasters;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PlantMasters;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface PlantMastersDao<T> extends GenericsDAO<T> {

    public boolean isExist(T object);

    public PlantMasters readByPlant(String plan_code);

    public List getPlantMastersPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalPlantMastersCount();

    public int getFilteredPlantMastersCount(String search);

}
