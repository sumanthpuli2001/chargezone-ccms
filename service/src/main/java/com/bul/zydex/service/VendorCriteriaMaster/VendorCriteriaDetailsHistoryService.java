/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorCriteriaMaster;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface VendorCriteriaDetailsHistoryService<T> extends GenericsService<T> {

    public List readByCriteriaMasterId(int id);
    
}
