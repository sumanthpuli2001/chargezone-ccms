/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderPreQualificationDao;
import com.bul.zydex.model.TenderPreQualification;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderPreQualificationServiceImpl<T> extends GenericsServiceImpl<T> implements TenderPreQualificationService<T> {
    
    private TenderPreQualificationDao<T> tenderPreQualificationDao;

    public TenderPreQualificationDao<T> getTenderPreQualificationDao() {
        return tenderPreQualificationDao;
    }

    public void setTenderPreQualificationDao(TenderPreQualificationDao<T> tenderPreQualificationDao) {
        this.tenderPreQualificationDao = tenderPreQualificationDao;
        setGenericsDAO(tenderPreQualificationDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return tenderPreQualificationDao.readByRefNo(refNo);
    }

    @Override
    public void updatRefNo(String refNo, String technicalfile) {
        tenderPreQualificationDao.updatRefNo(refNo, technicalfile);
    }

    @Override
    public void updatePreData(String refNo, String preRemark, String preDocRemark) {
        tenderPreQualificationDao.updatePreData(refNo, preRemark, preDocRemark);
    }

    @Override
    public void updateServicePreData(String refNo, String refNo1, String preRemark, String preDocRemark) {
        tenderPreQualificationDao.updateServicePreData(refNo, refNo1, preRemark, preDocRemark);
    }
}
