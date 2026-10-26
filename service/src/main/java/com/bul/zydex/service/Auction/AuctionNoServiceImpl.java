/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionNoDao;
import com.bul.zydex.model.AuctionNo;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionNoServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionNoService<T> {
    
    private AuctionNoDao<T> auctionNoDao;

    public AuctionNoDao<T> getAuctionNoDao() {
        return auctionNoDao;
    }

    public void setAuctionNoDao(AuctionNoDao<T> auctionNoDao) {
        this.auctionNoDao = auctionNoDao;
        setGenericsDAO(auctionNoDao);
    }

    @Override
    public AuctionNo readByAuctionNo() {
        return auctionNoDao.readByAuctionNo();
    }
}
