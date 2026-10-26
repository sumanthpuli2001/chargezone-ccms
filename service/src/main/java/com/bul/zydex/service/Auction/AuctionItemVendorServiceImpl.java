/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionItemVendorDao;
import com.bul.zydex.model.AuctionItemVendor;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionItemVendorServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionItemVendorService<T> {



    private AuctionItemVendorDao<T> auctionItemVendorDao;

    public AuctionItemVendorDao<T> getAuctionItemVendorDao() {
        return auctionItemVendorDao;
    }

    public void setAuctionItemVendorDao(AuctionItemVendorDao<T> auctionItemVendorDao) {
        this.auctionItemVendorDao = auctionItemVendorDao;
        setGenericsDAO(auctionItemVendorDao);
    }

    @Override
    public List readByRefNo(String ref_no ,int item_no) {
        return auctionItemVendorDao.readByRefNo(ref_no , item_no);
    }

    @Override
    public List readByRefVendor(String ref_no, String vendor_code ,int item_no) {
       return auctionItemVendorDao.readByRefVendor(ref_no , vendor_code, item_no );
    }

    @Override
    public List readByItemId(int item_no) {
          return auctionItemVendorDao.readByItemId(item_no);
    }

    @Override
    public List readByIds(String ref_no, int item_no) {
          return auctionItemVendorDao.readByIds(ref_no, item_no);
    }
    @Override
      public List readByAuctionNo(String ref_no ,String vendor_code){
      return auctionItemVendorDao.readByAuctionNo(ref_no , vendor_code);
      }

    @Override
    public AuctionItemVendor readByVendorAuction(String auction_no, String username) {
       return auctionItemVendorDao.readByVendorAuction(auction_no, username);
    }

    @Override
    public List readByAuctionId(String auction_no) {
         return auctionItemVendorDao. readByAuctionId( auction_no);
    }

    @Override
    public List readAuctionItemVendor(String ref_no, int item_no) {
       return auctionItemVendorDao.readAuctionItemVendor(ref_no, item_no);
    }

    @Override
    public void updateAuctionNo(String refNo1, String refNo) {
        auctionItemVendorDao.updateAuctionNo(refNo1, refNo);
    }

 

}
