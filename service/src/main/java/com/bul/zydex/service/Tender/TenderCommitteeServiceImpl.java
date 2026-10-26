/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class TenderCommitteeServiceImpl<T> extends GenericsServiceImpl<T> implements TenderCommitteeService<T> {
    
    private TenderCommitteeDao<T> tenderCommitteeDao;

    public TenderCommitteeDao<T> getTenderCommitteeDao() {
        return tenderCommitteeDao;
    }

    public void setTenderCommitteeDao(TenderCommitteeDao<T> tenderCommitteeDao) {
        this.tenderCommitteeDao = tenderCommitteeDao;
        setGenericsDAO(tenderCommitteeDao);
    }

    @Override
    public List readByRefNo(String ref_no, String bid_type) {
        return tenderCommitteeDao.readByRefNo(ref_no, bid_type);
    }

    @Override
    public List readByRefUser(String ref_no, String employee_code, String bid_type) {
        return tenderCommitteeDao.readByRefUser(ref_no, employee_code, bid_type);
    }

    @Override
    public void updateStatus(String refNo, String username1, String bid_type) {
        tenderCommitteeDao.updateStatus(refNo, username1, bid_type);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        tenderCommitteeDao.updateTenderNo(refNo1, refNo);
    }

    @Override
    public List readByRefNoUser(String refNo, String username) {
        return tenderCommitteeDao.readByRefNoUser(refNo, username);
    }
    
    @Override
    public void deleteByRefNo(String ref_no, String bid_type) {
         tenderCommitteeDao.deleteBYRefNo(ref_no,bid_type);
    }

    @Override
    public List readByRefNoUser1(String refNo, String username) {
        return tenderCommitteeDao.readByRefNoUser1(refNo, username);
    }
}
