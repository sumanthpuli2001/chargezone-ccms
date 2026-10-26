/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderNoTempDao;
import com.bul.zydex.model.TenderNoTemp;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderNoTempServiceImpl<T> extends GenericsServiceImpl<T> implements TenderNoTempService<T> {
    
    private TenderNoTempDao<T> tenderNoTempDao;

    public TenderNoTempDao<T> getTenderNoTempDao() {
        return tenderNoTempDao;
    }

    public void setTenderNoTempDao(TenderNoTempDao<T> tenderNoTempDao) {
        this.tenderNoTempDao = tenderNoTempDao;
        setGenericsDAO(tenderNoTempDao);
    }

    @Override
    public TenderNoTemp readLastRecord() {
        return tenderNoTempDao.readLastRecord();
    }
    
}
