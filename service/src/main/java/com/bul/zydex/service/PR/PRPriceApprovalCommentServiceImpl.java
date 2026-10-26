/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRPriceApprovalCommentDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalCommentDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.model.PRPriceApprovalComment;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class PRPriceApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements PRPriceApprovalCommentService<T> {
    
    private PRPriceApprovalCommentDao<T> prPriceApprovalCommentDao;

    public PRPriceApprovalCommentDao<T> getPrPriceApprovalCommentDao() {
        return prPriceApprovalCommentDao;
    }

    public void setPrPriceApprovalCommentDao(PRPriceApprovalCommentDao<T> prPriceApprovalCommentDao) {
        this.prPriceApprovalCommentDao = prPriceApprovalCommentDao;
        setGenericsDAO(prPriceApprovalCommentDao);
    }

    @Override
    public PRPriceApprovalComment readByApproveId(int approveId) {
         return prPriceApprovalCommentDao.readByApproveId(approveId);
    }

   
   
    
        
    

    
}
