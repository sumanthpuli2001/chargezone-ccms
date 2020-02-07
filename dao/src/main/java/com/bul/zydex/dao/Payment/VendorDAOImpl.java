/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Vendors;

/**
 *
 * @author admin
 */
public class VendorDAOImpl<T> extends GenericsDAOImpl<T> implements VendorDAO<T> {
    
@Override
    protected Class getDomainClass() {
        return Vendors.class;
    }
}
