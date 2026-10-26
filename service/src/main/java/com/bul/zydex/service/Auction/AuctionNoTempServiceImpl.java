/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionNoTempDao;
import com.bul.zydex.model.AuctionNoTemp;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionNoTempServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionNoTempService<T> {
    
    private AuctionNoTempDao<T> auctionNoTempDao;

    public AuctionNoTempDao<T> getAuctionNoTempDao() {
        return auctionNoTempDao;
    }

    public void setAuctionNoTempDao(AuctionNoTempDao<T> auctionNoTempDao) {
        this.auctionNoTempDao = auctionNoTempDao;
        setGenericsDAO(auctionNoTempDao);
    }

    @Override
    public AuctionNoTemp readLastRecord() {
        return auctionNoTempDao.readLastRecord();
    }
}
