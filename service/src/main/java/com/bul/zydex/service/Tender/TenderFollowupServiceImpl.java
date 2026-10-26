/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderFollowupDao;
import com.bul.zydex.model.TenderFollowup;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class TenderFollowupServiceImpl<T> extends GenericsServiceImpl<T> implements TenderFollowupService<T> {
    
    private TenderFollowupDao<T> tenderFollowupDao;

    public TenderFollowupDao<T> getTenderFollowupDao() {
        return tenderFollowupDao;
    }

    public void setTenderFollowupDao(TenderFollowupDao<T> tenderFollowupDao) {
        this.tenderFollowupDao = tenderFollowupDao;
        setGenericsDAO(tenderFollowupDao);
    }

    @Override
    public List readByTender(String tender_no) {
        return tenderFollowupDao.readByTender(tender_no);
    }
}
