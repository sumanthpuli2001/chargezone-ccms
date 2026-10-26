/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorSelfDeclaration;

import com.bul.zydex.dao.VendorInviteSource.VendorInviteSourceDao;
import com.bul.zydex.dao.VendorSelfDeclaration.VendorSelfDeclarationDao;
import com.bul.zydex.model.VendorSelfDeclaration;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorSelfDeclarationServiceImpl<T> extends GenericsServiceImpl<T> implements VendorSelfDeclarationService<T> {

    private VendorSelfDeclarationDao<T> vendorSelfDeclarationDao;

    public VendorSelfDeclarationDao<T> getVendorSelfDeclarationDao() {
        return vendorSelfDeclarationDao;
    }

    public void setVendorSelfDeclarationDao(VendorSelfDeclarationDao<T> vendorSelfDeclarationDao) {
        this.vendorSelfDeclarationDao = vendorSelfDeclarationDao;
        setGenericsDAO(vendorSelfDeclarationDao);

    }

   

    @Override
    public VendorSelfDeclaration readByVendorInformationId(int i1) {
        return vendorSelfDeclarationDao.readByVendorInformationId(i1);
    }

    @Override
    public List readBytwoflag(int twoflag, String VInformationId) {
        return vendorSelfDeclarationDao.readBytwoflag(twoflag,VInformationId);
    }

}
