/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderGeneralDocDao;
import com.bul.zydex.model.TenderGeneralDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderGeneralDocServiceImpl<T> extends GenericsServiceImpl<T> implements TenderGeneralDocService<T> {

    private TenderGeneralDocDao<T> tenderGeneralDocDao;

    public TenderGeneralDocDao<T> getTenderGeneralDocDao() {
        return tenderGeneralDocDao;
    }

    public void setTenderGeneralDocDao(TenderGeneralDocDao<T> tenderGeneralDocDao) {
        this.tenderGeneralDocDao = tenderGeneralDocDao;
        setGenericsDAO(tenderGeneralDocDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return tenderGeneralDocDao.readByRefNo(refNo);
    }

    @Override
    public void deleteRefNo(String refNo) {
        tenderGeneralDocDao.deleteRefNo(refNo);
    }

    @Override
    public List readByDoc(String refNo, String generalfile) {
        return tenderGeneralDocDao.readByDoc(refNo, generalfile);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        tenderGeneralDocDao.updateTenderNo(refNo1, refNo);
    }
}
