/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Invoice;

import com.bul.zydex.dao.Invoice.PlantMasterDao;
import com.bul.zydex.model.PlantMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class PlantMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PlantMasterService<T> {
    
    private PlantMasterDao<T> plantMasterDao;

    public PlantMasterDao<T> getPlantMasterDao() {
        return plantMasterDao;
    }

    public void setPlantMasterDao(PlantMasterDao<T> plantMasterDao) {
        this.plantMasterDao = plantMasterDao;
        setGenericsDAO(plantMasterDao);
    }

    @Override
    public List getCompanyPlantPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return plantMasterDao.getCompanyPlantPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalPlantCount() {
        return plantMasterDao.getTotalPlantCount();
    }

    @Override
    public int getFilteredPlantCount(String search) {
        return plantMasterDao.getFilteredPlantCount(search);
    }
}
