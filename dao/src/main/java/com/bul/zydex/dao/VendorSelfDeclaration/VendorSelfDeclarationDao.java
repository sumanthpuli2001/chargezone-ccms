/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorSelfDeclaration;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorSelfDeclaration;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface VendorSelfDeclarationDao <T> extends GenericsDAO<T> {

    public VendorSelfDeclaration readByVendorInformationId(int i1);

    public List readBytwoflag(int twoflag, String VInformationId);
    
}
