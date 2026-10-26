/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderPreQualificationDao;
import com.bul.zydex.model.AuthTenderPreQualification;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AuthTenderPreQualificationServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderPreQualificationService<T> {
    
    private AuthTenderPreQualificationDao<T> authTenderPreQualificationDao;

    public AuthTenderPreQualificationDao<T> getAuthTenderPreQualificationDao() {
        return authTenderPreQualificationDao;
    }

    public void setAuthTenderPreQualificationDao(AuthTenderPreQualificationDao<T> authTenderPreQualificationDao) {
        this.authTenderPreQualificationDao = authTenderPreQualificationDao;
        setGenericsDAO(authTenderPreQualificationDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return authTenderPreQualificationDao.readByRefNo(refNo);
    }

    @Override
    public void updatRefNo(String refNo, String technicalfile) {
        authTenderPreQualificationDao.updatRefNo(refNo, technicalfile);
    }

    @Override
    public void updatePreData(String refNo, String preRemark, String preDocRemark) {
        authTenderPreQualificationDao.updatePreData(refNo, preRemark, preDocRemark);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderPreQualificationDao.deleteRefNo(refNo);
    }
}
