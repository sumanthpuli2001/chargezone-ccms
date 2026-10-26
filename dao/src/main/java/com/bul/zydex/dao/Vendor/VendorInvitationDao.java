/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorInvitation;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorInvitationDao<T> extends GenericsDAO<T> {
    
    public List readByrow();
    
    public List readEmail(String email);
    
    public VendorInvitation readEmailId(String email);
    
    public VendorInvitation readCode(String code);
}
