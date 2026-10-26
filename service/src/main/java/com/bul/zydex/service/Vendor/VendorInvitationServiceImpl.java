/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorInvitationDao;
import com.bul.zydex.model.VendorInvitation;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;


/**
 *
 * @author admin
 */
public class VendorInvitationServiceImpl<T> extends GenericsServiceImpl<T> implements VendorInvitationService<T> {
    
    private VendorInvitationDao<T> vendorInvitationDao;

    public VendorInvitationDao<T> getVendorInvitationDao() {
        return vendorInvitationDao;
    }

    public void setVendorInvitationDao(VendorInvitationDao<T> vendorInvitationDao) {
        this.vendorInvitationDao = vendorInvitationDao;
        setGenericsDAO(vendorInvitationDao);
    }
    
    @Override
    public List readByrow() {
        return vendorInvitationDao.readByrow();
    }
    
    @Override
    public List readEmail(String email) {
        return vendorInvitationDao.readEmail(email);
    }
    
    @Override
    public VendorInvitation readEmailId(String email) {
        return vendorInvitationDao.readEmailId(email);
    }
    
    @Override
    public VendorInvitation readCode(String code) {
        return vendorInvitationDao.readCode(code);
    }
    
}
