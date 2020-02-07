/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.payment;

import com.bul.zydex.dao.Payment.VendorDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author admin
 */
public class VendorServiceImpl<T> extends GenericsServiceImpl<T> implements VendorService<T> {
    
private VendorDAO<T> vendorDAO;

public VendorDAO<T> getEmployeeTypeDAO() {
        return vendorDAO;
    }


public void setVendorDAO(VendorDAO<T> vendorDAO) {
        this.vendorDAO = vendorDAO;
        setGenericsDAO(vendorDAO);
    }
}
