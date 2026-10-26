/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderTechnicalDao;
import com.bul.zydex.model.AuthTenderTechnical;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AuthTenderTechnicalServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderTechnicalService<T> {

    private AuthTenderTechnicalDao<T> authTenderTechnicalDao;

    public AuthTenderTechnicalDao<T> getAuthTenderTechnicalDao() {
        return authTenderTechnicalDao;
    }

    public void setAuthTenderTechnicalDao(AuthTenderTechnicalDao<T> authTenderTechnicalDao) {
        this.authTenderTechnicalDao = authTenderTechnicalDao;
        setGenericsDAO(authTenderTechnicalDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return authTenderTechnicalDao.readByRefNo(refNo);
    }

    @Override
    public void updateTechicalFile(String refNo, String technicalfile) {
        authTenderTechnicalDao.updateTechicalFile(refNo, technicalfile);
    }

    @Override
    public void updateTermsConditionFile(String refNo, String technicalfile) {
        authTenderTechnicalDao.updateTermsConditionFile(refNo, technicalfile);
    }

    @Override
    public void updateRequiredDocFile(String refNo, String technicalfile) {
        authTenderTechnicalDao.updateRequiredDocFile(refNo, technicalfile);
    }

    @Override
    public void updateTechicalData(String refNo, String technicalRemark, String technicalSpecRemark, String termsRemark, String docRemark) {
        authTenderTechnicalDao.updateTechicalData(refNo, technicalRemark, technicalSpecRemark, termsRemark, docRemark);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderTechnicalDao.deleteRefNo(refNo);
    }
}
