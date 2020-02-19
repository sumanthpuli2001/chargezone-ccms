/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.Vendors;

/**
 *
 * @author admin
 */
public interface VendorDAO<T> extends GenericsDAO<T> {

    public Vendors readByVendorCode(String vendorCode);

}
