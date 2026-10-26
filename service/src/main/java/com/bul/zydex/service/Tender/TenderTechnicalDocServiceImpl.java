/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderTechnicalDocDao;
import com.bul.zydex.model.TenderTechnicalDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;


/**
 *
 * @author admin
 */
public class TenderTechnicalDocServiceImpl<T> extends GenericsServiceImpl<T> implements TenderTechnicalDocService<T> {

    private TenderTechnicalDocDao<T> tenderTechnicalDocDao;

    public TenderTechnicalDocDao<T> getTenderTechnicalDocDao() {
        return tenderTechnicalDocDao;
    }

    public void setTenderTechnicalDocDao(TenderTechnicalDocDao<T> tenderTechnicalDocDao) {
        this.tenderTechnicalDocDao = tenderTechnicalDocDao;
        setGenericsDAO(tenderTechnicalDocDao);
    }

    @Override
    public List readByRefNo(String refNo) {
       return tenderTechnicalDocDao.readByRefNo(refNo);
    }

    @Override
    public void deleteRefNo(String refNo) {
        tenderTechnicalDocDao.deleteRefNo(refNo);
    }

    @Override
    public List readByDoc(String refNo, String technicalfile) {
        return tenderTechnicalDocDao.readByDoc(refNo, technicalfile);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        tenderTechnicalDocDao.updateTenderNo(refNo1, refNo);
    }
}
