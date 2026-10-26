/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TechnicalTenderPriceApprovalComment;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface TechnicalTenderPriceApprovalCommentService<T> extends GenericsService<T> {

    public List readByRefNo(int technical_tender_price_approval_id);

    public TechnicalTenderPriceApprovalComment readByApproveId(int approveId);

   

   
    
}
