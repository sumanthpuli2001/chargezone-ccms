/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorRequestApproval;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface VendorRequestApprovalDao<T> extends GenericsDAO<T> {

    public List readByUserName(String username);

    public VendorRequestApproval readByDeltecodes(String id);
    
}
