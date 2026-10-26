/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionItemMasterDao;
import com.bul.zydex.model.AuctionItemMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionItemMasterServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionItemMasterService<T> {
 
    private AuctionItemMasterDao<T> auctionItemMasterDao;

    public AuctionItemMasterDao<T> getAuctionItemMasterDao() {
        return auctionItemMasterDao;
    }

    public void setAuctionItemMasterDao(AuctionItemMasterDao<T> auctionItemMasterDao) {
        this.auctionItemMasterDao = auctionItemMasterDao;
        setGenericsDAO(auctionItemMasterDao);
    }

    @Override
    public List readRefNo(String ref_no) {
        return auctionItemMasterDao.readRefNo(ref_no);
    }

    @Override
    public void deleteRefNo(String ref_no) {
        auctionItemMasterDao.deleteRefNo(ref_no);
    }

    @Override
    public void updateAuctionNo(String refNo1, String refNo) {
        auctionItemMasterDao.updateAuctionNo(refNo1, refNo);
    }

    @Override
    public List readByAuctionId(String auction_no) {
         return auctionItemMasterDao.readByAuctionId(auction_no);
    }

    @Override
    public AuctionItemMaster readByVendorAuction(String auction_no, int item_id) {
        return auctionItemMasterDao.readByVendorAuction(auction_no,  item_id);
    }

    @Override
    public AuctionItemMaster readByVendorAuctionItemList(String auction_no) {
         return auctionItemMasterDao.readByVendorAuctionItemList(auction_no);
    }
}
