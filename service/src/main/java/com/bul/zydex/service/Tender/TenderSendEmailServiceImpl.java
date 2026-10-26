/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderSendEmailDao;
import com.bul.zydex.model.TenderSendEmail;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderSendEmailServiceImpl<T> extends GenericsServiceImpl<T> implements TenderSendEmailService<T> {
    
    private TenderSendEmailDao<T> tenderSendEmailDao;

    public TenderSendEmailDao<T> getTenderSendEmailDao() {
        return tenderSendEmailDao;
    }

    public void setTenderSendEmailDao(TenderSendEmailDao<T> tenderSendEmailDao) {
        this.tenderSendEmailDao = tenderSendEmailDao;
        setGenericsDAO(tenderSendEmailDao);
    }

    @Override
    public void deleteRefNo(String refNo) {
        tenderSendEmailDao.deleteRefNo(refNo);
    }

    @Override
    public List readByRefNo(String refNo) {
        return tenderSendEmailDao.readByRefNo(refNo);
    }
}
