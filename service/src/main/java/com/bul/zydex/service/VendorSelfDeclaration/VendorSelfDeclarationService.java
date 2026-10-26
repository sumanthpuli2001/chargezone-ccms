/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorSelfDeclaration;

import com.bul.zydex.model.VendorSelfDeclaration;
import com.bul.zydex.service.VendorInviteSource.*;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VendorSelfDeclarationService <T> extends GenericsService<T>{

    public VendorSelfDeclaration readByVendorInformationId(int i1);

    public List readBytwoflag(int twoflag, String VInformationId);

    
}
