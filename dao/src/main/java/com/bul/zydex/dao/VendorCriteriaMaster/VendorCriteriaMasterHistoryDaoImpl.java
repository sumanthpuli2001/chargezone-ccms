/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorCriteriaMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorCriteriaMasterHistory;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaMasterHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements VendorCriteriaMasterHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorCriteriaMasterHistory.class;
    }
    
}
