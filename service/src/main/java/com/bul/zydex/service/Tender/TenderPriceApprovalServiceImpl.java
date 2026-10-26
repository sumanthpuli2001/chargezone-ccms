/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderPriceApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements TenderPriceApprovalService<T> {

    private TenderPriceApprovalDao<T> tenderPriceApprovalDao;

    public TenderPriceApprovalDao<T> getTenderPriceApprovalDao() {
        return tenderPriceApprovalDao;
    }

    public void setTenderPriceApprovalDao(TenderPriceApprovalDao<T> tenderPriceApprovalDao) {
        this.tenderPriceApprovalDao = tenderPriceApprovalDao;
        setGenericsDAO(tenderPriceApprovalDao);
    }

    @Override
    public List approvaList(String username) {
        return tenderPriceApprovalDao.approvaList(username);
    }

    @Override
    public List readByIds(String id) {
        return tenderPriceApprovalDao.readByIds(id);
    }

    @Override
    public List readByTenRefNo(String refNo) {
        return tenderPriceApprovalDao.readByTenRefNo(refNo);
    }

    @Override
    public TenderPriceApproval readByRefNo(String refNo) {
        return tenderPriceApprovalDao.readByRefNo(refNo);
    }

    @Override
    public boolean isExist(String refNo) {
        return tenderPriceApprovalDao.isExist(refNo);
    }

    @Override
    public TenderPriceApproval readByList(String refNo) {
        return tenderPriceApprovalDao.readByList(refNo);
    }

    @Override
    public TenderPriceApproval readByRrecycleList(String refNo) {
        return tenderPriceApprovalDao.readByRrecycleList(refNo);
    }

}
