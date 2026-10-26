/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorApproval;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorApprovalDao<T> extends GenericsDAO<T> {
    
    public List readId(int id);

    public List readForVendorRecycled(int id);
    
}
