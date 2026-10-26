/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuctionMaster;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AuctionMasterDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo);

    public List liveAuctionList(String username, String location, String department);

    public List liveAuctionAuthorizerList(String username, String location, String department);

    public List liveAuctionUnautorizeList(String username, String location, String department);

    public void updateCloseAuction(String auction_no, String remark);

    public List unauthorizeAuction(String username, String location, String department);

    public List unauthorizeEmailAuction(String username, String location, String department);

    public void authorizeAuction(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark, String lastBiddingTime, String extendTime, String extendTimeNo, String autoDecIncAmount, String refreshRate, String bidding_display);

    public List vendorLiveAuction(String username);

    public List vendorLiveAuction1(String username);

    public AuctionMaster readByAuctionNo(String auction_no);

    public void updateDate(String auction_no, Date modifiedDate1, int no_time);

    public List rejectAuction(String username, String location, String department);

    public List receiveAuctionList(String username, String location, String department);

    public List liveAuctionList1(String username, String location, String department);

    public void updateDate1(String refNo, String biddingEnddate);

    public List recycleAuction(String username, String location, String department);

    public void recycleAuctionSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark, String lastBiddingTime, String extendTime, String extendTimeNo, String autoDecIncAmount, String refreshRate, String bidding_display);

    public List pastAuctionList(String location, String department, String auction_no, String auction_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date);
    
}
