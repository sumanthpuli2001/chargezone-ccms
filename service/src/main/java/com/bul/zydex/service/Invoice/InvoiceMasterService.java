/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Invoice;

import com.bul.zydex.model.InvoiceMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InvoiceMasterService <T> extends GenericsService<T>{

    public List readByPoNoAndVendorCode(String poNo, String username);

    public InvoiceMaster readByPoNoAndVendorCode1(String poNo, String vendorCode);

    public InvoiceMaster readByPoId(int id,String vendorCode);
    
}
