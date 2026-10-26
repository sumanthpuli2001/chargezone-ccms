/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface VendorApprovalUserDao <T> extends GenericsDAO<T> {

    public List<?> readByIdToList(String id);

    public List readByIdToList1(String approval);
    
}
