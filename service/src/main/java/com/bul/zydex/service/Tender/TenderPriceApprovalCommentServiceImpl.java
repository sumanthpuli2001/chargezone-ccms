/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalCommentDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class TenderPriceApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements TenderPriceApprovalCommentService<T> {
    
    private TenderPriceApprovalCommentDao<T> tenderPriceApprovalCommentDao;

    public TenderPriceApprovalCommentDao<T> getTenderPriceApprovalCommentDao() {
        return tenderPriceApprovalCommentDao;
    }

    public void setTenderPriceApprovalCommentDao(TenderPriceApprovalCommentDao<T> tenderPriceApprovalCommentDao) {
        this.tenderPriceApprovalCommentDao = tenderPriceApprovalCommentDao;
        setGenericsDAO(tenderPriceApprovalCommentDao);
    }

    @Override
    public TenderPriceApprovalComment approvaList1(String username) {
        return tenderPriceApprovalCommentDao.approvaList1(username);
    }

    @Override
    public TenderPriceApprovalComment readByApproveId(int approveId) {
        return tenderPriceApprovalCommentDao.readByApproveId(approveId);
    }

    @Override
    public List readByRefNo(int tender_price_approval_id) {
        return tenderPriceApprovalCommentDao.readByRefNo(tender_price_approval_id);
    }

    
}
