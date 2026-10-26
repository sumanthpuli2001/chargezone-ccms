/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderNoDao;
import com.bul.zydex.model.TenderNo;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class TenderNoServiceImpl<T> extends GenericsServiceImpl<T> implements TenderNoService<T> {
    
    private TenderNoDao<T> tenderNoDao;

    public TenderNoDao<T> getTenderNoDao() {
        return tenderNoDao;
    }

    public void setTenderNoDao(TenderNoDao<T> tenderNoDao) {
        this.tenderNoDao = tenderNoDao;
        setGenericsDAO(tenderNoDao);
    }

    @Override
    public TenderNo readByTenderNo() {
        return tenderNoDao.readByTenderNo();
    }
}
