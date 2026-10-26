/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AuditorMaster;

import com.bul.zydex.model.AuditorMaster;
import com.bul.zydex.service.GenericsService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface AuditorMasterService<T> extends GenericsService<T>  {

    public List readByCategoryHigh();

    public List readByCategoryMedium();

    public AuditorMaster readByAuditorCode(String auditor);

    public List getAuditorPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalAuditorCount();

    public int getFilteredAuditorCount(String searchValue);

    
}
