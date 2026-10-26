/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TechnicalTenderPriceApprovalCommentDao;
import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalCommentDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.model.TechnicalTenderPriceApprovalComment;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class TechnicalTenderPriceApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements TechnicalTenderPriceApprovalCommentService<T> {
    
    private TechnicalTenderPriceApprovalCommentDao<T> technicalTenderPriceApprovalCommentDao;

    public TechnicalTenderPriceApprovalCommentDao<T> getTechnicalTenderPriceApprovalCommentDao() {
        return technicalTenderPriceApprovalCommentDao;
    }

    public void setTechnicalTenderPriceApprovalCommentDao(TechnicalTenderPriceApprovalCommentDao<T> technicalTenderPriceApprovalCommentDao) {
        this.technicalTenderPriceApprovalCommentDao = technicalTenderPriceApprovalCommentDao;
        setGenericsDAO(technicalTenderPriceApprovalCommentDao);
    }

    @Override
    public List readByRefNo(int technical_tender_price_approval_id) {
         return technicalTenderPriceApprovalCommentDao.readByRefNo(technical_tender_price_approval_id);
    }

    @Override
    public TechnicalTenderPriceApprovalComment readByApproveId(int approveId) {
        return technicalTenderPriceApprovalCommentDao.readByApproveId(approveId);
    }

    
    
   
        
    

   

    
}
