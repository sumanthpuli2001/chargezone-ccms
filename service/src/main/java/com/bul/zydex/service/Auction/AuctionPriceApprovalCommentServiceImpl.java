/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionPriceApprovalCommentDao;
import com.bul.zydex.model.AuctionPriceApprovalComment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionPriceApprovalCommentServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionPriceApprovalCommentService<T> {
 
    private AuctionPriceApprovalCommentDao<T> auctionPriceApprovalCommentDao;

    public AuctionPriceApprovalCommentDao<T> getAuctionPriceApprovalCommentDao() {
        return auctionPriceApprovalCommentDao;
    }

    public void setAuctionPriceApprovalCommentDao(AuctionPriceApprovalCommentDao<T> auctionPriceApprovalCommentDao) {
        this.auctionPriceApprovalCommentDao = auctionPriceApprovalCommentDao;
        setGenericsDAO(auctionPriceApprovalCommentDao);
    }

    @Override
    public List readByRefNo(int auction_price_approval_id) {
        return auctionPriceApprovalCommentDao.readByRefNo(auction_price_approval_id);
    }

    @Override
    public AuctionPriceApprovalComment readByApproveId(int approveId) {
        return auctionPriceApprovalCommentDao.readByApproveId(approveId);
    }
}
