/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderVendorDocDao;
import com.bul.zydex.model.AuthTenderVendorDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AuthTenderVendorDocServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderVendorDocService<T> {

    private AuthTenderVendorDocDao<T> authTenderVendorDocDao;

    public AuthTenderVendorDocDao<T> getAuthTenderVendorDocDao() {
        return authTenderVendorDocDao;
    }

    public void setAuthTenderVendorDocDao(AuthTenderVendorDocDao<T> authTenderVendorDocDao) {
        this.authTenderVendorDocDao = authTenderVendorDocDao;
        setGenericsDAO(authTenderVendorDocDao);
    }

    @Override
    public List readGeneralDoc(String refNo, String vendor_code, int i) {
        return authTenderVendorDocDao.readGeneralDoc(refNo,vendor_code,i);
    }

    @Override
    public List readAdditionalDoc(String refNo, String vendor_code, int i) {
        return authTenderVendorDocDao.readAdditionalDoc(refNo,vendor_code,i);
    }

    @Override
    public List readTechnicalDoc(String refNo, String vendor_code, int i) {
        return authTenderVendorDocDao.readTechnicalDoc(refNo,vendor_code,i);
    }

    @Override
    public List readByRefNo(String refNo, String vendor_code) {
        return authTenderVendorDocDao.readByRefNo(refNo,vendor_code);
    }

    @Override
    public List readByDocRefNo(String refNo, String vendor_code, String attachment) {
        return authTenderVendorDocDao.readByDocRefNo(refNo,vendor_code,attachment);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderVendorDocDao.deleteRefNo(refNo);
    }
}
