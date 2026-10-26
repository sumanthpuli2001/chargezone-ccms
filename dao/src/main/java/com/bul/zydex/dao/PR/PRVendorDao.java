/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRVendor;
import com.bul.zydex.model.TenderVendor;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PRVendorDao<T> extends GenericsDAO<T> {

    public List readByRfqNo(String ref_no);

    public void delete1(int id);

    public PRVendor readId(int id);

    public void updatePRNo(String refNo1, String refNo);

    public List readByRfqVendor(String ref_no, String vendor_code);

    
    
}
