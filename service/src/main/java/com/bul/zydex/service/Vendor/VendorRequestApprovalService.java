/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.VendorRequestApproval;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface VendorRequestApprovalService<T> extends GenericsService<T> {

    public List readByUserName(String username);

    public VendorRequestApproval readByDeltecodes(String id);
    
}
