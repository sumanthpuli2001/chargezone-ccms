/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorInvitationCategory;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VendorInvitationCategoryDao<T> extends GenericsDAO<T> {

    public List readIds(int i);

//    public VendorInvitationCategory readIds(int i);

    public List readByAll(int vendorInvtId);

    public List readByVendorInvtlistId(int vendorInvtId);
    
    public VendorInvitationCategory readByVendorInvtId(int vendorInvtId);
    
}
