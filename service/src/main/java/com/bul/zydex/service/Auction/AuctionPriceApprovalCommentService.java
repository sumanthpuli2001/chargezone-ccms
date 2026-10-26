/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.model.AuctionPriceApprovalComment;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuctionPriceApprovalCommentService<T> extends GenericsService<T> {

    public List readByRefNo(int auction_price_approval_id);

    public AuctionPriceApprovalComment readByApproveId(int approveId);
    
}
