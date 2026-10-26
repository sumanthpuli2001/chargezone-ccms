/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderGeneralDocDao;
import com.bul.zydex.model.AuthTenderGeneralDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AuthTenderGeneralDocServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderGeneralDocService<T> {

    private AuthTenderGeneralDocDao<T> authTenderGeneralDocDao;

    public AuthTenderGeneralDocDao<T> getAuthTenderGeneralDocDao() {
        return authTenderGeneralDocDao;
    }

    public void setAuthTenderGeneralDocDao(AuthTenderGeneralDocDao<T> authTenderGeneralDocDao) {
        this.authTenderGeneralDocDao = authTenderGeneralDocDao;
        setGenericsDAO(authTenderGeneralDocDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return authTenderGeneralDocDao.readByRefNo(refNo);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderGeneralDocDao.deleteRefNo(refNo);
    }

    @Override
    public List readByDoc(String refNo, String tenderGeneralDocument) {
        return authTenderGeneralDocDao.readByDoc(refNo, tenderGeneralDocument);
    }

    @Override
    public void deleteDoc(String docid) {
        authTenderGeneralDocDao.deleteDoc(docid);
    }
}
