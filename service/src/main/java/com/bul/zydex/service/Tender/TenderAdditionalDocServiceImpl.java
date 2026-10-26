/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderAdditionalDocDao;
import com.bul.zydex.model.TenderAdditionalDoc;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;


/**
 *
 * @author admin
 */
public class TenderAdditionalDocServiceImpl<T> extends GenericsServiceImpl<T> implements TenderAdditionalDocService<T> {
 
    private TenderAdditionalDocDao<T> tenderAdditionalDocDao;

    public TenderAdditionalDocDao<T> getTenderAdditionalDocDao() {
        return tenderAdditionalDocDao;
    }

    public void setTenderAdditionalDocDao(TenderAdditionalDocDao<T> tenderAdditionalDocDao) {
        this.tenderAdditionalDocDao = tenderAdditionalDocDao;
        setGenericsDAO(tenderAdditionalDocDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return tenderAdditionalDocDao.readByRefNo(refNo);
    }

    @Override
    public void deleteRefNo(String refNo) {
        tenderAdditionalDocDao.deleteRefNo(refNo);
    }

    @Override
    public List readByDoc(String refNo, String additionalfile) {
        return tenderAdditionalDocDao.readByDoc(refNo, additionalfile);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        tenderAdditionalDocDao.updateTenderNo(refNo1, refNo);
    }
}
