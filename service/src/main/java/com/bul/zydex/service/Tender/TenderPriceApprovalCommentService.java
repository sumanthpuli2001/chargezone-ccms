/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface TenderPriceApprovalCommentService<T> extends GenericsService<T> {

    public TenderPriceApprovalComment approvaList1(String username);

    public TenderPriceApprovalComment readByApproveId(int approveId);

    public List readByRefNo(int tender_price_approval_id);

   
    
}
