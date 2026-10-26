/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderTechnicalDocDao;
import com.bul.zydex.model.AuthTenderTechnicalDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;


/**
 *
 * @author admin
 */
public class AuthTenderTechnicalDocServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderTechnicalDocService<T> {

    private AuthTenderTechnicalDocDao<T> authTenderTechnicalDocDao;

    public AuthTenderTechnicalDocDao<T> getAuthTenderTechnicalDocDao() {
        return authTenderTechnicalDocDao;
    }

    public void setAuthTenderTechnicalDocDao(AuthTenderTechnicalDocDao<T> authTenderTechnicalDocDao) {
        this.authTenderTechnicalDocDao = authTenderTechnicalDocDao;
        setGenericsDAO(authTenderTechnicalDocDao);
    }

    @Override
    public List readByRefNo(String refNo) {
       return authTenderTechnicalDocDao.readByRefNo(refNo);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderTechnicalDocDao.deleteRefNo(refNo);
    }

    @Override
    public List readByDoc(String refNo, String tenderTechnicalDocument1) {
        return authTenderTechnicalDocDao.readByDoc(refNo, tenderTechnicalDocument1);
    }

    @Override
    public void deleteDoc(String docid) {
        authTenderTechnicalDocDao.deleteDoc(docid);
    }
}
