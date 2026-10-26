/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionVendorDao;
import com.bul.zydex.model.AuctionVendor;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionVendorServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionVendorService<T> {

    private AuctionVendorDao<T> auctionVendorDao;

    public AuctionVendorDao<T> getAuctionVendorDao() {
        return auctionVendorDao;
    }

    public void setAuctionVendorDao(AuctionVendorDao<T> auctionVendorDao) {
        this.auctionVendorDao = auctionVendorDao;
        setGenericsDAO(auctionVendorDao);
    }

    @Override
    public List readByRefNo(String ref_no) {
        return auctionVendorDao.readByRefNo(ref_no);
    }

    @Override
    public List readByRefVendor(String ref_no, String vendor_code) {
        return auctionVendorDao.readByRefVendor(ref_no, vendor_code);
    }

    @Override
    public void updateRefNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, String start_price, String loading_factor_per, String loading_factor_val, String final_price, int checkVendorId) {
        auctionVendorDao.updateRefNo(refNo1, refNo, vendor_code, email_id, mobile_no, start_price, loading_factor_per, loading_factor_val, final_price, checkVendorId);
    }

    @Override
    public AuctionVendor readByVendorAuction(String auction_no, String username) {
        return auctionVendorDao.readByVendorAuction(auction_no, username);
    }

    @Override
    public void updateAuctionNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, String start_price, String loading_factor_per, String loading_factor_val, String final_price, int checkVendorId) {
        auctionVendorDao.updateAuctionNo(refNo1, refNo, vendor_code, email_id, mobile_no, start_price, loading_factor_per, loading_factor_val, final_price, checkVendorId);
    }

    @Override
    public List readByRefNoL1(String auction_no) {
        return auctionVendorDao.readByRefNoL1(auction_no);
    }

    @Override
    public List readByRefNoH1(String auction_no) {
        return auctionVendorDao.readByRefNoH1(auction_no);
    }
}
