/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ElectricalContractor;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface ElectricalContractorDao<T> extends GenericsDAO<T> {

    public List readByVendorInformationId(String vendorInformationid);

    public void deleteByVendorInformationId(String VInformationId);
    
}
