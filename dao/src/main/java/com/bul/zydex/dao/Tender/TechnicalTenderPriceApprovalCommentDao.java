/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TechnicalTenderPriceApprovalComment;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalComment;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TechnicalTenderPriceApprovalCommentDao<T> extends GenericsDAO<T> {

    public List readByRefNo(int technical_tender_price_approval_id);

//    public TenderPriceApprovalComment approvaList1(String username);
//
//    public TenderPriceApprovalComment readByApproveId(int approveId);
//
//    public List readByRefNo(int tender_price_approval_id);

    public TechnicalTenderPriceApprovalComment readByApproveId(int approveId);

   
    
}
