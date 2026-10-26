/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderRegretDao;
import com.bul.zydex.model.TenderRegret;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderRegretServiceImpl<T> extends GenericsServiceImpl<T> implements TenderRegretService<T> {
    
    private TenderRegretDao<T> tenderRegretDao;

    public TenderRegretDao<T> getTenderRegretDao() {
        return tenderRegretDao;
    }

    public void setTenderRegretDao(TenderRegretDao<T> tenderRegretDao) {
        this.tenderRegretDao = tenderRegretDao;
        setGenericsDAO(tenderRegretDao);
    }

    @Override
    public List regretList(String refNo) {
        return tenderRegretDao.regretList(refNo);
    }

    @Override
    public List readByTenderNo(String tender_no, String username) {
        return tenderRegretDao.readByTenderNo(tender_no, username);
    }

    @Override
    public void updateTenderRegret(String tender_no, String username, String remark) {
        tenderRegretDao.updateTenderRegret(tender_no, username, remark);
    }

    @Override
    public List readByVendor(String username) {
        return tenderRegretDao.readByVendor(username);
    }

    @Override
    public void updateTenderBid(String tender_no, String username) {
        tenderRegretDao.updateTenderBid(tender_no, username);
    }

    @Override
    public List regretList1(String tender_no) {
        return tenderRegretDao.regretList1(tender_no);
    }
}
