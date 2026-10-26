/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.VendorInvitationCategory;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VendorInvitationCategoryService<T> extends GenericsService<T> {

    public List readIds(int i);

//    public VendorInvitationCategory readIds(int i);

    public List readByAll(int vendorInvtId);

    public List readByVendorInvtlistId(int vendorInvtId);
    
    public VendorInvitationCategory readByVendorInvtId(int vendorInvtId);

  
    
}
