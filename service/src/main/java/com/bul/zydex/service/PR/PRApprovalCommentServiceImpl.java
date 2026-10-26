/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRApprovalCommentDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalCommentDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.model.PRApprovalComment;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author tailo
 */
public class PRApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements PRApprovalCommentService<T> {
    
    private PRApprovalCommentDao<T> prApprovalCommentDao;

    public PRApprovalCommentDao<T> getPrApprovalCommentDao() {
        return prApprovalCommentDao;
    }

    public void setPrApprovalCommentDao(PRApprovalCommentDao<T> prApprovalCommentDao) {
        this.prApprovalCommentDao = prApprovalCommentDao;
        setGenericsDAO(prApprovalCommentDao);
    }

    @Override
    public List readByPrNumber(String prNo) {
        return prApprovalCommentDao.readByPrNumber(prNo);
    }
}
