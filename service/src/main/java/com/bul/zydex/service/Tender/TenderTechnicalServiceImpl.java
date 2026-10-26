/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderTechnicalDao;
import com.bul.zydex.model.TenderTechnical;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderTechnicalServiceImpl<T> extends GenericsServiceImpl<T> implements TenderTechnicalService<T> {

    private TenderTechnicalDao<T> tenderTechnicalDao;

    public TenderTechnicalDao<T> getTenderTechnicalDao() {
        return tenderTechnicalDao;
    }

    public void setTenderTechnicalDao(TenderTechnicalDao<T> tenderTechnicalDao) {
        this.tenderTechnicalDao = tenderTechnicalDao;
        setGenericsDAO(tenderTechnicalDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return tenderTechnicalDao.readByRefNo(refNo);
    }

    @Override
    public void updateTechicalFile(String refNo, String technicalfile) {
        tenderTechnicalDao.updateTechicalFile(refNo, technicalfile);
    }

    @Override
    public void updateTermsConditionFile(String refNo, String technicalfile) {
        tenderTechnicalDao.updateTermsConditionFile(refNo, technicalfile);
    }

    @Override
    public void updateRequiredDocFile(String refNo, String technicalfile) {
        tenderTechnicalDao.updateRequiredDocFile(refNo, technicalfile);
    }

    @Override
    public void updateTechicalData(String refNo, String technicalRemark, String technicalSpecRemark, String termsRemark, String docRemark) {
        tenderTechnicalDao.updateTechicalData(refNo, technicalRemark, technicalSpecRemark, termsRemark, docRemark);
    }

    @Override
    public void updateServiceTechicalData(String refNo, String refNo1, String technicalRemark, String technicalSpecRemark, String termsRemark, String docRemark) {
        tenderTechnicalDao.updateServiceTechicalData(refNo, refNo1, technicalRemark, technicalSpecRemark, termsRemark, docRemark);
    }
}
