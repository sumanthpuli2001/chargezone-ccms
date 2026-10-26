/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Invoice;

import com.bul.zydex.model.PlantMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface PlantMasterService<T> extends GenericsService<T> {
     public List getCompanyPlantPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalPlantCount();

    public int getFilteredPlantCount(String searchValue);
    
}
