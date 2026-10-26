/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ValuationClassMaster;

import com.bul.zydex.service.ProductTypeMaster.*;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface ValuationClassMasterService<T> extends GenericsService<T> {

    public List getValPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getFilteredValCount(String searchValue);

    public int getTotalValCount();
    
}
