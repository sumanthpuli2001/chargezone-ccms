/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model. VendorHrCriteria;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface VendorHrCriteriaService<T> extends GenericsService<T> {

    public List readByAll();

    public List readByGroupName(String vendorInvtId);
    

    
}
