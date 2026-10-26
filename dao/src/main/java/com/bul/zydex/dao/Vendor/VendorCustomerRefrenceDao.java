/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorClearanceCertificate;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorCustomerRefrenceDao<T> extends GenericsDAO<T> {

    public List readId(int id);

    public void deleteById(String checkedValues);
    
    
    
}
