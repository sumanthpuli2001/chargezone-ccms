/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Invoice;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PlantMaster;
import java.util.List;
/**
 *
 * @author admin
 */
public interface PlantMasterDao<T> extends GenericsDAO<T> {

    public List getCompanyPlantPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalPlantCount();

    public int getFilteredPlantCount(String search);
    
}
