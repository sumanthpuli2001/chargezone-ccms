/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionPriceApprovalDao;
import com.bul.zydex.model.AuctionPriceApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionPriceApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionPriceApprovalService<T> {
    
    private AuctionPriceApprovalDao<T> auctionPriceApprovalDao;

    public AuctionPriceApprovalDao<T> getAuctionPriceApprovalDao() {
        return auctionPriceApprovalDao;
    }

    public void setAuctionPriceApprovalDao(AuctionPriceApprovalDao<T> auctionPriceApprovalDao) {
        this.auctionPriceApprovalDao = auctionPriceApprovalDao;
        setGenericsDAO(auctionPriceApprovalDao);
    }

    @Override
    public boolean isExist(String refNo) {
        return auctionPriceApprovalDao.isExist(refNo);
    }

    @Override
    public List approvaList(String username) {
        return auctionPriceApprovalDao.approvaList(username);
    }

    @Override
    public AuctionPriceApproval readByList(String refNo) {
        return auctionPriceApprovalDao.readByList(refNo);
    }

    @Override
    public List readByIds(String id) {
        return auctionPriceApprovalDao.readByIds(id);
    }
}
