/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.SapVendorEmail;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SapVendorEmailDao<T> extends GenericsDAO<T> {

    public List readByAddrNum(String ADRNR);

    public void truncate();
    
}
