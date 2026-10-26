/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderVendorDao;
import com.bul.zydex.model.AuthTenderVendor;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AuthTenderVendorServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderVendorService<T> {
    
    private AuthTenderVendorDao<T> authTenderVendorDao;

    public AuthTenderVendorDao<T> getAuthTenderVendorDao() {
        return authTenderVendorDao;
    }

    public void setAuthTenderVendorDao(AuthTenderVendorDao<T> authTenderVendorDao) {
        this.authTenderVendorDao = authTenderVendorDao;
        setGenericsDAO(authTenderVendorDao);
    }

    @Override
    public List readByVendor(String refNo, String vendor_code) {
        return authTenderVendorDao.readByVendor(refNo, vendor_code);
    }

    @Override
    public List readByRefNo(String refNo) {
        return authTenderVendorDao.readByRefNo(refNo);
    }

    @Override
    public void updateVendor(String refNo, String vendor_code, String email_id, String mobile_no, String checkVendorId) {
        authTenderVendorDao.updateVendor(refNo, vendor_code, email_id, mobile_no, checkVendorId);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderVendorDao.deleteRefNo(refNo);
    }

    @Override
    public void updateVendor1(String refNo, String LIFNR, String email, String tele) {
        authTenderVendorDao.updateVendor1(refNo, LIFNR, email, tele);
    }
}
