/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderAdditionalDocDao;
import com.bul.zydex.model.AuthTenderAdditionalDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;


/**
 *
 * @author admin
 */
public class AuthTenderAdditionalDocServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderAdditionalDocService<T> {
 
    private AuthTenderAdditionalDocDao<T> authTenderAdditionalDocDao;

    public AuthTenderAdditionalDocDao<T> getAuthTenderAdditionalDocDao() {
        return authTenderAdditionalDocDao;
    }

    public void setAuthTenderAdditionalDocDao(AuthTenderAdditionalDocDao<T> authTenderAdditionalDocDao) {
        this.authTenderAdditionalDocDao = authTenderAdditionalDocDao;
        setGenericsDAO(authTenderAdditionalDocDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return authTenderAdditionalDocDao.readByRefNo(refNo);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderAdditionalDocDao.deleteRefNo(refNo);
    }

    @Override
    public List readByDoc(String refNo, String tenderAdditionalDocument) {
        return authTenderAdditionalDocDao.readByDoc(refNo, tenderAdditionalDocument);
    }

    @Override
    public void deleteDoc(String docid) {
        authTenderAdditionalDocDao.deleteDoc(docid);
    }
}
