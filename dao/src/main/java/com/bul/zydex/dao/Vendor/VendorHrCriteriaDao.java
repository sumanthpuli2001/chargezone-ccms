/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorHrCriteria;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorHrCriteriaDao<T> extends GenericsDAO<T> {

    public List readByAll();

    public List readByGroupName(String vendorInvtId);
    
 
    
}
