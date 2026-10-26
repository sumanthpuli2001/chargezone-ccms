/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionMasterDao;
import com.bul.zydex.model.AuctionMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Date;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionMasterServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionMasterService<T> {
  
    private AuctionMasterDao<T> auctionMasterDao;

    public AuctionMasterDao<T> getAuctionMasterDao() {
        return auctionMasterDao;
    }

    public void setAuctionMasterDao(AuctionMasterDao<T> auctionMasterDao) {
        this.auctionMasterDao = auctionMasterDao;
        setGenericsDAO(auctionMasterDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return auctionMasterDao.readByRefNo(refNo);
    }

    @Override
    public List liveAuctionList(String username, String location, String department) {
        return auctionMasterDao.liveAuctionList(username, location, department);
    }

    @Override
    public List liveAuctionAuthorizerList(String username, String location, String department) {
        return auctionMasterDao.liveAuctionAuthorizerList(username, location, department);
    }

    @Override
    public List liveAuctionUnautorizeList(String username, String location, String department) {
        return auctionMasterDao.liveAuctionUnautorizeList(username, location, department);
    }

    @Override
    public void updateCloseAuction(String auction_no, String remark) {
        auctionMasterDao.updateCloseAuction(auction_no, remark);
    }

    @Override
    public List unauthorizeAuction(String username, String location, String department) {
        return auctionMasterDao.unauthorizeAuction(username, location, department);
    }

    @Override
    public List unauthorizeEmailAuction(String username, String location, String department) {
        return auctionMasterDao.unauthorizeEmailAuction(username, location, department);
    }

    @Override
    public void authorizeAuction(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark, String lastBiddingTime, String extendTime, String extendTimeNo, String autoDecIncAmount, String refreshRate, String bidding_display) {
        auctionMasterDao.authorizeAuction(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark, lastBiddingTime, extendTime, extendTimeNo, autoDecIncAmount, refreshRate, bidding_display);
    }

    @Override
    public List vendorLiveAuction(String username) {
        return auctionMasterDao.vendorLiveAuction(username);
    }

    @Override
    public List vendorLiveAuction1(String username) {
        return auctionMasterDao.vendorLiveAuction1(username);
    }

    @Override
    public AuctionMaster readByAuctionNo(String auction_no) {
        return auctionMasterDao.readByAuctionNo(auction_no);
    }

    @Override
    public void updateDate(String auction_no, Date modifiedDate1, int no_time) {
        auctionMasterDao.updateDate(auction_no, modifiedDate1, no_time);
    }

    @Override
    public List rejectAuction(String username, String location, String department) {
        return auctionMasterDao.rejectAuction(username, location, department);
    }

    @Override
    public List receiveAuctionList(String username, String location, String department) {
        return auctionMasterDao.receiveAuctionList(username, location, department);
    }

    @Override
    public List liveAuctionList1(String username, String location, String department) {
        return auctionMasterDao.liveAuctionList1(username, location, department);
    }

    @Override
    public void updateDate1(String refNo, String biddingEnddate) {
        auctionMasterDao.updateDate1(refNo, biddingEnddate);
    }

    @Override
    public List recycleAuction(String username, String location, String department) {
        return auctionMasterDao.recycleAuction(username, location, department);
    }

    @Override
    public void recycleAuctionSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark, String lastBiddingTime, String extendTime, String extendTimeNo, String autoDecIncAmount, String refreshRate, String bidding_display) {
        auctionMasterDao.recycleAuctionSubmit(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark, lastBiddingTime, extendTime, extendTimeNo, autoDecIncAmount, refreshRate, bidding_display);
    }

    @Override
    public List pastAuctionList(String location, String department, String auction_no, String auction_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        return auctionMasterDao.pastAuctionList(location, department, auction_no, auction_title, open_from_date, open_to_date, close_from_date, close_to_date);
    }
}
