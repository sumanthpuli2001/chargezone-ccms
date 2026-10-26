/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PlantMasters;

import com.bul.zydex.dao.PlantMasters.PlantMastersDao;
import com.bul.zydex.model.PlantMasters;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class PlantMastersServiceImpl<T> extends GenericsServiceImpl<T> implements PlantMastersService<T> {

    private PlantMastersDao<T> plantMastersDao;

    public PlantMastersDao<T> getPlantMastersDao() {
        return plantMastersDao;
    }

    public void setPlantMastersDao(PlantMastersDao<T> plantMastersDao) {
        this.plantMastersDao = plantMastersDao;
        setGenericsDAO(plantMastersDao);

    }
    @Override
    public boolean isExist(T object) {
        return plantMastersDao.isExist(object);
    }

    @Override
    public PlantMasters readByPlant(String plan_code) {
        return plantMastersDao.readByPlant(plan_code);
    }


    @Override
    public List getPlantMastersPagination(int start, int length, String search, String orderColumn, String orderDir) {
       return plantMastersDao.getPlantMastersPagination(start, length, search, orderColumn, orderDir);
    }

    @Override
    public int getTotalPlantMastersCount() {
        return plantMastersDao.getTotalPlantMastersCount();
    }

    @Override
    public int getFilteredPlantMastersCount(String search) {
        return plantMastersDao.getFilteredPlantMastersCount(search);
    }

}
