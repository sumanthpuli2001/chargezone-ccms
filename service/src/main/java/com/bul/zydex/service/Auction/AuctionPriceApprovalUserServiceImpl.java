/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionPriceApprovalUserDao;
import com.bul.zydex.model.AuctionPriceApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionPriceApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionPriceApprovalUserService<T> {
    
    private AuctionPriceApprovalUserDao<T> auctionPriceApprovalUserDao;

    public AuctionPriceApprovalUserDao<T> getAuctionPriceApprovalUserDao() {
        return auctionPriceApprovalUserDao;
    }

    public void setAuctionPriceApprovalUserDao(AuctionPriceApprovalUserDao<T> auctionPriceApprovalUserDao) {
        this.auctionPriceApprovalUserDao = auctionPriceApprovalUserDao;
        setGenericsDAO(auctionPriceApprovalUserDao);
    }

    @Override
    public List readByRefNo(int approveId) {
        return auctionPriceApprovalUserDao.readByRefNo(approveId);
    }

    @Override
    public AuctionPriceApprovalUser approvaList1(String username) {
        return auctionPriceApprovalUserDao.approvaList1(username);
    }

    @Override
    public AuctionPriceApprovalUser readByLevel(String auction_no, int level) {
        return auctionPriceApprovalUserDao.readByLevel(auction_no, level);
    }

    @Override
    public AuctionPriceApprovalUser approvaList2(int parseInt) {
        return auctionPriceApprovalUserDao.approvaList2(parseInt);
    }
}
