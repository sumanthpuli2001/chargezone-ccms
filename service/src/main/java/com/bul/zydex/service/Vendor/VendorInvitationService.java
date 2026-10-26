/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.VendorInvitation;
import com.bul.zydex.service.GenericsService;
import java.util.List;


/**
 *
 * @author admin
 */
public interface VendorInvitationService<T> extends GenericsService<T> {

    
    public List readByrow();
    
    public List readEmail(String email);
    
    public VendorInvitation readEmailId(String email);
    
    public VendorInvitation readCode(String code);
}
