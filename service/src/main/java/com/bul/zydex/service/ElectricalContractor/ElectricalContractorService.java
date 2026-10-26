/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ElectricalContractor;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface ElectricalContractorService<T> extends GenericsService<T> {

    public List readByVendorInformationId(String vendorInformationid);

    public void deleteByVendorInformationId(String VInformationId);
    
}
