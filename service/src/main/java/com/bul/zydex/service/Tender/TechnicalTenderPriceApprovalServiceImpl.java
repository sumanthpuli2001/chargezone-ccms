/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TechnicalTenderPriceApprovalDao;
import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.model.TechnicalTenderPriceApproval;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TechnicalTenderPriceApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements TechnicalTenderPriceApprovalService<T> {

    private TechnicalTenderPriceApprovalDao<T> technicalTenderPriceApprovalDao;

    public TechnicalTenderPriceApprovalDao<T> getTechnicalTenderPriceApprovalDao() {
        return technicalTenderPriceApprovalDao;
    }

    public void setTechnicalTenderPriceApprovalDao(TechnicalTenderPriceApprovalDao<T> technicalTenderPriceApprovalDao) {
        this.technicalTenderPriceApprovalDao = technicalTenderPriceApprovalDao;
        setGenericsDAO(technicalTenderPriceApprovalDao);
    }

    @Override
    public boolean isExist(String refNo) {
        return technicalTenderPriceApprovalDao.isExist(refNo);
    }

    @Override
    public TechnicalTenderPriceApproval readByList(String refNo) {
        return technicalTenderPriceApprovalDao.readByList(refNo);
    }

    @Override
    public TechnicalTenderPriceApproval readByRrecycleList(String refNo) {
        return technicalTenderPriceApprovalDao.readByRrecycleList(refNo);
    }

    @Override
    public List approvaList(String username) {
        return technicalTenderPriceApprovalDao.approvaList(username);
    }

    @Override
    public List readByIds(String id) {
        return technicalTenderPriceApprovalDao.readByIds(id);
    }

}
